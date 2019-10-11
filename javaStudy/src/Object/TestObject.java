package Object;

import org.testng.annotations.Test;

/**
 * @projectName: javaStudy
 * @className: TestObject
 * @author: WenYichong
 * @date: 2019/9/1-12:18
 * @description: 连我自己都不知道在写什么......
 */
public class TestObject {

    class MyClass{
        public MyClass(String s) {
            this.s = s;
        }

        protected String s;
    }
    @Test
    public void test1(){
        String a=new String("abc"); String b=new String("abc");
        System.out.println(a==b);
        String a1=new String("asd");
        String b1=a1;
        System.out.println(a1==b1);
        Integer n=new Integer(9);
        change(n);
        System.out.println(n);
        MyClass myClass=new MyClass("ww");
        change2(myClass);
        System.out.println(myClass.s);
    }
    void change(Integer  s){
        s=90;
    }
    void change2(MyClass  s){
       s.s="ssss";
    }
}
