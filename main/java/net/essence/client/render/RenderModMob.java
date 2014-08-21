package net.essence.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderModMob extends RenderLiving {

	private ResourceLocation texture;
	
	public RenderModMob(ModelBase model, float shadow, ResourceLocation tex) {
		super(model, shadow);
		texture = tex;
	}
	
	public RenderModMob(ModelBase model, ResourceLocation tex) {
		this(model, 0.5F, tex);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
}