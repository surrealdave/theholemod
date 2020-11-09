package pile.procedure;

import pile.block.BlockCrangleUnderground;
import pile.block.BlockCrangle;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@ElementsThePile.ModElement.Tag
public class ProcedureCrangleUndergroundNeighbourBlockChanges extends ElementsThePile.ModElement {
	public ProcedureCrangleUndergroundNeighbourBlockChanges(ElementsThePile instance) {
		super(instance, 442);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CrangleUndergroundNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CrangleUndergroundNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CrangleUndergroundNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CrangleUndergroundNeighbourBlockChanges!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockCrangle.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockCrangleUnderground.block.getDefaultState(), 3);
		}
	}
}
