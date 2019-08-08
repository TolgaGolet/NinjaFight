package ninjafight;

import java.util.Scanner;

public class NinjaFight {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        String name;
        int roundNum=1;
        
        System.out.println("***************Ninja Fight***************");
        Ninja ninja1=new Ninja();
        System.out.print("Name of Ninja1: ");
        name=scan.nextLine();
        ninja1.name=name;              
        Ninja ninja2=new Ninja();
        System.out.print("Name of Ninja2: ");
        name=scan.nextLine();
        ninja2.name=name;
       
        for(int i=0;i<3;i++) {
            Arena.introduceFighters(ninja1, ninja2, roundNum);
            Arena.displayStatus(ninja1, ninja2);
            System.out.print("Press Enter to start fight!: ");
            String keyPressed=scan.nextLine();
            Arena.startFight(ninja1, ninja2, roundNum);
            roundNum++;
        }
        
        if(ninja1.exp==3) loseMessage(ninja2.name);
        else loseMessage(ninja1.name);
        
        System.out.print("Type 1 to exit: ");
        int x=scan.nextInt();
    }
    
    private static void loseMessage(String loserNinja) throws Exception {
        throw new Exception(loserNinja+": I lost...");
    }
}