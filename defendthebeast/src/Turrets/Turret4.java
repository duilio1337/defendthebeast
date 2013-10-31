package Turrets;

import bullets.Bullet;
import bullets.Bullet1;
import jgame.ImageCache;
import dtb.Defend;

public class Turret4 extends Turret{

	public Turret4() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand4.png"));
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
