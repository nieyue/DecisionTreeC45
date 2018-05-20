package com.nieyue.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 职称类
 * @author yy
 *
 */
@Entity
@Table(name="positional_tb")
public class Positional implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer positionalId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String duty;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	public Integer getPositionalId() {
		return positionalId;
	}
	public void setPositionalId(Integer positionalId) {
		this.positionalId = positionalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}