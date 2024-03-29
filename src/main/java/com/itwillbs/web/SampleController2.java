package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	//http://localhost:8088/web/doB
	//http://localhost:8088/web/doB?msg="PEANUT"
	//http://localhost:8088/web/doB?msg="PEANUT"&age=20
//	@RequestMapping(value = "/doB")
	@GetMapping(value = "/doB")
	public String doB(@ModelAttribute("msg") String msg, 
						@ModelAttribute("age") int age) {
		/* int 기본형타입 불가 => 나중에 REST에서 사용가능 */
		
		// @ModelAttribute("파라미터명") 저장할 데이터변수
		// => 전달정보를 저장해서 연결된 view 페이지까지 전달
		
		// public String doB(@ModelAttribute("msg") String msg) { 
		logger.debug("doB() 호출");
		logger.debug("msg: "+msg); // 전달될 파라미터 정보 저장
		logger.debug("age: "+age);
		//메서드 리턴타입이 String일때 "리턴문자".jsp 뷰페이지로 연결 
		return "StringdoB";
	}
}
