package com.narxoz.rpg.vault;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.memento.*;

import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {

        Caretaker caretaker = new Caretaker();

        int restored = 0;
        int mementos = 0;

        for (Hero h : party) {


            caretaker.save(h.createMemento());
            mementos++;


            h.takeDamage(40);
            h.spendGold(50);

            h.restoreFromMemento(caretaker.undo());
            restored++;
        }

        return new VaultRunResult(
                0,          // artifactsAppraised (можно улучшить позже)
                mementos,
                restored
        );
    }
}