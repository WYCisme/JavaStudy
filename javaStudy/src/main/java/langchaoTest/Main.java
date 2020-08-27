package langchaoTest;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * @projectName: JavaStudy
 * @className: Main
 * @author: WenYichong
 * @date: 2019/10/13-12:31
 * @description: 连我自己都不知道在写什么......
 */
public class Main {
    void t01(){

    }
    void t02(){

    }
    public static void main(String[] args) {
    //入口
        ArrayList<Integer> nums= new ArrayList<>();
        nums.add(23);
        nums.add(3);
        nums.add(33);
        nums.add(21);
//        Integer array[] = (Integer[])nums.toArray();
//        Arrays.sort(array);
//        int len = nums.size();
//        System.out.printf(array[len-2].toString());
        Comparator<Integer> comparator =new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        ObservableList<Integer> ne=new ObservableListWrapper<>(nums);
        List<Integer> newN= new SortedList<>(ne,comparator);
        System.out.println(newN.get(nums.size()-2));
    }

}
