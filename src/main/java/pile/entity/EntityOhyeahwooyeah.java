
package pile.entity;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsThePile.ModElement.Tag
public class EntityOhyeahwooyeah extends ElementsThePile.ModElement {
	public static final int ENTITYID = 5;
	public static final int ENTITYID_RANGED = 6;
	public EntityOhyeahwooyeah(ElementsThePile instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("pile", "ohyeahwooyeah"), ENTITYID)
				.name("ohyeahwooyeah").tracker(64, 3, true).build());
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
			return new RenderLiving(renderManager, new Modelohyeahwooyeah(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pile:textures/oh yeah woo yeah.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(1.1f, 1.9f);
			experienceValue = 1207;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, true));
			this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.2, true));
			this.tasks.addTask(5, new EntityAIWander(this, 0.5));
			this.tasks.addTask(6, new EntityAILookIdle(this));
			this.tasks.addTask(7, new EntityAISwimming(this));
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
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(24D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Date: 21/02/2019 3:33:39 PM
	// Template version 1.1
	// Java generated by Techne
	// Keep in mind that you still need to fill in some blanks
	// - ZeuX
	public static class Modelohyeahwooyeah extends ModelBase {
		// fields
		ModelRenderer a1;
		ModelRenderer b1;
		ModelRenderer c1;
		ModelRenderer d1;
		ModelRenderer e1;
		ModelRenderer ff;
		ModelRenderer g1;
		ModelRenderer h1;
		ModelRenderer i1;
		ModelRenderer j1;
		ModelRenderer k1;
		ModelRenderer l1;
		ModelRenderer m1;
		public Modelohyeahwooyeah() {
			textureWidth = 32;
			textureHeight = 32;
			a1 = new ModelRenderer(this, 0, 0);
			a1.addBox(-1F, -7F, -0.5F, 2, 7, 1);
			a1.setRotationPoint(7F, 23F, 0F);
			a1.setTextureSize(32, 32);
			a1.mirror = true;
			setRotation(a1, 0F, 0F, 0.0698132F);
			b1 = new ModelRenderer(this, 0, 0);
			b1.addBox(-7F, -1F, -0.5F, 7, 2, 1);
			b1.setRotationPoint(7F, 23F, 0F);
			b1.setTextureSize(32, 32);
			b1.mirror = true;
			setRotation(b1, 0F, 0F, 0F);
			c1 = new ModelRenderer(this, 0, 0);
			c1.addBox(-7F, -1F, -0.5F, 7, 2, 1);
			c1.setRotationPoint(-3F, 20F, 0F);
			c1.setTextureSize(32, 32);
			c1.mirror = true;
			setRotation(c1, 0F, 0F, 0F);
			d1 = new ModelRenderer(this, 0, 0);
			d1.addBox(-10F, -7F, -0.5F, 9, 6, 1);
			d1.setRotationPoint(9.666667F, 11F, 0F);
			d1.setTextureSize(32, 32);
			d1.mirror = true;
			setRotation(d1, 0F, 0F, 0F);
			e1 = new ModelRenderer(this, 0, 0);
			e1.addBox(-2F, -7F, -0.5F, 3, 7, 1);
			e1.setRotationPoint(-3F, 20F, 0F);
			e1.setTextureSize(32, 32);
			e1.mirror = true;
			setRotation(e1, 0F, 0F, 0.0698132F);
			ff = new ModelRenderer(this, 0, 0);
			ff.addBox(-2F, -7F, -0.5F, 3, 7, 1);
			ff.setRotationPoint(-3F, 14F, 0F);
			ff.setTextureSize(32, 32);
			ff.mirror = true;
			setRotation(ff, 0F, 0F, 0.7330383F);
			g1 = new ModelRenderer(this, 0, 0);
			g1.addBox(-2F, -7F, -0.5F, 3, 7, 1);
			g1.setRotationPoint(8F, 17F, 0F);
			g1.setTextureSize(32, 32);
			g1.mirror = true;
			setRotation(g1, 0F, 0F, 0.3665191F);
			h1 = new ModelRenderer(this, 0, 0);
			h1.addBox(-7F, -13F, -0.5F, 9, 7, 1);
			h1.setRotationPoint(1.666667F, 3F, 0F);
			h1.setTextureSize(32, 32);
			h1.mirror = true;
			setRotation(h1, 0F, 0F, 0F);
			i1 = new ModelRenderer(this, 0, 0);
			i1.addBox(-4F, 0F, -0.5F, 15, 2, 1);
			i1.setRotationPoint(-12F, 0F, 0F);
			i1.setTextureSize(32, 32);
			i1.mirror = true;
			setRotation(i1, 0F, 0F, 0F);
			j1 = new ModelRenderer(this, 0, 0);
			j1.addBox(0F, 0F, -0.5F, 12, 2, 1);
			j1.setRotationPoint(-12F, 4F, 0F);
			j1.setTextureSize(32, 32);
			j1.mirror = true;
			setRotation(j1, 0F, 0F, 0F);
			k1 = new ModelRenderer(this, 0, 0);
			k1.addBox(-2F, -6F, -0.5F, 3, 6, 1);
			k1.setRotationPoint(10.66667F, 11F, 0F);
			k1.setTextureSize(32, 32);
			k1.mirror = true;
			setRotation(k1, 0F, 0F, 0F);
			l1 = new ModelRenderer(this, 0, 0);
			l1.addBox(-3F, -9F, -0.5F, 7, 7, 1);
			l1.setRotationPoint(2.666667F, 7F, 0F);
			l1.setTextureSize(32, 32);
			l1.mirror = true;
			setRotation(l1, 0F, 0F, -0.1396263F);
			m1 = new ModelRenderer(this, 0, 0);
			m1.addBox(-3F, -7F, -0.5F, 5, 3, 1);
			m1.setRotationPoint(1.666667F, 3F, 0F);
			m1.setTextureSize(32, 32);
			m1.mirror = true;
			setRotation(m1, 0F, 0F, -0.0698132F);
		}

		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			a1.render(f5);
			b1.render(f5);
			c1.render(f5);
			d1.render(f5);
			e1.render(f5);
			ff.render(f5);
			g1.render(f5);
			h1.render(f5);
			i1.render(f5);
			j1.render(f5);
			k1.render(f5);
			l1.render(f5);
			m1.render(f5);
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
