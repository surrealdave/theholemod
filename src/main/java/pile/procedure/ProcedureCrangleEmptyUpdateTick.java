package pile.procedure;

import pile.block.BlockCrangle;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

@ElementsThePile.ModElement.Tag
public class ProcedureCrangleEmptyUpdateTick extends ElementsThePile.ModElement {
	public ProcedureCrangleEmptyUpdateTick(ElementsThePile instance) {
		super(instance, 445);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CrangleEmptyUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CrangleEmptyUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CrangleEmptyUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CrangleEmptyUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIRT.getStateFromMeta(0).getBlock())
				&& (Math.random() <= 0.5)) && (!(world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockCrangle.block.getDefaultState(), 3);
		}
	}
}
