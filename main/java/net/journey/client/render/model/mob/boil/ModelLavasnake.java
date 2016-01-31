package net.journey.client.render.model.mob.boil;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLavasnake extends ModelBiped {

    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer headFin;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer fin1;
    ModelRenderer fin2;
    ModelRenderer fin3;
    ModelRenderer tailFin;
    ModelRenderer mouth;
    ModelRenderer tooth1;
    ModelRenderer tooth2;

	public ModelLavasnake() {
		textureWidth = 128;
	    textureHeight = 128;
	    
	      head = new ModelRenderer(this, 54, 0);
	      head.addBox(-4F, -4F, -6F, 8, 6, 6);
	      head.setRotationPoint(0F, 8F, -8F);
	      head.setTextureSize(128, 128);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      body = new ModelRenderer(this, 52, 32);
	      body.addBox(-6F, -10F, -7F, 12, 18, 12);
	      body.setRotationPoint(0F, 7F, 2F);
	      body.setTextureSize(128, 128);
	      body.mirror = true;
	      setRotation(body, 1.570796F, 0F, 0F);
	      headFin = new ModelRenderer(this, 0, 24);
	      headFin.addBox(0F, 0F, 0F, 0, 6, 8);
	      headFin.setRotationPoint(0F, 2F, -16F);
	      headFin.setTextureSize(128, 128);
	      headFin.mirror = true;
	      setRotation(headFin, 0.2974289F, 0F, 0F);
	      body1 = new ModelRenderer(this, 18, 15);
	      body1.addBox(-5F, 0F, 0F, 10, 16, 10);
	      body1.setRotationPoint(0F, 13F, 10F);
	      body1.setTextureSize(128, 128);
	      body1.mirror = true;
	      setRotation(body1, 1.570796F, 0F, 0F);
	      body2 = new ModelRenderer(this, 18, 60);
	      body2.addBox(-4F, 16F, 1F, 8, 14, 7);
	      body2.setRotationPoint(0F, 13F, 10F);
	      body2.setTextureSize(128, 128);
	      body2.mirror = true;
	      setRotation(body2, 1.570796F, 0F, 0F);
	      body3 = new ModelRenderer(this, 18, 89);
	      body3.addBox(-3F, 30F, 2F, 6, 12, 4);
	      body3.setRotationPoint(0F, 13F, 10F);
	      body3.setTextureSize(128, 128);
	      body3.mirror = true;
	      setRotation(body3, 1.570796F, 0F, 0F);
	      fin1 = new ModelRenderer(this, 0, 38);
	      fin1.addBox(0F, 0F, 0F, 0, 6, 8);
	      fin1.setRotationPoint(0F, -1F, -4F);
	      fin1.setTextureSize(128, 128);
	      fin1.mirror = true;
	      setRotation(fin1, 0F, 0F, 0F);
	      fin2 = new ModelRenderer(this, 0, 80);
	      fin2.addBox(0F, 0F, 0F, 0, 6, 8);
	      fin2.setRotationPoint(0F, 0F, 14F);
	      fin2.setTextureSize(128, 128);
	      fin2.mirror = true;
	      setRotation(fin2, 0F, 0F, 0F);
	      fin3 = new ModelRenderer(this, 0, 66);
	      fin3.addBox(0F, 0F, 0F, 0, 6, 8);
	      fin3.setRotationPoint(0F, 3F, 28F);
	      fin3.setTextureSize(128, 128);
	      fin3.mirror = true;
	      setRotation(fin3, 0F, 0F, 0F);
	      tailFin = new ModelRenderer(this, 0, 52);
	      tailFin.addBox(0F, -2F, 0F, 0, 6, 8);
	      tailFin.setRotationPoint(0F, 9F, 48F);
	      tailFin.setTextureSize(128, 128);
	      tailFin.mirror = true;
	      setRotation(tailFin, 0.5007752F, 0F, 0F);
	      mouth = new ModelRenderer(this, 84, 0);
	      mouth.addBox(0F, 0F, 0F, 8, 2, 6);
	      mouth.setRotationPoint(-4F, 11F, -14F);
	      mouth.setTextureSize(128, 128);
	      mouth.mirror = true;
	      setRotation(mouth, 0F, 0F, 0F);
	      tooth1 = new ModelRenderer(this, 84, 8);
	      tooth1.addBox(0F, 0F, 0F, 1, 1, 1);
	      tooth1.setRotationPoint(3F, 10F, -14F);
	      tooth1.setTextureSize(128, 128);
	      tooth1.mirror = true;
	      setRotation(tooth1, 0F, 0F, 0F);
	      tooth2 = new ModelRenderer(this, 84, 8);
	      tooth2.addBox(0F, 0F, 0F, 1, 1, 1);
	      tooth2.setRotationPoint(-4F, 10F, -14F);
	      tooth2.setTextureSize(128, 128);
	      tooth2.mirror = true;
	      setRotation(tooth2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
	      head.render(f5);
	      body.render(f5);
	      headFin.render(f5);
	      body1.render(f5);
	      body2.render(f5);
	      body3.render(f5);
	      fin1.render(f5);
	      fin2.render(f5);
	      fin3.render(f5);
	      tailFin.render(f5);
	      mouth.render(f5);
	      tooth1.render(f5);
	      tooth2.render(f5);
		    
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		
	}
}