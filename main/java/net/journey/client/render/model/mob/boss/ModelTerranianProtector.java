package net.journey.client.render.model.mob.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelTerranianProtector - Dizzlepop12
 * Created using Tabula 5.1.0
 */
public class ModelTerranianProtector extends ModelBase {
    public ModelRenderer body1;
    public ModelRenderer arm1;
    public ModelRenderer arm2;
    public ModelRenderer arm3;
    public ModelRenderer arm4;
    public ModelRenderer arm5;
    public ModelRenderer arm6;
    public ModelRenderer arm7;
    public ModelRenderer arm8;
    public ModelRenderer spinning1;
    public ModelRenderer spinning2;
    public ModelRenderer bodyConnector;
    public ModelRenderer body2;
    public ModelRenderer headConnector;
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer head3;

    public ModelTerranianProtector() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.bodyConnector = new ModelRenderer(this, 64, 100);
        this.bodyConnector.setRotationPoint(2.0F, -2.0F, 2.0F);
        this.bodyConnector.addBox(-8.0F, 0.0F, -8.0F, 12, 2, 12, 0.0F);
        this.arm6 = new ModelRenderer(this, 0, 40);
        this.arm6.setRotationPoint(2.0F, 0.0F, -4.0F);
        this.arm6.addBox(6.0F, 0.0F, 6.0F, 4, 16, 4, 0.0F);
        this.arm1 = new ModelRenderer(this, 0, 40);
        this.arm1.setRotationPoint(2.0F, 0.0F, 8.0F);
        this.arm1.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4, 0.0F);
        this.head2 = new ModelRenderer(this, 40, 20);
        this.head2.setRotationPoint(-12.0F, -11.0F, 0.0F);
        this.head2.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8, 0.0F);
        this.arm5 = new ModelRenderer(this, 0, 40);
        this.arm5.setRotationPoint(2.0F, 0.0F, -12.0F);
        this.arm5.addBox(6.0F, 0.0F, 6.0F, 4, 16, 4, 0.0F);
        this.arm8 = new ModelRenderer(this, 0, 40);
        this.arm8.setRotationPoint(-18.0F, 0.0F, -12.0F);
        this.arm8.addBox(6.0F, 0.0F, 6.0F, 4, 16, 4, 0.0F);
        this.spinning1 = new ModelRenderer(this, 80, 0);
        this.spinning1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spinning1.addBox(16.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.body1 = new ModelRenderer(this, 0, 80);
        this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body1.addBox(-8.0F, 0.0F, -8.0F, 16, 10, 16, 0.0F);
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.setRotationPoint(0.0F, -22.0F, 0.0F);
        this.head1.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8, 0.0F);
        this.arm4 = new ModelRenderer(this, 0, 40);
        this.arm4.setRotationPoint(2.0F, 0.0F, -12.0F);
        this.arm4.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4, 0.0F);
        this.spinning2 = new ModelRenderer(this, 80, 0);
        this.spinning2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spinning2.addBox(16.0F, 12.0F, 0.0F, 2, 4, 2, 0.0F);
        this.head3 = new ModelRenderer(this, 40, 20);
        this.head3.setRotationPoint(12.0F, -11.0F, 0.0F);
        this.head3.addBox(-4.0F, 0.0F, -4.0F, 8, 8, 8, 0.0F);
        this.arm3 = new ModelRenderer(this, 0, 40);
        this.arm3.setRotationPoint(-6.0F, 0.0F, -12.0F);
        this.arm3.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4, 0.0F);
        this.arm7 = new ModelRenderer(this, 0, 40);
        this.arm7.setRotationPoint(-18.0F, 0.0F, -4.0F);
        this.arm7.addBox(6.0F, 0.0F, 6.0F, 4, 16, 4, 0.0F);
        this.arm2 = new ModelRenderer(this, 0, 40);
        this.arm2.setRotationPoint(-6.0F, 0.0F, 8.0F);
        this.arm2.addBox(0.0F, 0.0F, 0.0F, 4, 16, 4, 0.0F);
        this.body2 = new ModelRenderer(this, 40, 50);
        this.body2.setRotationPoint(0.0F, -12.0F, 0.0F);
        this.body2.addBox(-8.0F, 0.0F, -8.0F, 16, 10, 16, 0.0F);
        this.headConnector = new ModelRenderer(this, 64, 100);
        this.headConnector.setRotationPoint(2.0F, -14.0F, 2.0F);
        this.headConnector.addBox(-8.0F, 0.0F, -8.0F, 12, 2, 12, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.bodyConnector.render(f5);
        this.arm6.render(f5);
        this.arm1.render(f5);
        this.head2.render(f5);
        this.arm5.render(f5);
        this.arm8.render(f5);
        this.spinning1.render(f5);
        this.body1.render(f5);
        this.head1.render(f5);
        this.arm4.render(f5);
        this.spinning2.render(f5);
        this.head3.render(f5);
        this.arm3.render(f5);
        this.arm7.render(f5);
        this.arm2.render(f5);
        this.body2.render(f5);
        this.headConnector.render(f5);
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
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) 
	{
		this.head1.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head1.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.head1.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head1.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.head2.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head2.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.head3.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head3.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.spinning1.rotateAngleY = par2/15;
		this.spinning2.rotateAngleY = par2/15;
		float f6;
		float f7;
	}
}
