package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.blocks.base.BlockModFire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockBoilingFire extends BlockModFire {

	public BlockBoilingFire(String name) {
		super(name);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) { }
	
	public boolean canBlockStay(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getBlock() == EssenceBlocks.hotBlock && worldIn.getBlockState(pos).getBlock() == Blocks.air;
	}
}