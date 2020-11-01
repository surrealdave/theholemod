package pile.procedure;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraft.world.World;

@ElementsThePile.ModElement.Tag
public class ProcedureDieCountInc extends ElementsThePile.ModElement {
	public ProcedureDieCountInc(ElementsThePile instance) {
		super(instance, 152);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DieCountInc!");
			return;
		}
		World world = (World) dependencies.get("world");
		ThePileVariables.MapVariables.get(world).DieCount = (double) ((ThePileVariables.MapVariables.get(world).DieCount) + 1);
		ThePileVariables.MapVariables.get(world).syncData(world);
	}
}
