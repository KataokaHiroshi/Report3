package jp.ac.uryukyu.ie.e205745;

/**
 * ヒーロークラス。
 *  String name; //勇者の名前
 *  int hitPoint; //勇者のHP
 *  int attack; //勇者の攻撃力
 *  boolean dead; //勇者の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {
    public Hero(String _name, int _hitPoint, int _attack) {
        super(_name, _hitPoint, _attack);
    }
}