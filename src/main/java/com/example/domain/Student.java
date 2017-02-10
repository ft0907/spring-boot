package com.example.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Student implements Serializable {

	private static final long serialVersionUID = 659925410003167992L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private Long age;

}
