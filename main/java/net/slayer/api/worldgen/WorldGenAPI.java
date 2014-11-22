package net.slayer.api.worldgen;

import java.util.ArrayList;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;

public class WorldGenAPI {

	private static Random r = new Random();

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
	
	public static Block getEucaLeaves() {
		Block leaves = null;
		switch(r.nextInt(3)) {
		case 0:
			leaves = EssenceBlocks.greenEucaLeaves;
			break;
		case 1:
			leaves = EssenceBlocks.blueEucaLeaves;
			break;
		case 2:
			leaves = EssenceBlocks.redEucaLeaves;
			break;
		}
		return leaves;
	}

	public static boolean isAirBlocks(World w, int size, int x, int y, int z) {
		boolean is = false;
		for(int x1 = 0; x1 < size; x1++) {
			for(int y1 = 0; y1 < size; y1++) {
				for(int z1 = 0; z1 < size; z1++) {
					if(w.getBlock(x + x1, y + y1, z + z1) == Blocks.air) {
						is = true;
						break;
					}
				}
			}
		}
		return is;
	}

	public static void addSpawner(World w, int x, int y, int z, String mobName) {
		w.setBlock(x, y, z, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner spawner = (TileEntityMobSpawner)w.getTileEntity(x, y, z);
		spawner.func_145881_a().setEntityName(mobName);
	}

	public static void addCube(int size, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < size; x1++){
			for(int z1 = 0; z1 < size; z1++){
				for(int y1 = 0; y1 < size; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b);
				}
			}
		}
	}

	public static void addBlock(World w, int x, int y, int z, Block b) {
		addCube(1, w, x, y + 1, z, b);
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
		addRectangleWithMetadata(1, 1, height, w, x + east - 1 , y, z, Blocks.air, meta);
		addRectangleWithMetadata(1, 1, height, w, x, y, z + south - 1, Blocks.air, meta);
		addRectangleWithMetadata(1, 1, height, w, x + east - 1, y, z + south - 1, Blocks.air, meta);
	}

	public static void placeChestWithContents(World w, int x, int y, int z, int meta, boolean trapped, ItemStack ... is) {
		Random r = new Random();
		if(trapped) w.setBlock(x, y, z, Blocks.trapped_chest, meta, 2);
		else w.setBlock(x, y, z, Blocks.chest, meta, 2);
		TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
		if(!w.isRemote && chest != null) {
			for(int i = 0; i < r.nextInt(27); i++) {
				ItemStack it = is[r.nextInt(is.length)];
				if(r.nextInt(2) == 0) chest.setInventorySlotContents(i, it);
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

	public static void addSphere(World w, int size, int x, int y, int z, Block b) {
		int XLength = x - size;
		int XHeight = x + size;
		int ZLength = z - size;
		int ZHeight = z + size;
		double realSize = size / 2;
		double sizeOfSphere = realSize * realSize;
		for(int i = XLength; i < XHeight; i++) {
			for(int j = y - size; j < y + size; j++) {
				for(int k = ZLength; k < ZHeight; k++) {
					double dx = i - x;
					double dy = j - y;
					double dz = k - z;
					if(dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
						w.setBlock(i, j + size + 3, k, b);
					}
				}
			}
		}
	}

	public static void addSphere(World w, int size, int x, int y, int z, Block bottom, Block top) {
		int XLength = x - size;
		int XHeight = x + size;
		int ZLength = z - size;
		int ZHeight = z + size;
		double realSize = size / 2;
		double sizeOfSphere = realSize * realSize;
		for(int i = XLength; i < XHeight; i++) {
			for(int j = y - size; j < y + size; j++) {
				for(int k = ZLength; k < ZHeight; k++) {
					double dx = i - x;
					double dy = j - y;
					double dz = k - z;
					if(dx * dx * 0.7 + dy * dy * 0.8 + dz * dz * 0.7 < sizeOfSphere) {
						w.setBlock(i, j + size + 3, k, bottom);
						w.setBlock(i, j + size + 4, k, top);
					}
				}
			}
		}
	}

	public static void addWorldSphere(World w, int size, int x, int y, int z, Block stone, Block dirt, Block grass) {
		int XLength = x - size;
		int XHeight = x + size;
		int ZLength = z - size;
		int ZHeight = z + size;
		double realSize = size / 2;
		double sizeOfSphere = realSize * realSize;
		for(int i = XLength; i < XHeight; i++) {
			for(int j = y - size; j < y + size; j++) {
				for(int k = ZLength; k < ZHeight; k++) {
					double dx = i - x;
					double dy = j - y;
					double dz = k - z;
					if(dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
						w.setBlock(i, j + size + 2, k, stone);
						w.setBlock(i, j + size + 3, k, dirt);
						w.setBlock(i, j + size + 4, k, grass);
					}
				}
			}
		}
	}

	public static void addOreWorldSphere(World w, int size, int x, int y, int z, Block stone, Block dirt, Block grass, int chance, Block... ores) {
		ArrayList<Block> block = new ArrayList<Block>();
		for(Block b : ores) block.add(b);
		int XLength = x - size;
		int XHeight = x + size;
		int ZLength = z - size;
		int ZHeight = z + size;
		double realSize = size / 2;
		double sizeOfSphere = realSize * realSize;
		for(int i = XLength; i < XHeight; i++) {
			for(int j = y - size; j < y + size; j++) {
				for(int k = ZLength; k < ZHeight; k++) {
					double dx = i - x;
					double dy = j - y;
					double dz = k - z;
					if(dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
						w.setBlock(i, j + size + 2, k, stone);
						w.setBlock(i, j + size + 3, k, dirt);
						w.setBlock(i, j + size + 4, k, grass);
					}
					if(w.getBlock(i, j, k) == stone) {
						if(r.nextInt(chance) == 0 && block != null) w.setBlock(i, j, k, block.get(r.nextInt(block.size())));
					}
				}
			}
		}
	}

	public static void addCone(World w, int height, Random r, int x, int y, int z, Block b) {
		int height1 = r.nextInt(4) + height;
		for(int i = 0; i < height1; i++) placeFlatCircle(w, x, y + i, z, height1 - i, b);
	}

	private static void placeFlatCircle(World par1World, int x, int y, int z, int radius, Block block) {
		for(float i = 0; i < radius; i += 0.5) {
			for(float j = 0; j < 2 * Math.PI * i; j += 0.5)
				par1World.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), block);
		}
	}
}