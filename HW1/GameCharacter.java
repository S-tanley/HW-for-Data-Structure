package HW1;

import java.security.SecureRandom;

/**
 * GameCharacter
 */
public class GameCharacter {
    private String name;
    private double height;
    private double weight;
    private double morality = 0.0;
    private double health = 1.0;
    
    private void initialize(String n, double h, double w) {
        name = n;
        height = h;
        weight = w;
    }

    private void heal(double percentage) {
        double tem = health * percentage/100 + health;
        if (tem > 1.0) {
            health = 1.0;
        } else {
            health = tem;
        }
    }

    public void injure(double pecentage) {
        double tem = health - health * pecentage/100;
        if (tem < 0.0) {
            health = 0.0;
        } else {
            health = tem;
        }
    }

    public void change(double flag) {
        SecureRandom random = new SecureRandom();
        double x = random.nextDouble(1.0);
        if (flag > 0 ) {
            if (morality + morality * x > 1.0) {
                morality = 1.0;
            } else {
                morality = morality + morality * x;    
            }
        }else if (flag == 0) {
            
        }else{
            if (morality - morality * x < -1.0) {
                morality = -1.0;
            } else {
                morality -= morality * x;
            }
        }
    }

    public void mytoString() {
        System.out.println(name);
        System.out.println(height);
        System.out.println(weight);
        System.out.println(morality);
        System.out.println(health);
    }

    public static void main(String[] args) {
        GameCharacter C1 = new GameCharacter();
        C1.initialize("test1", 180, 60);
        //C1.mytoString();
        //C1.injure(12);
        C1.change(1);
        C1.mytoString();
        C1.heal(12);
        //C1.mytoString();
    }
}