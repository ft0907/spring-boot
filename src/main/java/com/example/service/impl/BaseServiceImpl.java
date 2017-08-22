package com.example.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.BaseRepository;
import com.example.service.BaseService;

/**
 * Service - 基类
 * 
 * @author SHOP++ Team
 * @version 1.0
 */
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	/** BaseRepository */
	private BaseRepository<T, ID> baseRepository;

	@Inject
	protected void setBaseRepository(BaseRepository<T, ID> baseRepository) {
		this.baseRepository = baseRepository;
	}

	@Override
	public T getOne(ID id) {
		return baseRepository.getOne(id);
	}

	@Override
	public T findOne(ID id) {
		return baseRepository.findOne(id);
	}

	@Override
	public T findOne(Specification<T> specification) {
		return baseRepository.findOne(specification);
	}

	@Override
	public <S extends T> S findOne(Example<S> example) {
		return baseRepository.findOne(example);
	}

	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public List<T> findAll(Iterable<ID> ids) {
		return baseRepository.findAll(ids);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return baseRepository.findAll(sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return baseRepository.findAll(pageable);
	}

	@Override
	public List<T> findAll(Specification<T> specification) {
		return baseRepository.findAll(specification);
	}

	@Override
	public List<T> findAll(Specification<T> specification, Sort sort) {
		return baseRepository.findAll(specification, sort);
	}

	@Override
	public Page<T> findAll(Specification<T> specification, Pageable pageable) {
		return baseRepository.findAll(specification, pageable);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		return baseRepository.findAll(example);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return baseRepository.findAll(example, sort);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return baseRepository.findAll(example, pageable);
	}

	@Override
	public boolean exists(ID id) {
		return baseRepository.exists(id);
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		return baseRepository.exists(example);
	}

	@Override
	public long count() {
		return baseRepository.count();
	}

	@Override
	public long count(Specification<T> specification) {
		return baseRepository.count(specification);
	}

	@Override
	public <S extends T> long count(Example<S> example) {
		return baseRepository.count(example);
	}

	@Transactional
	@Override
	public <S extends T> S save(S entity) {
		return baseRepository.save(entity);
	}

	@Transactional
	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		List<S> result = new ArrayList<S>();
		if (entities == null) {
			return result;
		}

		for (S entity : entities) {
			result.add(save(entity));
		}
		return result;
	}

	@Transactional
	@Override
	public void delete(ID id) {
		baseRepository.delete(id);
	}

	@Transactional
	@Override
	public void delete(T entity) {
		baseRepository.delete(entity);
	}

	@Transactional
	@Override
	public void delete(Iterable<? extends T> entities) {
		baseRepository.delete(entities);
	}

	@Transactional
	@Override
	public void deleteInBatch(Iterable<T> entities) {
		baseRepository.deleteInBatch(entities);
	}

	@Transactional
	@Override
	public void deleteAll() {
		baseRepository.deleteAll();
	}

	@Transactional
	@Override
	public void deleteAllInBatch() {
		baseRepository.deleteAllInBatch();
	}

	@Override
	public void flush() {
		baseRepository.flush();
	}

	@Transactional
	@Override
	public <S extends T> S saveAndFlush(S entity) {
		S result = save(entity);
		baseRepository.flush();

		return result;
	}

}
