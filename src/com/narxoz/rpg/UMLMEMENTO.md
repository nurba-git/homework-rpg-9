@startuml

title Memento Pattern - Chronomancer's Vault

class Hero {
-name : String
-hp : int
-mana : int
-gold : int
-maxHp : int
-attackPower : int
-defense : int
-inventory : Inventory

    +takeDamage()
    +heal()
    +addGold()
    +spendGold()
    +createMemento()
    +restoreFromMemento(m : HeroMemento)
}

class HeroMemento {
-name : String
-hp : int
-mana : int
-gold : int
-maxHp : int
-attackPower : int
-defense : int
-inventorySnapshot : List<Artifact>

    ~getHp()
    ~getMana()
    ~getGold()
    ~getInventorySnapshot()
}

class Caretaker {
-history : Stack<HeroMemento>
+save(m : HeroMemento)
+undo()
+peek()
+size()
}

class ChronomancerEngine {
+runVault(party : List<Hero>)
}

class VaultRunResult {
-artifactsAppraised : int
-mementosCreated : int
-restoredCount : int
}

Hero --> HeroMemento : creates
Hero --> Inventory
Caretaker --> HeroMemento : stores (opaque)
ChronomancerEngine --> Hero
ChronomancerEngine --> Caretaker
ChronomancerEngine --> VaultRunResult

@enduml