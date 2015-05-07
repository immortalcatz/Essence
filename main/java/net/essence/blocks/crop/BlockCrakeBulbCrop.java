package net.essence.blocks.crop;

import net.essence.EssenceItems;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;
import net.slayer.api.block.BlockModCrop;

public class BlockCrakeBulbCrop extends BlockModCrop {

	public BlockCrakeBulbCrop(String name) {
		super(name);
	}

	@Override
	public PropertyInteger getAge() {
		return PropertyInteger.create("age", 0, 4);
	}
	
	@Override
	public Item getSeed() {
		return EssenceItems.crakeBulbSeeds;
	}

	@Override
	public Item getCrop() {
		return EssenceItems.crakeBulb;
	}

	@Override
	public int getStages() {
		return 4;
	}
}