package net.journey.client.render.mob;

import net.journey.client.render.RenderBoss;
import net.journey.entity.mob.boss.EntityEudor;
import net.journey.util.Textures;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEudor extends RenderBoss {

	private ResourceLocation texture;
	
	public RenderEudor(ModelBase model, float shadow, float size, ResourceLocation tex, int bossID) {
		super(model, shadow, size, tex, bossID);
		texture = tex;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		EntityEudor e = (EntityEudor)var1;
		return e.isInv() ? Textures.blank : texture;
	}
}