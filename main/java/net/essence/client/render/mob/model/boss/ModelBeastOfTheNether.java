package net.essence.client.render.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBeastOfTheNether extends ModelBase {

	private ModelRenderer Body;
	private ModelRenderer BackRightLeg;
	private ModelRenderer BackLeftLeg;
	private ModelRenderer FrontLeftLeg;
	private ModelRenderer FrontRightLeg;
	private ModelRenderer Head;
	private ModelRenderer RightHornBase;
	private ModelRenderer LeftHornBase;
	private ModelRenderer RightHorn;
	private ModelRenderer LeftHorn;

	public ModelBeastOfTheNether() {
		textureWidth = 256;
		textureHeight = 128;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-8F, -6F, 0F, 16, 14, 27);
		Body.setRotationPoint(0F, 1F, -11F);
		Body.setTextureSize(256, 128);
		Body.mirror = true;
		setRotation(Body, -0.2443461F, 0F, 0F);
		BackRightLeg = new ModelRenderer(this, 0, 41);
		BackRightLeg.addBox(-2F, 0F, -2F, 4, 10, 4);
		BackRightLeg.setRotationPoint(-6F, 14F, 11F);
		BackRightLeg.setTextureSize(256, 128);
		BackRightLeg.mirror = true;
		setRotation(BackRightLeg, 0F, 0F, 0F);
		BackLeftLeg = new ModelRenderer(this, 0, 41);
		BackLeftLeg.addBox(-2F, 0F, -2F, 4, 10, 4);
		BackLeftLeg.setRotationPoint(6F, 14F, 11F);
		BackLeftLeg.setTextureSize(256, 128);
		BackLeftLeg.mirror = true;
		setRotation(BackLeftLeg, 0F, 0F, 0F);
		FrontLeftLeg = new ModelRenderer(this, 16, 41);
		FrontLeftLeg.addBox(-2F, 0F, -2F, 4, 15, 4);
		FrontLeftLeg.setRotationPoint(6F, 9F, -8F);
		FrontLeftLeg.setTextureSize(256, 128);
		FrontLeftLeg.mirror = true;
		setRotation(FrontLeftLeg, 0F, 0F, 0F);
		FrontRightLeg = new ModelRenderer(this, 16, 41);
		FrontRightLeg.addBox(-2F, 0F, -2F, 4, 15, 4);
		FrontRightLeg.setRotationPoint(-6F, 9F, -8F);
		FrontRightLeg.setTextureSize(256, 128);
		FrontRightLeg.mirror = true;
		setRotation(FrontRightLeg, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 98, 41);
		Head.addBox(-4F, -3F, -7F, 8, 8, 8);
		Head.setRotationPoint(0F, 1F, -11F);
		Head.setTextureSize(256, 128);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		RightHornBase = new ModelRenderer(this, 64, 41);
		RightHornBase.addBox(-7F, -1F, -1F, 8, 2, 2);
		RightHornBase.setRotationPoint(-3F, 0F, -13F);
		RightHornBase.setTextureSize(256, 128);
		RightHornBase.mirror = true;
		setRotation(RightHornBase, 0F, 0F, 0.2617994F);
		LeftHornBase = new ModelRenderer(this, 64, 41);
		LeftHornBase.addBox(-1F, -1F, -1F, 8, 2, 2);
		LeftHornBase.setRotationPoint(3F, 0F, -13F);
		LeftHornBase.setTextureSize(256, 128);
		LeftHornBase.mirror = true;
		setRotation(LeftHornBase, 0F, 0F, -0.2617994F);
		RightHorn = new ModelRenderer(this, 64, 45);
		RightHorn.addBox(-1F, -1F, -1F, 7, 2, 2);
		RightHorn.setRotationPoint(-9F, -2F, -13F);
		RightHorn.setTextureSize(256, 128);
		RightHorn.mirror = true;
		setRotation(RightHorn, 0F, 0F, -1.815142F);
		LeftHorn = new ModelRenderer(this, 64, 45);
		LeftHorn.addBox(-1F, -1F, -1F, 7, 2, 2);
		LeftHorn.setRotationPoint(9F, -2F, -13F);
		LeftHorn.setTextureSize(256, 128);
		LeftHorn.mirror = true;
		setRotation(LeftHorn, 0F, 0F, -1.27409F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		BackRightLeg.render(f5);
		BackLeftLeg.render(f5);
		FrontLeftLeg.render(f5);
		FrontRightLeg.render(f5);
		Head.render(f5);
		RightHornBase.render(f5);
		LeftHornBase.render(f5);
		RightHorn.render(f5);
		LeftHorn.render(f5);
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
		this.RightHornBase.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.RightHornBase.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.RightHorn.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.RightHorn.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.LeftHornBase.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.LeftHornBase.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.LeftHorn.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.LeftHorn.rotateAngleX = par5 / (180F / (float)Math.PI);
		
		this.BackRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
		this.BackLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.FrontLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.FrontRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	}
}