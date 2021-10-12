package com.study.thejavatest.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private StudyStatus studyStatus = StudyStatus.DRAFT;

    private int limitCount;

    private String name;

    private LocalDateTime openedDateTime;

    private Long ownerId;


    public Study(int limitCount, String name) {
        this.limitCount = limitCount;
        this.name = name;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야함");
        }
        this.limitCount = limitCount;
    }

    public void open() {
        this.openedDateTime = LocalDateTime.now();
        this.studyStatus = StudyStatus.OPENED;
    }
}
