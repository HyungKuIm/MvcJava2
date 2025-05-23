package com.oraclejava.spring.sample1.service;

import java.util.List;

import com.oraclejava.spring.sample1.entity.BoardPost;

public interface BoardPostService {
	List<BoardPost> findAll();
	BoardPost save(BoardPost boardPost);
	BoardPost reply(Integer parentId, BoardPost boardPost);
	BoardPost findById(Integer id);
	BoardPost findByIdAndIncreaseHit(Integer id);
	void deleteById(Integer id);
}
