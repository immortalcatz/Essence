package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.slayer.api.block.BlockMod;

public class BlockModOre extends BlockMod {

	public BlockModOre(String name, float hardness) {
		super(name, hardness);
	}

	@Override
	public Item getItemDropped(int par1, Random par2, int par3) {
		if(this == EssenceBlocks.ashual) return EssenceItems.ash;
		if(this == EssenceBlocks.magneticOre) return EssenceItems.magnet;
		return Item.getItemFromBlock(this);
	}
}