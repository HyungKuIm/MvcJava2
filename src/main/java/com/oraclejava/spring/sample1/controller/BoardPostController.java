package com.oraclejava.spring.sample1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oraclejava.spring.sample1.entity.BoardPost;
import com.oraclejava.spring.sample1.service.BoardPostService;

@RequestMapping("/boardPost")
@Controller
public class BoardPostController {

	private BoardPostService boardPostService;
	
	@GetMapping
	public String list(Model model) {
		List<BoardPost> boardPosts = boardPostService.findAll();
		model.addAttribute("boardPosts", boardPosts);
		return "posts/list";
	}

	@Autowired
	public void setBoardPostService(BoardPostService boardPostService) {
		this.boardPostService = boardPostService;
	}
	
	
}
