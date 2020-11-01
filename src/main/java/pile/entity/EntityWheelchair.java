
package pile.entity;

import pile.procedure.ProcedureWheelchairMobDies;

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
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsThePile.ModElement.Tag
public class EntityWheelchair extends ElementsThePile.ModElement {
	public static final int ENTITYID = 21;
	public static final int ENTITYID_RANGED = 22;
	public EntityWheelchair(ElementsThePile instance) {
		super(instance, 232);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "wheelchair"), ENTITYID)
				.name("wheelchair").tracker(64, 3, true).build());
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
			return new RenderLiving(renderManager, new ModelWheelchair(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/wheelchair.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.6f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
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
				ProcedureWheelchairMobDies.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand) {
			super.processInteract(entity, hand);
			entity.startRiding(this);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = entity.getHeldItem(hand);
			return true;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}

		@Override
		public void travel(float ti, float tj, float tk) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof EntityLivingBase) {
					this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
					float forward = ((EntityLivingBase) entity).moveForward;
					float strafe = 0;
					super.travel(strafe, 0, forward);
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.posX - this.prevPosX;
				double d0 = this.posZ - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(ti, tj, tk);
		}
	}

	// Date: 2/03/2019 4:52:15 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class ModelWheelchair extends ModelBase {
		// fields
		ModelRenderer w2;
		ModelRenderer w1;
		ModelRenderer back;
		ModelRenderer seat;
		ModelRenderer h2;
		ModelRenderer h1;
		ModelRenderer rl2;
		ModelRenderer rl1;
		ModelRenderer ll1;
		ModelRenderer ll2;
		ModelRenderer la;
		ModelRenderer ra;
		public ModelWheelchair() {
			textureWidth = 64;
			textureHeight = 32;
			w2 = new ModelRenderer(this, 0, 2);
			w2.addBox(0F, -5F, -5F, 0, 10, 10);
			w2.setRotationPoint(-5F, 19F, 0F);
			w2.setTextureSize(64, 32);
			w2.mirror = true;
			setRotation(w2, 0F, 0F, 0F);
			w1 = new ModelRenderer(this, 0, 2);
			w1.addBox(0F, -5F, -5F, 0, 10, 10);
			w1.setRotationPoint(5F, 19F, 0F);
			w1.setTextureSize(64, 32);
			w1.mirror = true;
			setRotation(w1, 0F, 0F, 0F);
			back = new ModelRenderer(this, 0, 0);
			back.addBox(-5F, 3F, 0F, 10, 2, 10);
			back.setRotationPoint(0F, 17F, 0F);
			back.setTextureSize(64, 32);
			back.mirror = true;
			setRotation(back, 1.396263F, 0F, 0F);
			seat = new ModelRenderer(this, 0, 0);
			seat.addBox(-5F, -1F, -5F, 10, 2, 10);
			seat.setRotationPoint(0F, 17F, 0F);
			seat.setTextureSize(64, 32);
			seat.mirror = true;
			setRotation(seat, 0F, 0F, 0F);
			h2 = new ModelRenderer(this, 30, 0);
			h2.addBox(-4F, 0F, 0F, 1, 1, 4);
			h2.setRotationPoint(0F, 7F, 5F);
			h2.setTextureSize(64, 32);
			h2.mirror = true;
			setRotation(h2, 0F, 0F, 0F);
			h1 = new ModelRenderer(this, 30, 0);
			h1.addBox(3F, 0F, 0F, 1, 1, 4);
			h1.setRotationPoint(0F, 7F, 5F);
			h1.setTextureSize(64, 32);
			h1.mirror = true;
			setRotation(h1, 0F, 0F, 0F);
			rl2 = new ModelRenderer(this, 0, 5);
			rl2.addBox(-1F, 3F, -2F, 2, 1, 2);
			rl2.setRotationPoint(-3F, 18F, -5F);
			rl2.setTextureSize(64, 32);
			rl2.mirror = true;
			setRotation(rl2, -0.1745329F, 0F, 0F);
			rl1 = new ModelRenderer(this, 0, 0);
			rl1.addBox(-1F, 0F, 0F, 2, 4, 1);
			rl1.setRotationPoint(-3F, 18F, -5F);
			rl1.setTextureSize(64, 32);
			rl1.mirror = true;
			setRotation(rl1, -0.1745329F, 0F, 0F);
			ll1 = new ModelRenderer(this, 0, 0);
			ll1.addBox(-1F, 0F, 0F, 2, 4, 1);
			ll1.setRotationPoint(3F, 18F, -5F);
			ll1.setTextureSize(64, 32);
			ll1.mirror = true;
			setRotation(ll1, -0.1745329F, 0F, 0F);
			ll2 = new ModelRenderer(this, 0, 5);
			ll2.addBox(-1F, 3F, -2F, 2, 1, 2);
			ll2.setRotationPoint(3F, 18F, -5F);
			ll2.setTextureSize(64, 32);
			ll2.mirror = true;
			setRotation(ll2, -0.1745329F, 0F, 0F);
			la = new ModelRenderer(this, 40, 0);
			la.addBox(-1F, 0F, -10F, 2, 1, 10);
			la.setRotationPoint(5F, 13F, 4F);
			la.setTextureSize(64, 32);
			la.mirror = true;
			setRotation(la, 0F, 0F, 0F);
			ra = new ModelRenderer(this, 40, 0);
			ra.addBox(-1F, 0F, -10F, 2, 1, 10);
			ra.setRotationPoint(-5F, 13F, 4F);
			ra.setTextureSize(64, 32);
			ra.mirror = true;
			setRotation(ra, 0F, 0F, 0F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			w2.render(f5);
			w1.render(f5);
			back.render(f5);
			seat.render(f5);
			h2.render(f5);
			h1.render(f5);
			rl2.render(f5);
			rl1.render(f5);
			ll1.render(f5);
			ll2.render(f5);
			la.render(f5);
			ra.render(f5);
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
