package HW1;

class FractionOperation {
    Fraction[] fractions = new Fraction[3];
    
    public void set() {
        System.out.println("请输入第一个分数");
        fractions[1] = new Fraction();
        fractions[1].imput();;
        System.out.println("请输入第二个分数");
        fractions[2] = new Fraction();
        fractions[2].imput();;
    }
    
    public void add() {
        set();
        fractions[0] = new Fraction();
        fractions[0].i2 = fractions[1].i2 * fractions[2].i2;
        if (fractions[1].check ^ fractions[2].check == false) {
            fractions[0].i1 = fractions[1].i1 * fractions[2].i2 + fractions[2].i1 * fractions[1].i2;
            fractions[0].check = false;
        } else {
            fractions[0].i1 = fractions[1].i1 * fractions[2].i2 - fractions[2].i1 * fractions[1].i2;    
            fractions[0].check = true;
        }
        fractions[0].simplify();
    }

    public void subtract() {
        set();
        fractions[0] = new Fraction();
        fractions[0].i2 = fractions[1].i2 * fractions[2].i2;
        if (fractions[1].check ^ fractions[2].check == false) {
            fractions[0].i1 = fractions[1].i1 * fractions[2].i2 - fractions[2].i1 * fractions[1].i2;
            fractions[0].check = false;
        } else {
            fractions[0].i1 = fractions[1].i1 * fractions[2].i2 + fractions[2].i1 * fractions[1].i2;    
            fractions[0].check = true;
        }
        fractions[0].simplify(); 
    }

    public void multiply() {
        set();
        fractions[0] = new Fraction();
        fractions[0].i2 = fractions[1].i2 * fractions[2].i2;
        fractions[0].i1 = fractions[1].i1 * fractions[2].i1;
        if (fractions[1].check ^ fractions[2].check == false) {
            fractions[0].check = false;
        } else {
            fractions[0].check = true;
        }
        fractions[0].simplify();
    }

    public void divide() {
        set();
        fractions[0] = new Fraction();
        fractions[0].i2 = fractions[1].i2 * fractions[2].i1;
        fractions[0].i1 = fractions[1].i1 * fractions[2].i2;
        if (fractions[1].check ^ fractions[2].check == false) {
            fractions[0].check = false;
        } else {
            fractions[0].check = true;
        }
        fractions[0].simplify();
    }

    public void output(Fraction tem) {
        if (tem.i1 == 0) {
            System.err.println("0");
        } else {
            if (tem.check == false) {
                System.out.println( tem.i1 + "/" + tem.i2); 
            } else {
                System.out.println( "-" + tem.i1 + "/" + tem.i2); 
            }
        }
    }
}

/**
 * TestMixedNumber
 */
public class TestFractionOperation {
    public static void main(String[] args) {
        FractionOperation test = new FractionOperation();
        //test.add();
        //test.subtract();
        test.multiply();
        //test.divide();
        test.output(test.fractions[0]);
    }
}