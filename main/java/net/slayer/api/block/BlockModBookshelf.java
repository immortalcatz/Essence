package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModBookshelf extends BlockBookshelf {
	
	private Block tex;

    public BlockModBookshelf(String name, Block top) {
        this.tex = top;
        setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.blocks);
        setStepSound(Block.soundTypeWood);
        GameRegistry.registerBlock(this, name);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side != 1 && side != 0 ? super.getIcon(side, meta) : tex.getBlockTextureFromSide(side);
    }
}