
package pile.entity;

import pile.item.ItemWormEye;

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
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsThePile.ModElement.Tag
public class EntityWormWithEyes extends ElementsThePile.ModElement {
	public static final int ENTITYID = 49;
	public static final int ENTITYID_RANGED = 50;
	public EntityWormWithEyes(ElementsThePile instance) {
		super(instance, 419);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "wormwitheyes"), ENTITYID)
				.name("wormwitheyes").tracker(1, 3, true).egg(-52, -1).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 5, 1, 3, EnumCreatureType.CREATURE, spawnBiomes);
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
			return new RenderLiving(renderManager, new ModelWormWithEyes(), 0.2f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/wormwitheyes-.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.2f, 0.2f);
			experienceValue = 1;
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
			this.tasks.addTask(4, new EntityAIEatGrass(this));
			this.tasks.addTask(5, new EntityAIRestrictSun(this));
			this.tasks.addTask(6, new EntityAIPanic(this, 1.2));
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
			return new ItemStack(ItemWormEye.block, (int) (1)).getItem();
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Date: 14/05/2019 3:47:20 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelWormWithEyes extends ModelBase {
		// fields
		ModelRenderer b8;
		ModelRenderer b2;
		ModelRenderer bb3;
		ModelRenderer b4;
		ModelRenderer b5;
		ModelRenderer b6;
		ModelRenderer b7;
		ModelRenderer e2;
		ModelRenderer b1;
		ModelRenderer m;
		ModelRenderer e1;
		public ModelWormWithEyes() {
			textureWidth = 64;
			textureHeight = 32;
			b8 = new ModelRenderer(this, 0, 0);
			b8.addBox(-1F, -1F, -2F, 2, 2, 2);
			b8.setRotationPoint(1F, 23.5F, 8F);
			b8.setTextureSize(64, 32);
			b8.mirror = true;
			setRotation(b8, 0F, 0F, 0F);
			b2 = new ModelRenderer(this, 0, 0);
			b2.addBox(-1F, -1F, -2F, 2, 2, 2);
			b2.setRotationPoint(-1F, 23F, -4F);
			b2.setTextureSize(64, 32);
			b2.mirror = true;
			setRotation(b2, 0F, 0F, 0F);
			bb3 = new ModelRenderer(this, 0, 0);
			bb3.addBox(-1F, -1F, -2F, 2, 2, 2);
			bb3.setRotationPoint(-2F, 23.5F, -2F);
			bb3.setTextureSize(64, 32);
			bb3.mirror = true;
			setRotation(bb3, 0F, 0F, 0F);
			b4 = new ModelRenderer(this, 0, 0);
			b4.addBox(-1F, -1F, -2F, 2, 2, 2);
			b4.setRotationPoint(-1F, 23.5F, 0F);
			b4.setTextureSize(64, 32);
			b4.mirror = true;
			setRotation(b4, 0F, 0F, 0F);
			b5 = new ModelRenderer(this, 0, 0);
			b5.addBox(-1F, -1F, -2F, 2, 2, 2);
			b5.setRotationPoint(0F, 23.5F, 2F);
			b5.setTextureSize(64, 32);
			b5.mirror = true;
			setRotation(b5, 0F, 0F, 0F);
			b6 = new ModelRenderer(this, 0, 0);
			b6.addBox(-1F, -1F, -2F, 2, 2, 2);
			b6.setRotationPoint(1F, 23.5F, 4F);
			b6.setTextureSize(64, 32);
			b6.mirror = true;
			setRotation(b6, 0F, 0F, 0F);
			b7 = new ModelRenderer(this, 0, 0);
			b7.addBox(-1F, -1F, -2F, 2, 2, 2);
			b7.setRotationPoint(2F, 23.5F, 6F);
			b7.setTextureSize(64, 32);
			b7.mirror = true;
			setRotation(b7, 0F, 0F, 0F);
			e2 = new ModelRenderer(this, 0, 4);
			e2.addBox(0.5F, -1F, -2.5F, 1, 1, 1);
			e2.setRotationPoint(0F, 22.5F, -6F);
			e2.setTextureSize(64, 32);
			e2.mirror = true;
			setRotation(e2, 0F, 0F, 0F);
			b1 = new ModelRenderer(this, 0, 0);
			b1.addBox(-1F, -1F, -2F, 2, 2, 2);
			b1.setRotationPoint(0F, 22.5F, -6F);
			b1.setTextureSize(64, 32);
			b1.mirror = true;
			setRotation(b1, 0F, 0F, 0F);
			m = new ModelRenderer(this, 0, 6);
			m.addBox(-0.5F, 0F, -2.25F, 1, 1, 1);
			m.setRotationPoint(0F, 22.5F, -6F);
			m.setTextureSize(64, 32);
			m.mirror = true;
			setRotation(m, 0F, 0F, 0F);
			e1 = new ModelRenderer(this, 0, 4);
			e1.addBox(-1.5F, -1F, -2.5F, 1, 1, 1);
			e1.setRotationPoint(0F, 22.5F, -6F);
			e1.setTextureSize(64, 32);
			e1.mirror = true;
			setRotation(e1, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			b8.render(f5);
			b2.render(f5);
			bb3.render(f5);
			b4.render(f5);
			b5.render(f5);
			b6.render(f5);
			b7.render(f5);
			e2.render(f5);
			b1.render(f5);
			m.render(f5);
			e1.render(f5);
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
			this.e2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.e2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.m.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.m.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.b1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.b1.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
