package com.example.dto;

import com.example.model.Board;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardRequestDto {
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private char deleteYn; // 삭제 여부
	
	public Board toEntity() {
		return Board.builder()
					.title(title)
					.content(content)
					.writer(writer)
					.hits(0)
					.deleteYn(deleteYn)
					.build();
	}
}
