package net.essence.blocks;

import net.essence.EssenceItems;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;
import net.slayer.api.block.BlockModCrop;

public class BlockSpineberryCrop extends BlockModCrop {

	public BlockSpineberryCrop(String name) {
		super(name);
	}

	@Override
	public PropertyInteger getAge() {
		return PropertyInteger.create("age", 0, 7);
	}
	
	@Override
	public Item getSeed() {
		return EssenceItems.spineberrySeeds;
	}

	@Override
	public Item getCrop() {
		return EssenceItems.spineberries;
	}

	@Override
	public int getStages() {
		return 7;
	}
}