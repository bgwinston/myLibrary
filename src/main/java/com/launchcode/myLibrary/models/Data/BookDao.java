package com.launchcode.myLibrary.models.Data;

import com.launchcode.myLibrary.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository <Book, Integer>{
}
