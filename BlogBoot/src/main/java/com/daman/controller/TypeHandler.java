package com.daman.controller;

import com.daman.entity.Blog;
import com.daman.entity.Type;
import com.daman.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeHandler {
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("findById/{id}")
    public Type findById(@PathVariable("id") Integer id){
        return typeRepository.findById(id).get();
    }

    @GetMapping("/findAll")
    public List<Type> findAll(){
        return typeRepository.findAll();
    }
}
