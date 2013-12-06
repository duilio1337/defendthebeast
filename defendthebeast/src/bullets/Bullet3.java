package bullets;

import jgame.ImageCache;
import dtb.Defend;

import java.awt.Image;

public class Bullet3 extends Bullet {
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
