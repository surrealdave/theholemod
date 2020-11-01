package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureCinderclawMobIsHitWithTool extends ElementsThePile.ModElement {
	public ProcedureCinderclawMobIsHitWithTool(ElementsThePile instance) {
		super(instance, 371);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CinderclawMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CinderclawMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		entity.setFire((int) 15);
		if ((world
				.isAirBlock(
						new BlockPos(
								(int) (entity.world
										.rayTraceBlocks(entity.getPositionEyes(1f),
												entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
														entity.getLook(1f).z * 2),
												false, false, true)
										.getBlockPos().getX()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true).getBlockPos().getY()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f), entity.getPositionEyes(1f)
										.addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2), false, false, true)
										.getBlockPos().getZ()))))) {
			world.setBlockState(
					new BlockPos(
							(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getX()),
							(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getY()),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getZ())),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if ((world
				.isAirBlock(
						new BlockPos(
								(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true).getBlockPos().getX()) + 1),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true).getBlockPos().getY()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f), entity.getPositionEyes(1f)
										.addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2), false, false, true)
										.getBlockPos().getZ()))))) {
			world.setBlockState(
					new BlockPos(
							(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getX()) + 1),
							(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getY()),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getZ())),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if ((world
				.isAirBlock(
						new BlockPos(
								(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true).getBlockPos().getX()) - 1),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true).getBlockPos().getY()),
								(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f), entity.getPositionEyes(1f)
										.addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2), false, false, true)
										.getBlockPos().getZ()))))) {
			world.setBlockState(
					new BlockPos(
							(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getX()) - 1),
							(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getY()),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getZ())),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if ((world
				.isAirBlock(new BlockPos(
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(
												entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getX()),
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getY()),
						(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								false, false, true).getBlockPos().getZ()) + 1))))) {
			world.setBlockState(
					new BlockPos(
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getX()),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getY()),
							(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getZ()) + 1)),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if ((world
				.isAirBlock(new BlockPos(
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(
												entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getX()),
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getY()),
						(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								false, false, true).getBlockPos().getZ()) - 1))))) {
			world.setBlockState(
					new BlockPos(
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getX()),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getY()),
							(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getZ()) - 1)),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if ((world
				.isAirBlock(new BlockPos(
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(
												entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getX()),
						(int) ((entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getY()) + 1),
						(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								false, false, true).getBlockPos().getZ()))))) {
			world.setBlockState(
					new BlockPos(
							(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getX()),
							(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getY()) + 1),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getZ())),
					Blocks.FIRE.getDefaultState(), 3);
		}
		if ((world
				.isAirBlock(new BlockPos(
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(
												entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getX()),
						(int) ((entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
												entity.getLook(1f).z * 2),
										false, false, true)
								.getBlockPos().getY()) - 1),
						(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2, entity.getLook(1f).z * 2),
								false, false, true).getBlockPos().getZ()))))) {
			world.setBlockState(
					new BlockPos(
							(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getX()),
							(int) ((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true).getBlockPos().getY()) - 1),
							(int) (entity.world
									.rayTraceBlocks(entity.getPositionEyes(1f),
											entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
													entity.getLook(1f).z * 2),
											false, false, true)
									.getBlockPos().getZ())),
					Blocks.FIRE.getDefaultState(), 3);
		}
	}
}
