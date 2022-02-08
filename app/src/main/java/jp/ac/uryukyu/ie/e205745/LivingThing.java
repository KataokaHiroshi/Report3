package jp.ac.uryukyu.ie.e205745;

/**
 * LivingThingクラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param _name 名前
     * @param _hitPoint HP
     * @param _attack 攻撃力
     */
    public LivingThing(String _name, int _hitPoint, int _attack){
        this.name = _name;
        this.hitPoint = _hitPoint;
        this.attack = _attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", _name, _hitPoint, _attack);
    }

    /**
     * 敵の生死を判断する。HPが0を下回ったらdeadの値をtrue(死亡)にする。
     */
    public boolean isDead(){
        if(hitPoint < 0){
            this.dead = true;
        }
        return this.dead;
    }

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
     * 敵へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){        
        if( dead == false ){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * ウェポンスキルを発動するメソッド。
     * attackの1.5倍の値を算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attackWithWeaponSkill(LivingThing opponent){       
        if( dead == false ){
            int damage = (int)(attack * 1.5);
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }       
    }


    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        isDead();
        if( dead == true ) {
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
