package com.icia.board.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 작성시간 수정시간 컬럼을 가지는 클래스
 * 이 클래스를 상속받은 클래는 작성시간, 수정시간 칼럼을 추가함
 */

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Setter(AccessLevel.PRIVATE)
@Getter
@ToString

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)  // 업데이트 시에는 무시해라
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(insertable = false) // 인서트할 때는 가만히있어라
    private LocalDateTime updatedAt;

}
