package Collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import static cn.hutool.core.lang.Console.log;

/**
 * @projectName: javaStudy
 * @className: TestSet
 * @author: WenYichong
 * @date: 2019/9/1-11:32
 * @description: 连我自己都不知道在写什么......
 */
public class TestSet {

    @Test
    public void test() {

        TreeMap<String,Integer> treeMap =new TreeMap<>();
        treeMap.put("A",666);

        Set<String> set=new HashSet<>();

        set.add(treeMap.toString());
        log("set:{}",set);
    }

}
