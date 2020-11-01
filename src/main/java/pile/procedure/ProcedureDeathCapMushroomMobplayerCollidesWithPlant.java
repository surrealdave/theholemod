package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureDeathCapMushroomMobplayerCollidesWithPlant extends ElementsThePile.ModElement {
	public ProcedureDeathCapMushroomMobplayerCollidesWithPlant(ElementsThePile instance) {
		super(instance, 258);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DeathCapMushroomMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WITHER, (int) 5, (int) 2));
	}
}
