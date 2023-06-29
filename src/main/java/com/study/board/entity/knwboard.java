package com.study.board.entity;

import lombok.Data;

import javax.persistence.*;

@Entity // 대충 DB 관련 연결 설정을 담당함을 명시하는 jpa
@Data // lombok 을 쓰기위한 jpa
@SequenceGenerator( // DB내에 시퀸스를 받아와서 쓰기위한 준비작업 오라클 형식임 generater는 table형식으로 받아오는것도 있는데 느려서 잘 안쓴다함
        name = "knwboard_seq_GENERATOR",
        sequenceName = "knwboard_seq",
        initialValue = 1, allocationSize = 1)
public class    knwboard {

    @Id // jpa를 이용해서 spring에 pk는 DB에서 이값이라고 선언해줌 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "knwboard_seq_GENERATOR") // 시퀸스를 받아와서 next.val작업을 바로 수행해주는 jpa
    private Integer id;


    private String title;
    private String content;
}
