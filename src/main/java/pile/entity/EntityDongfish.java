
package pile.entity;

import pile.item.ItemRawDongfish;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

@ElementsThePile.ModElement.Tag
public class EntityDongfish extends ElementsThePile.ModElement {
	public static final int ENTITYID = 26;
	public static final int ENTITYID_RANGED = 27;
	public EntityDongfish(ElementsThePile instance) {
		super(instance, 127);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "dongfish"), ENTITYID)
				.name("dongfish").tracker(64, 3, true).egg(-52276, -3355444).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("deep_ocean")),
				Biome.REGISTRY.getObject(new ResourceLocation("ocean")),};
		EntityRegistry.addSpawn(EntityCustom.class, 10, 3, 10, EnumCreatureType.WATER_CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelDongfish(), 0.3f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/dongfish2.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.5f, 0.5f);
			experienceValue = 3;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAISwimming(this));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
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
			return new ItemStack(ItemRawDongfish.block, (int) (1)).getItem();
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
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean getCanSpawnHere() {
			return true;
		}

		@Override
		public boolean isNotColliding() {
			return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}

	// Date: 11/12/2019 7:17:47 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelDongfish extends ModelBase {
		// fields
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer tail;
		ModelRenderer scungle2;
		ModelRenderer scungle1;
		ModelRenderer nuttesac;
		ModelRenderer tailfin;
		ModelRenderer backfin;
		ModelRenderer hand;
		public ModelDongfish() {
			textureWidth = 64;
			textureHeight = 32;
			head = new ModelRenderer(this, 0, 0);
			head.addBox(-1F, -1F, -2.2F, 2, 2, 2);
			head.setRotationPoint(0F, 14.8F, -5.333333F);
			head.setTextureSize(64, 32);
			head.mirror = true;
			setRotation(head, 0.2602503F, 0F, 0F);
			body = new ModelRenderer(this, 0, 4);
			body.addBox(-1F, -1.2F, 0F, 2, 2, 7);
			body.setRotationPoint(0F, 15F, -6F);
			body.setTextureSize(64, 32);
			body.mirror = true;
			setRotation(body, 0F, 0F, 0F);
			tail = new ModelRenderer(this, 12, 0);
			tail.addBox(-0.5F, -1F, 0F, 1, 2, 5);
			tail.setRotationPoint(0F, 14.86667F, 0.6F);
			tail.setTextureSize(64, 32);
			tail.mirror = true;
			setRotation(tail, -0.0546319F, 0F, 0F);
			scungle2 = new ModelRenderer(this, 0, 8);
			scungle2.addBox(-0.5F, 1F, 1F, 1, 1, 2);
			scungle2.setRotationPoint(0F, 15.6F, -3.333333F);
			scungle2.setTextureSize(64, 32);
			scungle2.mirror = true;
			setRotation(scungle2, -0.9037501F, 0F, 0F);
			scungle1 = new ModelRenderer(this, 11, 8);
			scungle1.addBox(-0.5F, 0F, 0F, 1, 2, 1);
			scungle1.setRotationPoint(0F, 15.6F, -4F);
			scungle1.setTextureSize(64, 32);
			scungle1.mirror = true;
			setRotation(scungle1, -0.1289891F, 0F, 0F);
			nuttesac = new ModelRenderer(this, 0, 13);
			nuttesac.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
			nuttesac.setRotationPoint(0F, 19F, -3F);
			nuttesac.setTextureSize(64, 32);
			nuttesac.mirror = true;
			setRotation(nuttesac, 1.047198F, 0F, 0F);
			tailfin = new ModelRenderer(this, 20, 0);
			tailfin.addBox(0F, -2F, 0.4F, 0, 1, 2);
			tailfin.setRotationPoint(0F, 15F, 0.6F);
			tailfin.setTextureSize(64, 32);
			tailfin.mirror = true;
			setRotation(tailfin, 0F, 0F, 0F);
			backfin = new ModelRenderer(this, 24, 0);
			backfin.addBox(0F, -2F, 3F, 0, 1, 3);
			backfin.setRotationPoint(0F, 15F, -6F);
			backfin.setTextureSize(64, 32);
			backfin.mirror = true;
			setRotation(backfin, 0F, 0F, 0F);
			hand = new ModelRenderer(this, 30, 0);
			hand.addBox(-1.5F, 0F, 0F, 3, 1, 1);
			hand.setRotationPoint(0F, 14.66667F, -5F);
			hand.setTextureSize(64, 32);
			hand.mirror = true;
			setRotation(hand, 0.2602503F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			head.render(f5);
			body.render(f5);
			tail.render(f5);
			scungle2.render(f5);
			scungle1.render(f5);
			nuttesac.render(f5);
			tailfin.render(f5);
			backfin.render(f5);
			hand.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.tailfin.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.nuttesac.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
