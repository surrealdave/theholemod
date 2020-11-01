package pile.procedure;

import pile.block.BlockCorn1;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@ElementsThePile.ModElement.Tag
public class ProcedureCorn3UpdateTick extends ElementsThePile.ModElement {
	public ProcedureCorn3UpdateTick(ElementsThePile instance) {
		super(instance, 203);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Corn3UpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Corn3UpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Corn3UpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Corn3UpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((Math.random() * 10) >= 5)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockCorn1.block.getDefaultState(), 3);
		}
	}
}
