
package pile.entity;

import pile.procedure.ProcedureCrabbMobDies;

import pile.item.ItemYam;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

@ElementsThePile.ModElement.Tag
public class EntityCrabb extends ElementsThePile.ModElement {
	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;
	public EntityCrabb(ElementsThePile instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "crabb"), ENTITYID)
				.name("crabb").tracker(64, 3, true).egg(-65536, -6737152).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("ocean")), Biome.REGISTRY.getObject(new ResourceLocation("river")),
				Biome.REGISTRY.getObject(new ResourceLocation("beaches")),};
		EntityRegistry.addSpawn(EntityCustom.class, 7, 4, 10, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelcrabn(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/crabn.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.5f, 0.5f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAISwimming(this));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAIEatGrass(this));
			this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityCrabb.EntityCustom.class, (float) 6));
			this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayerMP.class, (float) 6));
			this.tasks.addTask(6, new EntityAILookIdle(this));
			this.tasks.addTask(7, new EntityAISwimming(this));
			this.targetTasks.addTask(8, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ARTHROPOD;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return null;
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
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureCrabbMobDies.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
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

	// Date: 27/12/2018 4:52:52 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class Modelcrabn extends ModelBase {
		// fields
		ModelRenderer body;
		ModelRenderer es1;
		ModelRenderer es2;
		ModelRenderer e1;
		ModelRenderer e2;
		ModelRenderer a21;
		ModelRenderer a22;
		ModelRenderer cl3;
		ModelRenderer cl1;
		ModelRenderer cs1;
		ModelRenderer cs2;
		ModelRenderer a11;
		ModelRenderer a12;
		ModelRenderer rl23;
		ModelRenderer rl21;
		ModelRenderer rl22;
		ModelRenderer rl41;
		ModelRenderer rl42;
		ModelRenderer rl43;
		ModelRenderer rl11;
		ModelRenderer rl12;
		ModelRenderer rl13;
		ModelRenderer rl33;
		ModelRenderer rl32;
		ModelRenderer rl31;
		ModelRenderer ll13;
		ModelRenderer ll12;
		ModelRenderer ll11;
		ModelRenderer ll21;
		ModelRenderer ll22;
		ModelRenderer ll23;
		ModelRenderer ll33;
		ModelRenderer ll32;
		ModelRenderer ll31;
		ModelRenderer ll41;
		ModelRenderer ll42;
		ModelRenderer ll43;
		public Modelcrabn() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this, 0, 0);
			body.addBox(-3.5F, 0F, -5F, 7, 3, 10);
			body.setRotationPoint(0F, 18F, 0F);
			body.setTextureSize(64, 32);
			body.mirror = true;
			setRotation(body, 0F, 0F, -0.1396263F);
			es1 = new ModelRenderer(this, 0, 0);
			es1.addBox(0F, -2F, 0F, 1, 2, 1);
			es1.setRotationPoint(3F, 18F, 1F);
			es1.setTextureSize(64, 32);
			es1.mirror = true;
			setRotation(es1, 0F, 0F, 0F);
			es2 = new ModelRenderer(this, 0, 0);
			es2.addBox(0F, -2F, -1F, 1, 2, 1);
			es2.setRotationPoint(3F, 18F, -1F);
			es2.setTextureSize(64, 32);
			es2.mirror = true;
			setRotation(es2, 0F, 0F, 0F);
			e1 = new ModelRenderer(this, 0, 3);
			e1.addBox(0.2F, -2.7F, 0F, 1, 1, 1);
			e1.setRotationPoint(3F, 18F, 1F);
			e1.setTextureSize(64, 32);
			e1.mirror = true;
			setRotation(e1, 0F, -0.1047198F, 0F);
			e2 = new ModelRenderer(this, 0, 3);
			e2.addBox(0.2F, -2.7F, -1F, 1, 1, 1);
			e2.setRotationPoint(3F, 18F, -1F);
			e2.setTextureSize(64, 32);
			e2.mirror = true;
			setRotation(e2, 0F, 0.1047198F, 0F);
			a21 = new ModelRenderer(this, 24, 0);
			a21.addBox(0F, -1F, -1F, 5, 2, 2);
			a21.setRotationPoint(2F, 20F, -3F);
			a21.setTextureSize(64, 32);
			a21.mirror = true;
			setRotation(a21, 0F, 0.6981317F, 0F);
			a22 = new ModelRenderer(this, 24, 4);
			a22.addBox(3.5F, -1.5F, 0.5F, 2, 2, 2);
			a22.setRotationPoint(2F, 20F, -3F);
			a22.setTextureSize(64, 32);
			a22.mirror = true;
			setRotation(a22, 0F, 0.6981317F, 0F);
			cl3 = new ModelRenderer(this, 38, 4);
			cl3.addBox(3.6F, -0.5F, 1.5F, 2, 1, 4);
			cl3.setRotationPoint(2F, 20F, -3F);
			cl3.setTextureSize(64, 32);
			cl3.mirror = true;
			setRotation(cl3, -0.1396263F, 0.6981317F, 0F);
			cl1 = new ModelRenderer(this, 50, 4);
			cl1.addBox(4.6F, -1.5F, 1.5F, 1, 1, 4);
			cl1.setRotationPoint(2F, 20F, -3F);
			cl1.setTextureSize(64, 32);
			cl1.mirror = true;
			setRotation(cl1, 0.1396263F, 0.6981317F, 0F);
			cs1 = new ModelRenderer(this, 48, 0);
			cs1.addBox(4.6F, -1F, -4.5F, 1, 1, 3);
			cs1.setRotationPoint(2F, 20F, 3F);
			cs1.setTextureSize(64, 32);
			cs1.mirror = true;
			setRotation(cs1, -0.0698132F, -0.6981317F, 0F);
			cs2 = new ModelRenderer(this, 38, 0);
			cs2.addBox(3.6F, -0.5F, -4.5F, 2, 1, 3);
			cs2.setRotationPoint(2F, 20F, 3F);
			cs2.setTextureSize(64, 32);
			cs2.mirror = true;
			setRotation(cs2, 0.0698132F, -0.6981317F, 0F);
			a11 = new ModelRenderer(this, 24, 0);
			a11.addBox(0F, -1F, -1F, 5, 2, 2);
			a11.setRotationPoint(2F, 20F, 3F);
			a11.setTextureSize(64, 32);
			a11.mirror = true;
			setRotation(a11, 0F, -0.6981317F, 0F);
			a12 = new ModelRenderer(this, 24, 4);
			a12.addBox(3.5F, -1.5F, -2.5F, 2, 2, 2);
			a12.setRotationPoint(2F, 20F, 3F);
			a12.setTextureSize(64, 32);
			a12.mirror = true;
			setRotation(a12, 0F, -0.6981317F, 0F);
			rl23 = new ModelRenderer(this, 0, 20);
			rl23.addBox(0F, -0.2F, -5F, 1, 5, 1);
			rl23.setRotationPoint(0F, 20.8F, -4F);
			rl23.setTextureSize(64, 32);
			rl23.mirror = true;
			setRotation(rl23, -0.1745329F, 0.0872665F, 0F);
			rl21 = new ModelRenderer(this, 0, 13);
			rl21.addBox(0F, -0.6666667F, -4F, 1, 1, 4);
			rl21.setRotationPoint(0F, 21F, -4F);
			rl21.setTextureSize(64, 32);
			rl21.mirror = true;
			setRotation(rl21, -0.2094395F, 0.0872665F, 0F);
			rl22 = new ModelRenderer(this, 0, 18);
			rl22.addBox(0F, -1.2F, -4.7F, 1, 1, 1);
			rl22.setRotationPoint(0F, 20.8F, -4F);
			rl22.setTextureSize(64, 32);
			rl22.mirror = true;
			setRotation(rl22, -0.0174533F, 0.0872665F, 0F);
			rl41 = new ModelRenderer(this, 0, 13);
			rl41.addBox(0F, 2.997602E-15F, -4F, 1, 1, 4);
			rl41.setRotationPoint(-2F, 21F, -4F);
			rl41.setTextureSize(64, 32);
			rl41.mirror = true;
			setRotation(rl41, -0.4014257F, 0.6108652F, 0F);
			rl42 = new ModelRenderer(this, 0, 18);
			rl42.addBox(0F, -1.533333F, -4.5F, 1, 1, 1);
			rl42.setRotationPoint(-2F, 21F, -4F);
			rl42.setTextureSize(64, 32);
			rl42.mirror = true;
			setRotation(rl42, -0.0174533F, 0.6108652F, 0F);
			rl43 = new ModelRenderer(this, 0, 20);
			rl43.addBox(0F, -0.5333334F, -5F, 1, 5, 1);
			rl43.setRotationPoint(-2F, 21F, -4F);
			rl43.setTextureSize(64, 32);
			rl43.mirror = true;
			setRotation(rl43, -0.1745329F, 0.6108652F, 0F);
			rl11 = new ModelRenderer(this, 0, 13);
			rl11.addBox(0F, 0F, -4F, 1, 1, 4);
			rl11.setRotationPoint(1F, 20F, -4F);
			rl11.setTextureSize(64, 32);
			rl11.mirror = true;
			setRotation(rl11, -0.1745329F, -0.1745329F, 0F);
			rl12 = new ModelRenderer(this, 0, 18);
			rl12.addBox(0F, -0.5333334F, -4.9F, 1, 1, 1);
			rl12.setRotationPoint(1F, 20F, -4F);
			rl12.setTextureSize(64, 32);
			rl12.mirror = true;
			setRotation(rl12, -0.0174533F, -0.1745329F, 0F);
			rl13 = new ModelRenderer(this, 0, 20);
			rl13.addBox(0F, 0.4666667F, -5F, 1, 5, 1);
			rl13.setRotationPoint(1F, 20F, -4F);
			rl13.setTextureSize(64, 32);
			rl13.mirror = true;
			setRotation(rl13, -0.1745329F, -0.1745329F, 0F);
			rl33 = new ModelRenderer(this, 0, 20);
			rl33.addBox(0F, 0F, -5F, 1, 5, 1);
			rl33.setRotationPoint(-1F, 20.5F, -4F);
			rl33.setTextureSize(64, 32);
			rl33.mirror = true;
			setRotation(rl33, -0.1745329F, 0.3490659F, 0F);
			rl32 = new ModelRenderer(this, 0, 18);
			rl32.addBox(0F, -1F, -4.7F, 1, 1, 1);
			rl32.setRotationPoint(-1F, 20.5F, -4F);
			rl32.setTextureSize(64, 32);
			rl32.mirror = true;
			setRotation(rl32, -0.0174533F, 0.3490659F, 0F);
			rl31 = new ModelRenderer(this, 0, 13);
			rl31.addBox(0F, -0.4666667F, -4F, 1, 1, 4);
			rl31.setRotationPoint(-1F, 21F, -4F);
			rl31.setTextureSize(64, 32);
			rl31.mirror = true;
			setRotation(rl31, -0.2792527F, 0.3490659F, 0F);
			ll13 = new ModelRenderer(this, 0, 20);
			ll13.addBox(0F, 0.4666667F, 4F, 1, 5, 1);
			ll13.setRotationPoint(1F, 20F, 4F);
			ll13.setTextureSize(64, 32);
			ll13.mirror = true;
			setRotation(ll13, 0.1745329F, 0.1745329F, 0F);
			ll12 = new ModelRenderer(this, 0, 18);
			ll12.addBox(0F, -0.5333334F, 3.933333F, 1, 1, 1);
			ll12.setRotationPoint(1F, 20F, 4F);
			ll12.setTextureSize(64, 32);
			ll12.mirror = true;
			setRotation(ll12, 0.0174533F, 0.1745329F, 0F);
			ll11 = new ModelRenderer(this, 0, 13);
			ll11.addBox(0F, 0F, 0F, 1, 1, 4);
			ll11.setRotationPoint(1F, 20F, 4F);
			ll11.setTextureSize(64, 32);
			ll11.mirror = true;
			setRotation(ll11, 0.1745329F, 0.1745329F, 0F);
			ll21 = new ModelRenderer(this, 0, 13);
			ll21.addBox(0F, -0.6666667F, 0F, 1, 1, 4);
			ll21.setRotationPoint(0F, 21F, 4F);
			ll21.setTextureSize(64, 32);
			ll21.mirror = true;
			setRotation(ll21, 0.2094395F, -0.0872665F, 0F);
			ll22 = new ModelRenderer(this, 0, 18);
			ll22.addBox(0F, -1.2F, 3.7F, 1, 1, 1);
			ll22.setRotationPoint(0F, 20.8F, 4F);
			ll22.setTextureSize(64, 32);
			ll22.mirror = true;
			setRotation(ll22, 0.0174533F, -0.0872665F, 0F);
			ll23 = new ModelRenderer(this, 0, 20);
			ll23.addBox(0F, -0.2F, 4F, 1, 5, 1);
			ll23.setRotationPoint(0F, 20.8F, 4F);
			ll23.setTextureSize(64, 32);
			ll23.mirror = true;
			setRotation(ll23, 0.1745329F, -0.0872665F, 0F);
			ll33 = new ModelRenderer(this, 0, 20);
			ll33.addBox(0F, 0F, 4F, 1, 5, 1);
			ll33.setRotationPoint(-1F, 20.5F, 4F);
			ll33.setTextureSize(64, 32);
			ll33.mirror = true;
			setRotation(ll33, 0.1745329F, -0.3490659F, 0F);
			ll32 = new ModelRenderer(this, 0, 18);
			ll32.addBox(0F, -1F, 3.7F, 1, 1, 1);
			ll32.setRotationPoint(-1F, 20.5F, 4F);
			ll32.setTextureSize(64, 32);
			ll32.mirror = true;
			setRotation(ll32, 0.0174533F, -0.3490659F, 0F);
			ll31 = new ModelRenderer(this, 0, 13);
			ll31.addBox(0F, -0.4666667F, 0F, 1, 1, 4);
			ll31.setRotationPoint(-1F, 21F, 4F);
			ll31.setTextureSize(64, 32);
			ll31.mirror = true;
			setRotation(ll31, 0.2792527F, -0.3490659F, 0F);
			ll41 = new ModelRenderer(this, 0, 13);
			ll41.addBox(0F, 2.997602E-15F, 0F, 1, 1, 4);
			ll41.setRotationPoint(-2F, 21F, 4F);
			ll41.setTextureSize(64, 32);
			ll41.mirror = true;
			setRotation(ll41, 0.4014257F, -0.6108652F, 0F);
			ll42 = new ModelRenderer(this, 0, 18);
			ll42.addBox(0F, -1.533333F, 3.5F, 1, 1, 1);
			ll42.setRotationPoint(-2F, 21F, 4F);
			ll42.setTextureSize(64, 32);
			ll42.mirror = true;
			setRotation(ll42, 0.0174533F, -0.6108652F, 0F);
			ll43 = new ModelRenderer(this, 0, 20);
			ll43.addBox(0F, -0.5333334F, 4F, 1, 5, 1);
			ll43.setRotationPoint(-2F, 21F, 4F);
			ll43.setTextureSize(64, 32);
			ll43.mirror = true;
			setRotation(ll43, 0.1745329F, -0.6108652F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			body.render(f5);
			es1.render(f5);
			es2.render(f5);
			e1.render(f5);
			e2.render(f5);
			a21.render(f5);
			a22.render(f5);
			cl3.render(f5);
			cl1.render(f5);
			cs1.render(f5);
			cs2.render(f5);
			a11.render(f5);
			a12.render(f5);
			rl23.render(f5);
			rl21.render(f5);
			rl22.render(f5);
			rl41.render(f5);
			rl42.render(f5);
			rl43.render(f5);
			rl11.render(f5);
			rl12.render(f5);
			rl13.render(f5);
			rl33.render(f5);
			rl32.render(f5);
			rl31.render(f5);
			ll13.render(f5);
			ll12.render(f5);
			ll11.render(f5);
			ll21.render(f5);
			ll22.render(f5);
			ll23.render(f5);
			ll33.render(f5);
			ll32.render(f5);
			ll31.render(f5);
			ll41.render(f5);
			ll42.render(f5);
			ll43.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.e1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.e1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.ll43.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rl43.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
