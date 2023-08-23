package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.entity.Board;

@Mapper
public interface BoardMapper { //xml, annotation

	//전체목록
	public List<Board> getList();
	//등록처리
	public void insert(Board vo);
	//등록처리2
	public void insertSelectKey(Board vo);
		
}
