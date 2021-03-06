
package pile.entity;

import pile.procedure.ProcedureMolboMobDies;

import pile.item.ItemCookedBrogle;

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
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

@ElementsThePile.ModElement.Tag
public class EntityHoleMolbo extends ElementsThePile.ModElement {
	public static final int ENTITYID = 53;
	public static final int ENTITYID_RANGED = 54;
	public EntityHoleMolbo(ElementsThePile instance) {
		super(instance, 432);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "holemolbo"), ENTITYID)
				.name("holemolbo").tracker(64, 3, true).egg(-13057, -1).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("plains")), Biome.REGISTRY.getObject(new ResourceLocation("desert")),};
		EntityRegistry.addSpawn(EntityCustom.class, 2, 1, 1, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelHoleMolbo(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/holemolbo.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
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
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
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
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureMolboMobDies.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
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
			if (new ItemStack(ItemCookedBrogle.block, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

	// Date: 6/06/2020 1:18:17 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelHoleMolbo extends ModelBase {
		// fields
		ModelRenderer head;
		ModelRenderer body2;
		ModelRenderer rightleg;
		ModelRenderer leftleg;
		ModelRenderer body3;
		ModelRenderer body1;
		ModelRenderer body4;
		public ModelHoleMolbo() {
			textureWidth = 64;
			textureHeight = 32;
			head = new ModelRenderer(this, 0, 0);
			head.addBox(-4F, -8F, -4F, 8, 8, 8);
			head.setRotationPoint(0F, 0F, 0F);
			head.setTextureSize(64, 32);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
			body2 = new ModelRenderer(this, 16, 24);
			body2.addBox(-4F, 8F, -2F, 8, 4, 4);
			body2.setRotationPoint(0F, 0F, 0F);
			body2.setTextureSize(64, 32);
			body2.mirror = true;
			setRotation(body2, 0F, 0F, 0F);
			rightleg = new ModelRenderer(this, 0, 16);
			rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			rightleg.setRotationPoint(-2F, 12F, 0F);
			rightleg.setTextureSize(64, 32);
			rightleg.mirror = true;
			setRotation(rightleg, 0F, 0F, 0F);
			leftleg = new ModelRenderer(this, 0, 16);
			leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
			leftleg.setRotationPoint(2F, 12F, 0F);
			leftleg.setTextureSize(64, 32);
			leftleg.mirror = true;
			setRotation(leftleg, 0F, 0F, 0F);
			body3 = new ModelRenderer(this, 40, 16);
			body3.addBox(2F, 4F, -2F, 2, 4, 4);
			body3.setRotationPoint(0F, 0F, 0F);
			body3.setTextureSize(64, 32);
			body3.mirror = true;
			setRotation(body3, 0F, 0F, 0F);
			body1 = new ModelRenderer(this, 16, 16);
			body1.addBox(-4F, 0F, -2F, 8, 4, 4);
			body1.setRotationPoint(0F, 0F, 0F);
			body1.setTextureSize(64, 32);
			body1.mirror = true;
			setRotation(body1, 0F, 0F, 0F);
			body4 = new ModelRenderer(this, 40, 16);
			body4.addBox(-4F, 4F, -2F, 2, 4, 4);
			body4.setRotationPoint(0F, 0F, 0F);
			body4.setTextureSize(64, 32);
			body4.mirror = true;
			setRotation(body4, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			head.render(f5);
			body2.render(f5);
			rightleg.render(f5);
			leftleg.render(f5);
			body3.render(f5);
			body1.render(f5);
			body4.render(f5);
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
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
