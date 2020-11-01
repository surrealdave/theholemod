package pile.procedure;

import pile.block.BlockPileHalf;
import pile.block.BlockPileBlock;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@ElementsThePile.ModElement.Tag
public class ProcedurePileUpdateTick extends ElementsThePile.ModElement {
	public ProcedurePileUpdateTick(ElementsThePile instance) {
		super(instance, 305);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PileUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PileUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PileUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PileUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockPileHalf.block.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockPileBlock.block.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockPileBlock.block.getDefaultState().getBlock())) {
			if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockPileHalf.block.getDefaultState(), 3);
			}
		}
	}
}
