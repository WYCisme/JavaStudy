package Leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @projectName: javaStudy
 * @className: Solution
 * @author: WenYichong
 * @date: 2019/9/17-14:47
 * @description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。......
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        int n=1;//从后面往前面判断，开始离数组最后一个的距离为 1
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=n){//如果能到达最后一个就重置距离为1，相当于截断后面的
                n=1;
            }else {//否则就把距离+1
                n++;
            }
        }
        if(n>1){//如果遍历到第一个完之后，需要到达下一个的距离 >1 ,说明无法到达。
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n[]={3,2,1,0,4};//false
//        int n[]={3,0,8,2,0,0,1};//true
        System.out.println(canJump(n));
    }
}
