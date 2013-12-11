package Turrets;

import jgame.ImageCache;
import bullets.Bullet;
import bullets.Bullet1;
import dtb.Defend;

public class Turret1 extends Turret {
	
	private static int turretCost = 100;

	public Turret1() {
		super(ImageCache.forClass(Defend.class).get("Wands/wand1turret.png"));
		// TODO Auto-generated constructor stub
	}
	
	public void fireBullet() {
        for(int a=1; a<=10; a++){
                double rand1=(Math.random()*40)-20;
                double rand2=(Math.random()*20);
                fireBullet(rand1,Math.abs(rand2));
        }
	}
	

	public String getSound(){
		String Snd;
		double a = (Math.random()*3);
		if(a<1){
			Snd = "flame1.wav";
		}else if(a<2){
			Snd = "flame2.wav";
		}else{
			Snd = "flame3.wav";
		}
		return Snd;

	}
	
	public double getFireRange() {
		return 400;
	}

	public int getFireDelay() {
		return 10;
	}
	
	public int getFireCost() {
		return 1;
	}

	public int getFireCoolDown() {
		return 0;
	}

	public double getBulletSpeed() {
		return 7;
	}

	public Bullet createBullet() {
		return new Bullet1();
	}
	
	public static int getCost() {
		return turretCost;
	}
	
	public int getTurretCost() {
		return turretCost;
	}
}
