package com.test.dao;

import com.test.model.User;
import com.test.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @Insert({
        "insert into user (id, username, ",
        "birthday, sex, address, ",
        "pwd, picurl)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{sex,jdbcType=CHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{picurl,jdbcType=VARCHAR})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="picurl", property="picurl", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @Select({
        "select",
        "id, username, birthday, sex, address, pwd, picurl",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="picurl", property="picurl", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);
    
    
    //根据地址查询
    @Select({
        "select",
        "id, username, birthday, sex, address, pwd, picurl",
        "from user",
        "where address = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday",jdbcType=JdbcType.DATE),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="picurl", property="picurl", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByAddress(String address);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Apr 26 10:49:07 CST 2017
     */
    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "sex = #{sex,jdbcType=CHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "picurl = #{picurl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
    
    
    
    @Select({
        "select",
        "count(*)",
        "from user",
        "where username = #{username,jdbcType=VARCHAR} and pwd = #{pwd,jdbcType=VARCHAR}"
    })
    int selectByusernameAndPwd(@Param("username")String username,@Param("pwd")String pwd);
    
}