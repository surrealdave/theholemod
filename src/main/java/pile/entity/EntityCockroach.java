
package pile.entity;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

@ElementsThePile.ModElement.Tag
public class EntityCockroach extends ElementsThePile.ModElement {
	public static final int ENTITYID = 28;
	public static final int ENTITYID_RANGED = 29;
	public EntityCockroach(ElementsThePile instance) {
		super(instance, 128);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "cockroach"), ENTITYID)
				.name("cockroach").tracker(64, 3, true).egg(-10079488, -13159).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("swampland")),};
		EntityRegistry.addSpawn(EntityCustom.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("pile:cockroach"), 180);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelCockroach(), 0.4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/cockroach.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.5f, 1.2999999999999998f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2, true));
			this.tasks.addTask(3, new EntityAIWander(this, 0.4));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAILeapAtTarget(this, (float) 1));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ARTHROPOD;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("pile:pile.cockroach.living"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("pile:pile.cockroach.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("pile:pile.cockroach.die"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityArrow)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Date: 20/12/2019 11:06:12 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelCockroach extends ModelBase {
		// fields
		ModelRenderer body;
		ModelRenderer tail1;
		ModelRenderer head2;
		ModelRenderer head;
		ModelRenderer eye1;
		ModelRenderer eye2;
		ModelRenderer antenna1;
		ModelRenderer antenna2;
		ModelRenderer tail3;
		ModelRenderer ll32;
		ModelRenderer ll12;
		ModelRenderer ll13;
		ModelRenderer ll22;
		ModelRenderer ll23;
		ModelRenderer ll33;
		ModelRenderer tail2;
		ModelRenderer ll31;
		ModelRenderer ll21;
		ModelRenderer ll11;
		ModelRenderer rl11;
		ModelRenderer rl21;
		ModelRenderer rl31;
		ModelRenderer rl32;
		ModelRenderer rl33;
		ModelRenderer rl13;
		ModelRenderer rl12;
		ModelRenderer rl22;
		ModelRenderer rl23;
		public ModelCockroach() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this, 0, 0);
			body.addBox(-4F, 0F, 1F, 8, 16, 2);
			body.setRotationPoint(0F, 0F, 0F);
			body.setTextureSize(64, 32);
			body.mirror = true;
			setRotation(body, 0.3490659F, 0F, 0F);
			tail1 = new ModelRenderer(this, 0, 24);
			tail1.addBox(-3F, 16F, 1F, 6, 2, 1);
			tail1.setRotationPoint(0F, 0F, 0F);
			tail1.setTextureSize(64, 32);
			tail1.mirror = true;
			setRotation(tail1, 0.3490659F, 0F, 0F);
			head2 = new ModelRenderer(this, 0, 18);
			head2.addBox(-3F, -2F, 0.9F, 6, 4, 2);
			head2.setRotationPoint(0F, 0F, 0F);
			head2.setTextureSize(64, 32);
			head2.mirror = true;
			setRotation(head2, 0.7853982F, 0F, 0F);
			head = new ModelRenderer(this, 20, 0);
			head.addBox(-1.5F, -2F, -1F, 3, 4, 3);
			head.setRotationPoint(0F, 0F, 0F);
			head.setTextureSize(64, 32);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			eye1 = new ModelRenderer(this, 32, 0);
			eye1.addBox(-1.8F, -1F, -1.2F, 1, 2, 2);
			eye1.setRotationPoint(0F, 0F, 0F);
			eye1.setTextureSize(64, 32);
			eye1.mirror = true;
			setRotation(eye1, 0F, 0F, 0F);
			eye2 = new ModelRenderer(this, 32, 0);
			eye2.addBox(0.8F, -1F, -1.2F, 1, 2, 2);
			eye2.setRotationPoint(0F, 0F, 0F);
			eye2.setTextureSize(64, 32);
			eye2.mirror = true;
			setRotation(eye2, 0F, 0F, 0F);
			antenna1 = new ModelRenderer(this, 20, 7);
			antenna1.addBox(-1F, -12F, 0F, 1, 11, 1);
			antenna1.setRotationPoint(0F, 0F, 0F);
			antenna1.setTextureSize(64, 32);
			antenna1.mirror = true;
			setRotation(antenna1, 0.3839724F, 0F, -0.1396263F);
			antenna2 = new ModelRenderer(this, 20, 7);
			antenna2.addBox(0F, -12F, 0F, 1, 11, 1);
			antenna2.setRotationPoint(0F, 0F, 0F);
			antenna2.setTextureSize(64, 32);
			antenna2.mirror = true;
			setRotation(antenna2, 0.3839724F, 0F, 0.1396263F);
			tail3 = new ModelRenderer(this, 28, 11);
			tail3.addBox(-8F, 14F, 5F, 2, 1, 1);
			tail3.setRotationPoint(0F, 0F, 0F);
			tail3.setTextureSize(64, 32);
			tail3.mirror = true;
			setRotation(tail3, 0.122173F, -0.715585F, -0.5585054F);
			ll32 = new ModelRenderer(this, 24, 9);
			ll32.addBox(-4.6F, 12F, 4F, 1, 4, 1);
			ll32.setRotationPoint(0F, 0F, 0F);
			ll32.setTextureSize(64, 32);
			ll32.mirror = true;
			setRotation(ll32, 0.1047198F, -0.7853982F, -0.2268928F);
			ll12 = new ModelRenderer(this, 24, 9);
			ll12.addBox(-4F, 3F, 2F, 1, 3, 1);
			ll12.setRotationPoint(0F, 0F, 0F);
			ll12.setTextureSize(64, 32);
			ll12.mirror = true;
			setRotation(ll12, 0.1047198F, -0.6457718F, -0.0349066F);
			ll13 = new ModelRenderer(this, 28, 9);
			ll13.addBox(-6F, 5F, 2F, 2, 1, 1);
			ll13.setRotationPoint(0F, 0F, 0F);
			ll13.setTextureSize(64, 32);
			ll13.mirror = true;
			setRotation(ll13, 0.1047198F, -0.6457718F, -0.1396263F);
			ll22 = new ModelRenderer(this, 24, 9);
			ll22.addBox(-3.6F, 7F, 3F, 1, 3, 1);
			ll22.setRotationPoint(0F, 0F, 0F);
			ll22.setTextureSize(64, 32);
			ll22.mirror = true;
			setRotation(ll22, 0.1047198F, -0.6457718F, -0.1396263F);
			ll23 = new ModelRenderer(this, 28, 9);
			ll23.addBox(-6F, 9F, 3F, 2, 1, 1);
			ll23.setRotationPoint(0F, 0F, 0F);
			ll23.setTextureSize(64, 32);
			ll23.mirror = true;
			setRotation(ll23, 0.1047198F, -0.6457718F, -0.2443461F);
			ll33 = new ModelRenderer(this, 28, 9);
			ll33.addBox(-7.6F, 15F, 4F, 2, 1, 1);
			ll33.setRotationPoint(0F, 0F, 0F);
			ll33.setTextureSize(64, 32);
			ll33.mirror = true;
			setRotation(ll33, 0.1047198F, -0.7853982F, -0.3316126F);
			tail2 = new ModelRenderer(this, 28, 11);
			tail2.addBox(6F, 14F, 5F, 2, 1, 1);
			tail2.setRotationPoint(0F, 0F, 0F);
			tail2.setTextureSize(64, 32);
			tail2.mirror = true;
			setRotation(tail2, 0.122173F, 0.715585F, 0.5585054F);
			ll31 = new ModelRenderer(this, 24, 7);
			ll31.addBox(-3.6F, 12F, 4F, 4, 1, 1);
			ll31.setRotationPoint(0F, 0F, 0F);
			ll31.setTextureSize(64, 32);
			ll31.mirror = true;
			setRotation(ll31, 0.1047198F, -0.7853982F, -0.1919862F);
			ll21 = new ModelRenderer(this, 24, 7);
			ll21.addBox(-2.6F, 7F, 3F, 4, 1, 1);
			ll21.setRotationPoint(0F, 0F, 0F);
			ll21.setTextureSize(64, 32);
			ll21.mirror = true;
			setRotation(ll21, 0.1047198F, -0.6457718F, -0.1047198F);
			ll11 = new ModelRenderer(this, 24, 7);
			ll11.addBox(-3F, 3F, 2F, 4, 1, 1);
			ll11.setRotationPoint(0F, 0F, 0F);
			ll11.setTextureSize(64, 32);
			ll11.mirror = true;
			setRotation(ll11, 0.1047198F, -0.6457718F, 0F);
			rl11 = new ModelRenderer(this, 24, 7);
			rl11.addBox(-1F, 3F, 2F, 4, 1, 1);
			rl11.setRotationPoint(0F, 0F, 0F);
			rl11.setTextureSize(64, 32);
			rl11.mirror = true;
			setRotation(rl11, 0.1047198F, 0.6457718F, 0F);
			rl21 = new ModelRenderer(this, 24, 7);
			rl21.addBox(-0.6F, 7F, 3F, 4, 1, 1);
			rl21.setRotationPoint(0F, 0F, 0F);
			rl21.setTextureSize(64, 32);
			rl21.mirror = true;
			setRotation(rl21, 0.1047198F, 0.6457718F, 0.1047198F);
			rl31 = new ModelRenderer(this, 24, 7);
			rl31.addBox(-0.6F, 12F, 4F, 4, 1, 1);
			rl31.setRotationPoint(0F, 0F, 0F);
			rl31.setTextureSize(64, 32);
			rl31.mirror = true;
			setRotation(rl31, 0.1047198F, 0.7853982F, 0.1919862F);
			rl32 = new ModelRenderer(this, 24, 9);
			rl32.addBox(3.4F, 12F, 4F, 1, 4, 1);
			rl32.setRotationPoint(0F, 0F, 0F);
			rl32.setTextureSize(64, 32);
			rl32.mirror = true;
			setRotation(rl32, 0.1047198F, 0.7853982F, 0.2268928F);
			rl33 = new ModelRenderer(this, 28, 9);
			rl33.addBox(5.4F, 15F, 4F, 2, 1, 1);
			rl33.setRotationPoint(0F, 0F, 0F);
			rl33.setTextureSize(64, 32);
			rl33.mirror = true;
			setRotation(rl33, 0.1047198F, 0.7853982F, 0.3316126F);
			rl13 = new ModelRenderer(this, 28, 9);
			rl13.addBox(4F, 5F, 2F, 2, 1, 1);
			rl13.setRotationPoint(0F, 0F, 0F);
			rl13.setTextureSize(64, 32);
			rl13.mirror = true;
			setRotation(rl13, 0.1047198F, 0.6457718F, 0.1396263F);
			rl12 = new ModelRenderer(this, 24, 9);
			rl12.addBox(3F, 3F, 2F, 1, 3, 1);
			rl12.setRotationPoint(0F, 0F, 0F);
			rl12.setTextureSize(64, 32);
			rl12.mirror = true;
			setRotation(rl12, 0.1047198F, 0.6457718F, 0.0349066F);
			rl22 = new ModelRenderer(this, 24, 9);
			rl22.addBox(3.4F, 7F, 3F, 1, 3, 1);
			rl22.setRotationPoint(0F, 0F, 0F);
			rl22.setTextureSize(64, 32);
			rl22.mirror = true;
			setRotation(rl22, 0.1047198F, 0.6457718F, 0.1396263F);
			rl23 = new ModelRenderer(this, 28, 9);
			rl23.addBox(5F, 9F, 3F, 2, 1, 1);
			rl23.setRotationPoint(0F, 0F, 0F);
			rl23.setTextureSize(64, 32);
			rl23.mirror = true;
			setRotation(rl23, 0.1047198F, 0.6457718F, 0.2443461F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			body.render(f5);
			tail1.render(f5);
			head2.render(f5);
			head.render(f5);
			eye1.render(f5);
			eye2.render(f5);
			antenna1.render(f5);
			antenna2.render(f5);
			tail3.render(f5);
			ll32.render(f5);
			ll12.render(f5);
			ll13.render(f5);
			ll22.render(f5);
			ll23.render(f5);
			ll33.render(f5);
			tail2.render(f5);
			ll31.render(f5);
			ll21.render(f5);
			ll11.render(f5);
			rl11.render(f5);
			rl21.render(f5);
			rl31.render(f5);
			rl32.render(f5);
			rl33.render(f5);
			rl13.render(f5);
			rl12.render(f5);
			rl22.render(f5);
			rl23.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		}
	}
}
