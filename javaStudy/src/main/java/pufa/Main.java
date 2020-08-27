package pufa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @projectName: JavaStudy
 * @className: Main
 * @author: WenYichong
 * @date: 2019/10/18-19:12
 * @description: 连我自己都不知道在写什么......
 */
public class Main {
    /*
        * @author: WenYichong
        * @date: 2019/10/21  21:21
        * @method: test01
    　　* @param: []
    　　* @return_type: void
        * @description: 浦发测试题1
    */
    public static void test01(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> sums=new ArrayList<>();
        while (scanner.hasNext()) {
            String ss=scanner.nextLine();
            String[] sss;
            sss = ss.split(" ");
            int sum=Integer.parseInt(sss[0])+Integer.parseInt(sss[1]);
            sums.add(sum);
        }
        for (int i:sums){
            System.out.println(i);
        }

    }
    /*
        * @author: WenYichong
        * @date: 2019/10/21  21:21
        * @method: test02
    　　* @param: []
    　　* @return_type: void
        * @description: 浦发正式题1
    */
public static void test02(){
    Scanner scanner=new Scanner(System.in);
    String [] chars=scanner.nextLine().split(" ");
    int x=Integer.parseInt(chars[0]) + Integer.parseInt(chars[1]);
    int y=Integer.parseInt(chars[2]) + Integer.parseInt(chars[3]);
    System.out.println(x/2+" "+y/2);
}
/*
    * @author: WenYichong
    * @date: 2019/10/21  21:21
    * @method: test03
　　* @param: []
　　* @return_type: void
    * @description: 浦发正式题2
*/
    public static void test03(){

    }
    public static void main(String[] args) {
//        test01();
//        test02();
    }
}
