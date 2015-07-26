package net.slayer.api.block;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockModFence extends BlockFence {

	public BlockModFence(Block block, String name, String finalName, boolean light) {
		super(block.getMaterial());
		LangRegistry.addBlock(name, finalName);
		setUnlocalizedName(name);
		setCreativeTab(EssenceTabs.blocks);
		if(light) setLightLevel(0.5F);
		setHardness(block.getBlockHardness(null, null));
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}
	
	public BlockModFence(Block b, String n, String finalName) {
		this(b, n, finalName, false);
	}
	
	@Override
	public boolean canConnectTo(IBlockAccess blockAccess, BlockPos pos) {
		Block block = blockAccess.getBlockState(pos).getBlock();
		 return block == Blocks.barrier ? false : ((!(block instanceof BlockFence) || block.getMaterial() != this.blockMaterial) && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.isFullCube() ? block.getMaterial() != Material.gourd : false) : true);
	}
}