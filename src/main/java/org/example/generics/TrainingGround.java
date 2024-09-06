package org.example.generics;


import org.example.generics.weapon.Bow;
import org.example.generics.weapon.Fangs;
import org.example.generics.weapon.MagicWeapon;
import org.example.generics.weapon.MeleeWeapon;
import org.example.generics.weapon.Sword;
import org.example.generics.weapon.Wand;
import org.example.generics.weapon.Weapon;

public class TrainingGround {

    public static void main(String[] args) {
        Hero<Sword> warrior = new Warrior<>("Боромир");
        Hero<Wand> mage = new Mage<>("Гэндольф");
        Archer<Bow> archer = new Archer<>("Леголас");

//        warrior.setWeapon(new Sword());
        mage.setWeapon(new Wand());
        archer.setWeapon(new Bow());


        // impossible to create wolf separately?
//        Archer<Bow>.Wolf<Fangs> wolf = archer.new Wolf<>("Wolf");

        Enemy enemy = new Enemy("Зомби", 100);


        attackEnemy(enemy, warrior, mage, archer);
    }

    @SafeVarargs
    public static void attackEnemy(Enemy enemy, Hero<? extends Weapon>... heroes) {
        while (enemy.isAlive()) {
            for (Hero<? extends Weapon> hero : heroes) {
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                    System.out.println("*".repeat(42));
                }
            }
        }
    }
}
