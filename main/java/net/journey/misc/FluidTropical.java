package net.journey.misc;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.slayer.api.SlayerAPI;

public class FluidTropical extends Fluid {

	public FluidTropical(String fluidName) {
		super(fluidName, new ResourceLocation(SlayerAPI.PREFIX + "textures/blocks/tropic_still.png"), new ResourceLocation(SlayerAPI.PREFIX + "textures/blocks/tropic_flow.png"));
	}
}