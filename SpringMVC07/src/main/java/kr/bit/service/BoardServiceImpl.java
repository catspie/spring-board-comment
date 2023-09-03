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

	@Override
	public Board get(int idx) {
		Board vo = boardMapper.read(idx);
		return vo;
	}

	@Override
	public void modify(Board vo) {
		boardMapper.update(vo);	
	}

	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);
	}

	@Override
	public void replyProcess(Board vo) {
		//-답글만들기
		//1. 부모글(원글)의 정보를 가져오기 (vo->idx)
		Board parent = boardMapper.read(vo.getIdx());
		//2. 부모글의 boardGroup의 값을 -> 답글정보에 저장하기
		vo.setBoardGroup(parent.getBoardGroup());
		//3. 부모글의 시퀀스 값에 1을 더해 -> 답글(vo) 정보에 저장하기 
		vo.setBoardSequence(parent.getBoardSequence()+1);
		//4. 부모글의 level의 값에 1을 더해 -> 답글(vo) 정보에 저장하기
		vo.setBoardLevel(parent.getBoardLevel()+1);
		//5. 같은 boardGroup에 있는 글 중에서 부모글의 시퀀스보다 큰 값들을 모두 1씩 update하기 
		//부모글의 시퀀스보다 큰 값들을 모두 1씩 업데이트 하기 
		boardMapper.replySeqUpdate(parent);
		//6. 답글을 (vo) 저장하기 
		boardMapper.replyInsert(vo);
	}
}
