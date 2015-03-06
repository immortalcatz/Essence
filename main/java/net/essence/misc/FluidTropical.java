package net.essence.misc;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.slayer.api.SlayerAPI;

public class FluidTropical extends Fluid {

	public FluidTropical(String fluidName) {
		super(fluidName);
		//setIcons(TextureTropical.createTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/blocks/tropic_still.png")), TextureTropical.createTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/blocks/tropic_flow.png")));
	}
}