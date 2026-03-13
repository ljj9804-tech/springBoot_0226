package com.busanit501.springboot_0226.repository;


import com.busanit501.springboot_0226.domain.Board;
import com.busanit501.springboot_0226.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
// 아무 기능이 없지만, 우리는 기본 기능을 이용해서, CRUD 를 테스트 할수 있다.

}
