package org.example.generics;

import org.example.generics.weapon.MeleeWeapon;
import org.example.generics.weapon.Sword;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (getWeapon() == null) {
            System.out.printf("%s: у меня нет %s!!%n", getName(), Sword.class.getSimpleName());
            enemy.takeDamage(0);
            return;
        }
        System.out.println(getName() + " взмахнул мечом на " + enemy.getName());
        enemy.takeDamage(getWeapon().getDamage());
    }
}
