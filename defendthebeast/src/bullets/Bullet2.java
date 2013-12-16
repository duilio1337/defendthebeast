package bullets;

import java.awt.Image;

import jgame.ImageCache;
import dtb.Defend;

public class Bullet2 extends Bullet {

	public Bullet2() {
		super(randImg(), 25, "Enemy");
	}
	private static Image randImg(){
		String Img;
		double a = (Math.random()*2);
		if(a<1){
			Img = "Bullets/iceshard1.png";
		}else{
			Img = "Bullets/iceshard2.png";
		}
		return ImageCache.forClass(Defend.class).get(Img);
	}

}
