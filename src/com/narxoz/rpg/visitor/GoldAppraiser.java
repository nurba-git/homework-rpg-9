
package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;
public class GoldAppraiser implements ArtifactVisitor {

    private int total = 0;

    public int getTotal() {
        return total;
    }

    @Override
    public void visit(Weapon weapon) {
        int value = weapon.getValue() + weapon.getAttackBonus() * 2;
        total += value;
        System.out.println("[Gold] Weapon " + weapon.getName() + " = " + value);
    }

    @Override
    public void visit(Potion potion) {
        total += potion.getValue();
        System.out.println("[Gold] Potion " + potion.getName());
    }

    @Override
    public void visit(Scroll scroll) {
        total += scroll.getValue() + 20;
        System.out.println("[Gold] Scroll " + scroll.getName());
    }

    @Override
    public void visit(Ring ring) {
        total += ring.getValue() + ring.getMagicBonus() * 3;
        System.out.println("[Gold] Ring " + ring.getName());
    }

    @Override
    public void visit(Armor armor) {
        total += armor.getValue() + armor.getDefenseBonus() * 2;
        System.out.println("[Gold] Armor " + armor.getName());
    }
}