package jp.ac.uryukyu.ie.e205745;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
    @Test
    void attackWithWeaponTest() {
        for(int i=0; i<2; i++){
            int defaultWarriorAttack = 100;
            Warrior demoWarrior = new Warrior("デモ戦士", 100, defaultWarriorAttack);
            Enemy slime = new Enemy("スライムもどき", 151, 0);
            demoWarrior.attackWithWeaponSkill(slime);
            slime.attack(demoWarrior);
            assertEquals((int)(defaultWarriorAttack*1.5), 151-slime.getHitPoint());
        }
    }
}
