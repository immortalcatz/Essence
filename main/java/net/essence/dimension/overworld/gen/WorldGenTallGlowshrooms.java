package net.essence.dimension.overworld.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTallGlowshrooms extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		Block top = EssenceBlocks.greenGlowshroomTop, bottom = EssenceBlocks.greenGlowshroomBottom;
		switch(r.nextInt(3)){
		case 0: 
			bottom = EssenceBlocks.greenGlowshroomBottom;
			top = EssenceBlocks.greenGlowshroomTop;
			break;
		case 1: 
			bottom = EssenceBlocks.redGlowshroomBottom;
			top = EssenceBlocks.redGlowshroomTop; 
			break;
		case 2: 
			bottom = EssenceBlocks.blueGlowshroomBottom;
			top = EssenceBlocks.blueGlowshroomTop; 
			break;
		}
		for(int i = 0; i < 50; i++) {
			if(w.getBlockState(pos.down()).getBlock().getMaterial() == Material.rock && w.getBlockState(pos) == Blocks.air.getDefaultState() && w.getBlockState(pos.up()) == Blocks.air.getDefaultState() && pos.getY() < 60) {
				w.setBlockState(pos, bottom.getDefaultState(), 2);
				w.setBlockState(pos.up(), top.getDefaultState(), 2);
			}
		}
		return true;
	}
}