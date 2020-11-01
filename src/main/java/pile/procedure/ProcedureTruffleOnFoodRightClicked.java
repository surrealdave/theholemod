package pile.procedure;

import pile.item.ItemTruffle;

import pile.block.BlockTrufflePlant;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureTruffleOnFoodRightClicked extends ElementsThePile.ModElement {
	public ProcedureTruffleOnFoodRightClicked(ElementsThePile instance) {
		super(instance, 256);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TruffleOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TruffleOnFoodRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((world
				.isAirBlock(
						new BlockPos(
								(int) (entity.world
										.rayTraceBlocks(entity.getPositionEyes(1f),
												entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
														entity.getLook(1f).z * 3),
												false, false, true)
										.getBlockPos().getX()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
												entity.getLook(1f).z * 3),
										false, false, true).getBlockPos().getY()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f), entity.getPositionEyes(1f)
										.addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3), false, false, true)
										.getBlockPos().getZ()))))) {
			if ((!(world.isAirBlock(new BlockPos(
					(int) (entity.world
							.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
											entity.getLook(1f).z * 3),
									false, false, true)
							.getBlockPos().getX()),
					(int) ((entity.world
							.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
											entity.getLook(1f).z * 3),
									false, false, true)
							.getBlockPos().getY()) - 1),
					(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
							entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3, entity.getLook(1f).z * 3), false,
							false, true).getBlockPos().getZ())))))) {
				world.setBlockState(
						new BlockPos(
								(int) (entity.world
										.rayTraceBlocks(entity.getPositionEyes(1f),
												entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
														entity.getLook(1f).z * 3),
												false, false, true)
										.getBlockPos().getX()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
												entity.getLook(1f).z * 3),
										false, false, true).getBlockPos().getY()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 3, entity.getLook(1f).y * 3,
												entity.getLook(1f).z * 3),
										false, false, true).getBlockPos().getZ())),
						BlockTrufflePlant.block.getDefaultState(), 3);
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemTruffle.block, (int) (1)).getItem(), -1, (int) 1, null);
			}
		}
	}
}
