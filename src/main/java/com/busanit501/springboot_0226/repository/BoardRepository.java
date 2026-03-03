package com.busanit501.springboot_0226.repository;

import com.busanit501.springboot_0226.domain.Board;
import com.busanit501.springboot_0226.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

}
