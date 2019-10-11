package PaperTest;

/**
 * @projectName: javaStudy
 * @className: Tencent3
 * @author: WenYichong
 * @date: 2019/9/20-20:51
 * @description: 腾讯第三次笔试......
 */
import java.util.Scanner;
public class Main {
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t=0;
            t=in.nextInt();
            String[] res =new String[100];
            for (int i=0 ;i <t;i++){
                String n="";
                n=in.next();
                String s="";
                s=in.next();
                if ("11".compareTo(n)==0){
                    char c=s.toCharArray()[0];
                    if ('8'== c){
                        res[i]="YES";
                    }else {
                        res[i]="NO";
                    }
                }else if("11".compareTo(n)>0){
                    res[i]="NO";
                }else  {
                    char[] c=s.toCharArray();
                    int len=c.length;
                    boolean f=false;
                    for (int k=0;k<len-11;k++){
                        if (c[k]=='8'){
                            res[i]="YES";
                            f=true;
                            break;
                        }
                    }
                    if (!f) res[i]="NO";
                }
            }
            for (String re : res) {
                if (re==null) break;
                System.out.println(re);
            }
        }
}
