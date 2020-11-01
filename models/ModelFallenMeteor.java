// Date: 21/04/2020 1:34:22 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

public static class ModelFallenMeteor extends ModelBase {
	// fields
	ModelRenderer meteor;

	public ModelFallenMeteor() {
		textureWidth = 64;
		textureHeight = 32;

		meteor = new ModelRenderer(this, 0, 0);
		meteor.addBox(-4F, -4F, -4F, 8, 8, 8);
		meteor.setRotationPoint(0F, 20F, 0F);
		meteor.setTextureSize(64, 32);
		meteor.mirror = true;
		setRotation(meteor, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		meteor.render(f5);
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
