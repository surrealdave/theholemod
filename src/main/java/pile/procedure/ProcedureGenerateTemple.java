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
public class ProcedureGenerateTemple extends ElementsThePile.ModElement {
	public ProcedureGenerateTemple(ElementsThePile instance) {
		super(instance, 400);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GenerateTemple!");
			return;
		}
		World world = (World) dependencies.get("world");
		double rX = 0;
		double rZ = 0;
		double rY = 0;
		if ((((rX) == 0) && ((rZ) == 0))) {
			rX = (double) ((Math.random() * 6000) - 300);
			rZ = (double) ((Math.random() * 6000) - 3000);
			rY = (double) 60;
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("pile", "mondaytemple"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (rX), (int) (rY), (int) (rZ));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
			ThePileVariables.MapVariables.get(world).mondayX = (double) (rX);
			ThePileVariables.MapVariables.get(world).syncData(world);
			ThePileVariables.MapVariables.get(world).mondayX = (double) (rZ);
			ThePileVariables.MapVariables.get(world).syncData(world);
		}
	}
}
