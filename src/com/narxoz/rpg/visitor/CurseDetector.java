package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;
public class CurseDetector implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("[Curse] Weapon safe");
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 0) {
            System.out.println("[Curse] Poison potion detected!");
        } else {
            System.out.println("[Curse] Potion safe");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("[Curse] Scroll unknown...");
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() > 10) {
            System.out.println("[Curse] Suspicious ring!");
        } else {
            System.out.println("[Curse] Ring safe");
        }
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[Curse] Armor safe");
    }
}