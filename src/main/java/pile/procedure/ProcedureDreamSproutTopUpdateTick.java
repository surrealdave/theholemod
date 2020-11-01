package pile.procedure;

import pile.block.BlockDreamSproutTop;
import pile.block.BlockDreamSprout;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@ElementsThePile.ModElement.Tag
public class ProcedureDreamSproutTopUpdateTick extends ElementsThePile.ModElement {
	public ProcedureDreamSproutTopUpdateTick(ElementsThePile instance) {
		super(instance, 356);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DreamSproutTopUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DreamSproutTopUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DreamSproutTopUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DreamSproutTopUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((Math.random() * 100) >= 80)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockDreamSprout.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockDreamSproutTop.block.getDefaultState(), 3);
		}
	}
}
