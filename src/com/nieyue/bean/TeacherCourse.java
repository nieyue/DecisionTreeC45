package com.nieyue.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 教师课程类
 * @author yy
 *
 */
@Entity
@Table(name="teacher_course_tb")
public class TeacherCourse implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer teacherCourseId;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 教师id
	 */
	private Integer teacherAccountId;
	/**
	 * 课程id
	 */
	private Integer courseId;
	/**
	 * 课程
	 */
	@Transient
	private Course course;
	/**
	 *教师账户
	 */
	@Transient
	private Account teacherAccount;
	public Integer getTeacherCourseId() {
		return teacherCourseId;
	}
	public void setTeacherCourseId(Integer teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getTeacherAccountId() {
		return teacherAccountId;
	}
	public void setTeacherAccountId(Integer teacherAccountId) {
		this.teacherAccountId = teacherAccountId;
	}
	public Account getTeacherAccount() {
		return teacherAccount;
	}
	public void setTeacherAccount(Account teacherAccount) {
		this.teacherAccount = teacherAccount;
	}
	
}