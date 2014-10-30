package net.essence.client.render.mob;

import net.essence.client.render.RenderBoss;
import net.essence.entity.mob.boss.EntityCalcia;
import net.essence.util.Textures;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCalcia extends RenderBoss {

	private ResourceLocation texture;
	
	public RenderCalcia(ModelBase model, float shadow, float size, ResourceLocation tex, int bossID) {
		super(model, shadow, size, tex, bossID);
		texture = tex;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		EntityCalcia calcia = (EntityCalcia)var1;
		return calcia.isInv() ? Textures.blank : texture;
	}
}