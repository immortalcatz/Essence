package net.essence.client.render.mob;

import net.essence.client.render.RenderModMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderMage extends RenderModMob {

	public RenderMage(ModelBase model, ResourceLocation tex) {
		super(model, tex);
		this.addLayer(new LayerHeldItem(this));
	}
}