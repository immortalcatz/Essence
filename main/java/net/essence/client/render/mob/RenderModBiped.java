package net.essence.client.render.mob;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderModBiped extends RenderBiped {

	private ResourceLocation tex;
	
	public RenderModBiped(ModelBiped m, ResourceLocation tex) {
		super(Minecraft.getMinecraft().getRenderManager(), m, 0.5F);
		this.tex = tex;
	}
	
	@Override
	public void passSpecialRender(EntityLivingBase e, double d, double d1, double d2) { }

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		return tex;
	}
}