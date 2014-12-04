package net.essence.dimension.euca.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEucaPlant extends WorldGenerator {
	
    private Block flower;

    public WorldGenEucaPlant(Block b) {
    	this.flower = b;
    }

    @Override
    public boolean generate(World w, Random r, BlockPos p) {
        for(int i = 0; i < 64; ++i) {
            BlockPos blockpos1 = p.add(r.nextInt(8) - r.nextInt(8), r.nextInt(4) - r.nextInt(4), r.nextInt(8) - r.nextInt(8));
            if(w.isAirBlock(blockpos1) && (!w.provider.getHasNoSky() || blockpos1.getY() < 255)) {
                w.setBlockState(blockpos1, flower.getDefaultState());
            }
        }
        return true;
    }
}