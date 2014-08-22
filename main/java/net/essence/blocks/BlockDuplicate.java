package net.essence.blocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.slayer.api.block.BlockMod;

public class BlockDuplicate extends BlockMod {

	public BlockDuplicate(String name) {
		super(name, 50.0F);
	}

	@Override
	public void breakBlock(World w, int x, int y, int z, Block b, int m) {
		Block underneath = w.getBlock(x, y - 1, z);
		w.setBlock(x, y, x, underneath, m, 2);
	}
}