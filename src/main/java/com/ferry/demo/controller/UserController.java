package com.ferry.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ferry.demo.bean.User;
import com.ferry.demo.config.Resource;
import com.ferry.demo.pojo.ResultBean;
import com.ferry.demo.service.IUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUser iUser;

    //@RequestMapping(value="hello",method = RequestMethod.GET)
    @GetMapping("hello")
    public String hello(){
        return "hello,Spring!testtesttest!";
    }

    @Autowired
    private Resource resource;

    @GetMapping("{id}")
    public User getById(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        System.out.println("获取信息");
        return iUser.getById(id);
    }

    @DeleteMapping("{id}")
    public String delById(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        System.out.println("删除信息");
        return "OK!";
    }

    /*@PostMapping("add")
    public ResultBean add(@Valid User user, BindingResult bindingResult) throws JsonProcessingException {
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String,String> result=new HashMap<String,String>();
            for(FieldError fieldError:fieldErrors){
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                log.error("[{}]:[{}])",field,message);
                System.out.println(field+":"+message);
                result.put(field,message);
            }
            ObjectMapper objectMapper=new ObjectMapper();
            String asString = objectMapper.writeValueAsString(result);
            return new ResultBean("fail",asString);
        }
        return new ResultBean("sucess","ok");
    }*/

    @PostMapping("add")
    public ResultBean add(@Valid User user) throws JsonProcessingException {
        return new ResultBean("sucess","ok");
    }

    @GetMapping("getImageServer")
    public String getImageServer(){
        return resource.getImageServer();
    }

}
