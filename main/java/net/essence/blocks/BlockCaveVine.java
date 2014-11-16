package net.essence.blocks;

import net.minecraft.world.IBlockAccess;
import net.slayer.api.block.BlockModVine;

public class BlockCaveVine extends BlockModVine {

	public BlockCaveVine(String name) {
		super(name);
		setLightLevel(0.6F);
	}

	@Override
	public int getMixedBrightnessForBlock(IBlockAccess w, int x, int y, int z) {
		return 1000;
	}
}