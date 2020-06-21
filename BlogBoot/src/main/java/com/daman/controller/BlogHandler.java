package com.daman.controller;

import com.daman.entity.Blog;
import com.daman.repository.BlogRepository;
import com.daman.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class BlogHandler {
    @Autowired
    private BlogRepository blogRepository;

//    @Autowired
//    private TypeRepository typeRepository;

    @GetMapping("findAll/{page}")
    public Page findAll(@PathVariable("page") Integer page){
        Pageable pageable = PageRequest.of(page-1,5);
        return blogRepository.findAll(pageable);
    }

    @GetMapping("/findAll")
    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody Blog blog){
        Blog result = blogRepository.save(blog);
        if(result != null){
            return "success";
        }
        else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Blog findById(@PathVariable("id") Integer id){
        return blogRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Blog blog){
        Blog result = blogRepository.save(blog);
        if(result != null){
            return "success";
        }
        else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        blogRepository.deleteById(id);
    }
}
