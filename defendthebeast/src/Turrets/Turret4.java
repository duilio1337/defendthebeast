package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet4;
import dtb.Defend;

public class Turret4 extends Turret{

	public Turret4() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand4turret.png"), 500);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound(){
		String Snd;
		double a = (Math.random()*3);
		if(a<1){
			Snd = "light1.wav";
		}else if(a<2){
			Snd = "light1.wav";
		}else{
			Snd = "light1.wav";
		}
		return Snd;
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

    public double getBulletSpeed(){
    	return 10;
    }

    public Bullet createBullet(){
    	return new Bullet4();
    }
    
    public static int getCost() {
		return 400;
	}

}
