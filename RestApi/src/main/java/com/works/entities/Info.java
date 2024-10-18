package com.works.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String url;
    private String name;
    private String roles;
    private String detail;
    private Long time;
    private String sessionId;

    public Info() {
    }

    public Info(String url, String name, String roles, String detail, Long time, String sessionId) {
        this.url = url;
        this.name = name;
        this.roles = roles;
        this.detail = detail;
        this.time = time;
        this.sessionId = sessionId;
    }
}
