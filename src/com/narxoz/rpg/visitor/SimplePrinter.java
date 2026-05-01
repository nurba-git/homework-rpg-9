package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class SimplePrinter implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("Weapon: " + weapon.getName());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Potion: " + potion.getName());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Scroll: " + scroll.getName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Ring: " + ring.getName());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Armor: " + armor.getName());
    }
}