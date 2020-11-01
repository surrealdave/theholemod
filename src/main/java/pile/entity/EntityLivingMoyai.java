
package pile.entity;

import pile.procedure.ProcedureLivingMoyaiMobDies;

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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
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

import java.util.Iterator;
import java.util.ArrayList;

@ElementsThePile.ModElement.Tag
public class EntityLivingMoyai extends ElementsThePile.ModElement {
	public static final int ENTITYID = 3;
	public static final int ENTITYID_RANGED = 4;
	public EntityLivingMoyai(ElementsThePile instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "livingmoyai"), ENTITYID)
				.name("livingmoyai").tracker(64, 3, true).egg(-13421773, -13421773).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("pile", "entitybulletlivingmoyai"), ENTITYID_RANGED).name("entitybulletlivingmoyai").tracker(64, 1, true)
				.build());
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
			return new RenderLiving(renderManager, new ModelMoyai(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/moyai_mob.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(Blocks.STONE, (int) (1));
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(1f, 1.75f);
			experienceValue = 6;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAILookIdle(this));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, true));
			this.tasks.addTask(4, new EntityAISwimming(this));
			this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, false));
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
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.stone.place"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.stone.break"));
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
				ProcedureLivingMoyaiMobDies.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
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

	// Date: 21/02/2019 2:11:41 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelMoyai extends ModelBase {
		// fields
		ModelRenderer base;
		ModelRenderer n1;
		ModelRenderer n2;
		ModelRenderer b2;
		ModelRenderer b1;
		ModelRenderer m2;
		ModelRenderer m1;
		ModelRenderer e;
		public ModelMoyai() {
			textureWidth = 64;
			textureHeight = 128;
			base = new ModelRenderer(this, 0, 0);
			base.addBox(-8F, 0F, -8F, 16, 28, 16);
			base.setRotationPoint(0F, -4F, 0F);
			base.setTextureSize(64, 128);
			base.mirror = true;
			setRotation(base, 0F, 0F, 0F);
			n1 = new ModelRenderer(this, 0, 56);
			n1.addBox(-3F, -9F, -1F, 6, 9, 1);
			n1.setRotationPoint(0F, 11F, -8F);
			n1.setTextureSize(64, 128);
			n1.mirror = true;
			setRotation(n1, 0F, 0F, 0F);
			n2 = new ModelRenderer(this, 0, 72);
			n2.addBox(-5F, 0F, -1F, 10, 6, 2);
			n2.setRotationPoint(0F, 11F, -9F);
			n2.setTextureSize(64, 128);
			n2.mirror = true;
			setRotation(n2, 0F, 0F, 0F);
			b2 = new ModelRenderer(this, 0, 50);
			b2.addBox(-8F, -1.5F, -9F, 16, 5, 1);
			b2.setRotationPoint(0F, -2F, 0F);
			b2.setTextureSize(64, 128);
			b2.mirror = true;
			setRotation(b2, 0F, 0F, 0F);
			b1 = new ModelRenderer(this, 0, 44);
			b1.addBox(-8F, 0F, -10F, 16, 4, 2);
			b1.setRotationPoint(0F, -3F, 0F);
			b1.setTextureSize(64, 128);
			b1.mirror = true;
			setRotation(b1, 0F, 0F, 0F);
			m2 = new ModelRenderer(this, 42, 44);
			m2.addBox(-5F, 0F, 0.5F, 10, 2, 1);
			m2.setRotationPoint(0F, 21F, -9F);
			m2.setTextureSize(64, 128);
			m2.mirror = true;
			setRotation(m2, 0F, 0F, 0F);
			m1 = new ModelRenderer(this, 42, 44);
			m1.addBox(-5F, 0F, 0F, 10, 2, 1);
			m1.setRotationPoint(0F, 19F, -9F);
			m1.setTextureSize(64, 128);
			m1.mirror = true;
			setRotation(m1, 0F, 0F, 0F);
			e = new ModelRenderer(this, 14, 56);
			e.addBox(-9F, 3F, 0F, 18, 9, 7);
			e.setRotationPoint(0F, 0F, 0F);
			e.setTextureSize(64, 128);
			e.mirror = true;
			setRotation(e, -0.3926991F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			base.render(f5);
			n1.render(f5);
			n2.render(f5);
			b2.render(f5);
			b1.render(f5);
			m2.render(f5);
			m1.render(f5);
			e.render(f5);
		}

		private void setRotation(ModelRenderer model, float x, float y, float z) {
			model.rotateAngleX = x;
			model.rotateAngleY = y;
			model.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		}
	}
}
