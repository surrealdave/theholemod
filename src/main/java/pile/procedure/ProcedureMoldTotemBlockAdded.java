package pile.procedure;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;

@ElementsThePile.ModElement.Tag
public class ProcedureMoldTotemBlockAdded extends ElementsThePile.ModElement {
	public ProcedureMoldTotemBlockAdded(ElementsThePile instance) {
		super(instance, 428);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MoldTotemBlockAdded!");
			return;
		}
		World world = (World) dependencies.get("world");
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList()
						.sendMessage(new TextComponentString("Black Mold growth can no longer happen. Destroy this totem to cancel this action."));
		}
		ThePileVariables.MapVariables.get(world).canMoldGrow = (boolean) (false);
		ThePileVariables.MapVariables.get(world).syncData(world);
	}
}
