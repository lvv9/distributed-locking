package me.liuweiqiang.locking;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class ZKLock {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ZooKeeper zookeeper;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String LOCK = "/lock";
    private static final String TIME = "/time";

    ZKLock() throws IOException, InterruptedException, KeeperException {
        this.zookeeper = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183",
                2000, event -> {
            if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        Stat stat = this.zookeeper.exists(LOCK,   false);
        Stat timeStat = this.zookeeper.exists(TIME, false);
        if (stat == null) {
            this.zookeeper.create(LOCK, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        if (timeStat == null) {
            this.zookeeper.create(TIME, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    public Stat lock(String space) throws InterruptedException, KeeperException {
        Stat timeStat = zookeeper.setData(TIME, null, -1);
        ByteBuffer nowBuffer = ByteBuffer.allocate(Long.BYTES);
        nowBuffer.putLong(timeStat.getMtime());
        byte[] now = nowBuffer.array();
        String path = LOCK + "/" + space;
        Stat exists;
        try {
            exists = zookeeper.exists(path, false);
            if (exists == null) {
                Stat stat = new Stat();
                zookeeper.create(path, now, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, stat);
                return stat;
            }
        } catch (KeeperException e) {
            if (!e.code().equals(KeeperException.Code.NODEEXISTS)) {
                throw e;
            }
        }
        while (true) {
            exists = new Stat();
            byte[] existsDate = zookeeper.getData(path, false, exists);
            ByteBuffer existsDateBuffer = ByteBuffer.allocate(Long.BYTES);
            existsDateBuffer.put(existsDate);
            existsDateBuffer.flip();
            timeStat = zookeeper.setData(TIME, null, -1);
            long duration = timeStat.getMtime() - existsDateBuffer.getLong();
            logger.info("duration: {}", duration);
            if (TimeUnit.MILLISECONDS.toSeconds(duration) > 10) {
                ByteBuffer newTimeBuffer = ByteBuffer.allocate(Long.BYTES);
                newTimeBuffer.putLong(timeStat.getMtime());
                byte[] newTime = newTimeBuffer.array();
                try {
                    return zookeeper.setData(path, newTime, exists.getVersion());
                } catch (KeeperException e) {
                    if (!e.code().equals(KeeperException.Code.BADVERSION)) {
                        throw e;
                    }
                }
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void unlock(String space, int version) throws InterruptedException, KeeperException {
        String path = LOCK + "/" + space;
        Stat exists = new Stat();
        byte[] existsDate = zookeeper.getData(path, false, exists);
        ByteBuffer existsDateBuffer = ByteBuffer.allocate(Long.BYTES);
        existsDateBuffer.put(existsDate);
        existsDateBuffer.flip();
        long expired = existsDateBuffer.getLong() - TimeUnit.SECONDS.toMillis(10);
        ByteBuffer expiredBuffer = ByteBuffer.allocate(Long.BYTES);
        expiredBuffer.putLong(expired);
        try {
            zookeeper.setData(path, expiredBuffer.array(), version);
        } catch (KeeperException e) {
            if (!e.code().equals(KeeperException.Code.BADVERSION)) {
                throw e;
            }
        }
    }
}
