package com.example.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping(value = "/list")
	@Transactional(readOnly = true)
	public List<Student> list() {
		return studentRepository.findAll();
	}

	@RequestMapping(value = "/save")
	public String save() {
		Student student = new Student();
		student.setName("张三");
		student.setAge(15L);
		studentRepository.save(student);
		return "保存完毕";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Long id) {
		Student student = studentRepository.findOne(id);
		student.setName("333");
		studentRepository.saveAndFlush(student);
		return "更新完毕";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long id) {
		Student student = studentRepository.findOne(id);
		studentRepository.delete(student);
		return "删除完毕";
	}
}
