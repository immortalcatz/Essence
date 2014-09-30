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
			WorldGenAPI.addCube(7, w, x, y - 1, z, EssenceBlocks.hotBrick);
			WorldGenAPI.addHollowCube(5, w, x + 1, y - 2, z + 1, EssenceBlocks.hotBrick);
			WorldGenAPI.addRectangle(7, 5, 1, w, x, y + 2, z + 1, EssenceBlocks.hotGlass);
			WorldGenAPI.addRectangle(5, 7, 1, w, x + 1, y + 2, z, EssenceBlocks.hotGlass);
			WorldGenAPI.addCube(5, w, x + 1, y, z + 1, Blocks.air);
			WorldGenAPI.addRectangle(7, 7, 5, w, x, y + 4, z, Blocks.air);
			WorldGenAPI.addRectangle(5, 5, 1, w, x + 1, y + 4, z + 1, EssenceBlocks.hotBrick);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y + 4, z + 2, Blocks.air);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y + 5, z + 2, EssenceBlocks.hotGlass);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y - 1, z + 2, Blocks.flowing_lava);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y, z + 2, EssenceBlocks.hotGlass);

			switch(r.nextInt(4)) {
			case 0:
				WorldGenAPI.addRectangle(1, 1, 2, w, x + 3, y + 1, z, Blocks.air);
				ItemDoor.placeDoorBlock(w, x + 3, y + 1, z, 1, EssenceBlocks.hotDoor);
				break;
			case 1:
				WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 1, z + 3, Blocks.air);
				ItemDoor.placeDoorBlock(w, x, y + 1, z + 3, 0, EssenceBlocks.hotDoor);
				break;
			case 2:
				WorldGenAPI.addRectangle(1, 1, 2, w, x + 6, y + 1, z + 3, Blocks.air);
				ItemDoor.placeDoorBlock(w, x + 6, y + 1, z + 3, 2, EssenceBlocks.hotDoor);
				break;
			case 3:
				WorldGenAPI.addRectangle(1, 1, 2, w, x + 3, y + 1, z + 6, Blocks.air);
				ItemDoor.placeDoorBlock(w, x + 3, y + 1, z + 6, 3, EssenceBlocks.hotDoor);
				break;
			}
		}
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add(SlayerAPI.Colour.GREEN + "Used to light portals.");
	}
}