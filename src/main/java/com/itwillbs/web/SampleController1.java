package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller : 스프링이 컨트롤러로 인식하도록 함
//				HttpServlet 상속X, doGET/POST 메서드 구현X
@Controller
public class SampleController1 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// http://localhost:8088/web/doA
	// 구현하고자 하는 동작을 메서드로 선언
//	@RequestMapping(value="URI주소", method=전달방식) 
	@RequestMapping(value="/doA", method=RequestMethod.GET) // method는 상수를 불러줌 
	public void doA() {
	logger.debug("doA() 실행");
		
		// 페이지 이동(스프링 처리)
		// => 메서드 선언시 방법 결정
		// 메서드의 리턴타입이 void일때 주소이름.jsp 뷰페이지로 이동(연결)
	}
	
	// http://localhost:8088/web/doA1
	//doA1 주소사용 페이지 호출
	@RequestMapping(value = "/doA1", method=RequestMethod.GET)
	public void doA1() {
		logger.debug("doA1() 실행");
	}
	
}