package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@WebAppConfiguration : 스프링 웹(MVC)으로 Controller 테스트 하겠다.(서버사용O)
// 이거없으면 서버를 쓰지않고 테스트하겠다.

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration (
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class SampleControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	//MockMvc : 웹브라우저에서 HTTP 통신을 할 때 요청, 응답을 처리하는 테스트용 객체
	private MockMvc mockMvc; // 주입받지 않고 별도의 형태로 생성해야함
	
//	@Before : @Test 실행전에 반드시 처리해야하는 메서드
	@Before
	public void setUp() {
		// MockMvc 객체를 생성(준비)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		logger.debug("MockMvc 객체 생성 완료!(테스트 준비)");
	}
	
	@Test
	public void controllerTest() {
		// 서버없이 컨트롤러를 테스트
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
