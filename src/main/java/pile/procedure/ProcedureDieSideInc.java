package pile.procedure;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraft.world.World;

@ElementsThePile.ModElement.Tag
public class ProcedureDieSideInc extends ElementsThePile.ModElement {
	public ProcedureDieSideInc(ElementsThePile instance) {
		super(instance, 150);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DieSideInc!");
			return;
		}
		World world = (World) dependencies.get("world");
		ThePileVariables.MapVariables.get(world).SideCount = (double) ((ThePileVariables.MapVariables.get(world).SideCount) + 1);
		ThePileVariables.MapVariables.get(world).syncData(world);
	}
}
