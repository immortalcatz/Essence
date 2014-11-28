package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.minecraft.block.BlockLadder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.SlayerAPI;

public class BlockModLadder extends BlockLadder { 
    
	public BlockModLadder(String name) {
        setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.blocks);
        GameRegistry.registerBlock(this, name);
	}
}