package net.essence.dimension.boil.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoilingFire extends WorldGenerator{

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		for(int i = 0; i < 20; i++){
			if(w.getBlockState(new BlockPos(pos.down())) == EssenceBlocks.hotBlock){
				w.setBlockState(pos, EssenceBlocks.boilingFire.getDefaultState(), 2);
				return true;
			}
		}
		return false;
	}
}