package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.BlockLadder;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModLadder extends BlockLadder { 
    
	public BlockModLadder(String name) {
	    setBlockTextureName(SlayerAPI.PREFIX + name);
        setBlockName(name);
        setCreativeTab(EssenceTabs.blocks);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
	}
}