package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BoardRequestDto;
import com.example.dto.BoardResponseDto;
import com.example.service.BoardService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardAPIController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/boards")
	public Long save(@RequestBody BoardRequestDto params) {
		return boardService.save(params);
	}
	
	@GetMapping("/boards1")
	public List<BoardResponseDto> findAll() {
		return boardService.findAll();
	}
	
	@GetMapping("/boards2")
	public List<BoardResponseDto> findAll2() {
		return boardService.findAll2();
	}
	
	@PatchMapping("/boards/{id}")
	public Long save(@PathVariable Long id, @RequestBody BoardRequestDto params) {
		return boardService.update(id, params);
	}
	
	@GetMapping("/boards/{id}")
	public BoardResponseDto findById(@PathVariable Long id) {
		return boardService.findById(id);
	}
	
	@DeleteMapping("/boards/{id}")
	public BoardResponseDto findByIdDelete(@PathVariable Long id) {
		return boardService.findByIdDelete(id);
	}
}
