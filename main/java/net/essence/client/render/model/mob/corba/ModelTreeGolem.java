package net.essence.client.render.model.mob.corba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTreeGolem extends ModelBase {

	ModelRenderer foot1;
	ModelRenderer foot2;
	ModelRenderer Leg1;
	ModelRenderer leg2;
	ModelRenderer body;
	ModelRenderer arm1;
	ModelRenderer arm2;
	ModelRenderer hand1;
	ModelRenderer hand2;
	ModelRenderer head;

	public ModelTreeGolem() {
		textureWidth = 128;
		textureHeight = 64;
		foot1 = new ModelRenderer(this, 0, 0);
		foot1.addBox(0F, 0F, 0F, 6, 8, 6);
		foot1.setRotationPoint(2F, 16F, 2F);
		foot1.setTextureSize(128, 64);
		setRotation(foot1, 0F, 0F, 0F);
		foot2 = new ModelRenderer(this, 0, 42);
		foot2.addBox(0F, 0F, 0F, 6, 8, 6);
		foot2.setRotationPoint(-8F, 16F, 2F);
		foot2.setTextureSize(128, 64);
		setRotation(foot2, 0F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 81, 23);
		Leg1.addBox(0F, 0F, 0F, 4, 10, 4);
		Leg1.setRotationPoint(3F, 6F, 3F);
		Leg1.setTextureSize(128, 64);
		setRotation(Leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 64, 23);
		leg2.addBox(0F, 0F, 0F, 4, 10, 4);
		leg2.setRotationPoint(-7F, 6F, 3F);
		leg2.setTextureSize(128, 64);
		setRotation(leg2, 0F, 0F, 0F);
		body = new ModelRenderer(this, 99, 0);
		body.addBox(0F, 0F, 0F, 6, 19, 6);
		body.setRotationPoint(-3F, 3F, -9F);
		body.setTextureSize(128, 64);
		setRotation(body, 1.003822F, 0F, 0F);
		arm1 = new ModelRenderer(this, 81, 0);
		arm1.addBox(0F, 0F, 0F, 4, 17, 4);
		arm1.setRotationPoint(3F, -1F, -6F);
		arm1.setTextureSize(128, 64);
		setRotation(arm1, 0F, 0F, 0F);
		arm2 = new ModelRenderer(this, 64, 0);
		arm2.addBox(0F, 0F, 0F, 4, 17, 4);
		arm2.setRotationPoint(-7F, -1F, -6F);
		arm2.setTextureSize(128, 64);
		setRotation(arm2, 0F, 0F, 0F);
		hand1 = new ModelRenderer(this, 0, 14);
		hand1.addBox(0F, 0F, 0F, 6, 8, 6);
		hand1.setRotationPoint(2F, 16F, -7F);
		hand1.setTextureSize(128, 64);
		setRotation(hand1, 0F, 0F, 0F);
		hand2 = new ModelRenderer(this, 0, 28);
		hand2.addBox(0F, 0F, 0F, 6, 8, 6);
		hand2.setRotationPoint(-8F, 16F, -7F);
		hand2.setTextureSize(128, 64);
		setRotation(hand2, 0F, 0F, 0F);
		head = new ModelRenderer(this, 24, 0);
		head.addBox(-5F, -5F, -10F, 10, 10, 10);
		head.setRotationPoint(0F, 0F, -6F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		Leg1.addChild(foot1);
		leg2.addChild(foot2);
		arm1.addChild(foot1);
		arm2.addChild(foot2);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Leg1.render(f5);
		leg2.render(f5);
		body.render(f5);
		arm1.render(f5);
		arm2.render(f5);
		head.render(f5);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.Leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.arm1.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.arm2.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}
}