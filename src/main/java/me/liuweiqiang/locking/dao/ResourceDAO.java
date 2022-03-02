package me.liuweiqiang.locking.dao;

import java.util.List;
import me.liuweiqiang.locking.dao.model.Resource;
import me.liuweiqiang.locking.dao.model.ResourceExample;
import org.apache.ibatis.annotations.Param;

public interface ResourceDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    long countByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int deleteByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    Resource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..resource
     *
     * @mbg.generated Mon Feb 21 00:20:13 CST 2022
     */
    int updateByPrimaryKey(Resource record);
}