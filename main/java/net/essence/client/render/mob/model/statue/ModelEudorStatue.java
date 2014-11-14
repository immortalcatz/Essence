package net.essence.client.render.mob.model.statue;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEudorStatue extends ModelStatue {

	ModelRenderer LowerBody;
	ModelRenderer RightLeg;
	ModelRenderer LeftLeg;
	ModelRenderer RightFoot;
	ModelRenderer LeftFoot;
	ModelRenderer Chest;
	ModelRenderer LeftUpperArm;
	ModelRenderer RightUpperArm;
	ModelRenderer RightArm;
	ModelRenderer Head;
	ModelRenderer Neck;
	ModelRenderer LeftArm;

	public ModelEudorStatue() {
		textureWidth = 128;
		textureHeight = 64;

		LowerBody = new ModelRenderer(this, 0, 0);
		LowerBody.addBox(-4F, 0F, -2F, 8, 8, 4);
		LowerBody.setRotationPoint(0F, 4F, 0F);
		LowerBody.setTextureSize(128, 64);
		LowerBody.mirror = true;
		setRotation(LowerBody, 0.3141593F, 0F, 0F);
		RightLeg = new ModelRenderer(this, 0, 12);
		RightLeg.addBox(-1.5F, 0F, -1.5F, 3, 11, 3);
		RightLeg.setRotationPoint(-2.5F, 11F, 2F);
		RightLeg.setTextureSize(128, 64);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0F);
		LeftLeg = new ModelRenderer(this, 0, 12);
		LeftLeg.addBox(-1.5F, 0F, -1.5F, 3, 11, 3);
		LeftLeg.setRotationPoint(2.5F, 11F, 2F);
		LeftLeg.setTextureSize(128, 64);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0F);
		RightFoot = new ModelRenderer(this, 24, 0);
		RightFoot.addBox(-1.5F, 11F, -6F, 3, 2, 7);
		RightFoot.setRotationPoint(-2.5F, 11F, 2.5F);
		RightFoot.setTextureSize(128, 64);
		RightFoot.mirror = true;
		setRotation(RightFoot, 0F, 0F, 0F);
		LeftFoot = new ModelRenderer(this, 24, 0);
		LeftFoot.addBox(-1.5F, 11F, -6F, 3, 2, 7);
		LeftFoot.setRotationPoint(2.5F, 11F, 2.5F);
		LeftFoot.setTextureSize(128, 64);
		LeftFoot.mirror = true;
		setRotation(LeftFoot, 0F, 0F, 0F);
		Chest = new ModelRenderer(this, 12, 12);
		Chest.addBox(-8F, -9F, -4F, 16, 10, 7);
		Chest.setRotationPoint(0F, 4F, 0F);
		Chest.setTextureSize(128, 64);
		Chest.mirror = true;
		setRotation(Chest, 0.9599311F, 0F, 0F);
		LeftUpperArm = new ModelRenderer(this, 58, 0);
		LeftUpperArm.addBox(0F, -1.5F, -1.5F, 3, 10, 3);
		LeftUpperArm.setRotationPoint(8F, 0F, -6F);
		LeftUpperArm.setTextureSize(128, 64);
		LeftUpperArm.mirror = true;
		setRotation(LeftUpperArm, 0.3141593F, 0F, 0F);
		RightUpperArm = new ModelRenderer(this, 58, 0);
		RightUpperArm.addBox(-3F, -1.5F, -1.5F, 3, 10, 3);
		RightUpperArm.setRotationPoint(-8F, 0F, -6F);
		RightUpperArm.setTextureSize(128, 64);
		RightUpperArm.mirror = true;
		setRotation(RightUpperArm, 0.3141593F, 0F, 0F);
		RightArm = new ModelRenderer(this, 58, 13);
		RightArm.addBox(-3F, 5.5F, 3.5F, 3, 11, 3);
		RightArm.setRotationPoint(-8F, 0F, -6F);
		RightArm.setTextureSize(128, 64);
		RightArm.mirror = true;
		setRotation(RightArm, -0.3490659F, 0F, 0F);
		Head = new ModelRenderer(this, 20, 29);
		Head.addBox(-3F, -3F, -6F, 6, 6, 6);
		Head.setRotationPoint(0F, 0F, -10F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, -0.0872665F, 0F, 0F);
		Neck = new ModelRenderer(this, 0, 29);
		Neck.addBox(-2.5F, -3F, -2.5F, 5, 6, 5);
		Neck.setRotationPoint(0F, 0F, -7F);
		Neck.setTextureSize(128, 64);
		Neck.mirror = true;
		setRotation(Neck, 1.448623F, 0F, 0F);
		LeftArm = new ModelRenderer(this, 58, 13);
		LeftArm.addBox(-1F, 5.5F, 3.5F, 3, 11, 3);
		LeftArm.setRotationPoint(9F, 0F, -6F);
		LeftArm.setTextureSize(128, 64);
		LeftArm.mirror = true;
		setRotation(LeftArm, -0.3490659F, 0F, 0F);
	}

	public void render(float f5) {
		LowerBody.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
		RightFoot.render(f5);
		LeftFoot.render(f5);
		Chest.render(f5);
		LeftUpperArm.render(f5);
		RightUpperArm.render(f5);
		RightArm.render(f5);
		Head.render(f5);
		Neck.render(f5);
		LeftArm.render(f5);
	}
}