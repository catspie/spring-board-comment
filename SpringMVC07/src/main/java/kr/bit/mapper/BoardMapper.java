package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.entity.Board;
import kr.bit.entity.Member;

@Mapper
public interface BoardMapper { //xml, annotation

	//전체목록
	public List<Board> getList();
	//등록처리 ver.1
	public void insert(Board vo);
	//등록처리 ver.2
	public void insertSelectKey(Board vo);
	//로그인
	public Member login(Member vo);
				
}
