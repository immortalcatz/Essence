package net.essence.items;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemFlameCoin extends ItemMod {

	public ItemFlameCoin(String name) {
		super(name);
		setCreativeTab(EssenceTabs.util);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer p, World w, BlockPos pos, EnumFacing fa, float par8, float par9, float par10) {
		Random r = new Random();
		if(fa != EnumFacing.UP && w.getBlockState(pos.up()).getBlock() != Blocks.air){
			return false;
		} else {
			Block block = w.getBlockState(pos).getBlock();
			if(block == Blocks.snow ||block == EssenceBlocks.eucaPortalFrame || block == EssenceBlocks.depthsPortalFrame || block == EssenceBlocks.boilPortalFrame) {
				w.setBlockState(new BlockPos(pos.up()), EssenceBlocks.fire.getDefaultState(), 2);
				return true;
			}
			else return false;
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add(SlayerAPI.Colour.GREEN + "Used to light portals.");
	}
}