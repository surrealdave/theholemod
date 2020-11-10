package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureBoneDustEntityWalksOnTheBlock extends ElementsThePile.ModElement {
	public ProcedureBoneDustEntityWalksOnTheBlock(ElementsThePile instance) {
		super(instance, 454);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BoneDustEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BoneDustEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BoneDustEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BoneDustEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		if ((entity instanceof EntityItem)) {
			entity.setPositionAndUpdate(x, y, z);
		}
	}
}
