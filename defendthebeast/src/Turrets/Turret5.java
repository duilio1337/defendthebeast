package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet1;
import dtb.Defend;

public class Turret5 extends Turret{

	public Turret5() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand5.png"));
		// TODO Auto-generated constructor stub
	}
	public double getFireRange(){
		return 7.5;
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
