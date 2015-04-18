package net.essence.client.render.model.mob.corba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLeafBlower extends ModelBase {


    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer stick4;
    private ModelRenderer stick3;
    private ModelRenderer stick2;
    private ModelRenderer stick1;
    private ModelRenderer leaves;
    private ModelRenderer stick5;
    private ModelRenderer stick6;



	public ModelLeafBlower() {
		textureWidth = 64;
	    textureHeight = 64;
	    
	      head = new ModelRenderer(this, 0, 0);
	      head.addBox(-4F, -8F, -4F, 8, 8, 8);
	      head.setRotationPoint(0F, 0F, -1F);
	      head.setTextureSize(64, 64);
	      setRotation(head, 0F, 0F, 0F);
	      body = new ModelRenderer(this, 16, 16);
	      body.addBox(-4F, 0F, -2F, 2, 8, 2);
	      body.setRotationPoint(3F, 0F, 0F);
	      body.setTextureSize(64, 64);
	      setRotation(body, 0F, 0F, 0F);
	      stick4 = new ModelRenderer(this, 32, 16);
	      stick4.addBox(-3F, -2F, -2F, 2, 24, 2);
	      stick4.setRotationPoint(-2F, 2F, 0F);
	      stick4.setTextureSize(64, 64);
	      setRotation(stick4, 0F, 0F, 0F);
	      stick3 = new ModelRenderer(this, 32, 16);
	      stick3.addBox(-1F, -2F, -2F, 2, 24, 2);
	      stick3.setRotationPoint(4F, 2F, 0F);
	      stick3.setTextureSize(64, 64);
	      setRotation(stick3, 0F, 0F, 0F);
	      stick2 = new ModelRenderer(this, 0, 16);
	      stick2.addBox(-2F, 0F, -2F, 2, 13, 2);
	      stick2.setRotationPoint(1F, 4F, -6F);
	      stick2.setTextureSize(64, 64);
	      setRotation(stick2, 0F, 0F, 0F);
	      stick1 = new ModelRenderer(this, 0, 16);
	      stick1.addBox(-2F, 0F, -2F, 2, 13, 2);
	      stick1.setRotationPoint(1F, 4F, 6F);
	      stick1.setTextureSize(64, 64);
	      setRotation(stick1, 0F, 0F, 0F);
	      leaves = new ModelRenderer(this, 0, 32);
	      leaves.addBox(-4F, 0F, -4F, 8, 10, 8);
	      leaves.setRotationPoint(0F, 0F, -1F);
	      leaves.setTextureSize(64, 64);
	      setRotation(leaves, 0F, 0F, 0F);
	      stick5 = new ModelRenderer(this, 0, 16);
	      stick5.addBox(0F, 0F, 0F, 2, 13, 2);
	      stick5.setRotationPoint(-7F, 0F, -8F);
	      stick5.setTextureSize(64, 64);
	      setRotation(stick5, 0F, 0F, 0F);
	      stick6 = new ModelRenderer(this, 0, 16);
	      stick6.addBox(0F, 0F, 0F, 2, 13, 2);
	      stick6.setRotationPoint(5F, -2F, 4F);
	      stick6.setTextureSize(64, 64);
	      setRotation(stick6, 0F, 0F, 0F);


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
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    head.render(f5);
	    body.render(f5);
	    stick4.render(f5);
	    stick3.render(f5);
	    stick2.render(f5);
	    stick1.render(f5);
	    leaves.render(f5);
	    stick5.render(f5);
	    stick6.render(f5);

	}
}