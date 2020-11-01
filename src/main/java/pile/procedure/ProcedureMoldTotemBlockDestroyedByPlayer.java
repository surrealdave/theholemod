package pile.procedure;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;

@ElementsThePile.ModElement.Tag
public class ProcedureMoldTotemBlockDestroyedByPlayer extends ElementsThePile.ModElement {
	public ProcedureMoldTotemBlockDestroyedByPlayer(ElementsThePile instance) {
		super(instance, 429);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MoldTotemBlockDestroyedByPlayer!");
			return;
		}
		World world = (World) dependencies.get("world");
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString("Mold Totem destroyed! Black Mold can now grow again, look out!"));
		}
		ThePileVariables.MapVariables.get(world).canMoldGrow = (boolean) (true);
		ThePileVariables.MapVariables.get(world).syncData(world);
	}
}
