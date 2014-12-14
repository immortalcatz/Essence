package net.essence.enums;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumOres {

	HELLSTONE(EssenceBlocks.hellstoneOre, EssenceItems.hellstoneDust, EssenceItems.hellstoneIngot);
	
	public Block ore;
	public Item dust, ingot;
	
	private EnumOres(Block ore, Item dust, Item ingot) {
		this.ore = ore;
		this.dust = dust;
		this.ingot = ingot;
	}
}