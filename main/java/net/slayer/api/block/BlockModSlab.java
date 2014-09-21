package net.slayer.api.block;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModSlab extends BlockSlab {

	@SideOnly(Side.CLIENT)
	private IIcon tex;
	private Block plank;
	private boolean isFull; 

	public BlockModSlab(String name, boolean isFull, Block plank) {
		super(isFull, EnumMaterialTypes.WOOD.getMaterial());
		this.plank = plank;
		this.setCreativeTab(EssenceTabs.blocks);
		setBlockName(name);
		LangRegistry.addBlock(this);
		GameRegistry.registerBlock(this, name);
		setHardness(2.0F);
		this.isFull = isFull;
		this.setLightOpacity(1);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z) {
		if(this.isFull) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return plank.getBlockTextureFromSide(side);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister i) {
		this.tex = plank.getBlockTextureFromSide(1);
		this.blockIcon = tex;
	}

	@Override
	public String func_150002_b(int meta) {
		return null;
	}

	private Block getSlab() {
		if(this == EssenceBlocks.eucaFullSlab) return EssenceBlocks.eucaSlab;
		if(this == EssenceBlocks.depthsFullSlab) return EssenceBlocks.depthsSlab;
		return this;
	}
	
	private Block getFull() {
		if(this == EssenceBlocks.eucaSlab) return EssenceBlocks.eucaFullSlab;
		if(this == EssenceBlocks.depthsSlab) return EssenceBlocks.depthsFullSlab;
		return this;
	}

	@Override
	public Item getItemDropped(int i, Random r, int j) {
		if(isFull) Item.getItemFromBlock(getSlab());
		else return Item.getItemFromBlock(this);
		return null;
	}
}