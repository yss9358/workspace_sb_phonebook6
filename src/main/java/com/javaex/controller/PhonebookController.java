package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	// 전체 리스트 가져오기
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		List<PersonVo> personList = phonebookService.exeList();
		model.addAttribute("personList", personList);
		return "list";
	}

	// 등록폼
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		return "writeForm";
	}

	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		int count = phonebookService.exeWrite(personVo);
		System.out.println(count);
		return "redirect:/list";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {
		int count = phonebookService.exeDelete(no);
		System.out.println(count);
		return "redirect:/list";
	}

	// 수정폼
	@RequestMapping(value="/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		PersonVo personVo = phonebookService.exeSelectOne(no);
		model.addAttribute("personVo",personVo);
		return "modifyForm";
	}
	
	// 수정
	@RequestMapping(value="/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		int count = phonebookService.exeModify(personVo);
		System.out.println(count);
		return "redirect:/list";
	}
}

