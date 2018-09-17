package com.hit.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class flower {
    public static void main(String[] args) {
        int n;
        int x1;
        int y1;
        int x2;
        int y2;
        int r1;//平方值
        int r2;//平方值
        int rr1=0;//喷泉1结果值
        int rr2=0;//喷泉2结果值

        System.out.print("输入");
        Scanner scan = new Scanner(System.in);
        n=Integer.parseInt(scan.nextLine());
        if (n<1) {
           n=1;
        }
        if (n > 2000) {
            n=2000;
        }
        x1=Integer.parseInt(scan.nextLine());
        y1=Integer.parseInt(scan.nextLine());
        x2=Integer.parseInt(scan.nextLine());
        y2=Integer.parseInt(scan.nextLine());
        if(x1<(int)Math.pow(-10, 7)){

        }
        if(x2<(int)Math.pow(-10, 7)){

        }

//        System.out.println("绝对值："+Math.abs(x1-x2));
//        3的平方
//        System.out.println((int)Math.pow(3, 2));

        if (n>=1 && n<=2000) {
            for (int i = 1; i < n+1; i++) {
                System.out.print("输入第"+i+"朵花坐标");
                //花的坐标
                int x=Integer.parseInt(scan.nextLine());
                int y=Integer.parseInt(scan.nextLine());

                int resultx1=(int)Math.pow(Math.abs(x1-x), 2);
                int resulty1=(int)Math.pow(Math.abs(y1-y), 2);
                r1=resultx1+resulty1;

                int resultx2=(int)Math.pow(Math.abs(x2-x), 2);
                int resulty2=(int)Math.pow(Math.abs(y2-y), 2);
                r2=resultx2+resulty2;

                /**
                 * 分别计算该花到两个喷泉之间的距离，取最小的那个
                 */
                if (r1 <= r2) {
                    if(rr1==0 || r1>rr1){
                        rr1=r1;
                    }
                    if (rr2 != 0) {
                        if (rr2 >= r2) {
                            rr1=0;
                        }
                    }
                }else if (r2 <= r1) {
                    if(rr2==0 || r2>rr2){
                        rr2=r2;
                    }
                    if (rr1 != 0) {
                        if (rr1 >= r1) {
                            rr2=0;
                        }
                    }
                }
            }
        }
        System.out.println("r1²+r2²="+rr1+rr2);
    }
}
