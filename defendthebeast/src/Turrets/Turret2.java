package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet2;
import dtb.Defend;

public class Turret2 extends Turret{

	private static int turretCost = 200;
	
	public Turret2() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand2turret.png"));
	}
	public double getFireRange(){
		return 300;
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
    	return new Bullet2();
    }
    
    public static int getCost() {
		return turretCost;
	}
    
	public int getTurretCost() {
		return turretCost;
	}

}
