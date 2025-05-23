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
	public BoardPost findByIdAndIncreaseHit(Integer id) {
		BoardPost boardPost = boardPostRepository.findOne(id);
		boardPost.increaseHit();  // 조회수 증가
		return boardPost;
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		boardPostRepository.delete(id);
	}
	
	@Override
	public BoardPost save(BoardPost boardPost) {
		// TODO Auto-generated method stub
		//return boardPostRepository.save(boardPost);
		BoardPost savedPost = boardPostRepository.save(boardPost);
		savedPost.setNum(savedPost.getId());
		savedPost.setReply(0);
		savedPost.setHit(0);
		savedPost.setType("POST"); // POST: 게시글, COMMENT: 댓글
		//savedPost.setParent_id(null);
		
		return boardPostRepository.save(savedPost);
	}
	
	@Override
	public BoardPost reply(Integer parentId, BoardPost boardPost) {
		BoardPost parent = 
				boardPostRepository.findOne(parentId);
		
		BoardPost reply = new BoardPost();
		reply.setTitle(boardPost.getTitle());
		reply.setAuthor_name(boardPost.getAuthor_name());
		reply.setAuthor_pass(boardPost.getAuthor_pass());
		reply.setContent(boardPost.getContent());
		
		// num은 원글의 num을 따라감
		reply.setNum(parent.getNum());
		
		// 계층구조 설정
		reply.setParent_id(parent.getId());
		reply.setReply(parent.getReply() + 1);
		
		return boardPostRepository.save(reply);
	}

	@Autowired
	public void setBoardPostRepository(BoardPostRepository boardPostRepository) {
		this.boardPostRepository = boardPostRepository;
	}

	
}
