package com.oraclejava.spring.sample1.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.oraclejava.spring.sample1.entity.BoardPost;

public interface BoardPostRepository extends PagingAndSortingRepository<BoardPost, Integer>{

	@Query("select b from BoardPost b order by b.id desc")
	Iterable<BoardPost> findAll();
}
