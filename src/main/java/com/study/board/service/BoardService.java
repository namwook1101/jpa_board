package com.study.board.service;

import com.study.board.entity.knwboard;
import com.study.board.repository.BoardRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 서비스 임을 명시하는 jpa
public class BoardService {

    @Autowired // java에서 ooo = new ooo() 하는 작업을 생략하고 넣어주는 jpa
    private BoardRepositery boardRepositery;

    //글 작성
    public void write(knwboard board){
        boardRepositery.save(board);
    }

    // 게시글 리스트 처리
    public List<knwboard> knwboardList(){
        return boardRepositery.findAll();
    }

    //특정 게시글 불러오기
    public knwboard boardview(Integer id){

        return boardRepositery.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepositery.deleteById(id);
    }

}
