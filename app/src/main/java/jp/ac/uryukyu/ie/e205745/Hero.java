package jp.ac.uryukyu.ie.e205745;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * Mainクラスで敵の名前を返す。
     */
    public String getName(){
        return this.name;
    }

    /**
     * Mainクラスで敵のHPの値を返す。
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * Mainクラスで敵の攻撃力の値を返す。
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * 敵の生死を判断する。HPが0を下回ったらdeadの値をtrue(死亡)にする。
     */
    public boolean setDead(){
        if( hitPoint < 0 ) {
            this.dead = true;
        }
        return this.dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( dead == true ) {
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}