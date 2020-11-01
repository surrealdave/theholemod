package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;

import java.util.Random;

@ElementsThePile.ModElement.Tag
public class ProcedureVrobotsSeveredArmRightClickedInAir extends ElementsThePile.ModElement {
	public ProcedureVrobotsSeveredArmRightClickedInAir(ElementsThePile instance) {
		super(instance, 369);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VrobotsSeveredArmRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure VrobotsSeveredArmRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VrobotsSeveredArmRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		if (itemstack.attemptDamageItem((int) 1, new Random(), null)) {
			itemstack.shrink(1);
			itemstack.setItemDamage(0);
		}
		world.addWeatherEffect(
				new EntityLightningBolt(world,
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(
												entity.getLook(1f).x
														* (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
																entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 50,
																		entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true).getBlockPos().getX()),
												entity.getLook(1f).y * (entity.world
														.rayTraceBlocks(entity.getPositionEyes(1f),
																entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 50,
																		entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true)
														.getBlockPos().getX()),
												entity.getLook(1f).z * (entity.world
														.rayTraceBlocks(entity.getPositionEyes(1f),
																entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 50,
																		entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true)
														.getBlockPos().getX())),
										false, false, true)
								.getBlockPos().getX()),
						(int) (entity.world
								.rayTraceBlocks(
										entity.getPositionEyes(1f),
										entity.getPositionEyes(1f)
												.addVector(
														entity.getLook(1f).x
																* (entity.world
																		.rayTraceBlocks(entity.getPositionEyes(1f),
																				entity.getPositionEyes(1f).addVector(
																						entity.getLook(1f).x * 50, entity.getLook(1f).y * 50,
																						entity.getLook(1f).z * 50),
																				false, false, true)
																		.getBlockPos().getY()),
														entity.getLook(1f).y * (entity.world
																.rayTraceBlocks(
																		entity.getPositionEyes(1f),
																		entity.getPositionEyes(1f).addVector(
																				entity.getLook(1f).x * 50, entity.getLook(1f).y * 50,
																				entity.getLook(1f).z * 50),
																		false, false, true)
																.getBlockPos().getY()),
														entity.getLook(1f).z * (entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
																entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 50,
																		entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true).getBlockPos().getY())),
										false, false, true)
								.getBlockPos().getY()),
						(int) (entity.world
								.rayTraceBlocks(entity.getPositionEyes(1f),
										entity.getPositionEyes(1f).addVector(
												entity.getLook(1f).x * (entity.world
														.rayTraceBlocks(entity.getPositionEyes(1f), entity.getPositionEyes(1f).addVector(
																entity.getLook(1f).x * 50, entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true)
														.getBlockPos().getZ()),
												entity.getLook(1f).y * (entity.world
														.rayTraceBlocks(entity.getPositionEyes(1f),
																entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 50,
																		entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true)
														.getBlockPos().getZ()),
												entity.getLook(1f).z * (entity.world
														.rayTraceBlocks(entity.getPositionEyes(1f),
																entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 50,
																		entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
																false, false, true)
														.getBlockPos().getZ())),
										false, false, true)
								.getBlockPos().getZ()),
						false));
	}
}
