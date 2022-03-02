package me.liuweiqiang.locking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DBUniqueLockTest {

    @Autowired
    private DBUniqueLock dbUniqueLock;

    @Test
    public void testTimedRelease() {
        dbUniqueLock.timedRelease();
    }

    @Test
    public void testLock() throws Exception {
        dbUniqueLock.lock("lvv9");
    }

    @Test
    public void testUnlock() {
        dbUniqueLock.unlock(2L);
    }
}