package net.essence.items;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World w, int x, int y, int z, int par7, float par8, float par9, float par10) {
		Random r = new Random();
		/*if(par7 != 1){
			return false;
		} else {
			Block block = w.getBlock(x, y, z);
			if(block == EssenceBlocks.eucaPortalFrame || block == EssenceBlocks.depthsPortalFrame || block == EssenceBlocks.boilPortalFrame){
				w.setBlock(x, y + 1, z, EssenceBlocks.fire);
				return true;
			}
			else return false;
		}*/
		int i;
		y = y - 2;
		WorldGenAPI.addRectangle(4, 8, 11, w, x, y - 5, z - 2, Blocks.nether_brick);
		WorldGenAPI.addRectangle(2, 6, 3, w, x + 1, y + 2, z - 2, Blocks.air);
		WorldGenAPI.addRectangle(2, 4, 3, w, x + 1, y, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(4, 1, 1, w, x, y + 2, z - 2, Blocks.nether_brick);
		WorldGenAPI.addRectangle(2, 3, 3, w, x + 1, y - 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 1, y - 2, z + 3, Blocks.air);
		WorldGenAPI.addRectangle(2, 1, 3, w, x + 1, y - 3, z + 4, Blocks.air);
		WorldGenAPI.addRectangle(4, 6, 5, w, x, y - 5, z + 5, Blocks.nether_brick);
		WorldGenAPI.addBlock(w, x, y - 4, z + 7, Blocks.glowstone);
		WorldGenAPI.addBlock(w, x + 3, y - 4, z + 7, Blocks.glowstone);
		WorldGenAPI.addRectangle(2, 1, 1, w, x + 1, y, z + 6, Blocks.nether_brick);
		WorldGenAPI.addRectangle(2, 1, 1, w, x + 1, y, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 1, y - 1, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(16, 17, 5, w, x - 6, y - 5, z + 10, Blocks.nether_brick);
		WorldGenAPI.addRectangle(14, 14, 3, w, x - 5, y - 4, z + 11, Blocks.air);
		WorldGenAPI.addRectangle(2, 6, 3, w, x + 1, y - 4, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(4, 4, 1, w, x, y - 4, z + 16, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 1, y - 4, z + 17, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 1, y - 5, z + 17, Blocks.lava);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 9, y - 3, z + 17, Blocks.glowstone);
		WorldGenAPI.addRectangle(1, 2, 1, w, x - 6, y - 3, z + 17, Blocks.glowstone);
		WorldGenAPI.addRectangle(10, 1, 5, w, x - 3, y - 5, z + 25, EssenceBlocks.boilPortalFrame);
		WorldGenAPI.addRectangle(8, 1, 3, w, x - 2, y - 4, z + 25, EssenceBlocks.boilPortal);
		WorldGenAPI.addRectangle(2, 14, 1, w, x - 5, y - 5, z + 11, Blocks.soul_sand);
		WorldGenAPI.addRectangle(2, 14, 1, w, x + 7, y - 5, z + 11, Blocks.soul_sand);
		WorldGenAPI.addRectangle(1, 14, 3, w, x + 6, y - 4, z + 11, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(1, 14, 3, w, x - 3, y - 4, z + 11, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangleWithMetadata(2, 14, 1, w, x - 5, y - 4, z + 11, Blocks.nether_wart, 3);
		WorldGenAPI.addRectangleWithMetadata(2, 14, 1, w, x + 7, y - 4, z + 11, Blocks.nether_wart, 3);
		for(i = 0; i < 7; i++){
			w.setBlock(x + 1, y - 4 + i, z + 5 - i, Blocks.nether_brick_stairs, 3, 2);
			w.setBlock(x + 2, y - 4 + i, z + 5 - i, Blocks.nether_brick_stairs, 3, 2);
		}
		
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add(SlayerAPI.Colour.GREEN + "Used to light portals.");
	}
}