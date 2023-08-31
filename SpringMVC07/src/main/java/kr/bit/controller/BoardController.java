package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.service.BoardService;

@Controller //POJO
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String getList(Model model) {
		List<Board> list = boardService.getList();
		//객체 바인딩
		model.addAttribute("list", list); //model
		return "board/list"; //view
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		return "board/register"; //view
	}
	
	@PostMapping("/register*")
	public String register(Board vo, RedirectAttributes rttr) { //파라미터 수집(vo) <--한글 encoding 필수 > pom에 설정
		boardService.register(vo); //게시물 등록(vo->idx,boardGroup)
		System.out.println(vo);
		//일회성 세션을 사용 > 데이터를 꺼내기 쉬움 ${result}
		rttr.addFlashAttribute("result", vo.getIdx());
		return "redirect:/board/list"; //view
	}
	
	@GetMapping("/get")
	public String get(@RequestParam("idx") int idx, Model model) {
		Board vo = boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/get"; // 경로: WEB-INF/views/board/get.jsp
	}

	@GetMapping("/modify")
	public String modify(@RequestParam("idx") int idx, Model model) {
		Board vo = boardService.get(idx);
		model.addAttribute("vo", vo);
		return "board/modify"; // 경로: WEB-INF/views/board/get.jsp
	}
	
	@PostMapping("/modify")
	public String modify(Board vo) {
		boardService.modify(vo); //수정
		return "redirect:/board/list"; // 경로: WEB-INF/views/board/get.jsp
	}
	
	@GetMapping("/remove")
	public String remove(int idx) {
		boardService.remove(idx);
		return "redirect:/board/list"; // 경로: WEB-INF/views/board/get.jsp
	}
	
	@GetMapping("/reply")
	public String reply(int idx, Model model) {
		Board vo = boardService.get(idx);
		model.addAttribute("vo",vo);
		return "board/reply";	// 경로: WEB-INF/views/board/reply.jsp	
	}
	
	//vo에 파라미터 수집
	@PostMapping("/reply")
	public String reply(Board vo) {
		//답글에 필요한 처리...
		
		boardService.replyProcess(vo); //답글저장됨
		return "redirect:/board/list"; // 경로: WEB-INF/views/board/get.jsp
	}


}
