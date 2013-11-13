package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet5;
import dtb.Defend;

public class Turret5 extends Turret{

	public Turret5() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand5.png"));
		// TODO Auto-generated constructor stub
	}
	public double getFireRange(){
		return 300;
	}

    public int getFireDelay(){
    	return 5;
    }

    public int getFireCoolDown(){
    	return 100;
    }

    public double getBulletSpeed(){
    	return 6;
    }

    public Bullet createBullet(){
    	return new Bullet5();
    }

}
