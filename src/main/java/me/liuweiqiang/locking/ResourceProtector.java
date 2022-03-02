package me.liuweiqiang.locking;

import me.liuweiqiang.locking.dao.TokenDAO;
import me.liuweiqiang.locking.dao.model.Token;
import me.liuweiqiang.locking.dao.model.TokenExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class ResourceProtector {

    @Autowired
    private TokenDAO tokenDAO;

    @Transactional
    public void runWithTokenCAS(String resourceKey, Long token) {
        TokenExample example = new TokenExample();
        TokenExample.Criteria criteria = example.createCriteria();
        criteria.andResourceKeyEqualTo(resourceKey);
        List<Token> tokens = tokenDAO.selectByExample(example);
        if (tokens == null || tokens.isEmpty()) {
            Token firstResourceToken = new Token();
            firstResourceToken.setResourceKey(resourceKey);
            firstResourceToken.setTokenAkaLockingId(token);
            tokenDAO.insertSelective(firstResourceToken);
            run(resourceKey);
            return;
        }
        Token updateResource = new Token();
        updateResource.setTokenAkaLockingId(token);
        TokenExample tokenForUpdate = new TokenExample();
        TokenExample.Criteria tokenCriteria = tokenForUpdate.createCriteria();
        tokenCriteria.andResourceKeyEqualTo(resourceKey);
        tokenCriteria.andTokenAkaLockingIdLessThanOrEqualTo(token);
        int updated = tokenDAO.updateByExampleSelective(updateResource, tokenForUpdate);
        if (updated < 1) {
            throw new RuntimeException("token expired");
        }
        run(resourceKey);
    }

    public abstract void run(String resourceKey);
}
