package pile.procedure;

import pile.block.BlockFallenMeteor;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureMeteorOnEntityTickUpdate extends ElementsThePile.ModElement {
	public ProcedureMeteorOnEntityTickUpdate(ElementsThePile instance) {
		super(instance, 330);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MeteorOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MeteorOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MeteorOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MeteorOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MeteorOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((!(world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z))))
				|| (!(world.isAirBlock(new BlockPos((int) x, (int) (y - 2), (int) z)))))) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) (y - 1), (int) z, (float) 2, true);
			}
			world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), BlockFallenMeteor.block.getDefaultState(), 3);
			entity.world.removeEntity(entity);
		}
	}
}
