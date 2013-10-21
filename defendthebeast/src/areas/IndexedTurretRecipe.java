package areas;

import Turrets.Turret;
import Turrets.Turret1;

public class IndexedTurretRecipe implements TurretRecipe {
	private final int index;

	public IndexedTurretRecipe(int index) {
		super();
		this.index = index;
	}

	@Override
	public Turret createTurret() {
		switch (index) {
		case 0:
			return new Turret1();
		case 1:
			return new Turret2();
		case 2:
			return new Turret3();
		case 3:
			return new Turret4();
		case 4:
			return new Turret5();

		default:
			return null;
		}
	}

}
