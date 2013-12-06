package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet4;
import dtb.Defend;

public class Turret4 extends Turret{

	public Turret4() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand4turret.png"));
		// TODO Auto-generated constructor stub
	}
	public double getFireRange(){
		return 500;
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
    	return 10;
    }

    public Bullet createBullet(){
    	return new Bullet4();
    }
    
    public static int getCost() {
		return 400;
	}
    
	public int getTurretCost() {
		return 100;
	}

}
