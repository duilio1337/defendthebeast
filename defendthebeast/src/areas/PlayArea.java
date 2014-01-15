package areas;

import java.awt.Color;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.TimerListener;
import Enemies.Boss1;
import Enemies.Boss2;
import Enemies.Enemy;
import Enemies.Enemy1;
import Enemies.Enemy2;
import Enemies.Enemy3;
import Enemies.Enemy4;
import Enemies.Enemy5;

public class PlayArea extends GContainer {
	
	TimerListener spawnTimer;
	TimerListener waveTimer;
	
	protected int nextWave;
	private int wave1[];
	private int wave2[];
	private int wave3[];
	private int wave4[];
	private int wave5[];
	
	public PlayArea(String level, int waves[][]) {
		setSize(1280, 720);
		setBackgroundColor(Color.PINK);
		GSprite g = new GSprite(ImageCache.getImage(level));
		setBackgroundSprite(g);
		
		// 1=Enemy1 2=Enemy2.... 101=Boss1 102=Boss2
		
		this.wave1 = wave1;
		this.wave2 = wave2;
		this.wave3 = wave3;
		this.wave4 = wave4;
		this.wave5 = wave5;
		
		startWave(wave1);
		nextWave = 1;
	}
	
	public void startWave(final int wave[]) {
		spawnTimer = new TimerListener(120) {
			int i = 0;
			@Override
			public void invoke(GObject target, Context context) {
				if(i < wave.length) {
					addEnemy(wave[i]);
					i++;
				}else{
					endWave();
					removeListener(spawnTimer);
				}
			}
		};
		addListener(spawnTimer);
	}
	
	public void endWave() {
		waveTimer = new TimerListener(300) {
			int i = 0;
			@Override
			public void invoke(GObject target, Context context) {
				if(i > 0) {
					nextWave++;
					switch(nextWave) {
					case 1:
						startWave(wave1);
						removeListener(waveTimer);
						break;
					case 2:
						startWave(wave2);
						removeListener(waveTimer);
						break;
					case 3:
						startWave(wave3);
						removeListener(waveTimer);
						break;
					case 4:
						startWave(wave4);
						removeListener(waveTimer);
						break;
					case 5:
						startWave(wave5);
						removeListener(waveTimer);
						break;
					default:
						System.err.println("ERROR: INVALID WAVE NUMBER");
						System.err.println("Wave Number '" + nextWave + "' is invalid.");
						removeListener(waveTimer);
					}
					
				}else{
					i++;
				}
			}
		};
		addListener(waveTimer);
	}
	
	public void addEnemy(int eN) {
		
		Enemy e = null;
		switch(eN) {
		case 1:
			e = new Enemy1();
			break;
		case 2:
			e = new Enemy2();
			break;
		case 3:
			e = new Enemy3();
			break;
		case 4:
			e = new Enemy4();
			break;
		case 5:
			e = new Enemy5();
			break;
		case 101:
			e = new Boss1();
			break;
		case 102:
			e = new Boss2();
			break;
		}
		add(e);
	}
	
//	private void addRandomEnemy() {
//	int pick = (int) (Math.random() * 1000);
//	Enemy e = null;
//	if(pick<200){
//		e = new Enemy1();
//	}else if(pick<400){
//		e = new Enemy2();
//	}else if(pick<600){
//		e = new Enemy3();
//	}else if(pick<800){
//		e = new Enemy4();
//	}else if(pick<900){
//		e = new Enemy5();
//	}else if(pick<933){
//		e = new Boss1();
//	}else{
//		e = new Boss2();
//	}
//	this.add(e);
}
