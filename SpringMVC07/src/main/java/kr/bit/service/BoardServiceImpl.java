package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<Board> getList() {
		//반영할 로직이 있으면 서비스 단에서 처리 
		List<Board> list = boardMapper.getList();
		return list;
	}

	@Override
	public Member login(Member vo) {
		// 로그인
		Member mvo = boardMapper.login(vo);
		return mvo;
	}

	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);
	}

}
