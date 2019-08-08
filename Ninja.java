package ninjafight;

import java.util.Random;

public class Ninja {
    public String name="Nameless";
    public int hp=100;
    public Random rand=new Random();
    public int exp=1;                //Default experience level.
    
    public static Weapon sword=new Weapon("ninja sword", 15);  ////Weapons: Sword(%20), Nunchaku(İkili)(%30), Shuriken(Yıldız)(%50).
    public static Weapon nunchaku=new Weapon("nunchaku", 10);
    public static Weapon shuriken=new Weapon("shuriken", 5);
    
    public int missingPossibility(Ninja ninja) {
        switch (ninja.exp) {
            case 1:  //Lv.1
                return 50;
            case 2:
                return 30;
            case 3:
                return 0;
            default:
                return 15;
        }
    }
    
    public void attack(Ninja attacker, Ninja attackTo) {
        int r=rand.nextInt(100); //Weapon chance.
        int givenDamage;
        
        if(r<20) {  //Sword.
            r=rand.nextInt(100); //Hitting chance.
            
            if(r>missingPossibility(attacker)) {            //Missing possibility percentage.
                if(defend()==true) {  //Defending chance.
                    givenDamage=sword.damage-5;
                    if(doubleShot()==true) {
                        givenDamage=givenDamage*2;
                        System.out.println("*****"+attacker.name+" gets a double shot*****");
                    }
                    System.out.println(">"+attacker.name+" hit "+givenDamage+" hp to "+attackTo.name+" with "+sword.weaponName+"("+attackTo.name+" defended.)"); 
                    attackTo.hp=(attackTo.hp-givenDamage);
                }
                else {
                    givenDamage=sword.damage;
                    if(doubleShot()==true) {
                        givenDamage=sword.damage*2;
                        System.out.println("*****"+attacker.name+" gets a double shot*****");
                    }
                    System.out.println(">"+attacker.name+" hit "+givenDamage+" hp to "+attackTo.name+" with "+sword.weaponName+"("+attackTo.name+" couldn't defend.)");
                    attackTo.hp=(attackTo.hp-givenDamage);
                }
            }
            
            else {
            System.out.println(">"+attacker.name+" missed the hit "+attackTo.name+" with "+sword.weaponName);
            }
        }
        
        else if(r>=20 && r<=50) {  //Nunchaku.
            r=rand.nextInt(100); //Hitting chance.
            
            if(r>missingPossibility(attacker)) {            //Missing possibility percentage.
                if(defend()==true) {  //Defending chance.
                    givenDamage=nunchaku.damage-5;
                    if(doubleShot()==true) {
                        givenDamage=givenDamage*2;
                        System.out.println("*****"+attacker.name+" gets a double shot*****");
                    }
                    System.out.println(">"+attacker.name+" hit "+givenDamage+" hp to "+attackTo.name+" with "+nunchaku.weaponName+"("+attackTo.name+" defended.)");
                    attackTo.hp=(attackTo.hp-givenDamage);
                }
                else {
                    givenDamage=nunchaku.damage;
                    if(doubleShot()==true) {
                        givenDamage=nunchaku.damage*2;
                        System.out.println("*****"+attacker.name+" gets a double shot*****");
                    }
                    System.out.println(">"+attacker.name+" hit "+givenDamage+" hp to "+attackTo.name+" with "+nunchaku.weaponName+"("+attackTo.name+" couldn't defend.)");
                    attackTo.hp=(attackTo.hp-givenDamage);
                }
        }
            else {
            System.out.println(">"+attacker.name+" missed the hit "+attackTo.name+" with "+nunchaku.weaponName);
            }
        }
            
        
        else if(r>50) {  //Shuriken.
            r=rand.nextInt(100); //Hitting chance.
            
            if(r>missingPossibility(attacker)) {            //Missing possibility percentage.
                if(defend()==true) {  //Defending chance.
                    givenDamage=shuriken.damage-5;
                    if(doubleShot()==true) {
                        givenDamage=givenDamage*2;
                        System.out.println("*****"+attacker.name+" gets a double shot*****");
                    }
                    System.out.println(">"+attacker.name+" hit "+givenDamage+" hp to "+attackTo.name+" with "+shuriken.weaponName+"("+attackTo.name+" defended.)");
                    attackTo.hp=(attackTo.hp-givenDamage);
                }
                else {
                    givenDamage=shuriken.damage;
                    if(doubleShot()==true) {
                        givenDamage=shuriken.damage*2;
                        System.out.println("*****"+attacker.name+" gets a double shot*****");
                    }
                    System.out.println(">"+attacker.name+" hit "+givenDamage+" hp to "+attackTo.name+" with "+shuriken.weaponName+"("+attackTo.name+" couldn't defend.)");
                    attackTo.hp=(attackTo.hp-givenDamage);
                }
        }
            else {
                System.out.println(">"+attacker.name+" missed the hit "+attackTo.name+" with "+shuriken.weaponName);
            }
    }
    }
    
    public boolean defend() {
        int r=rand.nextInt(100);   //Defending chance
        if(r>=50) return true;
        else return false;
    }
    
    public boolean doubleShot() {
        int r=rand.nextInt(100);  //Double shot percentage.
        if(r>=70) return true;
        else return false;
    }
}