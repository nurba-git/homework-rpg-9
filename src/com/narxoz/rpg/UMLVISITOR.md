@startuml

title Visitor Pattern - Chronomancer's Vault

interface ArtifactVisitor {
+visit(Weapon weapon)
+visit(Potion potion)
+visit(Scroll scroll)
+visit(Ring ring)
+visit(Armor armor)
}

abstract class Artifact {
-name : String
-value : int
-weight : int
+getName()
+getValue()
+getWeight()
+accept(visitor : ArtifactVisitor)
}

class Weapon {
-attackBonus : int
+getAttackBonus()
}

class Potion {
-healing : int
+getHealing()
}

class Scroll {
-spellName : String
+getSpellName()
}

class Ring {
-magicBonus : int
+getMagicBonus()
}

class Armor {
-defenseBonus : int
+getDefenseBonus()
}

class Inventory {
-artifacts : List<Artifact>
+addArtifact()
+accept(visitor : ArtifactVisitor)
+copy()
}

class GoldAppraiser
class WeightCalculator
class CurseDetector
class SimplePrinter

Artifact <|-- Weapon
Artifact <|-- Potion
Artifact <|-- Scroll
Artifact <|-- Ring
Artifact <|-- Armor

ArtifactVisitor <|.. GoldAppraiser
ArtifactVisitor <|.. WeightCalculator
ArtifactVisitor <|.. CurseDetector
ArtifactVisitor <|.. SimplePrinter

Inventory --> Artifact
Artifact --> ArtifactVisitor : accept()

Inventory --> ArtifactVisitor : traverse

@enduml