package me.liuweiqiang.locking;

import me.liuweiqiang.locking.dao.ResourceDAO;
import me.liuweiqiang.locking.dao.model.Resource;
import me.liuweiqiang.locking.dao.model.ResourceExample;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestResourceTest {

    @Autowired
    private TestResource testResource;

    @Autowired
    private DBUniqueLock dbUniqueLock;

    @Autowired
    private ResourceDAO resourceDAO;

    @Autowired
    private ZKLock zkLock;

    private static final String key = "lvv9";
    private static final String keyForZoo = "lvv9_zoo";

    @BeforeEach
    public void before() {
        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        criteria.andResourceKeyEqualTo(key);
        List<Resource> resources = resourceDAO.selectByExample(example);
        if (resources == null || resources.isEmpty()) {
            Resource resource = new Resource();
            resource.setResourceKey(key);
            resource.setValue(Integer.toString(new Random().nextInt()));
            resourceDAO.insertSelective(resource);
        }
        ResourceExample exampleForZoo = new ResourceExample();
        ResourceExample.Criteria criteriaForZoo = exampleForZoo.createCriteria();
        criteriaForZoo.andResourceKeyEqualTo(keyForZoo);
        resources = resourceDAO.selectByExample(exampleForZoo);
        if (resources == null || resources.isEmpty()) {
            Resource resource = new Resource();
            resource.setResourceKey(keyForZoo);
            resource.setValue(Integer.toString(new Random().nextInt()));
            resourceDAO.insertSelective(resource);
        }
    }

    @Test
    public void testcase1() throws Exception {
        Long token = null;
        try {
            token = dbUniqueLock.lock(key);
            testResource.runWithTokenCAS(key, token);
        } finally {
            if (token != null) {
                dbUniqueLock.unlock(token);
            }
        }
    }

    @Test
    public void testcase2() throws Exception {
        Stat stat = null;
        try {
            stat = zkLock.lock(keyForZoo);
            testResource.runWithTokenCAS(keyForZoo, (long) stat.getVersion());
        } finally {
            if (stat != null) {
                zkLock.unlock(keyForZoo, stat.getVersion());
            }
        }
    }

    @Test
    public void testcase3() throws Exception {
        Stat stat = null;
        long begin;
        long end;
        try {
            zkLock.lock(keyForZoo);
            begin = System.currentTimeMillis();
            stat = zkLock.lock(keyForZoo);
            end = System.currentTimeMillis();
        } finally {
            if (stat != null) {
                zkLock.unlock(keyForZoo, stat.getVersion());
            }
        }
        Assertions.assertTrue(TimeUnit.MILLISECONDS.toSeconds(end - begin) > 9);
    }

    @Test
    public void testcase4() throws Exception {
        Stat stat = zkLock.lock(keyForZoo);
        long begin = System.currentTimeMillis();
        zkLock.unlock(keyForZoo, stat.getVersion());
        stat = zkLock.lock(keyForZoo);
        zkLock.unlock(keyForZoo, stat.getVersion());
        long end = System.currentTimeMillis();
        Assertions.assertTrue(TimeUnit.MILLISECONDS.toSeconds(end - begin) < 10);
    }
}
