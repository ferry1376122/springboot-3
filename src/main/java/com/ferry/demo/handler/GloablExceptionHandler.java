package com.ferry.demo.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ferry.demo.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.写一个全局异常处理，相当于默认处理机制
 * 2.针对特殊场景的异常，比如数据校验部分，做定制化机制。
 */
@ControllerAdvice
@Slf4j
public class GloablExceptionHandler {

    private Logger logger= LoggerFactory.getLogger(GloablExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException e) throws JsonProcessingException {
        BindingResult bindingResult = e.getBindingResult();
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
        return new ResultBean("400",asString);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e){
        logger.error(e.getMessage());
        return new ResultBean("success","当前服务器繁忙，请稍后再试");
    }

}
