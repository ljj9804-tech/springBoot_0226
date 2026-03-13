package com.busanit501.springboot_0226.service;


import com.busanit501.springboot_0226.dto.PageRequestDTO;
import com.busanit501.springboot_0226.dto.PageResponseDTO;
import com.busanit501.springboot_0226.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);

    ReplyDTO read(Long rno);
    void modify(ReplyDTO replyDTO);
    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);


}
