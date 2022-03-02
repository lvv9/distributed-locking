package me.liuweiqiang.locking;

import me.liuweiqiang.locking.dao.LockDAO;
import me.liuweiqiang.locking.dao.model.Lock;
import me.liuweiqiang.locking.dao.model.LockExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Component
public class DBUniqueLock {

    @Autowired
    private LockDAO lockDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long lock(String space) throws InterruptedException {
        while (true) {
            Lock lock = new Lock();
            lock.setSpace(space);
            try {
                lockDAO.insertSelective(lock);
                break;
            } catch (DuplicateKeyException e) {
                TimeUnit.SECONDS.sleep(1);
            }
        }
        LockExample example = new LockExample();
        LockExample.Criteria criteria = example.createCriteria();
        criteria.andSpaceEqualTo(space);
        Lock inserted = lockDAO.selectByExample(example).get(0);
        return inserted.getId();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void unlock(Long id) {
        lockDAO.deleteByPrimaryKey(id);
    }

    public void timedRelease() {
        jdbcTemplate.execute("delete from locking.lock where now() > date_add(create_time, interval 10 second)");
    }
}
