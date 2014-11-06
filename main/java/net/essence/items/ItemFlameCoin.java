package net.essence.items;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.dimension.euca.gen.WorldGenBigEucaTree;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;
import net.slayer.api.worldgen.WorldGenAPI;

public class ItemFlameCoin extends ItemMod {

	public ItemFlameCoin(String name) {
		super(name);
		setCreativeTab(EssenceTabs.util);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer p, World w, int x, int y, int z, int par7, float par8, float par9, float par10) {
		Random r = new Random();
		if(!SlayerAPI.DEVMODE) {
			if(par7 != 1 && w.getBlock(x, y + 1, z) != Blocks.air){
				return false;
			} else {
				Block block = w.getBlock(x, y, z);
				if(block == EssenceBlocks.eucaPortalFrame || block == EssenceBlocks.depthsPortalFrame || block == EssenceBlocks.boilPortalFrame){
					w.setBlock(x, y + 1, z, EssenceBlocks.fire);
					return true;
				}
				else return false;
			}
		} else {
			WorldGenAPI.addOreWorldSphere(w, 16, x, y, z, EssenceBlocks.eucaStone, EssenceBlocks.eucaDirt, EssenceBlocks.eucaGrass, 50, EssenceBlocks.celestiumOre);
		}
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add(SlayerAPI.Colour.GREEN + "Used to light portals.");
	}
}