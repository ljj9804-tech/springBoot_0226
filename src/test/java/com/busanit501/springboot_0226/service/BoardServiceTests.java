package com.busanit501.springboot_0226.service;

import com.busanit501.springboot_0226.dto.BoardDTO;
import com.busanit501.springboot_0226.dto.PageRequestDTO;
import com.busanit501.springboot_0226.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("삭제 테스트용 더미2")
                .content("삭제 테스트용2")
                .writer("김꼬질")
                .build();

        Long bno = boardService.register(boardDTO);
        log.info("등록된 bno 확인 : " + bno);
    }

    @Test
    public void testSlelectOne() {
        Long bno = 101L;
        BoardDTO boardDTO = boardService.readOne(bno);
        log.info("하나 조회 결과: " + boardDTO);
    }

    @Test
    public void testModify() {
        BoardDTO boardDTO = boardService.readOne(99L);
        boardDTO.setTitle("수정 테스트_title2");
        boardDTO.setContent("수정 테스트_content2");
        boardService.modify(boardDTO);
    }

    @Test
    public void testRemove() {
        boardService.remove(101L);
    }

    @Test
    public void testList() {
// 준비물, 화면에서, 전달받은 페이징 정보와, 검색 정보를 담은
// PageRequestDTO 필요함.
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("더미")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        log.info("responseDTO 확인 : " + responseDTO);

    }



}
