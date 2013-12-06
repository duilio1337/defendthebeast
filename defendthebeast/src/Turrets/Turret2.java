package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet2;
import dtb.Defend;

public class Turret2 extends Turret{

	public Turret2() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand2turret.png"), 500);
	}
	
	public String getSound(){
		String Snd;
		double a = (Math.random()*3);
		if(a<1){
			Snd = "ice1.wav";
		}else if(a<2){
			Snd = "ice2.wav";
		}else{
			Snd = "ice3.wav";
		}
		return Snd;
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

    public double getBulletSpeed(){
    	return 10;
    }

    public Bullet createBullet(){
    	return new Bullet2();
    }
    
    public static int getCost() {
		return 200;
	}

}
