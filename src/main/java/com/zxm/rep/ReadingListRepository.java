package com.zxm.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zxm.domain.Book;

import java.util.*;


public interface ReadingListRepository extends JpaRepository<Book,Long>{
	
	
	public List<Book> findBookByReader(String reader);
	
}
