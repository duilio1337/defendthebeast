package bullets;

import jgame.ImageCache;
import dtb.Defend;
import java.awt.Image;

public class Bullet3 extends Bullet {

	public Bullet3() {
		super(randImg(), Integer.MAX_VALUE, "Enemy");
		// TODO Auto-generated constructor stub
	}
	private static Image randImg(){
		String Img = "Bullets/lightning1.png";
		double a = (Math.random()*3);
		if(a<1){
			Img = "Bullets/lightning1.png";
		}else if(a<2){
			Img = "Bullets/lightning2.png";
		}else if(a<3){
			Img = "Bullets/lightning1.png";
		}else{
			Img = "Bullets/lightning2.png";
		}
		return ImageCache.forClass(Defend.class).get(Img);
	}

}
