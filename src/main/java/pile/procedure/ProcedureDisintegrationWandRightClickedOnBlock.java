package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import java.util.Random;

@ElementsThePile.ModElement.Tag
public class ProcedureDisintegrationWandRightClickedOnBlock extends ElementsThePile.ModElement {
	public ProcedureDisintegrationWandRightClickedOnBlock(ElementsThePile instance) {
		super(instance, 190);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DisintegrationWandRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DisintegrationWandRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DisintegrationWandRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure DisintegrationWandRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DisintegrationWandRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, y, z, (int) 50, 3, 3, 3, 1, new int[0]);
		if (itemstack.attemptDamageItem((int) 1, new Random(), null)) {
			itemstack.shrink(1);
			itemstack.setItemDamage(0);
		}
	}
}
