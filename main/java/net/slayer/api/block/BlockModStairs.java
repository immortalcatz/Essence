package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModStairs extends BlockStairs {

	public BlockModStairs(Block stair, String name, boolean light) {
		super(stair, 0);
		setCreativeTab(EssenceTabs.blocks);
		setBlockName(name);
		if(light) setLightLevel(0.5F);
		this.setLightOpacity(1);
		setHardness(stair.getBlockHardness(null, 0, 0, 0));
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
	}
	
	public BlockModStairs(Block b, String n) {
		this(b, n, false);
	}
}