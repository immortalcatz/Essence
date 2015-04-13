package net.essence.client.render.model.mob.corba;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOverseerElder extends ModelBase
{
  //fields
    ModelRenderer Head1;
    ModelRenderer Head2;
    ModelRenderer Head3;
    ModelRenderer Head4;
    ModelRenderer Junction1;
    ModelRenderer Junction2;
  
  public ModelOverseerElder()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Head1 = new ModelRenderer(this, 0, 0);
      Head1.addBox(0F, 0F, 0F, 16, 16, 16);
      Head1.setRotationPoint(-8F, -8F, -8F);
      Head1.setTextureSize(128, 64);
      Head1.mirror = true;
      setRotation(Head1, 0F, 0F, 0F);
      Head2 = new ModelRenderer(this, 0, 0);
      Head2.addBox(0F, 0F, 0F, 16, 16, 16);
      Head2.setRotationPoint(8F, -24F, -8F);
      Head2.setTextureSize(128, 64);
      Head2.mirror = true;
      setRotation(Head2, 0F, 0F, 0F);
      Head3 = new ModelRenderer(this, 0, 0);
      Head3.addBox(0F, 0F, 0F, 16, 16, 16);
      Head3.setRotationPoint(-24F, -24F, -8F);
      Head3.setTextureSize(128, 64);
      Head3.mirror = true;
      setRotation(Head3, 0F, 0F, 0F);
      Head4 = new ModelRenderer(this, 0, 0);
      Head4.addBox(0F, 0F, 0F, 16, 16, 16);
      Head4.setRotationPoint(-8F, -40F, -8F);
      Head4.setTextureSize(128, 64);
      Head4.mirror = true;
      setRotation(Head4, 0F, 0F, 0F);
      Junction1 = new ModelRenderer(this, 0, -4);
      Junction1.addBox(0F, 0F, 0F, 4, 16, 4);
      Junction1.setRotationPoint(-2F, -24F, -2F);
      Junction1.setTextureSize(128, 64);
      Junction1.mirror = true;
      setRotation(Junction1, 0F, 0F, 0F);
      Junction2 = new ModelRenderer(this, 0, 52);
      Junction2.addBox(0F, 0F, 0F, 16, 4, 4);
      Junction2.setRotationPoint(-8F, -18F, -2F);
      Junction2.setTextureSize(128, 64);
      Junction2.mirror = true;
      setRotation(Junction2, 0F, 0F, 0F);
  }
  
  private void setRotation(ModelRenderer head2, float f, float g, float h) {
		
}
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head1.render(f5);
    Head2.render(f5);
    Head3.render(f5);
    Head4.render(f5);
    Junction1.render(f5);
    Junction2.render(f5);
  }
  
  private void setRotation(ModelRenderer head2, float f, float g, float h) {
		
}

@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			super.render(entity, f, f1, f2, f3, f4, f5);
			setRotationAngles(f, f1, f2, f3, f4, f5, entity);
			Head.render(f5);

  }

}
