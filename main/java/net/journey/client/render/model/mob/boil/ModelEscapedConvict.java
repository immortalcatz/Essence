package net.journey.client.render.model.mob.boil;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEscapedConvict extends ModelBase {

	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer neck;
	ModelRenderer muzzle;
	ModelRenderer lHorn;
	ModelRenderer rHorn;

	public ModelEscapedConvict() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 14, 8, 9);
		head.setRotationPoint(-3F, 0F, -1F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 24);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(128, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 72, 12);
		rightarm.addBox(-3F, -2F, -2F, 4, 14, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(128, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 72, 11);
		leftarm.addBox(-1F, -2F, -2F, 4, 14, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(128, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 24);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(128, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 40);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(128, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 56, 16);
		neck.addBox(0F, 0F, 0F, 4, 4, 4);
		neck.setRotationPoint(-2F, -4F, -2F);
		neck.setTextureSize(128, 64);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0F);
		muzzle = new ModelRenderer(this, 46, 1);
		muzzle.addBox(-2F, -5F, -8F, 10, 4, 4);
		muzzle.setRotationPoint(-3F, 0F, -1F);
		muzzle.setTextureSize(128, 64);
		muzzle.mirror = true;
		setRotation(muzzle, 0F, 0F, 0F);
		lHorn = new ModelRenderer(this, 46, 1);
		lHorn.addBox(10F, -12F, 0F, 2, 6, 2);
		lHorn.setRotationPoint(-3F, 0F, -1F);
		lHorn.setTextureSize(128, 64);
		lHorn.mirror = true;
		setRotation(lHorn, 0F, 0F, 0F);
		rHorn = new ModelRenderer(this, 46, 1);
		rHorn.addBox(-6F, -12F, 0F, 2, 6, 2);
		rHorn.setRotationPoint(-3F, 0F, -1F);
		rHorn.setTextureSize(128, 64);
		rHorn.mirror = true;
		setRotation(rHorn, 0F, 0F, 0F);
		head.addChild(lHorn);
		head.addChild(rHorn);
		head.addChild(muzzle);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		neck.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
	}
}