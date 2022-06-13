package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	// 메소드
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		PhoneDao pDao = new PhoneDao();
		List<PersonVo> pList = pDao.personSelect();

		model.addAttribute("pList", pList);

		return "/WEB-INF/views/list.jsp";
	}

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo pVo) { // Automatically adds Parameters to class (through set methods
														// in Vo)
		System.out.println("PhoneController>list");

		PhoneDao pDao = new PhoneDao();
		System.out.println(pVo);

		pDao.personInsert(pVo);

		return "redirect:/list";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("PhoneController>delete");

		PhoneDao pDao = new PhoneDao();
		int count = pDao.personDelete(personId);

		return "redirect:/list";
	}

	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @RequestParam("personId") int personId) {
		System.out.println("PhoneController>updateForm");

		PhoneDao pDao = new PhoneDao();
		PersonVo pVo = pDao.getPerson(personId);

		model.addAttribute("pVo", pVo);

		return "/WEB-INF/views/updateForm.jsp";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo pVo) {
		System.out.println("PhoneController>update");

		PhoneDao pDao = new PhoneDao();
		int count = pDao.personUpdate(pVo);

		return "redirect:/list";
	}
}
