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

import com.test.model.Reporter;
import com.test.model.ReporterExample.Criteria;
import com.test.model.ReporterExample.Criterion;
import com.test.model.ReporterExample;
import java.util.List;
import java.util.Map;

public class ReporterSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String countByExample(ReporterExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("reporter");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String deleteByExample(ReporterExample example) {
        BEGIN();
        DELETE_FROM("reporter");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String insertSelective(Reporter record) {
        BEGIN();
        INSERT_INTO("reporter");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getExcdate() != null) {
            VALUES("excdate", "#{excdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotaltime() != null) {
            VALUES("totaltime", "#{totaltime,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalcount() != null) {
            VALUES("totalcount", "#{totalcount,jdbcType=INTEGER}");
        }
        
        if (record.getSuccesscount() != null) {
            VALUES("successcount", "#{successcount,jdbcType=INTEGER}");
        }
        
        if (record.getFailurescount() != null) {
            VALUES("failurescount", "#{failurescount,jdbcType=INTEGER}");
        }
        
        if (record.getSkipscount() != null) {
            VALUES("skipscount", "#{skipscount,jdbcType=INTEGER}");
        }
        
        if (record.getErrorcount() != null) {
            VALUES("errorcount", "#{errorcount,jdbcType=INTEGER}");
        }
        
        if (record.getSuccesspercent() != null) {
            VALUES("successpercent", "#{successpercent,jdbcType=DOUBLE}");
        }
        
        if (record.getText() != null) {
            VALUES("text", "#{text,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String selectByExampleWithBLOBs(ReporterExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("excdate");
        SELECT("totaltime");
        SELECT("totalcount");
        SELECT("successcount");
        SELECT("failurescount");
        SELECT("skipscount");
        SELECT("errorcount");
        SELECT("successpercent");
        SELECT("text");
        FROM("reporter");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String selectByExample(ReporterExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("excdate");
        SELECT("totaltime");
        SELECT("totalcount");
        SELECT("successcount");
        SELECT("failurescount");
        SELECT("skipscount");
        SELECT("errorcount");
        SELECT("successpercent");
        FROM("reporter");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Reporter record = (Reporter) parameter.get("record");
        ReporterExample example = (ReporterExample) parameter.get("example");
        
        BEGIN();
        UPDATE("reporter");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getExcdate() != null) {
            SET("excdate = #{record.excdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotaltime() != null) {
            SET("totaltime = #{record.totaltime,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalcount() != null) {
            SET("totalcount = #{record.totalcount,jdbcType=INTEGER}");
        }
        
        if (record.getSuccesscount() != null) {
            SET("successcount = #{record.successcount,jdbcType=INTEGER}");
        }
        
        if (record.getFailurescount() != null) {
            SET("failurescount = #{record.failurescount,jdbcType=INTEGER}");
        }
        
        if (record.getSkipscount() != null) {
            SET("skipscount = #{record.skipscount,jdbcType=INTEGER}");
        }
        
        if (record.getErrorcount() != null) {
            SET("errorcount = #{record.errorcount,jdbcType=INTEGER}");
        }
        
        if (record.getSuccesspercent() != null) {
            SET("successpercent = #{record.successpercent,jdbcType=DOUBLE}");
        }
        
        if (record.getText() != null) {
            SET("text = #{record.text,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("reporter");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("excdate = #{record.excdate,jdbcType=TIMESTAMP}");
        SET("totaltime = #{record.totaltime,jdbcType=VARCHAR}");
        SET("totalcount = #{record.totalcount,jdbcType=INTEGER}");
        SET("successcount = #{record.successcount,jdbcType=INTEGER}");
        SET("failurescount = #{record.failurescount,jdbcType=INTEGER}");
        SET("skipscount = #{record.skipscount,jdbcType=INTEGER}");
        SET("errorcount = #{record.errorcount,jdbcType=INTEGER}");
        SET("successpercent = #{record.successpercent,jdbcType=DOUBLE}");
        SET("text = #{record.text,jdbcType=LONGVARCHAR}");
        
        ReporterExample example = (ReporterExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("reporter");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("excdate = #{record.excdate,jdbcType=TIMESTAMP}");
        SET("totaltime = #{record.totaltime,jdbcType=VARCHAR}");
        SET("totalcount = #{record.totalcount,jdbcType=INTEGER}");
        SET("successcount = #{record.successcount,jdbcType=INTEGER}");
        SET("failurescount = #{record.failurescount,jdbcType=INTEGER}");
        SET("skipscount = #{record.skipscount,jdbcType=INTEGER}");
        SET("errorcount = #{record.errorcount,jdbcType=INTEGER}");
        SET("successpercent = #{record.successpercent,jdbcType=DOUBLE}");
        
        ReporterExample example = (ReporterExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    public String updateByPrimaryKeySelective(Reporter record) {
        BEGIN();
        UPDATE("reporter");
        
        if (record.getExcdate() != null) {
            SET("excdate = #{excdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotaltime() != null) {
            SET("totaltime = #{totaltime,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalcount() != null) {
            SET("totalcount = #{totalcount,jdbcType=INTEGER}");
        }
        
        if (record.getSuccesscount() != null) {
            SET("successcount = #{successcount,jdbcType=INTEGER}");
        }
        
        if (record.getFailurescount() != null) {
            SET("failurescount = #{failurescount,jdbcType=INTEGER}");
        }
        
        if (record.getSkipscount() != null) {
            SET("skipscount = #{skipscount,jdbcType=INTEGER}");
        }
        
        if (record.getErrorcount() != null) {
            SET("errorcount = #{errorcount,jdbcType=INTEGER}");
        }
        
        if (record.getSuccesspercent() != null) {
            SET("successpercent = #{successpercent,jdbcType=DOUBLE}");
        }
        
        if (record.getText() != null) {
            SET("text = #{text,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reporter
     *
     * @mbggenerated Sun Jul 16 11:16:31 CST 2017
     */
    protected void applyWhere(ReporterExample example, boolean includeExamplePhrase) {
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