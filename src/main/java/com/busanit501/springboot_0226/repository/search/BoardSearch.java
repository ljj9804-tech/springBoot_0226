package com.busanit501.springboot_0226.repository.search;

import com.busanit501.springboot_0226.domain.Board;
import com.busanit501.springboot_0226.dto.BoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    //검색 결과도 페이징 처리 예정
    Page<Board> search1(Pageable pageable);

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);

    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable);

}
