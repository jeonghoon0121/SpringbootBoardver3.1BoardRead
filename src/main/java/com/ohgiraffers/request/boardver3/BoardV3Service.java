package com.ohgiraffers.request.boardver3;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardV3Service {
    private final BoardV3Mapper boardV3Mapper;
    public BoardV3Service(BoardV3Mapper boardV3Mapper){this.boardV3Mapper=boardV3Mapper;}
    public List<BoardV3DTO> findAllBoards() {
//        System.out.println(boardV3Mapper.findAllBoards());
        return boardV3Mapper.findAllBoards();
    }
    public BoardV3DTO findBoardById(Long boardId) {
        return boardV3Mapper.selectBoardById(boardId);
    }
}
