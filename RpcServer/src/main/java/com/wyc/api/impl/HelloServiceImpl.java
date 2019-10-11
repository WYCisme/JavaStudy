package com.wyc.api.impl;

import com.wyc.api.service.SomeService;

/**
 * @projectName: javaStudy
 * @className: HelloServiceImpl
 * @author: WenYichong
 * @date: 2019/9/19-22:03
 * @description: 连我自己都不知道在写什么......
 */
public class HelloServiceImpl implements SomeService {
    public String doSome(String depart) {
        return "Hello "+ depart;
    }
}
