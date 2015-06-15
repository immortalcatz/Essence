package net.essence.client.render.model.mob.overworld;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelReaper extends ModelBase {

    ModelRenderer BackBone;
    ModelRenderer Rib3;
    ModelRenderer Rib4;
    ModelRenderer Rib5;
    ModelRenderer TopRib;
    ModelRenderer LeftShoulder;
    ModelRenderer RightShoulder;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Head;
    ModelRenderer Hood;


	public ModelReaper() {
	      textureWidth = 64;
	      textureHeight = 64;
	    
	      BackBone = new ModelRenderer(this, 40, 0);
	      BackBone.addBox(0F, 0F, 0F, 2, 12, 2);
	      BackBone.setRotationPoint(0F, 0F, -2F);
	      BackBone.setTextureSize(64, 64);

	      setRotation(BackBone, 0.3365992F, 0F, 0F);
	      Rib3 = new ModelRenderer(this, 28, 14);
	      Rib3.addBox(0F, 0F, 0F, 8, 1, 2);
	      Rib3.setRotationPoint(-3F, 6F, 1F);
	      Rib3.setTextureSize(64, 64);

	      setRotation(Rib3, 0F, 0F, 0F);
	      Rib4 = new ModelRenderer(this, 28, 18);
	      Rib4.addBox(0F, 0F, 0F, 6, 1, 2);
	      Rib4.setRotationPoint(-2F, 9F, 2F);
	      Rib4.setTextureSize(64, 64);

	      setRotation(Rib4, 0F, 0F, 0F);
	      Rib5 = new ModelRenderer(this, 28, 22);
	      Rib5.addBox(0F, 0F, 0F, 10, 2, 2);
	      Rib5.setRotationPoint(-4F, 3F, 0F);
	      Rib5.setTextureSize(64, 64);

	      setRotation(Rib5, 0F, 0F, 0F);
	      TopRib = new ModelRenderer(this, 26, 28);
	      TopRib.addBox(0F, 0F, 0F, 16, 2, 2);
	      TopRib.setRotationPoint(-7F, 0F, -1F);
	      TopRib.setTextureSize(64, 64);

	      setRotation(TopRib, 0.122173F, 0F, 0F);
	      LeftShoulder = new ModelRenderer(this, 0, 10);
	      LeftShoulder.addBox(0F, 0F, 0F, 5, 5, 5);
	      LeftShoulder.setRotationPoint(5F, -1F, -3F);
	      LeftShoulder.setTextureSize(64, 64);

	      setRotation(LeftShoulder, 0F, 0F, 0F);
	      RightShoulder = new ModelRenderer(this, 0, 0);
	      RightShoulder.addBox(0F, 0F, 0F, 5, 5, 5);
	      RightShoulder.setRotationPoint(-8F, -1F, -3F);
	      RightShoulder.setTextureSize(64, 64);

	      setRotation(RightShoulder, 0F, 0F, 0F);

	      LeftArm = new ModelRenderer(this, 26, 0);
	      LeftArm.addBox(0F, 0F, 0F, 2, 8, 2);
	      LeftArm.setRotationPoint(7F, 2F, -2F);
	      LeftArm.setTextureSize(64, 64);

	      setRotation(LeftArm, 0F, 0F, 0F);

	      RightArm = new ModelRenderer(this, 26, 0);
	      RightArm.addBox(0F, 0F, 0F, 2, 8, 2);
	      RightArm.setRotationPoint(-7F, 2F, -2F);
	      RightArm.setTextureSize(64, 64);

	      setRotation(RightArm, 0F, 0F, 0F);
	      Head = new ModelRenderer(this, 0, 20);
	      Head.addBox(0F, 0F, 0F, 6, 6, 6);
	      Head.setRotationPoint(-2F, -6F, -3F);
	      Head.setTextureSize(64, 64);

	      setRotation(Head, 0F, 0F, 0F);
	      Hood = new ModelRenderer(this, 2, 34);
	      Hood.addBox(0F, 0F, 0F, 8, 8, 5);
	      Hood.setRotationPoint(-3F, -7F, -2F);
	      Hood.setTextureSize(64, 64);

	      setRotation(Hood, 0F, 0F, 0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    BackBone.render(f5);
	    Rib3.render(f5);
	    Rib4.render(f5);
	    Rib5.render(f5);
	    TopRib.render(f5);
	    LeftShoulder.render(f5);
	    RightShoulder.render(f5);
	    LeftArm.render(f5);
	    RightArm.render(f5);
	    Head.render(f5);
	    Hood.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.Head.rotateAngleY = f4 / (180F / (float)Math.PI);
		this.Head.rotateAngleX = f5 / (180F / (float)Math.PI);
	}
}