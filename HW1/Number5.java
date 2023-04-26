package HW1;
import java.util.Scanner;
import java.lang.Math;

class Fraction{
    int i1;//分子
    int i2;//分母
    int o1;
    boolean check = false;//sign
    Scanner in = new Scanner(System.in);

    public void preinput() {
        System.out.println("请输入分子：");
        i1 = in.nextInt();
        System.out.println("请输入分母");
        i2 = in.nextInt();
        //in.close();
        check();
        i1 = Math.abs(i1);
        i2 = Math.abs(i2);
    }

    public void check() {
        if (i1*i2 < 0) {
            check = true;
        } 
    }

    public void imput() {
        preinput();
        while (i2 == 0) {
            System.out.println("输入错误，请重新输入");
            preinput(); 
        }
    }

    public void simplify() {
        o1 = i1;
        int o2 = i2;
        int r;
        while (o2 != 0) {
            r = o1 % o2;
            o1 = o2;
            o2 = r;
        }
        i1 = i1 / o1;
        i2 = i2 / o1;
    }
}

public class Number5 {
   public static void main(String[] args) {
    Fraction tem = new Fraction();
    tem.imput();
    tem.simplify();
    System.out.println("最大公约数为" + tem.o1);
    if (tem.check == false) {
        System.out.println("约分后的数为" + tem.i1 + "/" + tem.i2); 
    } else {
        System.out.println("约分后的数为" + "-" + tem.i1 + "/" + tem.i2); 
    }
   } 
}
