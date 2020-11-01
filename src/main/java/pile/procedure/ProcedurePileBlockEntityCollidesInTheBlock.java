package pile.procedure;

import pile.entity.EntityCrabb;

import pile.block.BlockPileHalf;
import pile.block.BlockPileBlock;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedurePileBlockEntityCollidesInTheBlock extends ElementsThePile.ModElement {
	public ProcedurePileBlockEntityCollidesInTheBlock(ElementsThePile instance) {
		super(instance, 216);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PileBlockEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PileBlockEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PileBlockEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PileBlockEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PileBlockEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double heightCheck = 0;
		if ((entity instanceof EntityCrabb.EntityCustom)) {
			heightCheck = (double) 0;
			for (int index0 = 0; index0 < (int) ((256 - y)); index0++) {
				if ((world.isAirBlock(new BlockPos((int) x, (int) ((heightCheck) + y), (int) z)))) {
					if (((world.getBlockState(new BlockPos((int) x, (int) (((heightCheck) + y) - 1), (int) z))).getBlock() == BlockPileBlock.block
							.getDefaultState().getBlock())) {
						entity.world.removeEntity(entity);
						world.setBlockState(new BlockPos((int) x, (int) ((heightCheck) + y), (int) z), BlockPileHalf.block.getDefaultState(), 3);
					} else if (((world.getBlockState(new BlockPos((int) x, (int) (((heightCheck) + y) - 1), (int) z)))
							.getBlock() == BlockPileHalf.block.getDefaultState().getBlock())) {
						entity.world.removeEntity(entity);
						world.setBlockState(new BlockPos((int) x, (int) (((heightCheck) + y) - 1), (int) z), BlockPileBlock.block.getDefaultState(),
								3);
					} else {
						heightCheck = (double) ((heightCheck) + 1);
					}
				}
			}
		}
	}
}
