package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedurePorciniMushroomPlantDestroyedByPlayer extends ElementsThePile.ModElement {
	public ProcedurePorciniMushroomPlantDestroyedByPlayer(ElementsThePile instance) {
		super(instance, 257);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PorciniMushroomPlantDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((Math.random() + Math.random()) + (Math.random() + Math.random())) >= 2.5)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 10, (int) 1));
		}
	}
}
