package net.essence.client.render.model.mob.overworld;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelReaper extends ModelBase {

	ModelRenderer BackBone;
	ModelRenderer Rib2;
	ModelRenderer Rib3;
	ModelRenderer Rib4;
	ModelRenderer Rib5;
	ModelRenderer TopRib;
	ModelRenderer LeftShoulder;
	ModelRenderer RightShoulder;
	ModelRenderer LeftArm;
	ModelRenderer RightArm;
	ModelRenderer RightHand;
	ModelRenderer LeftHand;
	ModelRenderer Head;
	ModelRenderer LeftHorn1;
	ModelRenderer RightHorn1;
	ModelRenderer LeftHorn2;
	ModelRenderer RightHorn2;

	public ModelReaper() {
		textureWidth = 64;
		textureHeight = 32;

		BackBone = new ModelRenderer(this, 0, 0);
		BackBone.addBox(-0.5F, 0F, -0.5F, 1, 11, 1);
		BackBone.setRotationPoint(0F, 0F, 0F);
		BackBone.setTextureSize(64, 32);
		BackBone.mirror = true;
		setRotation(BackBone, 0F, 0F, 0F);
		Rib2 = new ModelRenderer(this, 4, 2);
		Rib2.addBox(-4F, -0.5F, -0.5F, 8, 1, 1);
		Rib2.setRotationPoint(0F, 5F, 0F);
		Rib2.setTextureSize(64, 32);
		Rib2.mirror = true;
		setRotation(Rib2, 0F, 0F, 0F);
		Rib3 = new ModelRenderer(this, 4, 4);
		Rib3.addBox(-3F, -0.5F, -0.5F, 6, 1, 1);
		Rib3.setRotationPoint(0F, 7F, 0F);
		Rib3.setTextureSize(64, 32);
		Rib3.mirror = true;
		setRotation(Rib3, 0F, 0F, 0F);
		Rib4 = new ModelRenderer(this, 4, 6);
		Rib4.addBox(-2F, -0.5F, -0.5F, 4, 1, 1);
		Rib4.setRotationPoint(0F, 9F, 0F);
		Rib4.setTextureSize(64, 32);
		Rib4.mirror = true;
		setRotation(Rib4, 0F, 0F, 0F);
		Rib5 = new ModelRenderer(this, 4, 0);
		Rib5.addBox(-5F, -0.5F, -0.5F, 10, 1, 1);
		Rib5.setRotationPoint(0F, 3F, 0F);
		Rib5.setTextureSize(64, 32);
		Rib5.mirror = true;
		setRotation(Rib5, 0F, 0F, 0F);
		TopRib = new ModelRenderer(this, 4, 8);
		TopRib.addBox(-8F, -0.5F, -0.5F, 16, 1, 1);
		TopRib.setRotationPoint(0F, 1F, 0F);
		TopRib.setTextureSize(64, 32);
		TopRib.mirror = true;
		setRotation(TopRib, 0.122173F, 0F, 0F);
		LeftShoulder = new ModelRenderer(this, 0, 12);
		LeftShoulder.addBox(0F, -2.5F, -2.5F, 5, 5, 5);
		LeftShoulder.setRotationPoint(8F, 1F, 0F);
		LeftShoulder.setTextureSize(64, 32);
		LeftShoulder.mirror = true;
		setRotation(LeftShoulder, 0F, 0F, -0.2443461F);
		RightShoulder = new ModelRenderer(this, 0, 12);
		RightShoulder.addBox(-5F, -2.5F, -2.5F, 5, 5, 5);
		RightShoulder.setRotationPoint(-8F, 1F, 0F);
		RightShoulder.setTextureSize(64, 32);
		RightShoulder.mirror = true;
		setRotation(RightShoulder, 0F, 0F, 0.2443461F);
		LeftArm = new ModelRenderer(this, 26, 0);
		LeftArm.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
		LeftArm.setRotationPoint(11F, 2F, 0F);
		LeftArm.setTextureSize(64, 32);
		LeftArm.mirror = true;
		setRotation(LeftArm, 0F, 0F, -0.2792527F);
		RightArm = new ModelRenderer(this, 26, 0);
		RightArm.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
		RightArm.setRotationPoint(-11F, 2F, 0F);
		RightArm.setTextureSize(64, 32);
		RightArm.mirror = true;
		setRotation(RightArm, 0F, 0F, 0.2792527F);
		RightHand = new ModelRenderer(this, 38, 0);
		RightHand.addBox(-0.5F, 0F, -0.5F, 1, 8, 1);
		RightHand.setRotationPoint(-13F, 8F, 0F);
		RightHand.setTextureSize(64, 32);
		RightHand.mirror = true;
		setRotation(RightHand, -0.4363323F, 0F, 0F);
		LeftHand = new ModelRenderer(this, 38, 0);
		LeftHand.addBox(-0.5F, 0F, -0.5F, 1, 8, 1);
		LeftHand.setRotationPoint(13F, 8F, 0F);
		LeftHand.setTextureSize(64, 32);
		LeftHand.mirror = true;
		setRotation(LeftHand, -0.4363323F, 0F, 0F);
		Head = new ModelRenderer(this, 0, 22);
		Head.addBox(-2.5F, -5F, -4F, 5, 5, 5);
		Head.setRotationPoint(0F, 0F, 0F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		LeftHorn1 = new ModelRenderer(this, 4, 10);
		LeftHorn1.addBox(-0.5F, 0F, -0.5F, 4, 1, 1);
		LeftHorn1.setRotationPoint(2F, -4F, -0.5F);
		LeftHorn1.setTextureSize(64, 32);
		LeftHorn1.mirror = true;
		setRotation(LeftHorn1, 0F, 0F, -0.5235988F);
		RightHorn1 = new ModelRenderer(this, 4, 10);
		RightHorn1.addBox(-4F, 0F, -0.5F, 4, 1, 1);
		RightHorn1.setRotationPoint(-2F, -4F, -0.5F);
		RightHorn1.setTextureSize(64, 32);
		RightHorn1.mirror = true;
		setRotation(RightHorn1, 0F, 0F, 0.5235988F);
		LeftHorn2 = new ModelRenderer(this, 42, 0);
		LeftHorn2.addBox(-0.5F, -0.5F, -4F, 1, 1, 4);
		LeftHorn2.setRotationPoint(5F, -5F, 0F);
		LeftHorn2.setTextureSize(64, 32);
		LeftHorn2.mirror = true;
		setRotation(LeftHorn2, -0.5410521F, -0.3490659F, -0.6108652F);
		RightHorn2 = new ModelRenderer(this, 42, 0);
		RightHorn2.addBox(-0.5F, -0.5F, -4F, 1, 1, 4);
		RightHorn2.setRotationPoint(-5F, -5F, 0F);
		RightHorn2.setTextureSize(64, 32);
		RightHorn2.mirror = true;
		setRotation(RightHorn2, -0.5410521F, 0.3490659F, 0.6108652F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BackBone.render(f5);
		Rib2.render(f5);
		Rib3.render(f5);
		Rib4.render(f5);
		Rib5.render(f5);
		TopRib.render(f5);
		LeftShoulder.render(f5);
		RightShoulder.render(f5);
		LeftArm.render(f5);
		RightArm.render(f5);
		RightHand.render(f5);
		LeftHand.render(f5);
		Head.render(f5);
		LeftHorn1.render(f5);
		RightHorn1.render(f5);
		LeftHorn2.render(f5);
		RightHorn2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		
	}
}