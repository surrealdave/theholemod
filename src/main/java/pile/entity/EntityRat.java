
package pile.entity;

import pile.item.ItemRatSkin;

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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

@ElementsThePile.ModElement.Tag
public class EntityRat extends ElementsThePile.ModElement {
	public static final int ENTITYID = 30;
	public static final int ENTITYID_RANGED = 31;
	public EntityRat(ElementsThePile instance) {
		super(instance, 123);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "rat"), ENTITYID)
				.name("rat").tracker(64, 3, true).egg(-10066432, -26266).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("forest")), Biome.REGISTRY.getObject(new ResourceLocation("taiga")),
				Biome.REGISTRY.getObject(new ResourceLocation("swampland")),};
		EntityRegistry.addSpawn(EntityCustom.class, 5, 5, 15, EnumCreatureType.MONSTER, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("pile:rat"), 180);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelRat(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/rat.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.5f, 0.5f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, true));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.2, true));
			this.tasks.addTask(5, new EntityAIMoveIndoors(this));
			this.tasks.addTask(6, new EntityAIBreakDoor(this));
			this.tasks.addTask(7, new EntityAIWander(this, 1));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(9, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemRatSkin.block, (int) (1)).getItem();
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
			if (source == DamageSource.FALL)
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
		}
	}

	// Date: 21/12/2019 3:43:08 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelRat extends ModelBase {
		// fields
		ModelRenderer body;
		ModelRenderer head2;
		ModelRenderer ear2;
		ModelRenderer tail2;
		ModelRenderer tail1;
		ModelRenderer rarm;
		ModelRenderer rleg;
		ModelRenderer larm;
		ModelRenderer lleg;
		ModelRenderer head1;
		ModelRenderer ear1;
		public ModelRat() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this, 0, 0);
			body.addBox(-2F, -3F, 0F, 4, 4, 8);
			body.setRotationPoint(0F, 22.8F, -2F);
			body.setTextureSize(64, 32);
			body.mirror = true;
			setRotation(body, 0F, 0F, 0F);
			head2 = new ModelRenderer(this, 0, 18);
			head2.addBox(-1.5F, -0.2F, -5F, 3, 2, 2);
			head2.setRotationPoint(0F, 22F, -2F);
			head2.setTextureSize(64, 32);
			head2.mirror = true;
			setRotation(head2, 0F, 0F, 0F);
			ear2 = new ModelRenderer(this, 0, 22);
			ear2.addBox(0.7F, -2.2F, -2F, 2, 2, 1);
			ear2.setRotationPoint(0F, 22F, -2F);
			ear2.setTextureSize(64, 32);
			ear2.mirror = true;
			setRotation(ear2, 0F, 0F, 0F);
			tail2 = new ModelRenderer(this, 24, 0);
			tail2.addBox(-0.5F, -0.55F, 4.8F, 1, 1, 5);
			tail2.setRotationPoint(0F, 23F, 5F);
			tail2.setTextureSize(64, 32);
			tail2.mirror = true;
			setRotation(tail2, -0.0523599F, 0F, 0F);
			tail1 = new ModelRenderer(this, 24, 0);
			tail1.addBox(-0.5F, -1F, 0F, 1, 1, 5);
			tail1.setRotationPoint(0F, 23F, 5F);
			tail1.setTextureSize(64, 32);
			tail1.mirror = true;
			setRotation(tail1, -0.1487144F, 0F, 0F);
			rarm = new ModelRenderer(this, 16, 0);
			rarm.addBox(-1F, 0F, -1F, 2, 2, 2);
			rarm.setRotationPoint(-1.5F, 22F, -0.5F);
			rarm.setTextureSize(64, 32);
			rarm.mirror = true;
			setRotation(rarm, 0F, 0F, 0F);
			rleg = new ModelRenderer(this, 16, 0);
			rleg.addBox(-1F, 0F, -1F, 2, 2, 2);
			rleg.setRotationPoint(-1.5F, 22F, 4.5F);
			rleg.setTextureSize(64, 32);
			rleg.mirror = true;
			setRotation(rleg, 0F, 0F, 0F);
			larm = new ModelRenderer(this, 16, 0);
			larm.addBox(-1F, 0F, -1F, 2, 2, 2);
			larm.setRotationPoint(1.5F, 22F, -0.5F);
			larm.setTextureSize(64, 32);
			larm.mirror = true;
			setRotation(larm, 0F, 0F, 0F);
			lleg = new ModelRenderer(this, 16, 0);
			lleg.addBox(-1F, 0F, -1F, 2, 2, 2);
			lleg.setRotationPoint(1.5F, 22F, 4.5F);
			lleg.setTextureSize(64, 32);
			lleg.mirror = true;
			setRotation(lleg, 0F, 0F, 0F);
			head1 = new ModelRenderer(this, 0, 12);
			head1.addBox(-1.5F, -1.2F, -3F, 3, 3, 3);
			head1.setRotationPoint(0F, 22F, -2F);
			head1.setTextureSize(64, 32);
			head1.mirror = true;
			setRotation(head1, 0F, 0F, 0F);
			ear1 = new ModelRenderer(this, 0, 22);
			ear1.addBox(-2.7F, -2.2F, -2F, 2, 2, 1);
			ear1.setRotationPoint(0F, 22F, -2F);
			ear1.setTextureSize(64, 32);
			ear1.mirror = true;
			setRotation(ear1, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			body.render(f5);
			head2.render(f5);
			ear2.render(f5);
			tail2.render(f5);
			tail1.render(f5);
			rarm.render(f5);
			rleg.render(f5);
			larm.render(f5);
			lleg.render(f5);
			head1.render(f5);
			ear1.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.ear2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.ear2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.ear1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.ear1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
