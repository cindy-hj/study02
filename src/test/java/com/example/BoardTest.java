package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Board;
import com.example.repository.BoardRepository;

@SpringBootTest
public class BoardTest {

	@Autowired
	BoardRepository boardRepository;
	@Test
	public void save() {
		Board params = Board.builder()
							.title("1번 게시글 제목")
							.content("1번 게시글 내용")
							.writer("작성자")
							.hits(0)
							.deleteYn('N')
							.build();
		boardRepository.save(params);
	}
	// 대부분 위의 방법으로 작성함
	@Test
	public void save1() {
		Board params = new Board();
		params.setTitle("게시글 제목 save1");
		params.setContent("게시글 내용 save1");
		params.setWriter("작성자");
		params.setHits(0);
		params.setDeleteYn('N');
		
		boardRepository.save(params);
	}
}
