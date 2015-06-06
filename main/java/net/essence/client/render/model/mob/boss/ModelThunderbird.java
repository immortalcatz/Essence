package net.essence.client.render.model.mob.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelThunderbird extends ModelBase {
	
    ModelRenderer Body;
    ModelRenderer Feet1;
    ModelRenderer Feet2;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Feather1;
    ModelRenderer Feather2;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Beak1;
    ModelRenderer Wings1;
    ModelRenderer Wings2;
    ModelRenderer Beak2;

	public ModelThunderbird() {
		textureWidth = 128;
	    textureHeight = 64;
	    
	      Body = new ModelRenderer(this, 32, 0);
	      Body.addBox(-4F, -8F, -4F, 8, 8, 8);
	      Body.setRotationPoint(0F, 15F, 0F);
	      Body.setTextureSize(128, 64);
	      setRotation(Body, 0F, 0F, 0F);
	      Feet1 = new ModelRenderer(this, 44, 16);
	      Feet1.addBox(0F, 0F, 0F, 3, 0, 2);
	      Feet1.setRotationPoint(-3F, 24F, -3F);
	      Feet1.setTextureSize(128, 64);
	      setRotation(Feet1, 0F, 0F, 0F);
	      Feet2 = new ModelRenderer(this, 44, 16);
	      Feet2.addBox(0F, 0F, 0F, 3, 0, 2);
	      Feet2.setRotationPoint(0F, 24F, -3F);
	      Feet2.setTextureSize(128, 64);
	      setRotation(Feet2, 0F, 0F, 0F);
	      Leg1 = new ModelRenderer(this, 56, 21);
	      Leg1.addBox(0F, 0F, 0F, 1, 9, 1);
	      Leg1.setRotationPoint(-2F, 15F, -1F);
	      Leg1.setTextureSize(128, 64);
	      setRotation(Leg1, 0F, 0F, 0F);
	      Leg2 = new ModelRenderer(this, 56, 21);
	      Leg2.addBox(0F, 0F, 0F, 1, 9, 1);
	      Leg2.setRotationPoint(1F, 15F, -1F);
	      Leg2.setTextureSize(128, 64);
	      setRotation(Leg2, 0F, 0F, 0F);
	      Feather1 = new ModelRenderer(this, 54, 31);
	      Feather1.addBox(0F, 0F, 0F, 32, 32, 1);
	      Feather1.setRotationPoint(-16F, -8F, 4F);
	      Feather1.setTextureSize(128, 64);
	      setRotation(Feather1, 0F, 0F, 0F);
	      Feather2 = new ModelRenderer(this, -1, 16);
	      Feather2.addBox(0F, 0F, 0F, 20, 20, 1);
	      Feather2.setRotationPoint(-10F, 4F, 6F);
	      Feather2.setTextureSize(128, 64);
	      setRotation(Feather2, 0F, 0F, 0F);
	      Neck = new ModelRenderer(this, 44, 21);
	      Neck.addBox(0F, 0F, 0F, 2, 12, 2);
	      Neck.setRotationPoint(-1F, -1F, -6F);
	      Neck.setTextureSize(128, 64);
	      setRotation(Neck, 0F, 0F, 0F);
	      Head = new ModelRenderer(this, 0, 0);
	      Head.addBox(0F, 0F, 0F, 6, 6, 8);
	      Head.setRotationPoint(-3F, -7F, -10F);
	      Head.setTextureSize(128, 64);
	      setRotation(Head, 0F, 0F, 0F);
	      Beak1 = new ModelRenderer(this, 64, 0);
	      Beak1.addBox(0F, 0F, 0F, 6, 2, 5);
	      Beak1.setRotationPoint(-3F, -4F, -15F);
	      Beak1.setTextureSize(128, 64);
	      setRotation(Beak1, 0F, 0F, 0F);
	      Wings1 = new ModelRenderer(this, 96, 6);
	      Wings1.addBox(0F, 0F, 0F, 1, 13, 8);
	      Wings1.setRotationPoint(4F, 7F, -4F);
	      Wings1.setTextureSize(128, 64);
	      setRotation(Wings1, 0F, 0F, 0F);
	      Wings2 = new ModelRenderer(this, 96, 6);
	      Wings2.addBox(0F, 0F, 0F, 1, 13, 8);
	      Wings2.setRotationPoint(-5F, 7F, -4F);
	      Wings2.setTextureSize(128, 64);
	      setRotation(Wings2, 0F, 0F, 0F);
	      Beak2 = new ModelRenderer(this, 64, 0);
	      Beak2.addBox(0F, 0F, 0F, 6, 1, 5);
	      Beak2.setRotationPoint(-3F, -2F, -14F);
	      Beak2.setTextureSize(128, 64);
	      setRotation(Beak2, 0F, 0F, 0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Body.render(f5);
	    Feet1.render(f5);
	    Feet2.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Feather1.render(f5);
	    Feather2.render(f5);
	    Neck.render(f5);
	    Head.render(f5);
	    Beak1.render(f5);
	    Wings1.render(f5);
	    Wings2.render(f5);
	    Beak2.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;

	}
}