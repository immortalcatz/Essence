package net.essence.blocks.tileentity;

import net.essence.client.render.mob.model.ModelStatue;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityStatue extends TileEntity {

	public ResourceLocation texture;
	public ModelStatue model;

	public TileEntityStatue(ResourceLocation texture, ModelStatue model) {
		this.model = model;
		this.texture = texture;
	}
}