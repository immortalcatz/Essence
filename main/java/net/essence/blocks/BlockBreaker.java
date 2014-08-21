package net.essence.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.slayer.api.block.BlockMod;

public class BlockBreaker extends BlockMod {

	public BlockBreaker(String name) {
		super(name, 2.0F);
		setTickRandomly(true);
	}

	@Override
	public void updateTick(World w, int x, int y, int z, Random r) {
		int meta = w.getBlockMetadata(x, y, z);
		Block front = w.getBlock(x, y, z);
		
	}
}