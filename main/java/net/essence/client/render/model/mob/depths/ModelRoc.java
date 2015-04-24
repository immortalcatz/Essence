package net.essence.client.render.model.mob.depths;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRoc extends ModelBase {
	
	ModelRenderer Body;
    ModelRenderer Feet1;
    ModelRenderer Leg2;
    ModelRenderer Feet2;
    ModelRenderer Leg1;
    ModelRenderer Feather;
    ModelRenderer Neck;
    ModelRenderer Head;


	public ModelRoc() {
		  textureWidth = 64;
	      textureHeight = 32;
	    
	      Body = new ModelRenderer(this, 32, 0);
	      Body.addBox(-4F, -8F, -4F, 8, 6, 8);
	      Body.setRotationPoint(0F, 21F, 0F);
	      Body.setTextureSize(64, 32);
	      setRotation(Body, 0F, 0F, 0F);
	      Feet1 = new ModelRenderer(this, 44, 16);
	      Feet1.addBox(0F, 0F, 0F, 3, 0, 2);
	      Feet1.setRotationPoint(-3F, 24F, -3F);
	      Feet1.setTextureSize(64, 32);
	      setRotation(Feet1, 0F, 0F, 0F);
	      Leg2 = new ModelRenderer(this, 56, 24);
	      Leg2.addBox(0F, 0F, 0F, 1, 5, 1);
	      Leg2.setRotationPoint(1F, 19F, -1F);
	      Leg2.setTextureSize(64, 32);
	      setRotation(Leg2, 0F, 0F, 0F);
	      Feet2 = new ModelRenderer(this, 44, 16);
	      Feet2.addBox(0F, 0F, 0F, 3, 0, 2);
	      Feet2.setRotationPoint(0F, 24F, -3F);
	      Feet2.setTextureSize(64, 32);
	      setRotation(Feet2, 0F, 0F, 0F);
	      Leg1 = new ModelRenderer(this, 56, 24);
	      Leg1.addBox(0F, 0F, 0F, 1, 5, 1);
	      Leg1.setRotationPoint(-2F, 19F, -1F);
	      Leg1.setTextureSize(64, 32);
	      setRotation(Leg1, 0F, 0F, 0F);
	      Feather = new ModelRenderer(this, 1, 16);
	      Feather.addBox(0F, 0F, 0F, 19, 14, 0);
	      Feather.setRotationPoint(-9F, 4F, 4F);
	      Feather.setTextureSize(64, 32);
	      setRotation(Feather, 0F, 0F, 0F);
	      Neck = new ModelRenderer(this, 44, 21);
	      Neck.addBox(0F, 0F, 0F, 2, 7, 2);
	      Neck.setRotationPoint(-1F, 9F, -6F);
	      Neck.setTextureSize(64, 32);
	      setRotation(Body, 0F, 0F, 0F);
	      Head = new ModelRenderer(this, 0, 0);
	      Head.addBox(0F, 0F, 0F, 6, 6, 8);
	      Head.setRotationPoint(-3F, 3F, -10F);
	      Head.setTextureSize(64, 32);
	      setRotation(Head, 0F, 0F, 0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Body.render(f5);
	    Feet1.render(f5);
	    Leg2.render(f5);
	    Feet2.render(f5);
	    Leg1.render(f5);
	    Feather.render(f5);
	    Neck.render(f5);
	    Head.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;

	}
}