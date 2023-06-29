package com.study.board.repository;

import com.study.board.entity.knwboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositery extends JpaRepository<knwboard,Integer> { 
    // repositery를 인터페이스 설정 후 JpaRepository라는 것을 상속 받는데 이는 DB작업을 수월하게 해줌
    // 괄호 안에는 (entity, pk의 타입) 즉 jpa로 @entity 명시해준 클래스 이름과 DB pk의 값의 타입을 넣어주게 됨
    // 이 작업을 수행함으로 써 save, delete, findall 등 다양한 기능 메소드 사용가능 복잡한 DB작업을 생략해주는 편리한 친구들
}
