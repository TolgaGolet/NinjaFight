package ninjafight;

import java.util.Scanner;

public class Arena {
    public static Scanner scan=new Scanner(System.in);
    
    public static void introduceFighters(Ninja ninja1, Ninja ninja2, int roundNum) {
        System.out.println(">>>>>>Ninja Fight: Ninja "+ninja1.name+" vs Ninja "+ninja2.name);        
        System.out.println("***************ROUND "+roundNum+"***************");
        System.out.println("Fight is ready!");
    }
    
    public static void displayStatus(Ninja ninja1, Ninja ninja2) {
        System.out.println(">>>"+ninja1.name+"(lv."+ninja1.exp+")"+": "+ninja1.hp+" hp, "+ninja2.name+"(lv."+ninja2.exp+")"+": "+ninja2.hp+" hp");
    }
    
    public static void startFight(Ninja ninja1, Ninja ninja2, int roundNum) {
        String keyPressed;
        System.out.println("Fight is starting...");
        
        while(ninja1.hp>0 && ninja2.hp>0) {
            System.out.print("Press enter to hit:");
            keyPressed=scan.nextLine();
            ninja1.attack(ninja1, ninja2);
            displayStatus(ninja1, ninja2);
            if(ninja2.hp<=0) {
                System.out.println("***************Ninja "+ninja1.name+" WON Ninja "+ ninja2.name+"***************");
                ninja1.exp++;
                ninja1.hp=100;
                ninja2.hp=100;
                if(roundNum<3) System.out.println("***************NINJA "+ninja1.name+" IS NOW LEVEL "+ninja1.exp);
                break;
            }
            System.out.print("Press enter to hit:");
            keyPressed=scan.nextLine();
            ninja2.attack(ninja2, ninja1);
            displayStatus(ninja1, ninja2);
        }
        if(ninja1.hp<=0) {
            System.out.println("***************Ninja "+ninja2.name+" WON Ninja "+ ninja1.name+"***************");
            ninja2.exp++;
            ninja1.hp=100;
            ninja2.hp=100;
            if(roundNum<3) System.out.println("***************NINJA "+ninja2.name+" IS NOW LEVEL "+ninja2.exp);
        }
    }
}
