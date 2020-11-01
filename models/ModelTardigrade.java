
public static class ModelTardigrade extends ModelBase {
	public final int MCA_MIN_REQUESTED_VERSION = 5;
	public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

	MCAModelRenderer body;
	MCAModelRenderer leg1;
	MCAModelRenderer leg2;
	MCAModelRenderer head;
	MCAModelRenderer leg3;
	MCAModelRenderer leg5;
	MCAModelRenderer leg8;
	MCAModelRenderer leg4;
	MCAModelRenderer leg7;
	MCAModelRenderer leg6;
	MCAModelRenderer tail;
	MCAModelRenderer mouth;

	public ModelTardigrade() {
		MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

		textureWidth = 64;
		textureHeight = 32;

		body = new MCAModelRenderer(this, "body", 0, 8);
		body.mirror = false;
		body.addBox(-2.5F, -2.0F, -6.0F, 5, 4, 10);
		body.setInitialRotationPoint(0.0F, -29.0F, 0.0F);
		body.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		body.setTextureSize(64, 32);
		parts.put(body.boxName, body);

		leg1 = new MCAModelRenderer(this, "leg1", 20, 9);
		leg1.mirror = false;
		leg1.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg1.setInitialRotationPoint(1.2F, -2.0F, 3.0F);
		leg1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg1.setTextureSize(64, 32);
		parts.put(leg1.boxName, leg1);
		body.addChild(leg1);

		leg2 = new MCAModelRenderer(this, "leg2", 20, 9);
		leg2.mirror = false;
		leg2.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg2.setInitialRotationPoint(-1.2F, -2.0F, 3.0F);
		leg2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg2.setTextureSize(64, 32);
		parts.put(leg2.boxName, leg2);
		body.addChild(leg2);

		head = new MCAModelRenderer(this, "head", 0, 0);
		head.mirror = false;
		head.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4);
		head.setInitialRotationPoint(0.0F, 0.0F, 4.0F);
		head.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		head.setTextureSize(64, 32);
		parts.put(head.boxName, head);
		body.addChild(head);

		leg3 = new MCAModelRenderer(this, "leg3", 20, 9);
		leg3.mirror = false;
		leg3.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg3.setInitialRotationPoint(1.2F, -2.0F, 0.0F);
		leg3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg3.setTextureSize(64, 32);
		parts.put(leg3.boxName, leg3);
		body.addChild(leg3);

		leg5 = new MCAModelRenderer(this, "leg5", 20, 9);
		leg5.mirror = false;
		leg5.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg5.setInitialRotationPoint(1.2F, -2.0F, -3.0F);
		leg5.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg5.setTextureSize(64, 32);
		parts.put(leg5.boxName, leg5);
		body.addChild(leg5);

		leg8 = new MCAModelRenderer(this, "leg8", 20, 9);
		leg8.mirror = false;
		leg8.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg8.setInitialRotationPoint(-1.2F, -2.0F, -6.0F);
		leg8.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg8.setTextureSize(64, 32);
		parts.put(leg8.boxName, leg8);
		body.addChild(leg8);

		leg4 = new MCAModelRenderer(this, "leg4", 20, 9);
		leg4.mirror = false;
		leg4.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg4.setInitialRotationPoint(-1.2F, -2.0F, 0.0F);
		leg4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg4.setTextureSize(64, 32);
		parts.put(leg4.boxName, leg4);
		body.addChild(leg4);

		leg7 = new MCAModelRenderer(this, "leg7", 20, 9);
		leg7.mirror = false;
		leg7.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg7.setInitialRotationPoint(1.2F, -2.0F, -6.0F);
		leg7.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg7.setTextureSize(64, 32);
		parts.put(leg7.boxName, leg7);
		body.addChild(leg7);

		leg6 = new MCAModelRenderer(this, "leg6", 20, 9);
		leg6.mirror = false;
		leg6.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2);
		leg6.setInitialRotationPoint(-1.2F, -2.0F, -3.0F);
		leg6.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		leg6.setTextureSize(64, 32);
		parts.put(leg6.boxName, leg6);
		body.addChild(leg6);

		tail = new MCAModelRenderer(this, "tail", 0, 22);
		tail.mirror = false;
		tail.addBox(-2.0F, -2.8F, -2.0F, 4, 4, 2);
		tail.setInitialRotationPoint(0.0F, 0.0F, -4.7F);
		tail.setInitialRotationMatrix(
				new Matrix4f().set(new Quaternion(0.19936793F, 0.0F, 0.0F, 0.9799247F)).transpose());
		tail.setTextureSize(64, 32);
		parts.put(tail.boxName, tail);
		body.addChild(tail);

		mouth = new MCAModelRenderer(this, "mouth", 16, 4);
		mouth.mirror = false;
		mouth.addBox(-1.5F, -1.0F, 0.0F, 3, 3, 1);
		mouth.setInitialRotationPoint(0.0F, -1.0F, 3.5F);
		mouth.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		mouth.setTextureSize(64, 32);
		parts.put(mouth.boxName, mouth);
		head.addChild(mouth);

	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		EntityTardigrade entity = (EntityTardigrade) par1Entity;

		AnimationHandler.performAnimationInModel(parts, entity);

		// Render every non-child part
		body.render(par7);
	}
	public MCAModelRenderer getModelRendererFromName(String name) {
		return parts.get(name);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg5.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg8.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg6.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg7.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}