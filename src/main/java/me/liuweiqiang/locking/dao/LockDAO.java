package me.liuweiqiang.locking.dao;

import java.util.List;
import me.liuweiqiang.locking.dao.model.Lock;
import me.liuweiqiang.locking.dao.model.LockExample;
import org.apache.ibatis.annotations.Param;

public interface LockDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    long countByExample(LockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int deleteByExample(LockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int insert(Lock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int insertSelective(Lock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    List<Lock> selectByExample(LockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    Lock selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int updateByExampleSelective(@Param("record") Lock record, @Param("example") LockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int updateByExample(@Param("record") Lock record, @Param("example") LockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int updateByPrimaryKeySelective(Lock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table locking..lock
     *
     * @mbg.generated Sun Feb 20 23:54:15 CST 2022
     */
    int updateByPrimaryKey(Lock record);
}