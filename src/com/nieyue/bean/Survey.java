package com.nieyue.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 学习调查表类
 * @author yy
 *
 */
@Entity
@Table(name="survey_tb")
public class Survey implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer surveyId;
	/**
	 * 课后上机学习时间 （小时）,1。 <5    2。5-10 3。 >10
	 */
	private Integer operateComputerLeaningTime;
	/**
	 * 课前了解,1不了解，2了解一点，3基本了解
	 */
	private Integer beforeClassUnderstand;
	/**
	 * 课堂学习,1差，2一般，3良，4优
	 */
	private Integer classroomLeaning;
	/**
	 * 平时成绩,1差，2一般，3良，4优
	 */
	private Integer peacetimeScore;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 学生id
	 */
	private Integer studentAccountId;
	/**
	 * 教师课程id
	 */
	private Integer teacherCourseId;
	/**
	 * 学生
	 */
	@Transient
	private Account studentAccount;
	/**
	 * 教师课程
	 */
	@Transient
	private TeacherCourse teacherCourse;
	
	public Account getStudentAccount() {
		return studentAccount;
	}
	public void setStudentAccount(Account studentAccount) {
		this.studentAccount = studentAccount;
	}
	public Integer getsurveyId() {
		return surveyId;
	}
	public void setsurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getStudentAccountId() {
		return studentAccountId;
	}
	public void setStudentAccountId(Integer studentAccountId) {
		this.studentAccountId = studentAccountId;
	}
	public Integer getTeacherCourseId() {
		return teacherCourseId;
	}
	public void setTeacherCourseId(Integer teacherCourseId) {
		this.teacherCourseId = teacherCourseId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TeacherCourse getTeacherCourse() {
		return teacherCourse;
	}
	public void setTeacherCourse(TeacherCourse teacherCourse) {
		this.teacherCourse = teacherCourse;
	}
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	public Integer getOperateComputerLeaningTime() {
		return operateComputerLeaningTime;
	}
	public void setOperateComputerLeaningTime(Integer operateComputerLeaningTime) {
		this.operateComputerLeaningTime = operateComputerLeaningTime;
	}
	public Integer getBeforeClassUnderstand() {
		return beforeClassUnderstand;
	}
	public void setBeforeClassUnderstand(Integer beforeClassUnderstand) {
		this.beforeClassUnderstand = beforeClassUnderstand;
	}
	public Integer getClassroomLeaning() {
		return classroomLeaning;
	}
	public void setClassroomLeaning(Integer classroomLeaning) {
		this.classroomLeaning = classroomLeaning;
	}
	public Integer getPeacetimeScore() {
		return peacetimeScore;
	}
	public void setPeacetimeScore(Integer peacetimeScore) {
		this.peacetimeScore = peacetimeScore;
	}
	
}