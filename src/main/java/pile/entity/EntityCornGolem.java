
package pile.entity;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsThePile.ModElement.Tag
public class EntityCornGolem extends ElementsThePile.ModElement {
	public static final int ENTITYID = 24;
	public static final int ENTITYID_RANGED = 25;
	public EntityCornGolem(ElementsThePile instance) {
		super(instance, 236);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "corngolem"), ENTITYID)
				.name("corngolem").tracker(64, 3, true).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelCornGolem(), 1.2f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/corngolem.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityIronGolem {
		public EntityCustom(World world) {
			super(world);
			setSize(1.2f, 2.2f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.wood.hit"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.wood.break"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
		}
	}

	// Date: 1/09/2019 12:41:25 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelCornGolem extends ModelBase {
		// fields
		ModelRenderer larm;
		ModelRenderer body1;
		ModelRenderer rarm;
		ModelRenderer body2;
		ModelRenderer hips;
		ModelRenderer rleg;
		ModelRenderer lleg;
		ModelRenderer neck;
		ModelRenderer head;
		public ModelCornGolem() {
			textureWidth = 64;
			textureHeight = 64;
			larm = new ModelRenderer(this, 0, 0);
			larm.addBox(-6F, -1F, -3F, 6, 22, 6);
			larm.setRotationPoint(-9F, -7.5F, 0F);
			larm.setTextureSize(64, 64);
			larm.mirror = true;
			setRotation(larm, 0F, 0F, 0F);
			body1 = new ModelRenderer(this, 14, 28);
			body1.addBox(-9F, 0F, -3.5F, 18, 9, 7);
			body1.setRotationPoint(0F, -9F, 0F);
			body1.setTextureSize(64, 64);
			body1.mirror = true;
			setRotation(body1, 0F, 0F, 0F);
			rarm = new ModelRenderer(this, 0, 0);
			rarm.addBox(0F, -1F, -3F, 6, 22, 6);
			rarm.setRotationPoint(9F, -7.5F, 0F);
			rarm.setTextureSize(64, 64);
			rarm.mirror = true;
			setRotation(rarm, 0F, 0F, 0F);
			body2 = new ModelRenderer(this, 24, 11);
			body2.addBox(-7F, 0F, -3F, 14, 4, 6);
			body2.setRotationPoint(0F, 0F, 0F);
			body2.setTextureSize(64, 64);
			body2.mirror = true;
			setRotation(body2, 0F, 0F, 0F);
			hips = new ModelRenderer(this, 24, 0);
			hips.addBox(-4.5F, 0F, -2.5F, 9, 6, 5);
			hips.setRotationPoint(0F, 4F, 0F);
			hips.setTextureSize(64, 64);
			hips.mirror = true;
			setRotation(hips, 0F, 0F, 0F);
			rleg = new ModelRenderer(this, 0, 0);
			rleg.addBox(0F, -1F, -3F, 6, 16, 6);
			rleg.setRotationPoint(2F, 9F, 0F);
			rleg.setTextureSize(64, 64);
			rleg.mirror = true;
			setRotation(rleg, 0F, 0F, 0F);
			lleg = new ModelRenderer(this, 0, 0);
			lleg.addBox(-6F, -1F, -3F, 6, 16, 6);
			lleg.setRotationPoint(-2F, 9F, 0F);
			lleg.setTextureSize(64, 64);
			lleg.mirror = true;
			setRotation(lleg, 0F, 0F, 0F);
			neck = new ModelRenderer(this, 40, 44);
			neck.addBox(-3F, -2F, -3F, 6, 2, 6);
			neck.setRotationPoint(0F, -9F, 0F);
			neck.setTextureSize(64, 64);
			neck.mirror = true;
			setRotation(neck, 0F, 0F, 0F);
			head = new ModelRenderer(this, 0, 44);
			head.addBox(-5F, -10F, -5F, 10, 10, 10);
			head.setRotationPoint(0F, -11F, 0F);
			head.setTextureSize(64, 64);
			head.mirror = true;
			setRotation(head, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			larm.render(f5);
			body1.render(f5);
			rarm.render(f5);
			body2.render(f5);
			hips.render(f5);
			rleg.render(f5);
			lleg.render(f5);
			neck.render(f5);
			head.render(f5);
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
			this.lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		}
	}
}
