package jp.ac.uryukyu.ie.e205745;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
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
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        
        if( dead = false ){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( dead = true ) {
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}