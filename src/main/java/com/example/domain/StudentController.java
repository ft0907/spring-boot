package com.example.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/list")
	@ResponseBody
	@Transactional(readOnly = true)
	public List<Student> list() {
		return studentRepository.findAll();
	}

	@RequestMapping("/save")
	@ResponseBody
	@Transactional()
	public String save() {
		System.out.println("111");
		Student student = new Student();
		student.setId(4L);
		student.setName("张三");
		student.setAge(15L);
		studentRepository.save(student);
		return "保存完毕";
	}

	@RequestMapping("/update")
	@ResponseBody
	@Transactional()
	public String update(Long id) {
		Student student = studentRepository.findOne(id);
		student.setName("111");
		studentRepository.saveAndFlush(student);
		return "更新完毕";
	}

	@RequestMapping("/delete")
	@ResponseBody
	@Transactional()
	public String delete(Long id) {
		Student student = studentRepository.findOne(id);
		studentRepository.delete(student);
		return "删除完毕";
	}
}
