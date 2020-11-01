package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureFrostCantripMobIsHitWithTool extends ElementsThePile.ModElement {
	public ProcedureFrostCantripMobIsHitWithTool(ElementsThePile instance) {
		super(instance, 372);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FrostCantripMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FrostCantripMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((Math.random() * 100) >= 60)) {
			world.setBlockState(new BlockPos((int) (entity.posX), (int) ((entity.posY) + 1), (int) (entity.posZ)),
					Blocks.FROSTED_ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (entity.posX), (int) ((entity.posY) + 2), (int) (entity.posZ)),
					Blocks.FROSTED_ICE.getDefaultState(), 3);
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 5, (int) 5, (true), (false)));
		}
	}
}
