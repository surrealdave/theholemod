package pile.procedure;

import pile.world.WorldDreamlandDim;

import pile.potion.PotionPsychoactivity;

import pile.item.ItemDreamCatcher;

import pile.entity.EntityMeteor;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.DimensionManager;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.world.Teleporter;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Collection;

@ElementsThePile.ModElement.Tag
public class ProcedureWakeup extends ElementsThePile.ModElement {
	public ProcedureWakeup(ElementsThePile instance) {
		super(instance, 335);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Wakeup!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Wakeup!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Wakeup!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Wakeup!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Wakeup!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double _x = 0;
		double _z = 0;
		if ((!(Biome.REGISTRY.getNameForObject(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
				.equals(new ResourceLocation("pile:dreamland"))))) {
			if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(ItemDreamCatcher.block, (int) (1)).getItem()) && (new Object() {
						boolean check() {
							if (entity instanceof EntityLivingBase) {
								Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
								for (PotionEffect effect : effects) {
									if (effect.getPotion() == PotionPsychoactivity.potion)
										return true;
								}
							}
							return false;
						}
					}.check()))) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, (int) 60, (int) 100, (false), (false)));
				entity.setPositionAndUpdate((_x), 300, (_z));
				if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
					int dimensionID = WorldDreamlandDim.DIMID;
					class TeleporterDirect extends Teleporter {
						public TeleporterDirect(WorldServer worldserver) {
							super(worldserver);
						}

						@Override
						public void placeInPortal(Entity entity, float yawrotation) {
						}

						@Override
						public boolean placeInExistingPortal(Entity entity, float yawrotation) {
							return true;
						}

						@Override
						public boolean makePortal(Entity entity) {
							return true;
						}
					}
					EntityPlayerMP _player = (EntityPlayerMP) entity;
					_player.mcServer.getPlayerList().transferPlayerToDimension(_player, dimensionID, new TeleporterDirect(_player.getServerWorld()));
					_player.connection.setPlayerLocation(DimensionManager.getWorld(dimensionID).getSpawnPoint().getX(),
							DimensionManager.getWorld(dimensionID).getSpawnPoint().getY() + 1,
							DimensionManager.getWorld(dimensionID).getSpawnPoint().getZ(), _player.rotationYaw, _player.rotationPitch);
				}
			} else if (((Math.random() * 100) <= 10)) {
				if (entity instanceof EntityPlayer && !world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You had a dream about a meteor..."), (true));
				}
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityMeteor.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, (y + 300), z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else {
				if (entity instanceof EntityPlayer && !world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You had a dream, but couldn't remember it..."), (true));
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerInBed(PlayerSleepInBedEvent event) {
		EntityPlayer entity = event.getEntityPlayer();
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = entity.world;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
