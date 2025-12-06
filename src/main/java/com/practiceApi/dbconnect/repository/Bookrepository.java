package com.practiceApi.dbconnect.repository;

import com.practiceApi.dbconnect.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepository extends JpaRepository<Book,Long> {
}
