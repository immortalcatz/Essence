package net.essence.blocks;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockBoilingFire extends BlockModFire {

	public BlockBoilingFire(String name) {
		super(name);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) { }
}