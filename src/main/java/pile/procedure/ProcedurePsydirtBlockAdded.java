package pile.procedure;

import pile.block.BlockPsygrass;

import pile.ElementsThePile;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;

@ElementsThePile.ModElement.Tag
public class ProcedurePsydirtBlockAdded extends ElementsThePile.ModElement {
	public ProcedurePsydirtBlockAdded(ElementsThePile instance) {
		super(instance, 342);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PsydirtBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PsydirtBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PsydirtBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PsydirtBlockAdded!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z))) && (Biome.REGISTRY
				.getNameForObject(world.getBiome(new BlockPos((int) x, (int) y, (int) z))).equals(new ResourceLocation("pile:dreamland"))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockPsygrass.block.getDefaultState(), 3);
		}
	}
}
