/*
 * Copyright 2005-2017 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.example.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * Service - 基类
 * 
 * @author SHOP++ Team
 * @version 1.0
 */
public interface BaseService<T, ID extends Serializable> {

	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	T getOne(ID id);

	/**
	 * 查找实体对象
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象，若不存在则返回null
	 */
	T findOne(ID id);

	/**
	 * 查找实体对象
	 * 
	 * @param specification
	 *            条件
	 * @return 实体对象，若不存在则返回null
	 */
	T findOne(Specification<T> specification);

	/**
	 * 查找实体对象
	 * 
	 * @param example
	 *            示例
	 * @return 实体对象，若不存在则返回null
	 */
	<S extends T> S findOne(Example<S> example);

	/**
	 * 查找所有实体对象集合
	 * 
	 * @return 所有实体对象集合
	 */
	List<T> findAll();

	/**
	 * 查找实体对象集合
	 * 
	 * @param ids
	 *            ID
	 * @return 实体对象集合
	 */
	List<T> findAll(Iterable<ID> ids);

	/**
	 * 查找实体对象集合
	 * 
	 * @param sort
	 *            排序
	 * @return 实体对象集合
	 */
	List<T> findAll(Sort sort);

	/**
	 * 查找实体对象分页
	 * 
	 * @param pageable
	 *            分页
	 * @return 实体对象分页
	 */
	Page<T> findAll(Pageable pageable);

	/**
	 * 查找实体对象集合
	 * 
	 * @param specification
	 *            条件
	 * @return 实体对象集合
	 */
	List<T> findAll(Specification<T> specification);

	/**
	 * 查找实体对象集合
	 * 
	 * @param specification
	 *            条件
	 * @param sort
	 *            排序
	 * @return 实体对象集合
	 */
	List<T> findAll(Specification<T> specification, Sort sort);

	/**
	 * 查找实体对象分页
	 * 
	 * @param specification
	 *            条件
	 * @param pageable
	 *            分页
	 * @return 实体对象分页
	 */
	Page<T> findAll(Specification<T> specification, Pageable pageable);

	/**
	 * 查找实体对象集合
	 * 
	 * @param example
	 *            示例
	 * @return 实体对象集合
	 */
	<S extends T> List<S> findAll(Example<S> example);

	/**
	 * 查找实体对象集合
	 * 
	 * @param example
	 *            示例
	 * @param sort
	 *            排序
	 * @return 实体对象集合
	 */
	<S extends T> List<S> findAll(Example<S> example, Sort sort);

	/**
	 * 查找实体对象分页
	 * 
	 * @param example
	 *            示例
	 * @param pageable
	 *            分页
	 * @return 实体对象分页
	 */
	<S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

	/**
	 * 判断实体对象是否存在
	 * 
	 * @param id
	 *            ID
	 * @return 实体对象是否存在
	 */
	boolean exists(ID id);

	/**
	 * 判断实体对象是否存在
	 * 
	 * @param example
	 *            示例
	 * @return 实体对象是否存在
	 */
	<S extends T> boolean exists(Example<S> example);

	/**
	 * 查询实体对象总数
	 * 
	 * @return 实体对象总数
	 */
	long count();

	/**
	 * 查询实体对象数量
	 * 
	 * @param specification
	 *            条件
	 * @return 实体对象数量
	 */
	long count(Specification<T> specification);

	/**
	 * 查询实体对象数量
	 * 
	 * @param example
	 *            示例
	 * @return 实体对象数量
	 */
	<S extends T> long count(Example<S> example);

	/**
	 * 保存实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	<S extends T> S save(S entity);

	/**
	 * 保存实体对象
	 * 
	 * @param entities
	 *            实体对象
	 * @return 实体对象
	 */
	<S extends T> List<S> save(Iterable<S> entities);

	/**
	 * 删除实体对象
	 * 
	 * @param id
	 *            ID
	 */
	void delete(ID id);

	/**
	 * 删除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void delete(T entity);

	/**
	 * 删除实体对象
	 * 
	 * @param entities
	 *            实体对象
	 */
	void delete(Iterable<? extends T> entities);

	/**
	 * 批量删除实体对象
	 * 
	 * @param entities
	 *            实体对象
	 */
	void deleteInBatch(Iterable<T> entities);

	/**
	 * 删除所有实体对象
	 */
	void deleteAll();

	/**
	 * 批量删除所有实体对象
	 */
	void deleteAllInBatch();

	/**
	 * 同步数据
	 */
	void flush();

	/**
	 * 保存并同步数据
	 * 
	 * @param entity
	 *            实体对象
	 */
	<S extends T> S saveAndFlush(S entity);

}