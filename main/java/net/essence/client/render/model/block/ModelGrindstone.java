package net.essence.client.render.model.block;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelGrindstone extends ModelBase {

	ModelRenderer stone;
	ModelRenderer base;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer side1;
	ModelRenderer side2;
	ModelRenderer side3;
	ModelRenderer side4;
	ModelRenderer turner;

	public ModelGrindstone() {
		textureWidth = 64;
		textureHeight = 64;

		stone = new ModelRenderer(this, 0, 19);
		stone.addBox(-3.5F, -3.5F, -2F, 7, 7, 2);
		stone.setRotationPoint(0.5F, 14F, 1F);
		stone.setTextureSize(64, 64);
		stone.mirror = true;
		setRotation(stone, 0F, 0F, 0F);
		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 11, 1, 6);
		base.setRotationPoint(-5F, 19F, -3F);
		base.setTextureSize(64, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 0);
		leg1.addBox(0F, 0F, 0F, 1, 4, 1);
		leg1.setRotationPoint(5F, 20F, -3F);
		leg1.setTextureSize(64, 64);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 0);
		leg2.addBox(0F, 0F, 0F, 1, 4, 1);
		leg2.setRotationPoint(-5F, 20F, 2F);
		leg2.setTextureSize(64, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 0);
		leg3.addBox(0F, 0F, 0F, 1, 4, 1);
		leg3.setRotationPoint(5F, 20F, 2F);
		leg3.setTextureSize(64, 64);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 0);
		leg4.addBox(0F, 0F, 0F, 1, 4, 1);
		leg4.setRotationPoint(-5F, 20F, -3F);
		leg4.setTextureSize(64, 64);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		side1 = new ModelRenderer(this, 0, 0);
		side1.addBox(0F, 0F, 0F, 11, 6, 1);
		side1.setRotationPoint(-5F, 13F, -3F);
		side1.setTextureSize(64, 64);
		side1.mirror = true;
		setRotation(side1, 0F, 0F, 0F);
		side2 = new ModelRenderer(this, 0, 0);
		side2.addBox(0F, 0F, 0F, 11, 6, 1);
		side2.setRotationPoint(-5F, 13F, 2F);
		side2.setTextureSize(64, 64);
		side2.mirror = true;
		setRotation(side2, 0F, 0F, 0F);
		side3 = new ModelRenderer(this, 0, 0);
		side3.addBox(0F, 0F, 0F, 1, 6, 4);
		side3.setRotationPoint(5F, 13F, -2F);
		side3.setTextureSize(64, 64);
		side3.mirror = true;
		setRotation(side3, 0F, 0F, 0F);
		side4 = new ModelRenderer(this, 0, 0);
		side4.addBox(0F, 0F, 0F, 1, 6, 4);
		side4.setRotationPoint(-5F, 13F, -2F);
		side4.setTextureSize(64, 64);
		side4.mirror = true;
		setRotation(side4, 0F, 0F, 0F);
		turner = new ModelRenderer(this, 0, 0);
		turner.addBox(0F, 0F, 0F, 1, 1, 4);
		turner.setRotationPoint(0F, 13F, -2F);
		turner.setTextureSize(64, 64);
		turner.mirror = true;
		setRotation(turner, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		stone.render(f5);
		base.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		side1.render(f5);
		side2.render(f5);
		side3.render(f5);
		side4.render(f5);
		turner.render(f5);
		stone.rotateAngleY += 50;
	}
	
	public void render(float f5, boolean b, float r) {
		base.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		side1.render(f5);
		side2.render(f5);
		side3.render(f5);
		side4.render(f5);
		turner.render(f5);
		if(b) stone.render(0.0625F);
		stone.rotateAngleZ += r;
	}
	
	public void setGrindstoneRotation(float rotation) {
		stone.render(0.0625F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}