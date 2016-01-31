package net.journey.client.render.model.mob.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWitheringBeast extends ModelBase {

	private ModelRenderer Chest;
	private ModelRenderer Stomach;
	private ModelRenderer LeftLeg;
	private ModelRenderer RightLeg;
	private ModelRenderer RightShoulder;
	private ModelRenderer RightArm;
	private ModelRenderer LeftArm;
	private ModelRenderer Head;
	private ModelRenderer Rib1;
	private ModelRenderer Rib2;
	private ModelRenderer LeftShoulder;

	public ModelWitheringBeast() {
		textureWidth = 128;
		textureHeight = 64;

		Chest = new ModelRenderer(this, 0, 0);
		Chest.addBox(-6.5F, 0F, -3.5F, 13, 7, 7);
		Chest.setRotationPoint(0F, 0F, 0F);
		Chest.setTextureSize(128, 64);
		Chest.mirror = true;
		setRotation(Chest, 0F, 0F, 0F);
		Stomach = new ModelRenderer(this, 0, 14);
		Stomach.addBox(-3.5F, 0F, -2F, 7, 7, 4);
		Stomach.setRotationPoint(0F, 7F, 0F);
		Stomach.setTextureSize(128, 64);
		Stomach.mirror = true;
		setRotation(Stomach, 0F, 0F, 0F);
		LeftLeg = new ModelRenderer(this, 22, 14);
		LeftLeg.addBox(-1.5F, 0F, -1.5F, 3, 10, 3);
		LeftLeg.setRotationPoint(2F, 14F, 0F);
		LeftLeg.setTextureSize(128, 64);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
		RightLeg = new ModelRenderer(this, 22, 14);
		RightLeg.addBox(-1.5F, 0F, -1.5F, 3, 10, 3);
		RightLeg.setRotationPoint(-2F, 14F, 0F);
		RightLeg.setTextureSize(128, 64);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		RightShoulder = new ModelRenderer(this, 40, 0);
		RightShoulder.addBox(-4.5F, -2.5F, -2.5F, 5, 5, 5);
		RightShoulder.setRotationPoint(-7F, 2F, 0F);
		RightShoulder.setTextureSize(128, 64);
		RightShoulder.mirror = true;
		setRotation(RightShoulder, 0F, 0F, 0F);
		RightArm = new ModelRenderer(this, 34, 14);
		RightArm.addBox(-2F, 0F, -2F, 4, 13, 4);
		RightArm.setRotationPoint(-9F, 4.5F, 0F);
		RightArm.setTextureSize(128, 64);
		RightArm.mirror = true;
		setRotation(RightArm, 0F, 0F, 0F);
		LeftArm = new ModelRenderer(this, 34, 14);
		LeftArm.addBox(-2F, 0F, -2F, 4, 13, 4);
		LeftArm.setRotationPoint(9F, 4.5F, 0F);
		LeftArm.setTextureSize(128, 64);
		LeftArm.mirror = true;
		setRotation(LeftArm, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 50, 10);
		Head.addBox(-3F, -6F, -3F, 6, 6, 6);
		Head.setRotationPoint(0F, 0F, 0F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Rib1 = new ModelRenderer(this, 0, 25);
		Rib1.addBox(-4.5F, -1F, -1F, 9, 2, 2);
		Rib1.setRotationPoint(0F, 9F, 0F);
		Rib1.setTextureSize(128, 64);
		Rib1.mirror = true;
		setRotation(Rib1, 0F, 0F, 0F);
		Rib2 = new ModelRenderer(this, 0, 25);
		Rib2.addBox(-4.5F, -1F, -1F, 9, 2, 2);
		Rib2.setRotationPoint(0F, 12F, 0F);
		Rib2.setTextureSize(128, 64);
		Rib2.mirror = true;
		setRotation(Rib2, 0F, 0F, 0F);
		LeftShoulder = new ModelRenderer(this, 40, 0);
		LeftShoulder.addBox(-0.5F, -2.5F, -2.5F, 5, 5, 5);
		LeftShoulder.setRotationPoint(7F, 2F, 0F);
		LeftShoulder.setTextureSize(128, 64);
		LeftShoulder.mirror = true;
		setRotation(LeftShoulder, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Chest.render(f5);
		Stomach.render(f5);
		LeftLeg.render(f5);
		RightLeg.render(f5);
		RightShoulder.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		Head.render(f5);
		Rib1.render(f5);
		Rib2.render(f5);
		LeftShoulder.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.Head.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
		this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	}
}