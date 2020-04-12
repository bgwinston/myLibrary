package com.launchcode.myLibrary.models.Data;

import com.launchcode.myLibrary.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface bookDao extends CrudRepository <Book, Integer>{
}
