BaseHero - базовый класс героев

1. MagicClacc - класс магических героев (потомок класса BaseHero)
1.1. Priest - класс МОНАХОВ (потомок MagClass)
1.2. Magician - класс МАГОВ (потомок MagClass)

2. InfantryClass - класс бойцов ближнего боя / пехотинцев (потомок класса BaseHero)
2.1. Robber - класс РАЗБОЙНИКОВ (потомок класса InfantryClass)
2.2. Spearman - класс КОПЕЙЩИКОВ (потомок класса InfantryClass)

3. ShooterClass - класс бойцов дальнего боя / стрелков (потомок класса BaseHero)
3.1. Sniper - класс СНАЙПЕРОВ (потомок класса ShooterClass)
3.2. Crossbowman - класс АРБАЛЕТЧИКОВ (потомок класса ShooterClass)

4. Peasant - класс КРЕСТЬЯНИН   -> пока данный класс не имеет промежуточного подкласса, он сразу потомок класса BaseHero