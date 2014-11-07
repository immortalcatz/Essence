package net.essence.client.render.mob;

import net.essence.client.render.RenderModMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderReaper extends RenderModMob {

	public RenderReaper(ModelBase model, ResourceLocation tex) {
		super(model, tex);
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase e, float f) {
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		//super.renderEquippedItems(e, f);
		
		float f1 = 0.225F;
		//this.renderManager.itemRenderer.renderItem(e, e.getHeldItem(), 0);
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
		//GL11.glScalef(f1, -f1, f1 + 0.5F);
		GL11.glRotatef(-100.0F, 1.0F, 0.5F, 0.0F);
		GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
	}
}