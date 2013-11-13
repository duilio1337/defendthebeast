package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet1;
import dtb.Defend;

public class Turret2 extends Turret{

	public Turret2() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand2turret.png"));
	}
	public double getFireRange(){
		return 1000;
	}

    public int getFireDelay(){
    	return 10;
    }

    public int getFireCoolDown(){
    	return 10;
    }

    public double getBulletSpeed(){
    	return 10;
    }

    public Bullet createBullet(){
    	return new Bullet1();
    }

}
