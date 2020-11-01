package pile.procedure;

import pile.world.WorldYamDimension;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraftforge.common.DimensionManager;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.world.Teleporter;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureDieRoll extends ElementsThePile.ModElement {
	public ProcedureDieRoll(ElementsThePile instance) {
		super(instance, 154);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DieRoll!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DieRoll!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DieRoll!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DieRoll!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DieRoll!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		ThePileVariables.MapVariables.get(world).DieResult = (double) 0;
		ThePileVariables.MapVariables.get(world).syncData(world);
		for (int index0 = 0; index0 < (int) ((ThePileVariables.MapVariables.get(world).DieCount)); index0++) {
			for (int index1 = 0; index1 < (int) ((ThePileVariables.MapVariables.get(world).SideCount)); index1++) {
				ThePileVariables.MapVariables
						.get(world).DieResult = (double) ((ThePileVariables.MapVariables.get(world).DieResult) + Math.round(Math.random()));
				ThePileVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (((ThePileVariables.MapVariables.get(world).DieResult) < 1)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).clearActivePotions();
			world.playSound((EntityPlayer) null, x, y, z,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.blaze.death")),
					SoundCategory.NEUTRAL, (float) 100, (float) 1);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).closeScreen();
			entity.setFire((int) 30);
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 120, (int) 5));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 120, (int) 5));
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, (int) 50, 3, 3, 3, 0.1, new int[0]);
			if (!entity.world.isRemote && !entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP) {
				int dimensionID = WorldYamDimension.DIMID;
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
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, (int) 50, 3, 3, 3, 0.1, new int[0]);
		}
		if (((ThePileVariables.MapVariables.get(world).DieResult) == ((ThePileVariables.MapVariables.get(world).SideCount)
				* (ThePileVariables.MapVariables.get(world).DieCount)))) {
			world.playSound((EntityPlayer) null, x, y, z,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.player.levelup")),
					SoundCategory.NEUTRAL, (float) 100, (float) 1);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).closeScreen();
			entity.extinguish();
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 120, (int) 5));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, (int) 120, (int) 5));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 120, (int) 5));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, (int) 120, (int) 5));
		}
	}
}
