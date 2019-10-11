package com.wyc.rpcService;


import lombok.Data;

/**
 * @projectName: javaStudy
 * @className: InvokMessage
 * @author: WenYichong
 * @date: 2019/9/17-21:56
 * @description: 连我自己都不知道在写什么......
 */
@Data
public class InvokMessage {

    private String className;

    private String methodName;

    private Class<?>[] paramTypes;

    private Object[] paramValues;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(Object[] paramValues) {
        this.paramValues = paramValues;
    }
}
