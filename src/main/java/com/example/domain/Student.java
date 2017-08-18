package com.example.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends BaseEntity<Long> {

	private static final long serialVersionUID = 659925410003167992L;

	private String name;

	private Long age;

}
