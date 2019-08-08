package ninjafight;

public class Weapon {
    String weaponName;
    int damage;
    
    ////Weapons: Sword(%20), Nunchaku(İkili)(%30), Shuriken(%50), Double shot(%5), Defending(%50). Ninja classında.
    
    public Weapon(String weaponName, int damage) {
        this.weaponName=weaponName;
        this.damage=damage;
    }
}
