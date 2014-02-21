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

	@Override
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

	@Override
	public double getFireRange(){
		return 300;
	}

	@Override
	public int getFireDelay(){
		return 10;
	}

	@Override
	public int getFireCoolDown(){
		return 10;
	}

	@Override
	public int getFireCost() {
		return 10;
	}

	@Override
	public double getBulletSpeed(){
		return 10;
	}

	@Override
	public Bullet createBullet(){
		return new Bullet2();
	}

	public static int getCost() {
		return turretCost;
	}

	@Override
	public int getTurretCost() {
		return turretCost;
	}

}
