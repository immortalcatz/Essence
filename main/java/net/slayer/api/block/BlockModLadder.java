package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.BlockLadder;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockModLadder extends BlockLadder { 
    
	public BlockModLadder(String name, String finalName) {
        LangRegistry.addBlock(name, finalName);
		setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.blocks);
        GameRegistry.registerBlock(this, name);
	}
}