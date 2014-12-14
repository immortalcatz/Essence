package net.slayer.api.block;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockModStairs extends BlockStairs {

	public BlockModStairs(Block stair, String name, boolean light) {
		super(stair.getDefaultState());
		setCreativeTab(EssenceTabs.blocks);
		setUnlocalizedName(name);
		if(light) setLightLevel(0.5F);
		this.setLightOpacity(1);
		setHardness(stair.getBlockHardness(null, null));
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public BlockModStairs(Block b, String n) {
		this(b, n, false);
	}
}