package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.BoardRequestDto;
import com.example.dto.BoardResponseDto;
import com.example.model.Board;
import com.example.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	/*
	 * 게시글 생성
	 */
	@Transactional
	public Long save(BoardRequestDto params) {
		Board entity = boardRepository.save(params.toEntity());
		return entity.getId();
	}
	
	public List<BoardResponseDto> findAll() {
		Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
		List<Board> list = boardRepository.findAll(sort);
		
		List<BoardResponseDto> boardList = new ArrayList<>();
		for(Board board:list) {
			boardList.add(new BoardResponseDto(board));
		}
		return boardList;
	}
	
	public List<BoardResponseDto> findAll2() {
		Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
		List<Board> list = boardRepository.findAll(sort);
		
		return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
	}
	
	@Transactional // 데이터가 변경된것을 최종적으로 적용시킴
	public Long update(Long id, BoardRequestDto params) {
		Board board = boardRepository.findById(id).orElseThrow(null);
		board.update(params.getTitle(), params.getContent(), params.getWriter());
		return id;
	}
	
	@Transactional
	public BoardResponseDto findById(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(null);
		board.increaseHits();
		return new BoardResponseDto(board);
	}
	
	@Transactional
	public BoardResponseDto findByIdDelete(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(null);
		board.delete();
		return new BoardResponseDto(board);
	}


}
