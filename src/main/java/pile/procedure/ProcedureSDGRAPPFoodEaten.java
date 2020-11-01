package pile.procedure;

import pile.potion.PotionPsychoactivity;

import pile.ElementsThePile;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureSDGRAPPFoodEaten extends ElementsThePile.ModElement {
	public ProcedureSDGRAPPFoodEaten(ElementsThePile instance) {
		super(instance, 295);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SDGRAPPFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionPsychoactivity.potion, (int) 2400, (int) 5, (true), (false)));
	}
}
