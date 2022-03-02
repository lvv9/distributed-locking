package me.liuweiqiang.locking;

import me.liuweiqiang.locking.dao.ResourceDAO;
import me.liuweiqiang.locking.dao.model.Resource;
import me.liuweiqiang.locking.dao.model.ResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TestResource extends ResourceProtector {

    @Autowired
    private ResourceDAO resourceDAO;

    @Override
    public void run(String resourceKey) {
        Random random = new Random();
        Resource resource = new Resource();
        resource.setValue(Integer.toString(random.nextInt()));

        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        criteria.andResourceKeyEqualTo(resourceKey);

        resourceDAO.updateByExampleSelective(resource, example);
    }
}
