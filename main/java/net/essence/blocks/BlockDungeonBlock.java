package net.essence.blocks;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockDungeonBlock extends BlockMod {

	public BlockDungeonBlock(String name, boolean light) {
		super(name, -1.0F);
		if(light) setLightLevel(0.5F);
	}

	public BlockDungeonBlock(String name){
		this(name, false);
	}
}