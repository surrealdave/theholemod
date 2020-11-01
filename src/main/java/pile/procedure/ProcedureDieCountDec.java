package pile.procedure;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraft.world.World;

@ElementsThePile.ModElement.Tag
public class ProcedureDieCountDec extends ElementsThePile.ModElement {
	public ProcedureDieCountDec(ElementsThePile instance) {
		super(instance, 153);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DieCountDec!");
			return;
		}
		World world = (World) dependencies.get("world");
		if (((ThePileVariables.MapVariables.get(world).DieCount) > 1)) {
			ThePileVariables.MapVariables.get(world).DieCount = (double) ((ThePileVariables.MapVariables.get(world).DieCount) - 1);
			ThePileVariables.MapVariables.get(world).syncData(world);
		}
	}
}
