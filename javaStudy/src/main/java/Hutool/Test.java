package Hutool;

import cn.hutool.core.convert.Convert;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import static cn.hutool.core.lang.Console.log;

/**
 * @projectName: JavaStudy
 * @className: Test
 * @author: WenYichong
 * @date: 2020/8/17-15:23
 * @description: 连我自己都不知道在写什么......
 */

//@SpringBootTest
@Slf4j
public class Test {

    @org.junit.Test
    public void test() {
        int a = 1;
//aStr为"1"
        String aStr = Convert.toStr(a);

        long[] b = {1,2,3,4,5};
//bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        log("aStr:{},bStr:{}",aStr,bStr);

        String strList = "[231,243,33,4,534,6,54,6,756,3245]";
        List<?> cList = Convert.toList(strList);

    }

//    金额转大写
    @org.junit.Test
    public void jine(){
        double a = 6755897897896.32;

//结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);

        log("￥{}转大写：{}",a,digitUppercase);
    }

    


}
