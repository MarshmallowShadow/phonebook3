package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	//필드
	
	@Autowired
	private PhoneService pService;
	
	
	// 메소드
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhoneController>list");
		List<PersonVo> pList = pService.personSelect();

		model.addAttribute("pList", pList);

		return "list";
	}

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm");
		return "writeForm";
	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo pVo) { // Automatically adds Parameters to class (through set methods in Vo)
		System.out.println("PhoneController>write");

		System.out.println(pVo);

		pService.personInsert(pVo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/delete/{personId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("personId") int personId) {
		System.out.println("PhoneController>delete");

		int count = pService.personDelete(personId);

		return "redirect:/list";
	}

	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @RequestParam("personId") int personId) {
		System.out.println("PhoneController>updateForm");

		PersonVo pVo = pService.getPerson(personId);

		model.addAttribute("pVo", pVo);

		return "updateForm";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo pVo) {
		System.out.println("PhoneController>update");

		int count = pService.personUpdate(pVo);

		return "redirect:/list";
	}
}
