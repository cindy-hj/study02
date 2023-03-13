package com.example.dto;

import java.time.LocalDateTime;

import com.example.model.Board;

import lombok.Data;

@Data
public class BoardResponseDto {
	private Long id; // PK
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private int hits; // 조회수
	private char deleteYn; // 삭제 여부
	private LocalDateTime createdDate; // 생성일
	private LocalDateTime modifiedDate; // 수정일
	
	public BoardResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.writer = board.getWriter();
		this.hits = board.getHits();
		this.deleteYn = board.getDeleteYn();
		this.createdDate = board.getCreatedDate();
		this.modifiedDate = board.getModifiedDate();
	}
 }
