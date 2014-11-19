package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.util.IIcon;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModBookshelf extends BlockBookshelf {
	
	private Block tex;

    public BlockModBookshelf(String name, Block top) {
        this.tex = top;
        setBlockTextureName(SlayerAPI.PREFIX + name);
        setBlockName(name);
        setCreativeTab(EssenceTabs.blocks);
        setStepSound(Block.soundTypeWood);
        GameRegistry.registerBlock(this, name);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side != 1 && side != 0 ? super.getIcon(side, meta) : tex.getBlockTextureFromSide(side);
    }
}