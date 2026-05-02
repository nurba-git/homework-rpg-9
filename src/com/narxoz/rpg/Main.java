import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.visitor.CurseDetector;
import com.narxoz.rpg.visitor.GoldAppraiser;
import com.narxoz.rpg.visitor.WeightCalculator;

public static void main(String[] args) {

    System.out.println("=== Visitor + Memento Demo ===");

    Inventory inv = new Inventory();
    inv.addArtifact(new Weapon("Sword", 100, 5, 10));
    inv.addArtifact(new Potion("Heal", 50, 1, 20));
    inv.addArtifact(new Armor("Armor", 150, 10, 15));
    inv.addArtifact(new Ring("Ring", 200, 1, 5));
    inv.addArtifact(new Scroll("Fire", 80, 1, "Fireball"));

    Hero hero1 = new Hero("Knight", 100, 50, 10, 5, 200, inv);
    Hero hero2 = new Hero("Mage", 80, 120, 5, 3, 300, inv.copy());

    GoldAppraiser g = new GoldAppraiser();
    WeightCalculator w = new WeightCalculator();
    CurseDetector c = new CurseDetector();

    inv.accept(g);
    inv.accept(w);
    inv.accept(c);

    System.out.println("Gold value: " + g.getTotal());
    System.out.println("Total weight: " + w.getTotalWeight());

    Caretaker caretaker = new Caretaker();

    System.out.println("\nBEFORE TRAP: " + hero1);

    caretaker.save(hero1.createMemento());

    hero1.takeDamage(70);
    hero1.spendGold(100);

    System.out.println("AFTER TRAP: " + hero1);

    hero1.restoreFromMemento(caretaker.undo());

    System.out.println("AFTER RESTORE: " + hero1);


    ChronomancerEngine engine = new ChronomancerEngine();
    System.out.println("\nRESULT: " + engine.runVault(List.of(hero1, hero2)));
}