package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.entity.Board;

@Mapper
public interface BoardMapper { //xml, annotation

	public List<Board> getList();
	
}
