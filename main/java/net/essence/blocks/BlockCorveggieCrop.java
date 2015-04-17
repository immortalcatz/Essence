package net.essence.blocks;

import net.essence.EssenceItems;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;
import net.slayer.api.block.BlockModCrop;

public class BlockCorveggieCrop extends BlockModCrop {

	public BlockCorveggieCrop(String name) {
		super(name);
	}

	@Override
	public PropertyInteger getAge() {
		return PropertyInteger.create("age", 0, 3);
	}
	
	@Override
	public Item getSeed() {
		return EssenceItems.corveggieSeeds;
	}

	@Override
	public Item getCrop() {
		return EssenceItems.corveggies;
	}

	@Override
	public int getStages() {
		return 3;
	}
}