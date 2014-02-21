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

	@Override
	public void fireBullet() {
		for(int a=1; a<=15; a++){
			double rand1=(Math.random()*40)-20;
			double rand2=(Math.random()*20);
			fireBullet(rand1,Math.abs(rand2));
		}
	}


	@Override
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

	@Override
	public double getFireRange() {
		return 400;
	}

	@Override
	public int getFireDelay() {
		return 5;
	}

	@Override
	public int getFireCost() {
		return 1;
	}

	@Override
	public int getFireCoolDown() {
		return 0;
	}

	@Override
	public double getBulletSpeed() {
		return 7;
	}

	@Override
	public Bullet createBullet() {
		return new Bullet1();
	}

	public static int getCost() {
		return turretCost;
	}

	@Override
	public int getTurretCost() {
		return turretCost;
	}
}
