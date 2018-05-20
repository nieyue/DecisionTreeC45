package com.nieyue.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * 账户类
 * @author yy
 *
 */
@Entity
@Table(name="account_tb")
public class Account implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accountId;
	/**
	 * 编号
	 */
	private String identifier;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 性别 ,1男 ，2女，0是其他
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 登陆时间
	 */
	private Date loginDate;
	/**
	 * 角色Id
	 */
	private Integer roleId;
	/**
	 * 专业Id
	 */
	private Integer majorId;
	/**
	 * 班级Id
	 */
	private Integer studentClassId;
	/**
	 * 职称Id
	 */
	private Integer positionalId;
	/**
	 * 角色
	 */
	@Transient
	private Role role;
	/**
	 * 专业
	 */
	@Transient
	private Major major;
	/**
	 * 班级
	 */
	@Transient
	private StudentClass studentClass ;
	/**
	 *职称
	 */
	@Transient
	private Positional positional ;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	public Integer getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(Integer studentClassId) {
		this.studentClassId = studentClassId;
	}
	public Integer getPositionalId() {
		return positionalId;
	}
	public void setPositionalId(Integer positionalId) {
		this.positionalId = positionalId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public StudentClass getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}
	public Positional getPositional() {
		return positional;
	}
	public void setPositional(Positional positional) {
		this.positional = positional;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}