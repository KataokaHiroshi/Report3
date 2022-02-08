package jp.ac.uryukyu.ie.e205745;

/**
 * ウォーリアークラス。
 *  String name; //戦士の名前
 *  int hitPoint; //戦士のHP
 *  int attack; //戦士の攻撃力
 *  boolean dead; //戦士の生死状態。true=死亡。
 * Created by e205745 on 2022/02/08.
 */

public class Warrior extends LivingThing {
    public Warrior(String _name, int _hitPoint, int _attack) {
        super(_name, _hitPoint, _attack);
    }

}
