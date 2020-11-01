package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Random;

@ElementsThePile.ModElement.Tag
public class ProcedureRayOfYesRightClickedInAir extends ElementsThePile.ModElement {
	public ProcedureRayOfYesRightClickedInAir(ElementsThePile instance) {
		super(instance, 376);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RayOfYesRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure RayOfYesRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RayOfYesRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		double dist = 0;
		world.destroyBlock(
				new BlockPos(
						(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 4.5, entity.getLook(1f).y * 4.5,
										entity.getLook(1f).z * 4.5),
								false, false, true).getBlockPos().getX()),
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 4.5, entity.getLook(1f).y * 4.5,
												entity.getLook(1f).z * 4.5),
										false, false, true)
								.getBlockPos().getY()),
						(int) (entity.world.rayTraceBlocks(entity.getPositionEyes(1f), entity.getPositionEyes(1f)
								.addVector(entity.getLook(1f).x * 4.5, entity.getLook(1f).y * 4.5, entity.getLook(1f).z * 4.5), false, false, true)
								.getBlockPos().getZ())),
				false);
		if (itemstack.attemptDamageItem((int) 1, new Random(), null)) {
			itemstack.shrink(1);
			itemstack.setItemDamage(0);
		}
		dist = (double) 0.5;
		for (int index0 = 0; index0 < (int) (20); index0++) {
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.FLAME,
						(entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * (dist), entity.getLook(1f).y * (dist),
										entity.getLook(1f).z * (dist)),
								false, false, true).getBlockPos().getX()),
						(entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * (dist), entity.getLook(1f).y * (dist),
										entity.getLook(1f).z * (dist)),
								false, false, true).getBlockPos().getY()),
						(entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
								entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * (dist), entity.getLook(1f).y * (dist),
										entity.getLook(1f).z * (dist)),
								false, false, true).getBlockPos().getZ()),
						(int) 5, 0.1, 0.1, 0.1, 0.01, new int[0]);
			dist = (double) ((dist) + 0.2);
		}
	}
}
