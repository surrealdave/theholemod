package pile.procedure;

import pile.item.ItemTheyLackTheMoai;
import pile.item.ItemTheBiblicalDrop;
import pile.item.ItemSDGRAPP;
import pile.item.ItemOctahedron;
import pile.item.ItemObamium;
import pile.item.ItemMetalocrab;
import pile.item.ItemKillTheMods;
import pile.item.ItemGarbageMistress;
import pile.item.ItemEndAndDeand;
import pile.item.ItemDavidite;
import pile.item.ItemDavecoin;
import pile.item.ItemColdGold;

import pile.entity.EntityMolbo;
import pile.entity.EntityIsopod;
import pile.entity.EntityFungusDealer;
import pile.entity.EntityCrabb;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureDavesMysteryBoxBlockDestroyedByPlayer extends ElementsThePile.ModElement {
	public ProcedureDavesMysteryBoxBlockDestroyedByPlayer(ElementsThePile instance) {
		super(instance, 425);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DavesMysteryBoxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DavesMysteryBoxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DavesMysteryBoxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DavesMysteryBoxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DavesMysteryBoxBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double chance = 0;
		double recordNum = 0;
		chance = (double) (Math.random() * 100);
		recordNum = (double) Math.ceil((Math.random() * 7));
		if (((chance) <= 5)) {
			for (int index0 = 0; index0 < (int) (Math.ceil(((Math.random() * 15) + 5))); index0++) {
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemOctahedron.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
			for (int index1 = 0; index1 < (int) (Math.ceil(((Math.random() * 15) + 5))); index1++) {
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemDavidite.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
			for (int index2 = 0; index2 < (int) ((Math.ceil((Math.random() * 2)) + 1)); index2++) {
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemObamium.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList()
							.sendMessage(new TextComponentString((((entity.getDisplayName().getFormattedText())) + "" + (" hit the jackpot!"))));
			}
		} else if (((chance) <= 10)) {
			for (int index3 = 0; index3 < (int) ((Math.ceil((Math.random() * 10)) + 1)); index3++) {
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemDavidite.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
			for (int index4 = 0; index4 < (int) ((Math.ceil((Math.random() * 2)) + 1)); index4++) {
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemOctahedron.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList()
							.sendMessage(new TextComponentString((((entity.getDisplayName().getFormattedText())) + "" + (" got very lucky!"))));
			}
		} else if (((chance) <= 20)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityMolbo.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityMolbo.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString((((entity.getDisplayName().getFormattedText())) + ""
							+ (" has been chosen to continue the Molbo species! Also have fun tripping out on the mushrooms."))));
			}
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemSDGRAPP.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else if (((chance) <= 50)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityFungusDealer.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			for (int index5 = 0; index5 < (int) ((Math.ceil((Math.random() * 10)) + 1)); index5++) {
				if (!world.isRemote) {
					EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemDavecoin.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.spawnEntity(entityToSpawn);
				}
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString(
							(((entity.getDisplayName().getFormattedText())) + "" + (" can now Have a Fungus whenever they want!"))));
			}
		} else {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityCrabb.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityIsopod.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(
							new TextComponentString((((entity.getDisplayName().getFormattedText())) + "" + (" got 2 cool new friends!"))));
			}
		}
		if (((recordNum) == 1)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemGarbageMistress.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else if (((recordNum) == 2)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemKillTheMods.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else if (((recordNum) == 3)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemTheyLackTheMoai.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else if (((recordNum) == 4)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemMetalocrab.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else if (((recordNum) == 5)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemEndAndDeand.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else if (((recordNum) == 6)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemTheBiblicalDrop.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		} else {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemColdGold.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
