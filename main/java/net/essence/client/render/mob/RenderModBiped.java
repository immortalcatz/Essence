package net.essence.client.render.mob;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderModBiped extends RenderBiped {

	private ResourceLocation tex;
	private float scale = 1.0F;
	
	public RenderModBiped(ModelBiped m, ResourceLocation tex) {
		super(Minecraft.getMinecraft().getRenderManager(), m, 0.5F);
		this.tex = tex;
	}
	
	public RenderModBiped(ModelBiped m, float size, ResourceLocation tex) {
		super(Minecraft.getMinecraft().getRenderManager(), m, 0.5F);
		this.tex = tex;
		this.scale = size;
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase var1, float var2) {
		GL11.glScalef(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		return tex;
	}
}