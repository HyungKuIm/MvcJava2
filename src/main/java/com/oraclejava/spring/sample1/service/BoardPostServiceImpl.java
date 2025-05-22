package com.oraclejava.spring.sample1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.oraclejava.spring.sample1.entity.BoardPost;
import com.oraclejava.spring.sample1.repo.BoardPostRepository;

@Transactional
@Service("boardPostService")
public class BoardPostServiceImpl implements BoardPostService {
	
	private BoardPostRepository boardPostRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<BoardPost> findAll() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(boardPostRepository.findAll());
	}
	
	@Override
	@Transactional(readOnly = true)
	public BoardPost findById(Integer id) {
		// TODO Auto-generated method stub
		return boardPostRepository.findOne(id);
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		boardPostRepository.delete(id);
	}
	
	@Override
	public BoardPost save(BoardPost boardPost) {
		// TODO Auto-generated method stub
		return boardPostRepository.save(boardPost);
	}
	

	@Autowired
	public void setBoardPostRepository(BoardPostRepository boardPostRepository) {
		this.boardPostRepository = boardPostRepository;
	}

	
}
