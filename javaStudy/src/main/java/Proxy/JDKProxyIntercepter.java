package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @projectName: javaStudy
 * @className: PeopleIntercepter
 * @author: WenYichong
 * @date: 2019/8/27-10:12
 * @description: 连我自己都不知道在写什么......
 */
public class JDKProxyIntercepter implements InvocationHandler {
    private Object target;

    public JDKProxyIntercepter(Object target){
        this.target=target;
    }
    public void setTarget(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始拦截代理目标对象的方法");
        System.out.println("日志处理----");
        System.out.println("开始事务----");
        method.invoke(this.target,args);//调用目标方法
        System.out.println("事务结束----");
        System.out.println("完成日志----");

        return null;
    }
    public Object creatProxy(){
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
    }
}
