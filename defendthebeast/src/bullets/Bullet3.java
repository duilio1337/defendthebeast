package bullets;

import jgame.Context;
import jgame.GObject;
import jgame.ImageCache;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.ButtonListener;
import jgame.listener.DelayListener;
import jgame.listener.HitTestListener;
import dtb.Defend;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import Enemies.Enemy;
import Turrets.Turret;

public class Bullet3 extends Bullet {
	
	private double bd;
	private Point initialPosition = new Point();
	public Bullet3() {
		super(randImg(), 200, "Enemy");
	}
	private static Image randImg(){
		String Img;
		double a = (Math.random()*4);
		if(a<1){
			Img = "Bullets/lightning1.png";
		}else if(a<2){
			Img = "Bullets/lightning2.png";
		}else if(a<3){
			Img = "Bullets/lightning3.png";
		}else{
			Img = "Bullets/lightning4.png";
		}
		return ImageCache.forClass(Defend.class).get(Img);
	}

}
