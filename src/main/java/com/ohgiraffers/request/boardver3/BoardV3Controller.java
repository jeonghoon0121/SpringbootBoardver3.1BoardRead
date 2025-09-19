package com.ohgiraffers.request.boardver3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/boardv3")
public class BoardV3Controller {
    private final BoardV3Service boardV3Service;

    public BoardV3Controller(BoardV3Service boardV3Service){
        this.boardV3Service =boardV3Service;
    }
    @GetMapping
    public String homeBoard(Model model){
        System.out.println("1");
        List<BoardV3DTO> boardV3DTOs=boardV3Service.findAllBoards();
        System.out.println("2");
        for(BoardV3DTO boards : boardV3DTOs){
            System.out.println(boards);
        }
        model.addAttribute("boardV3DTOs",boardV3DTOs);
        return "boardv3/description";
    }
    @GetMapping("/{boardId}")
    public String viewBoard(@PathVariable Long boardId, Model model) {
        BoardV3DTO board = boardV3Service.findBoardById(boardId);
//        List<PostV3DTO> posts=postV3Service.selectPostByBoardId(board.getBoardId());
        model.addAttribute("board", board);
//        model.addAttribute("posts",posts);
        return "boardv3/"+boardId;
    }
}
