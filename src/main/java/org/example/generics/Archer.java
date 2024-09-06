package org.example.generics;

import lombok.Getter;
import lombok.Setter;
import org.example.generics.weapon.Fangs;
import org.example.generics.weapon.RangeWeapon;

public class Archer<T extends RangeWeapon> extends Hero<T> {

    private final Wolf<Fangs> wolf;

    public Archer(String name) {
        super(name);
        this.wolf = new Wolf<>("Wolf");
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " стрельнул из лука в " + enemy.getName());
        wolf.attackEnemy(enemy);
    }

    @Setter
    @Getter
    public class Wolf<U extends Fangs> {

        private final String name;
        private U weapon;

        public Wolf(String name) {
            this.name = name;
            this.weapon = (U) new Fangs();
        }

        public void attackEnemy(Enemy enemy) {
            System.out.println(name + " и " + Archer.this.getName() + " наносят совместный урон");
            enemy.takeDamage(weapon.getDamage() + Archer.this.getWeapon().getDamage());
        }
    }
}
