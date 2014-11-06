package net.essence.client.render.mob;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderModBiped extends RenderBiped {

	private ResourceLocation tex;
	
	public RenderModBiped(ModelBiped m, ResourceLocation tex) {
		super(m, 0.5F);
		this.tex = tex;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		return tex;
	}
}