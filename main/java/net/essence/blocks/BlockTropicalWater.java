package net.essence.blocks;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.BlockLiquid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockTropicalWater extends BlockLiquid {

	public BlockTropicalWater(String name) {
		super(Essence.tropicalMat);
		setCreativeTab(EssenceTabs.tabBlock);
		setUnlocalizedName(name);
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public int getRenderType() {
		return 1;
	}
}