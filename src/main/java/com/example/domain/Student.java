package com.example.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 659925410003167992L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private Long age;

}
