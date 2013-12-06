package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet3;
import dtb.Defend;

public class Turret3 extends Turret{

	public Turret3() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand3turret.png"));
		// TODO Auto-generated constructor stub
	}
	public double getFireRange(){
		return 350;
	}

    public int getFireDelay(){
    	return 10;
    }

    public int getFireCoolDown(){
    	return 10;
    }
    
    public int getFireCost() {
		return 10;
	}

    public double getBulletSpeed(){
    	return Integer.MAX_VALUE;
    }
    
    public Bullet createBullet(){
    	return new Bullet3();
    }
    
    public static int getCost() {
		return 300;
	}
    
	public int getTurretCost() {
		return 100;
	}

}
