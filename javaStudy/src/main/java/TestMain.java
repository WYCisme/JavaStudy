import Proxy.*;
import org.junit.Test;

import static Threader.MasterThread.test1;

/**
 * @projectName: javaStudy
 * @className: TestMain
 * @author: WenYichong
 * @date: 2019/8/4-21:56
 * @description: 连我自己都不知道在写什么......
 */
public class TestMain {



    @Test
    public void A(){
        test1();
    }

    @Test
    public void TestJDKProxy(){
        People people=  new PeopleImp("蔡徐坤","唱跳rap打篮球");
        JDKProxyIntercepter intercepter=new JDKProxyIntercepter(people);
        /*
            * @author: WenYichong
            * @date: 2019/8/27  10:21
            * @description: 生成一个People代理对象
        */
        People peopleProxy=(People) intercepter.creatProxy();
        peopleProxy.show();
        System.out.println(peopleProxy.getClass().getName());
        //代理狗
        Dog dog=  new DogImp();
//        JDKProxyIntercepter intercepter2=new JDKProxyIntercepter(dog);
        /*
            * @author: WenYichong
            * @date: 2019/8/27  10:21
            * @description: 生成一个Dog代理对象
        */
        intercepter.setTarget(dog);
        Dog dogProxy=(Dog) intercepter.creatProxy();
        dogProxy.show();
        System.out.println(dogProxy.getClass().getName());
        peopleProxy.show();//当前拦截器已经不属于peopleProxy


    }

}
