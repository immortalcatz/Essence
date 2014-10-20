package net.slayer.api.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;

public class WorldGenAPI {

	public static boolean isValidLocationToSpawn(int x, int y, int z, World w, Block b){
		for(int i = 0; i < x; i++) {
			for(int l = 0; l < z; l++) {
				if(w.getBlock(x + i, y, z + l) != b) {
					return false;
				}
			}
		}
		return true;
	}

	public static void addCube(int size, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < size; x1++){
			for(int z1 = 0; z1 < size; z1++){
				for(int y1 = 0; y1 < size; y1++){
					w.setBlock(x + x1, y + y1 + 1, z + z1, b);
				}
			}
		}
	}

	public static void addBlock(World w, int x, int y, int z, Block b) {
		addCube(1, w, x, y, z, b);
	}

	public static void addHollowCube(int size, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < size; x1++){
			for(int z1 = 0; z1 < size; z1++){
				for(int y1 = 0; y1 < size; y1++){
					w.setBlock(x + x1, y + y1 + 1, z + z1, b);
				}
			}
		}

		for(int x1 = 0; x1 < size - 2; x1++){
			for(int z1 = 0; z1 < size - 2; z1++){
				for(int y1 = 0; y1 < size - 2; y1++){
					w.setBlock(x + x1 + 1, y + y1 + 2, z + z1 + 1, Blocks.air);
				}
			}
		}
	}

	public static void addRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b);
				}
			}
		}
	}

	public static void addCornerlessRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		addRectangle(east, south, height, w, x, y, z, b);
		addRectangle(1, 1, height, w, x, y, z, Blocks.air);
		addRectangle(1, 1, height, w, x+east-1 , y, z, Blocks.air);
		addRectangle(1, 1, height, w, x, y, z+south-1, Blocks.air);
		addRectangle(1, 1, height, w, x+east-1, y, z+south-1, Blocks.air);
	}

	public static void addRectangleWithMetadata(int east, int south, int height, World w, int x, int y, int z, Block b, int meta){
		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b, meta, 2);
				}
			}
		}
	}

	public static void addCornerlessRectangleWithMetadata(int east, int south, int height, World w, int x, int y, int z, Block b, int meta){
		addRectangleWithMetadata(east, south, height, w, x, y, z, b, meta);
		addRectangleWithMetadata(1, 1, height, w, x, y, z, Blocks.air, meta);
		addRectangleWithMetadata(1, 1, height, w, x+east-1 , y, z, Blocks.air, meta);
		addRectangleWithMetadata(1, 1, height, w, x, y, z+south-1, Blocks.air, meta);
		addRectangleWithMetadata(1, 1, height, w, x+east-1, y, z+south-1, Blocks.air, meta);
	}

	public static void placeChestWithContents(World w, int x, int y, int z, int meta, int amountOfItems, boolean trapped, ItemStack...is){
		Random r = new Random();
		if(trapped) w.setBlock(x, y, z, Blocks.trapped_chest, meta, 2);
		else w.setBlock(x, y, z, Blocks.chest, meta, 2);
		TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
		if(chest != null && !w.isRemote){// DOESNT WORK IF GENERATING 1 ITEM
			for(int i = 0; i < chest.getSizeInventory(); i++){
				ItemStack it = is[r.nextInt(is.length) + 1];
				chest.setInventorySlotContents(chest.getSizeInventory(), it);
			}
		}
	}

	public static void placeModdedChestWithContents(World w, int x, int y, int z, int meta, int amountOfItems, Block c, ItemStack...is){
		Random r = new Random();
		w.setBlock(x, y, z, c, meta, 2);
		TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
		if(chest != null && !w.isRemote){// DOESNT WORK IF GENERATING 1 ITEM
			for(int i = 0; i < chest.getSizeInventory(); i++){
				ItemStack it = is[r.nextInt(is.length) + 1];
				chest.setInventorySlotContents(chest.getSizeInventory(), it);
			}
		}
	}

	public static void placeSignWithText(World w, int x, int y, int z, int meta, String[] text, boolean standing){
		if(standing) w.setBlock(x, y, z, Blocks.standing_sign, meta, 2);
		else w.setBlock(x, y, z, Blocks.wall_sign, meta, 2);
		TileEntitySign sign = (TileEntitySign)w.getTileEntity(x, y, z);
		if(sign != null && !w.isRemote) sign.signText = text;
	}

	public static void addHollowRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b);
				}
			}
		}

		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height - 2; y1++){
					w.setBlock(x + x1 + 1, y + y1 + 1, z + z1 + 1, Blocks.air);
				}
			}
		}
	}

	public static void addCone(World w, int height, Random r, int x, int y, int z, Block b) {
		int height1 = r.nextInt(4) + height;
		for(int i = 0; i < height1; i++) placeBlockCircle(w, x, y + i, z, height1 - i, b);
	}

	private static void placeBlockCircle(World par1World, int x, int y, int z, int radius, Block block) {
		for(float i = 0; i < radius; i += 0.5) {
			for(float j = 0; j < 2 * Math.PI * i; j += 0.5)
				par1World.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), block);
		}
	}
}