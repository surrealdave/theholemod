package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureIcySpearMobIsHitWithTool extends ElementsThePile.ModElement {
	public ProcedureIcySpearMobIsHitWithTool(ElementsThePile instance) {
		super(instance, 169);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure IcySpearMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 10, (int) 2));
	}
}
