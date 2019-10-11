package Threader;


import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @projectName: javaStudy
 * @className: Meituan
 * @author: WenYichong
 * @date: 2019/9/11-16:28
 * @description: 连我自己都不知道在写什么......
 */
public class ReviewEncourage {
    public AtomicInteger size=new AtomicInteger(1);
    public AtomicIntegerFieldUpdater<ReviewEncourage> tex=AtomicIntegerFieldUpdater.newUpdater(ReviewEncourage.class,"tag");
    public int max=0;
    public int getTag() {
        return tag;
    }

    public volatile int tag=0;
    public ReviewEncourage(int n) {
       max=n;
    }      // 构造函数,n为中奖用户数

    public static class PrizePool {
        public void send(String input) {
            System.out.print(input);
        }
    }

    public void bonus(PrizePool prizePool) {
        prizePool.send("A");
    }  // 仅能打印A，表示发放积分
    public void coupon(PrizePool prizePool) {
        prizePool.send("B");
    }  // 仅能打印B，表示发放优惠券
    public void contribution(PrizePool prizePool) {
        prizePool.send("C");
    }  // 仅能打印C，表示发放贡献值

    public static void main(String[] args) {
        int n=0;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        final ReviewEncourage reviewEncourage=new ReviewEncourage(n);
        final PrizePool prizePool=new PrizePool();

        ExecutorService executorService=Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
//                reviewEncourage.bonus(prizePool);
                int n=reviewEncourage.size.getAndAdd(1);
                if (n%2 != 0){
                    //奇数
                    reviewEncourage.bonus(prizePool);
                }else{
                    if(!reviewEncourage.tex.compareAndSet(reviewEncourage,0,1)){
                        reviewEncourage.coupon(prizePool);
                    }else {
                        reviewEncourage.tex.compareAndSet(reviewEncourage,1,0);
                        reviewEncourage.contribution(prizePool);
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
//                reviewEncourage.bonus(prizePool);
                int n=reviewEncourage.size.getAndAdd(1);
                if (n%2 != 0){
                    //奇数
                    reviewEncourage.bonus(prizePool);
                }else{
                    if(!reviewEncourage.tex.compareAndSet(reviewEncourage,0,1)){
                        reviewEncourage.coupon(prizePool);
                    }else {
                        reviewEncourage.tex.compareAndSet(reviewEncourage,1,0);
                        reviewEncourage.contribution(prizePool);
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
//                reviewEncourage.bonus(prizePool);
                int n=reviewEncourage.size.getAndAdd(1);
                if (n%2 != 0){
                    //奇数
                    reviewEncourage.bonus(prizePool);
                }else{
                    if(!reviewEncourage.tex.compareAndSet(reviewEncourage,0,1)){
                        reviewEncourage.coupon(prizePool);
                    }else {
                        reviewEncourage.tex.compareAndSet(reviewEncourage,1,0);
                        reviewEncourage.contribution(prizePool);
                    }
                }
            }
        });

        executorService.shutdown();
    }
}
