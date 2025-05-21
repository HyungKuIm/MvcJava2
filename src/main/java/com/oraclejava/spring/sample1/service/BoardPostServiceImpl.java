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

	@Autowired
	public void setBoardPostRepository(BoardPostRepository boardPostRepository) {
		this.boardPostRepository = boardPostRepository;
	}

	
}
