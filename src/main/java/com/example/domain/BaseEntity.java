/*
 * Copyright 2005-2017 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.groups.Default;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity - 基类
 * 
 * @author SHOP++ Team
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity<PK extends Serializable> implements Persistable<PK> {

	private static final long serialVersionUID = 6702319381809051415L;

	/**
	 * 保存验证组
	 */
	public interface Save extends Default {

	}

	/**
	 * 更新验证组
	 */
	public interface Update extends Default {

	}

	/**
	 * 基础视图
	 */
	public interface BaseView {

	}

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableGenerator")
	@TableGenerator(name = "tableGenerator", table = "id_generator")
	private PK id;

	/**
	 * 创建日期
	 */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date createdDate;

	/**
	 * 最后修改日期
	 */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date lastModifiedDate;

	/**
	 * 版本
	 */
	@JsonIgnore
	@Version
	@Column(nullable = false)
	private Long version;

	/**
	 * 判断是否为新建对象
	 * 
	 * @return 是否为新建对象
	 */
	@JsonIgnore
	@Transient
	@Override
	public boolean isNew() {
		return getId() == null;
	}

	/**
	 * 获取创建日期
	 * 
	 * @return 创建日期
	 */
	@JsonSerialize(using = DateTimeSerializer.class)
	public DateTime getCreatedDate() {
		return createdDate != null ? new DateTime(createdDate) : null;
	}

	/**
	 * 设置创建日期
	 * 
	 * @param createdDate
	 *            创建日期
	 */
	public void setCreatedDate(final DateTime createdDate) {
		this.createdDate = createdDate != null ? createdDate.toDate() : null;
	}

	/**
	 * 重写toString方法
	 * 
	 * @return 字符串
	 */
	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}

}