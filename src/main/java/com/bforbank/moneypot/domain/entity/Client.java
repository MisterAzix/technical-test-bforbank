package com.bforbank.moneypot.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Client {
    private final Long id;
    private String name;
    private final Date createdAt;
    private Date updatedAt;

    public Client(Long id, String name, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}