package net.essence.client.render.model.mob.corba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWoodCreature extends ModelBase {

	 ModelRenderer Body;
	    ModelRenderer head;
	    ModelRenderer Leg1;
	    ModelRenderer Leg2;
	    ModelRenderer Leg3;
	    ModelRenderer Leg4;
	  
	  public ModelWoodCreature()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      Body = new ModelRenderer(this, 40, 15);
	      Body.addBox(-4F, -2F, -3F, 6, 10, 6);
	      Body.setRotationPoint(0F, 18F, 1F);
	      Body.setTextureSize(64, 32);
	      setRotation(Body, 1.273367F, 0F, 0F);
	      head = new ModelRenderer(this, 34, 0);
	      head.addBox(0F, 0F, 0F, 8, 6, 7);
	      head.setRotationPoint(-5F, 20F, -6F);
	      head.setTextureSize(64, 32);
	      setRotation(head, 1.570796F, 0F, 0F);
	      Leg1 = new ModelRenderer(this, 30, 21);
	      Leg1.addBox(-1F, 0F, -1F, 2, 4, 2);
	      Leg1.setRotationPoint(-4.5F, 20F, 7F);
	      Leg1.setTextureSize(64, 32);
	      setRotation(Leg1, 0F, 0F, 0F);
	      Leg2 = new ModelRenderer(this, 30, 21);
	      Leg2.addBox(-1F, 0F, -1F, 2, 4, 2);
	      Leg2.setRotationPoint(2.5F, 20F, 7F);
	      Leg2.setTextureSize(64, 32);
	      setRotation(Leg2, 0F, 0F, 0F);
	      Leg3 = new ModelRenderer(this, 30, 21);
	      Leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
	      Leg3.setRotationPoint(-4.5F, 16F, 1F);
	      Leg3.setTextureSize(64, 32);
	      setRotation(Leg3, 0F, 0F, 0F);
	      Leg4 = new ModelRenderer(this, 30, 21);
	      Leg4.addBox(-1F, 0F, -1F, 2, 8, 2);
	      Leg4.setRotationPoint(2.5F, 16F, 1F);
	      Leg4.setTextureSize(64, 32);
	      setRotation(Leg4, 0F, 0F, 0F);
	  }
	  
	  private void setRotation(ModelRenderer body2, float f, float g, float h) {
		
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Body.render(f5);
	    head.render(f5);
	    Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	  }

}