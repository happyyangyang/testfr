package com.test.model;

public class Project {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.id
     *
     * @mbggenerated Mon May 29 11:09:11 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column project.projectname
     *
     * @mbggenerated Mon May 29 11:09:11 CST 2017
     */
    private String projectname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.id
     *
     * @return the value of project.id
     *
     * @mbggenerated Mon May 29 11:09:11 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.id
     *
     * @param id the value for project.id
     *
     * @mbggenerated Mon May 29 11:09:11 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.projectname
     *
     * @return the value of project.projectname
     *
     * @mbggenerated Mon May 29 11:09:11 CST 2017
     */
    public String getProjectname() {
        return projectname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.projectname
     *
     * @param projectname the value for project.projectname
     *
     * @mbggenerated Mon May 29 11:09:11 CST 2017
     */
    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }
}