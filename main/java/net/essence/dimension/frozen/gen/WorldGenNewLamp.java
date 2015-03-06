package net.essence.dimension.frozen.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNewLamp extends WorldGenerator {

	@Override
	public boolean generate(World w, Random rand, BlockPos pos) {
		if(!w.getBlockState(pos.down()).getBlock().isFullBlock())return false;
		w.setBlockState(pos, EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(3), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(5), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(6), EssenceBlocks.frozenLamp.getDefaultState());
		
		w.setBlockState(pos.up(4).east(), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).west(), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).north(), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).south(), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).east(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).west(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).north(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(4).south(2), EssenceBlocks.workshopStone.getDefaultState());
		
		w.setBlockState(pos.up(3).east(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(3).west(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(3).north(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(3).south(2), EssenceBlocks.workshopStone.getDefaultState());
		w.setBlockState(pos.up(2).east(2), EssenceBlocks.frozenLamp.getDefaultState());
		w.setBlockState(pos.up(2).west(2), EssenceBlocks.frozenLamp.getDefaultState());
		w.setBlockState(pos.up(2).north(2), EssenceBlocks.frozenLamp.getDefaultState());
		w.setBlockState(pos.up(2).south(2), EssenceBlocks.frozenLamp.getDefaultState());
		return true;
	}

}
