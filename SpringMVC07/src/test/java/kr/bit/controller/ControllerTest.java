package kr.bit.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
//메모리에 다음 파일 등록 > db, controller
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class ControllerTest {

	//WebAppConfiguration > spring container 생성

	@Autowired
	private WebApplicationContext ctx; //Spring Container > memory 저장소 생성	
	private MockMvc mockMvc; // 가상 server 생성 및 구동
	
	//가상 환경 세팅
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//board 데이터들이 model에 보여짐, view의 정보가 보여짐
	@Test
	public void getListTest() throws Exception{
		log.info(
				//요청을 날려주는 함수, 뷰와 바인딩 된 model을 가지고 와서 controller 실행
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				//.getModelAndView());
				.getModelAndView().getModelMap());	
	}
}
