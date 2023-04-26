package HW1;

import java.util.Scanner;

class MixedNumber{
    int[] part = new int[4];//[0] is sign, [1] is integral part
                            //[2] is numerator, [3] is denominator

    public void set() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the sigh of the mixed number?");
        if (in.next().equals("-")) {
            part[0] = 1;
        } else {
            part[0] = 0;
        }
        System.out.println("What is the integral part?");
        part[1] = in.nextInt();
        System.out.println("What is the numerator part?");
        part[2] = in.nextInt();
        System.out.println("What is the denominator part?");
        part[3] = in.nextInt();
        in.close();
    }

    //From Mixed number form convert into Fraction form
    public Fraction conevrtintoF() {
        Fraction tem = new Fraction();
        tem.i1 = part[1] * part[3] + part[2];
        tem.i2 = part[3];
        if (part[0] == 1) {
            tem.check = true;
        } else {
            tem.check = false;
        }
        return tem;
    }

    //From Mixed number form convert into Fraction form
    public MixedNumber conevrtintoM(Fraction in) {
        MixedNumber tem = new MixedNumber();
        tem.part[1] = in.i1 / in.i2;
        tem.part[2] = in.i1 % in.i2;
        tem.part[3] = in.i2;
        if (in.check) {
            tem.part[0] = 1;
        } else {
            tem.part[0] = 0;
        }
        return tem;
    }

    public void output() {
        if (part[0] == 1) {
            System.out.print("-");
        } else {
            
        }
        if (part[1] != 0) {
            System.out.println(part[1] + " " + part[2] + "/" + part[3]);
        } else {
            System.out.println(part[2] + '/' + part[3]);
        }
    }

}

public class TestMixedNumber {
    public static void main(String[] args) {
        MixedNumber test = new MixedNumber();
        FractionOperation x = new FractionOperation();
        test.set();
        Fraction a = new Fraction();
        a = test.conevrtintoF();
        test.output();
        x.output(a);
    }
}
