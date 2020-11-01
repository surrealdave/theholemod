
package pile.entity;

import pile.item.ItemYam;
import pile.item.ItemIsopodItem;
import pile.item.ItemCookedBrogle;
import pile.item.ItemBrogle;

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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

@ElementsThePile.ModElement.Tag
public class EntityIsopod extends ElementsThePile.ModElement {
	public static final int ENTITYID = 11;
	public static final int ENTITYID_RANGED = 12;
	public EntityIsopod(ElementsThePile instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "isopod"), ENTITYID)
				.name("isopod").tracker(64, 3, true).egg(-13108, -992293).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("ocean")),
				Biome.REGISTRY.getObject(new ResourceLocation("deep_ocean")),};
		EntityRegistry.addSpawn(EntityCustom.class, 8, 3, 5, EnumCreatureType.WATER_CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelIsopod(), 0.4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/isopod.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.3f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAISwimming(this));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAIPanic(this, 1.2));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ARTHROPOD;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemIsopodItem.block, (int) (1)).getItem();
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
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
		}

		@Override
		public EntityCustom createChild(EntityAgeable ageable) {
			return new EntityCustom(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(ItemBrogle.block, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(ItemCookedBrogle.block, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(ItemYam.block, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
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

	// Date: 2/03/2019 5:45:51 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelIsopod extends ModelBase {
		// fields
		ModelRenderer b1;
		ModelRenderer head;
		ModelRenderer b3;
		ModelRenderer b2;
		ModelRenderer fin2;
		ModelRenderer fin1;
		ModelRenderer legs;
		ModelRenderer tail;
		public ModelIsopod() {
			textureWidth = 64;
			textureHeight = 32;
			b1 = new ModelRenderer(this, 0, 22);
			b1.addBox(-3F, -3.5F, -3F, 6, 4, 6);
			b1.setRotationPoint(0F, 23F, -3F);
			b1.setTextureSize(64, 32);
			b1.mirror = true;
			setRotation(b1, -0.0918105F, 0F, 0F);
			head = new ModelRenderer(this, 16, 12);
			head.addBox(-2F, -2F, -2F, 4, 3, 2);
			head.setRotationPoint(0F, 22F, -5.6F);
			head.setTextureSize(64, 32);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			b3 = new ModelRenderer(this, 42, 27);
			b3.addBox(-2.5F, -2F, 3F, 5, 3, 2);
			b3.setRotationPoint(0F, 23F, -0.2F);
			b3.setTextureSize(64, 32);
			b3.mirror = true;
			setRotation(b3, 0F, 0F, 0F);
			b2 = new ModelRenderer(this, 24, 25);
			b2.addBox(-3F, -2F, 0F, 6, 4, 3);
			b2.setRotationPoint(0F, 22F, -0.2F);
			b2.setTextureSize(64, 32);
			b2.mirror = true;
			setRotation(b2, 0F, 0F, 0F);
			fin2 = new ModelRenderer(this, 0, 12);
			fin2.addBox(-4.5F, 0F, -5.5F, 3, 0, 10);
			fin2.setRotationPoint(0F, 23F, -1F);
			fin2.setTextureSize(64, 32);
			fin2.mirror = true;
			setRotation(fin2, -0.0698132F, 0F, -0.1745329F);
			fin1 = new ModelRenderer(this, -6, 12);
			fin1.addBox(1.5F, 0F, -5.5F, 3, 0, 10);
			fin1.setRotationPoint(0F, 23F, -1F);
			fin1.setTextureSize(64, 32);
			fin1.mirror = true;
			setRotation(fin1, -0.0698132F, 0F, 0.1745329F);
			legs = new ModelRenderer(this, 0, 4);
			legs.addBox(-2F, 0F, -5.5F, 4, 1, 7);
			legs.setRotationPoint(0F, 23F, -1F);
			legs.setTextureSize(64, 32);
			legs.mirror = true;
			setRotation(legs, 0F, 0F, 0F);
			tail = new ModelRenderer(this, 12, 18);
			tail.addBox(-3.5F, 0F, 0F, 7, 0, 4);
			tail.setRotationPoint(0F, 23.5F, 4F);
			tail.setTextureSize(64, 32);
			tail.mirror = true;
			setRotation(tail, -0.0872665F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			b1.render(f5);
			head.render(f5);
			b3.render(f5);
			b2.render(f5);
			fin2.render(f5);
			fin1.render(f5);
			legs.render(f5);
			tail.render(f5);
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
		}
	}
}
