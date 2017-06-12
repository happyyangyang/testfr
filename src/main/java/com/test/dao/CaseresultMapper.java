package com.test.dao;

import com.test.model.Caseresult;
import com.test.model.CaseresultExample;
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

public interface CaseresultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @SelectProvider(type=CaseresultSqlProvider.class, method="countByExample")
    int countByExample(CaseresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @DeleteProvider(type=CaseresultSqlProvider.class, method="deleteByExample")
    int deleteByExample(CaseresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @Delete({
        "delete from caseresult",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @Insert({
        "insert into caseresult (id, response, ",
        "caseid, dsc)",
        "values (#{id,jdbcType=VARCHAR}, #{response,jdbcType=VARCHAR}, ",
        "#{caseid,jdbcType=VARCHAR}, #{dsc,jdbcType=VARCHAR})"
    })
    int insert(Caseresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @InsertProvider(type=CaseresultSqlProvider.class, method="insertSelective")
    int insertSelective(Caseresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @SelectProvider(type=CaseresultSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="response", property="response", jdbcType=JdbcType.VARCHAR),
        @Result(column="caseid", property="caseid", jdbcType=JdbcType.VARCHAR),
        @Result(column="dsc", property="dsc", jdbcType=JdbcType.VARCHAR)
    })
    List<Caseresult> selectByExample(CaseresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @Select({
        "select",
        "id, response, caseid, dsc",
        "from caseresult",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="response", property="response", jdbcType=JdbcType.VARCHAR),
        @Result(column="caseid", property="caseid", jdbcType=JdbcType.VARCHAR),
        @Result(column="dsc", property="dsc", jdbcType=JdbcType.VARCHAR)
    })
    Caseresult selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @UpdateProvider(type=CaseresultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Caseresult record, @Param("example") CaseresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @UpdateProvider(type=CaseresultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Caseresult record, @Param("example") CaseresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @UpdateProvider(type=CaseresultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Caseresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table caseresult
     *
     * @mbggenerated Mon Jun 12 17:27:06 CST 2017
     */
    @Update({
        "update caseresult",
        "set response = #{response,jdbcType=VARCHAR},",
          "caseid = #{caseid,jdbcType=VARCHAR},",
          "dsc = #{dsc,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Caseresult record);
}