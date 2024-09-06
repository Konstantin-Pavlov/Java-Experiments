package org.example.generics;

import lombok.Getter;
import lombok.Setter;
import org.example.generics.weapon.Weapon;

@Setter
@Getter
public abstract class Hero<T extends Weapon> {

    private final String name;
    private  T weapon;

    public Hero(String name) {
        this.name = name;
    }

    public abstract void attackEnemy(Enemy enemy);

}
