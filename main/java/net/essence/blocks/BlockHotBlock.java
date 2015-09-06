package net.essence.blocks;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.block.BlockMod;

public class BlockHotBlock extends BlockMod {

	public BlockHotBlock(String name, String f, boolean light) {
		super(name, f, -1.0F);
		if (light)
			setLightLevel(0.5F);
	}

	public BlockHotBlock(String name, String f) {
		this(name, f, false);

	}

	@Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side)
    {
		return true;
	}
}