package net.essence.blocks;

import net.essence.EssenceItems;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;
import net.slayer.api.block.BlockModCrop;

public class BlockGlowaCrop extends BlockModCrop {

	public BlockGlowaCrop(String name) {
		super(name);
	}

	@Override
	public PropertyInteger getAge() {
		return PropertyInteger.create("age", 0, 4);
	}
	
	@Override
	public Item getSeed() {
		return EssenceItems.glowaSeeds;
	}

	@Override
	public Item getCrop() {
		return EssenceItems.glowa;
	}

	@Override
	public int getStages() {
		return 4;
	}
}