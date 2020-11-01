package pile.procedure;

import pile.entity.EntityCornGolem;

import pile.block.BlockMoyai;
import pile.block.BlockCornCube;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureCornCoreNeighbourBlockChanges extends ElementsThePile.ModElement {
	public ProcedureCornCoreNeighbourBlockChanges(ElementsThePile instance) {
		super(instance, 237);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CornCoreNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CornCoreNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CornCoreNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CornCoreNeighbourBlockChanges!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BlockMoyai.block.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockCornCube.block.getDefaultState()
					.getBlock())) {
				world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y + 1), (int) z));
				world.setBlockToAir(new BlockPos((int) x, (int) (y - 1), (int) z));
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityCornGolem.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
