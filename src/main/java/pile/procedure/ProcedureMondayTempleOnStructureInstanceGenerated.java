package pile.procedure;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

@ElementsThePile.ModElement.Tag
public class ProcedureMondayTempleOnStructureInstanceGenerated extends ElementsThePile.ModElement {
	public ProcedureMondayTempleOnStructureInstanceGenerated(ElementsThePile instance) {
		super(instance, 332);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MondayTempleOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MondayTempleOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MondayTempleOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MondayTempleOnStructureInstanceGenerated!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double dist = 0;
		double dist2 = 0;
		if (!world.isRemote) {
			Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
					new ResourceLocation("pile", "mondaytemple"));
			if (template != null) {
				BlockPos spawnTo = new BlockPos((int) x, (int) (y + 10), (int) z);
				IBlockState iblockstate = world.getBlockState(spawnTo);
				world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
				template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
						.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
			}
		}
		dist = (double) Math.sqrt((Math.pow(((world.getSpawnPoint().getX()) - x), 2) + Math.pow(((world.getSpawnPoint().getZ()) - z), 2)));
		dist2 = (double) Math.sqrt((Math.pow(((world.getSpawnPoint().getX()) - (ThePileVariables.MapVariables.get(world).mondayX)), 2)
				+ Math.pow(((world.getSpawnPoint().getZ()) - (ThePileVariables.MapVariables.get(world).mondayZ)), 2)));
		if ((((dist) < (dist2)) || ((dist2) == 0))) {
			ThePileVariables.MapVariables.get(world).mondayX = (double) x;
			ThePileVariables.MapVariables.get(world).syncData(world);
			ThePileVariables.MapVariables.get(world).mondayZ = (double) z;
			ThePileVariables.MapVariables.get(world).syncData(world);
		}
	}
}
