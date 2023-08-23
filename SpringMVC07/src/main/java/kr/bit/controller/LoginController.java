package kr.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Member;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/login/*")
public class LoginController {

	@Autowired
	BoardService boardService;
	
	//1.세션으로 로그인 
	//2. 스프링 세큐리티로 로그인
	@RequestMapping("/loginProcess")
	public String login(Member vo, HttpSession session) {
		Member mvo = boardService.login(vo);
		//객체 바인딩 > 다른 jsp 파일에서도 mvo가 있는지 확인할 수 있도록 설정
		if(mvo != null) { //로그인 성공
			session.setAttribute("mvo", mvo);
		}else {
			
		}
		return "redirect:/board/list";
	}
	
	@RequestMapping("/logoutProcess")
	public String logout(Member vo, HttpSession session) {
		session.invalidate(); //세션 무효화
		return "redirect:/board/list";
	}

}
