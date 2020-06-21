package com.daman.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Type {
    @Id
    private Integer id;
    private  String type;
}
