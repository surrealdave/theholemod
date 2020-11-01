package pile.procedure;

import pile.entity.EntityObama;

import pile.block.BlockMondaystone;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureCubamaBlockNeighbourBlockChanges extends ElementsThePile.ModElement {
	public ProcedureCubamaBlockNeighbourBlockChanges(ElementsThePile instance) {
		super(instance, 399);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CubamaBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CubamaBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CubamaBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CubamaBlockNeighbourBlockChanges!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockMondaystone.block.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == BlockMondaystone.block.getDefaultState()
						.getBlock()))) {
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == BlockMondaystone.block.getDefaultState()
					.getBlock())
					&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == BlockMondaystone.block
							.getDefaultState().getBlock()))) {
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 1), (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 2), (int) z));
				world.setBlockToAir(new BlockPos((int) (x - 1), (int) (y - 1), (int) z));
				world.setBlockToAir(new BlockPos((int) (x + 1), (int) (y - 1), (int) z));
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityObama.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == BlockMondaystone.block
					.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == BlockMondaystone.block
							.getDefaultState().getBlock()))) {
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 1), (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 2), (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)));
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityObama.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
