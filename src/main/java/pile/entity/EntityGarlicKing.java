
package pile.entity;

import pile.item.ItemGarlic;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;

import java.util.Random;

@ElementsThePile.ModElement.Tag
public class EntityGarlicKing extends ElementsThePile.ModElement {
	public static final int ENTITYID = 7;
	public static final int ENTITYID_RANGED = 8;
	public EntityGarlicKing(ElementsThePile instance) {
		super(instance, 144);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "garlicking"), ENTITYID)
				.name("garlicking").tracker(64, 3, true).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("pile", "entitybulletgarlicking"), ENTITYID_RANGED).name("entitybulletgarlicking").tracker(64, 1, true)
				.build());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelGarlicKing(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/garlicking.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(ItemGarlic.block, (int) (1));
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(1.5f, 3.75f);
			experienceValue = 1598;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, true));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAIWander(this, 1));
			this.tasks.addTask(6, new EntityAISwimming(this));
			this.tasks.addTask(7, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemGarlic.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityArrow)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(510D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(42D);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 2; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 1.500000001490116D;
					double d4 = (random.nextFloat() - 0.5D) * 1.500000001490116D;
					double d5 = (random.nextFloat() - 0.5D) * 1.500000001490116D;
					world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}

	// Date: 23/02/2019 3:34:46 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelGarlicKing extends ModelBase {
		// fields
		ModelRenderer ll1;
		ModelRenderer ll2;
		ModelRenderer lf;
		ModelRenderer lt1;
		ModelRenderer lt2;
		ModelRenderer rf;
		ModelRenderer rl2;
		ModelRenderer rl1;
		ModelRenderer rt1;
		ModelRenderer rt2;
		ModelRenderer s2;
		ModelRenderer crown;
		ModelRenderer s1;
		ModelRenderer body;
		public ModelGarlicKing() {
			textureWidth = 128;
			textureHeight = 128;
			ll1 = new ModelRenderer(this, 0, 0);
			ll1.addBox(2F, 0F, -5F, 10, 12, 10);
			ll1.setRotationPoint(0F, 0F, 0F);
			ll1.setTextureSize(128, 128);
			ll1.mirror = true;
			setRotation(ll1, -0.0349066F, 0F, -0.0523599F);
			ll2 = new ModelRenderer(this, 0, 0);
			ll2.addBox(2F, 11.06667F, -5.666667F, 10, 12, 10);
			ll2.setRotationPoint(0F, 0F, 0F);
			ll2.setTextureSize(128, 128);
			ll2.mirror = true;
			setRotation(ll2, 0.0174533F, 0F, -0.0523599F);
			lf = new ModelRenderer(this, 40, 0);
			lf.addBox(2F, 20.06667F, -6.666667F, 10, 4, 12);
			lf.setRotationPoint(0F, 0F, 0F);
			lf.setTextureSize(128, 128);
			lf.mirror = true;
			setRotation(lf, 0.0174533F, 0F, -0.0523599F);
			lt1 = new ModelRenderer(this, 0, 22);
			lt1.addBox(7F, 22.06667F, -14.66667F, 5, 2, 8);
			lt1.setRotationPoint(0F, 0F, 0F);
			lt1.setTextureSize(128, 128);
			lt1.mirror = true;
			setRotation(lt1, 0.0523599F, -0.0872665F, -0.0523599F);
			lt2 = new ModelRenderer(this, 0, 22);
			lt2.addBox(2F, 22.06667F, -13.66667F, 5, 2, 8);
			lt2.setRotationPoint(0F, 0F, 0F);
			lt2.setTextureSize(128, 128);
			lt2.mirror = true;
			setRotation(lt2, 0.0349066F, 0.0872665F, -0.0523599F);
			rf = new ModelRenderer(this, 40, 0);
			rf.addBox(-12F, 20.06667F, -6.666667F, 10, 4, 12);
			rf.setRotationPoint(0F, 0F, 0F);
			rf.setTextureSize(128, 128);
			rf.mirror = true;
			setRotation(rf, 0.0174533F, 0F, 0.0523599F);
			rl2 = new ModelRenderer(this, 0, 0);
			rl2.addBox(-12F, 11.06667F, -5.666667F, 10, 12, 10);
			rl2.setRotationPoint(0F, 0F, 0F);
			rl2.setTextureSize(128, 128);
			rl2.mirror = true;
			setRotation(rl2, 0.0174533F, 0F, 0.0523599F);
			rl1 = new ModelRenderer(this, 0, 0);
			rl1.addBox(-12F, 0F, -5F, 10, 12, 10);
			rl1.setRotationPoint(0F, 0F, 0F);
			rl1.setTextureSize(128, 128);
			rl1.mirror = true;
			setRotation(rl1, -0.0349066F, 0F, 0.0523599F);
			rt1 = new ModelRenderer(this, 0, 22);
			rt1.addBox(-12F, 22.06667F, -14.66667F, 5, 2, 8);
			rt1.setRotationPoint(0F, 0F, 0F);
			rt1.setTextureSize(128, 128);
			rt1.mirror = true;
			setRotation(rt1, 0.0523599F, 0.0872665F, 0.0523599F);
			rt2 = new ModelRenderer(this, 0, 22);
			rt2.addBox(-7F, 22.06667F, -13.66667F, 5, 2, 8);
			rt2.setRotationPoint(0F, 0F, 0F);
			rt2.setTextureSize(128, 128);
			rt2.mirror = true;
			setRotation(rt2, 0.0349066F, -0.0872665F, 0.0523599F);
			s2 = new ModelRenderer(this, 54, 22);
			s2.addBox(0F, -34F, 8.2F, 4, 8, 4);
			s2.setRotationPoint(0F, 0F, 0F);
			s2.setTextureSize(128, 128);
			s2.mirror = true;
			setRotation(s2, 0.1570796F, 0.1396263F, 0.1047198F);
			crown = new ModelRenderer(this, 0, 88);
			crown.addBox(-15F, -34F, -15F, 30, 10, 30);
			crown.setRotationPoint(0F, 0F, 0F);
			crown.setTextureSize(128, 128);
			crown.mirror = true;
			setRotation(crown, 0F, 0F, 0F);
			s1 = new ModelRenderer(this, 70, 17);
			s1.addBox(-4F, -27F, -3F, 15, 3, 14);
			s1.setRotationPoint(0F, 0F, 0F);
			s1.setTextureSize(128, 128);
			s1.mirror = true;
			setRotation(s1, 0F, 0F, 0F);
			body = new ModelRenderer(this, 0, 34);
			body.addBox(-15F, -24F, -15F, 30, 24, 30);
			body.setRotationPoint(0F, 0F, 0F);
			body.setTextureSize(128, 128);
			body.mirror = true;
			setRotation(body, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			ll1.render(f5);
			ll2.render(f5);
			lf.render(f5);
			lt1.render(f5);
			lt2.render(f5);
			rf.render(f5);
			rl2.render(f5);
			rl1.render(f5);
			rt1.render(f5);
			rt2.render(f5);
			s2.render(f5);
			crown.render(f5);
			s1.render(f5);
			body.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.ll1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rl1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
