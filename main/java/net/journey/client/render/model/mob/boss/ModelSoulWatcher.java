package net.journey.client.render.model.mob.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSoulWatcher extends ModelBase {
	
    ModelRenderer lavasnakeBody;
    ModelRenderer lavasnakeEye;
    ModelRenderer[] lavasnakeTail;
    private static final String __OBFID = "CL_00002628";


    public ModelSoulWatcher()
    {
        textureWidth = 64;
        textureHeight = 64;
        lavasnakeBody = new ModelRenderer(this);
        lavasnakeBody.setTextureOffset(0, 0).addBox(-6.0F, 10.0F, -8.0F, 12, 12, 16);
        lavasnakeEye = new ModelRenderer(this, 8, 0);
        lavasnakeEye.addBox(-1.0F, 15.0F, 0.0F, 2, 2, 1);
        lavasnakeBody.addChild(lavasnakeEye);
        lavasnakeTail = new ModelRenderer[3];
        lavasnakeTail[0] = new ModelRenderer(this, 40, 0);
        lavasnakeTail[0].addBox(-2.0F, 14.0F, 7.0F, 4, 4, 8);
        lavasnakeTail[1] = new ModelRenderer(this, 0, 54);
        lavasnakeTail[1].addBox(0.0F, 14.0F, 0.0F, 3, 3, 7);
        lavasnakeTail[2] = new ModelRenderer(this);
        lavasnakeTail[2].setTextureOffset(41, 32).addBox(0.0F, 14.0F, 0.0F, 2, 2, 6);
        lavasnakeTail[2].setTextureOffset(25, 19).addBox(1.0F, 10.5F, 3.0F, 1, 9, 9);
        lavasnakeBody.addChild(lavasnakeTail[0]);
        lavasnakeTail[0].addChild(lavasnakeTail[1]);
        lavasnakeTail[1].addChild(lavasnakeTail[2]);

	}

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.lavasnakeBody.render(p_78088_7_);
    }

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;

	}
}