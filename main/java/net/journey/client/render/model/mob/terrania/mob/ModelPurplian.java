package net.journey.client.render.model.mob.terrania.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelBlaze - Dizzlepop12
 * Created using Tabula 5.1.0
 */
public class ModelPurplian extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer stick;
    public ModelRenderer stick0;
    public ModelRenderer stick1;
    public ModelRenderer stick2;
    public ModelRenderer stick3;
    public ModelRenderer stick4;

    public ModelPurplian() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.stick1 = new ModelRenderer(this, 0, 16);
        this.stick1.setRotationPoint(0.0F, -1.93F, -9.0F);
        this.stick1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.stick = new ModelRenderer(this, 0, 16);
        this.stick.setRotationPoint(4.95F, 1.06F, -4.95F);
        this.stick.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.stick3 = new ModelRenderer(this, 0, 16);
        this.stick3.setRotationPoint(2.27F, 10.61F, -4.46F);
        this.stick3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.head = new ModelRenderer(this, 8, 0);
        this.head.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.head.addBox(-4.0F, -4.0F, -4.0F, 8, 14, 8, 0.0F);
        this.stick0 = new ModelRenderer(this, 0, 16);
        this.stick0.setRotationPoint(-9.0F, -1.46F, 0.0F);
        this.stick0.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.stick2 = new ModelRenderer(this, 0, 16);
        this.stick2.setRotationPoint(-4.95F, 1.2F, 4.95F);
        this.stick2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.stick4 = new ModelRenderer(this, 0, 16);
        this.stick4.setRotationPoint(0.0F, -1.12F, 9.0F);
        this.stick4.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.stick1.render(f5);
        this.stick.render(f5);
        this.stick3.render(f5);
        this.head.render(f5);
        this.stick0.render(f5);
        this.stick2.render(f5);
        this.stick4.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
	@Override
	public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f7, Entity e) {
		this.stick3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f2;
		this.stick4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f2;
		this.stick1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f2;
		this.stick2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f2;
		this.stick.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f2;
		this.stick0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f2;
    }
}
