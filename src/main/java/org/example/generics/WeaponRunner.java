package org.example.generics;

import org.example.generics.weapon.Bow;
import org.example.generics.weapon.Sword;
import org.example.generics.weapon.Weapon;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("Леголас");
        archer.setWeapon(new Bow());

        Hero<Sword> warrior = new Warrior<>("Боромир");
        warrior.setWeapon(new Sword());

        printWeaponDamage(archer);
        printWeaponDamage(warrior);

        System.out.println();

        printWeaponDamageMethodLevelParameterization(archer);
        printWeaponDamageMethodLevelParameterization(warrior);
    }

        public static void printWeaponDamage(Hero<? extends Weapon> hero) {
        Weapon weapon = hero.getWeapon();
        System.out.println(weapon.getDamage());
    }
    public static<T extends Weapon> void printWeaponDamageMethodLevelParameterization(Hero<T> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }
}