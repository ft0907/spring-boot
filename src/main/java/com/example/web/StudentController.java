package com.example.web;

import javax.inject.Inject;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Inject
	private BaseRepository baseRepository;

	@GetMapping("/list")
	public String list(@PageableDefault(size = 20) Pageable pageable, ModelMap model) {
		model.addAttribute("page", baseRepository.findAll(pageable));
		return "student/list";
	}

	/**
	 * 添加
	 */
	@GetMapping("/add")
	public String add() {
		return "student/add";
	}

	@PostMapping("/save")
	public String save(Student student) {
		baseRepository.save(student);
		return "redirect:list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Long id) {
		Student student = baseRepository.findOne(id);
		student.setName("333");
		baseRepository.saveAndFlush(student);
		return "更新完毕";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long id) {
		Student student = baseRepository.findOne(id);
		baseRepository.delete(student);
		return "删除完毕";
	}
}
