package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEucaWater extends WorldGenerator {
	
	private final Block block;
	private final boolean update;

	public WorldGenEucaWater(Block block, boolean update) {
		this.block = block;
		this.update = update;
	}

	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		Block genOn = EssenceBlocks.eucaStone;
		if (w.getBlockState(p.offsetUp()).getBlock() != genOn) {
			return false;
		}
		else if (w.getBlockState(p).getBlock().getMaterial() != Material.air && w.getBlockState(p).getBlock() != genOn) {
			return false;
		} else {
			int i = 0;
			if(w.getBlockState(p.offsetWest()).getBlock() == genOn) ++i;          
			if(w.getBlockState(p.offsetEast()).getBlock() == genOn) ++i;         
			if(w.getBlockState(p.offsetNorth()).getBlock() == genOn) ++i;           
			if(w.getBlockState(p.offsetSouth()).getBlock() == genOn) ++i;           
			if(w.getBlockState(p.offsetDown()).getBlock() == genOn) ++i;            
			int j = 0;
			if(w.isAirBlock(p.offsetWest())) ++j;           
			if(w.isAirBlock(p.offsetEast())) ++j;           
			if(w.isAirBlock(p.offsetNorth())) ++j;
			if(w.isAirBlock(p.offsetSouth())) ++j;            
			if(w.isAirBlock(p.offsetDown())) ++j;           
			if(!this.update && i == 4 && j == 1 || i == 5) {
				w.setBlockState(p, this.block.getDefaultState(), 2);
				w.func_175637_a(this.block, p, r);
			}
			return true;
		}
	}
}