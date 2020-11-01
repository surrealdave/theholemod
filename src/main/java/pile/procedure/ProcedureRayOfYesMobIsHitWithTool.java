package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;

@ElementsThePile.ModElement.Tag
public class ProcedureRayOfYesMobIsHitWithTool extends ElementsThePile.ModElement {
	public ProcedureRayOfYesMobIsHitWithTool(ElementsThePile instance) {
		super(instance, 394);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure RayOfYesMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure RayOfYesMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure RayOfYesMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RayOfYesMobIsHitWithTool!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.CLOUD, x, y, z, (int) 50, 3, 3, 3, 0.01, new int[0]);
	}
}
