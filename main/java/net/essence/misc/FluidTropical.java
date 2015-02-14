package net.essence.misc;

import net.essence.client.render.StillLiquidTexture;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fluids.Fluid;

public class FluidTropical extends Fluid {

	@SuppressWarnings("THIS")
	public FluidTropical(String fluidName) {
		super(fluidName);
		//setFlowingIcon(new StillLiquidTexture(""), new FlowingLiquidTexture());
	}
}