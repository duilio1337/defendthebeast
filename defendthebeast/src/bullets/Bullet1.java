package bullets;

import java.awt.Image;

import jgame.ImageCache;
import dtb.Defend;

public class Bullet1 extends Bullet {

	public Bullet1() {
		super(randImg(), 0.3141592653, Behavior.STANDARD);
		// TODO Auto-generated constructor stub
	}
	private static Image randImg(){
		String Img;
		double a = (Math.random()*3);
		if(a<1){
			Img = "Bullets/flame1.png";
		}else if(a<2){
			Img = "Bullets/flame2.png";
		}else{
			Img = "Bullets/flame3.png";
		}
		return ImageCache.forClass(Defend.class).get(Img);
	}

}
