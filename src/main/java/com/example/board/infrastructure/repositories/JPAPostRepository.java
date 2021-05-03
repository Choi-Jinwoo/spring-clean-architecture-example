package com.example.board.infrastructure.repositories;

import com.example.board.infrastructure.tables.PostTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAPostRepository extends JpaRepository<PostTable, Long> {
}
