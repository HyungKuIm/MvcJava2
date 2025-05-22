package com.oraclejava.spring.sample1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping(value = "/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		BoardPost boardPost = boardPostService.findById(id);
		model.addAttribute("boardPost", boardPost);
		
		return "posts/show";
	}
	
	@GetMapping(value = "/{id}", params = "form")
	public String updateForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("boardPost", boardPostService.findById(id));
		return "posts/update";
	}
	
	@PostMapping(value = "/{id}", params = "form")
	public String update(@Validated BoardPost boardPost, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "글 수정에 실패하였습니다.");
			model.addAttribute("boardPost", boardPost);
			return "posts/create";
		}
		model.asMap().clear();  // 선택사항. 맵 클리어
		redirectAttributes.addFlashAttribute("message", "글 수정에 성공하였습니다.");
		
		boardPostService.save(boardPost);
		
		return "redirect:/boardPost/" + boardPost.getId();
	}
	
	@PostMapping(value = "/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {
		boardPostService.deleteById(id);
		return "redirect:/boardPost";
	}
	
	
	@GetMapping(params = "form")
	public String createForm(Model model) {
		BoardPost boardPost = new BoardPost();
		model.addAttribute("boardPost", boardPost);
		return "posts/create";
	}
	
	@PostMapping
	public String create(@Validated BoardPost boardPost, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "글 작성에 실패하였습니다.");
			model.addAttribute("boardPost", boardPost);
			return "posts/create";
		}
		model.asMap().clear();  // 선택사항. 맵 클리어
		redirectAttributes.addFlashAttribute("message", "글 작성에 성공하였습니다.");
		
		boardPostService.save(boardPost);
		
		return "redirect:/boardPost";
	}
	

	@Autowired
	public void setBoardPostService(BoardPostService boardPostService) {
		this.boardPostService = boardPostService;
	}
	
	
}
