package com.example.web;

import javax.inject.Inject;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseControllerAdvice {

	@Inject
	private BaseRepository baseRepository;

	@GetMapping(path = "list", produces = MediaType.TEXT_HTML_VALUE)
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("str", "你好");
		return "order/list";
	}

	@GetMapping("add")
	public String add() {
		return "order/add";
	}
}
