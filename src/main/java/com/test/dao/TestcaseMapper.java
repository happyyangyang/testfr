package com.test.dao;

import com.test.model.Testcase;
import com.test.model.TestcaseExample;
import com.test.vo.CaseVo;

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

public interface TestcaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @SelectProvider(type=TestcaseSqlProvider.class, method="countByExample")
    int countByExample(TestcaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @DeleteProvider(type=TestcaseSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestcaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @Delete({
        "delete from testcase",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @Insert({
        "insert into testcase (id, casename, ",
        "scenario, parmater, ",
        "expect, apiid)",
        "values (#{id,jdbcType=VARCHAR}, #{casename,jdbcType=VARCHAR}, ",
        "#{scenario,jdbcType=VARCHAR}, #{parmater,jdbcType=VARCHAR}, ",
        "#{expect,jdbcType=VARCHAR}, #{apiid,jdbcType=VARCHAR})"
    })
    int insert(Testcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @InsertProvider(type=TestcaseSqlProvider.class, method="insertSelective")
    int insertSelective(Testcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @SelectProvider(type=TestcaseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="casename", property="casename", jdbcType=JdbcType.VARCHAR),
        @Result(column="scenario", property="scenario", jdbcType=JdbcType.VARCHAR),
        @Result(column="parmater", property="parmater", jdbcType=JdbcType.VARCHAR),
        @Result(column="expect", property="expect", jdbcType=JdbcType.VARCHAR),
        @Result(column="apiid", property="apiid", jdbcType=JdbcType.VARCHAR)
    })
    List<Testcase> selectByExample(TestcaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @Select({
        "select",
        "id, casename, scenario, parmater, expect, apiid",
        "from testcase",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="casename", property="casename", jdbcType=JdbcType.VARCHAR),
        @Result(column="scenario", property="scenario", jdbcType=JdbcType.VARCHAR),
        @Result(column="parmater", property="parmater", jdbcType=JdbcType.VARCHAR),
        @Result(column="expect", property="expect", jdbcType=JdbcType.VARCHAR),
        @Result(column="apiid", property="apiid", jdbcType=JdbcType.VARCHAR)
    })
    Testcase selectByPrimaryKey(String id);
    
    @Select({
    	"select *",
        "from testcase"
    })
    List<Testcase> getlist();
    
    
    @Select({
    	"select a.id,",
    	"a.casename,",
    	"a.scenario,",
    	"a.parmater,",
    	"a.expect,",
    	"c.name,",
    	"c.url,",
    	"c.method,",
    	"c.projectname",
    	"from testcase a ,(select DISTINCT b.name,b.url,b.method,b.projectname from testcase a,apinfor b",
    	"where a.apiid = b.id) c"
    		
    })
    List<CaseVo> getCaseList1();
    
    @Select({
    	"select a.id,",
    	"a.casename,",
    	"a.scenario,",
    	"a.parmater,",
    	"a.expect,",
    	"b.name,",
    	"b.url,",
    	"b.method,",
    	"b.projectname",
    	"from testcase a ,apinfor b",
    	"where a.id = #{id,jdbcType=VARCHAR}",
    	"and a.apiid = b.id"
    		
    })
    CaseVo selectByid(String id);
    
    
    
    
    @Select({
    	"select a.id,",
    	"a.casename,",
    	"a.scenario,",
    	"a.parmater,",
    	"a.expect,",
    	"b.name,",
    	"b.url,",
    	"b.method,",
    	"b.projectname",
    	"from testcase a ,apinfor b",
    	"where a.apiid = b.id"
    	
    		
    })
    List<CaseVo> getCaseList();
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @UpdateProvider(type=TestcaseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Testcase record, @Param("example") TestcaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @UpdateProvider(type=TestcaseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Testcase record, @Param("example") TestcaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @UpdateProvider(type=TestcaseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Testcase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Tue Jun 13 14:23:36 CST 2017
     */
    @Update({
        "update testcase",
        "set casename = #{casename,jdbcType=VARCHAR},",
          "scenario = #{scenario,jdbcType=VARCHAR},",
          "parmater = #{parmater,jdbcType=VARCHAR},",
          "expect = #{expect,jdbcType=VARCHAR},",
          "apiid = #{apiid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Testcase record);
}