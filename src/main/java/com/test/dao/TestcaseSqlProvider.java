package com.test.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.model.Testcase;
import com.test.model.TestcaseExample.Criteria;
import com.test.model.TestcaseExample.Criterion;
import com.test.model.TestcaseExample;
import java.util.List;
import java.util.Map;

public class TestcaseSqlProvider {
	
	
	
	public String caselist(Map<String,String> parm){
		StringBuilder mysql = new StringBuilder();
		mysql.append("select a.id,");
		mysql.append("a.casename,");
		mysql.append("a.scenario,");
		mysql.append("a.parmater,");
		mysql.append("a.expectkey1,");
		mysql.append("a.expectvalue1,");
		mysql.append("a.expectkey2,");
		mysql.append("a.expectvalue2,");
		mysql.append("b.name,");
		mysql.append("b.url,");
		mysql.append("b.method,");
		mysql.append("b.projectname ");
		mysql.append("from testcase a ,apinfor b ");
		mysql.append("where a.apiid = b.id ");
		String pr = parm.get("projectname");
		String na = parm.get("casename");
		if(pr !=null && !pr.isEmpty()){
    		mysql.append(" and projectname like '%"+pr+"%'");
    	}
    	if(na !=null && !na.isEmpty()){
    		mysql.append(" and casename like '%"+na+"%'");
    	}
		return mysql.toString();
	}

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String countByExample(TestcaseExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("testcase");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String deleteByExample(TestcaseExample example) {
        BEGIN();
        DELETE_FROM("testcase");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String insertSelective(Testcase record) {
        BEGIN();
        INSERT_INTO("testcase");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCasename() != null) {
            VALUES("casename", "#{casename,jdbcType=VARCHAR}");
        }
        
        if (record.getScenario() != null) {
            VALUES("scenario", "#{scenario,jdbcType=VARCHAR}");
        }
        
        if (record.getParmater() != null) {
            VALUES("parmater", "#{parmater,jdbcType=VARCHAR}");
        }
        
        if (record.getApiid() != null) {
            VALUES("apiid", "#{apiid,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectkey1() != null) {
            VALUES("expectkey1", "#{expectkey1,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectvalue1() != null) {
            VALUES("expectvalue1", "#{expectvalue1,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectkey2() != null) {
            VALUES("expectkey2", "#{expectkey2,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectvalue2() != null) {
            VALUES("expectvalue2", "#{expectvalue2,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String selectByExample(TestcaseExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("casename");
        SELECT("scenario");
        SELECT("parmater");
        SELECT("apiid");
        SELECT("expectkey1");
        SELECT("expectvalue1");
        SELECT("expectkey2");
        SELECT("expectvalue2");
        FROM("testcase");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Testcase record = (Testcase) parameter.get("record");
        TestcaseExample example = (TestcaseExample) parameter.get("example");
        
        BEGIN();
        UPDATE("testcase");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getCasename() != null) {
            SET("casename = #{record.casename,jdbcType=VARCHAR}");
        }
        
        if (record.getScenario() != null) {
            SET("scenario = #{record.scenario,jdbcType=VARCHAR}");
        }
        
        if (record.getParmater() != null) {
            SET("parmater = #{record.parmater,jdbcType=VARCHAR}");
        }
        
        if (record.getApiid() != null) {
            SET("apiid = #{record.apiid,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectkey1() != null) {
            SET("expectkey1 = #{record.expectkey1,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectvalue1() != null) {
            SET("expectvalue1 = #{record.expectvalue1,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectkey2() != null) {
            SET("expectkey2 = #{record.expectkey2,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectvalue2() != null) {
            SET("expectvalue2 = #{record.expectvalue2,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("testcase");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("casename = #{record.casename,jdbcType=VARCHAR}");
        SET("scenario = #{record.scenario,jdbcType=VARCHAR}");
        SET("parmater = #{record.parmater,jdbcType=VARCHAR}");
        SET("apiid = #{record.apiid,jdbcType=VARCHAR}");
        SET("expectkey1 = #{record.expectkey1,jdbcType=VARCHAR}");
        SET("expectvalue1 = #{record.expectvalue1,jdbcType=VARCHAR}");
        SET("expectkey2 = #{record.expectkey2,jdbcType=VARCHAR}");
        SET("expectvalue2 = #{record.expectvalue2,jdbcType=VARCHAR}");
        
        TestcaseExample example = (TestcaseExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    public String updateByPrimaryKeySelective(Testcase record) {
        BEGIN();
        UPDATE("testcase");
        
        if (record.getCasename() != null) {
            SET("casename = #{casename,jdbcType=VARCHAR}");
        }
        
        if (record.getScenario() != null) {
            SET("scenario = #{scenario,jdbcType=VARCHAR}");
        }
        
        if (record.getParmater() != null) {
            SET("parmater = #{parmater,jdbcType=VARCHAR}");
        }
        
        if (record.getApiid() != null) {
            SET("apiid = #{apiid,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectkey1() != null) {
            SET("expectkey1 = #{expectkey1,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectvalue1() != null) {
            SET("expectvalue1 = #{expectvalue1,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectkey2() != null) {
            SET("expectkey2 = #{expectkey2,jdbcType=VARCHAR}");
        }
        
        if (record.getExpectvalue2() != null) {
            SET("expectvalue2 = #{expectvalue2,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table testcase
     *
     * @mbggenerated Wed Jul 12 15:05:45 CST 2017
     */
    protected void applyWhere(TestcaseExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}