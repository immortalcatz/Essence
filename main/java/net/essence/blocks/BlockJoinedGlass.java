package net.essence.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockJoinedGlass extends BlockMod {

	private String[] textures = new String[16];
	private IIcon[] icons = new IIcon[16];

	public BlockJoinedGlass(String name) {
		super(EnumMaterialTypes.GLASS, name, true);
        textures[0] = SlayerAPI.PREFIX + "glass/" + name + "/glass";
        textures[1] = SlayerAPI.PREFIX + "glass/" + name + "/glass_1_d";
        textures[2] = SlayerAPI.PREFIX + "glass/" + name + "/glass_1_u";
        textures[3] = SlayerAPI.PREFIX + "glass/" + name + "/glass_1_l";
        textures[4] = SlayerAPI.PREFIX + "glass/" + name + "/glass_1_r";
        textures[5] = SlayerAPI.PREFIX + "glass/" + name + "/glass_2_h";
        textures[6] = SlayerAPI.PREFIX + "glass/" + name + "/glass_2_v";
        textures[7] = SlayerAPI.PREFIX + "glass/" + name + "/glass_2_dl";
        textures[8] = SlayerAPI.PREFIX + "glass/" + name + "/glass_2_dr";
        textures[9] = SlayerAPI.PREFIX + "glass/" + name + "/glass_2_ul";
        textures[10] = SlayerAPI.PREFIX + "glass/" + name + "/glass_2_ur";
        textures[11] = SlayerAPI.PREFIX + "glass/" + name + "/glass_3_d";
        textures[12] = SlayerAPI.PREFIX + "glass/" + name + "/glass_3_u";
        textures[13] = SlayerAPI.PREFIX + "glass/" + name + "/glass_3_l";
        textures[14] = SlayerAPI.PREFIX + "glass/" + name + "/glass_3_r";
        textures[15] = SlayerAPI.PREFIX + "glass/" + name + "/glass_4";
	}
	

	public boolean shouldConnectTo(IBlockAccess w, int x, int y, int z, Block b) {
		return b == this;
	}

	private IIcon getConnectedTexture(IBlockAccess w, int x, int y, int z, int side) {
		boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

		switch(side) {
		case 0:
			if(shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) isOpenDown = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) isOpenUp = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) isOpenLeft = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) isOpenRight = true;
			
			if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) return icons[15];
			else if(isOpenUp && isOpenDown && isOpenLeft) return icons[11];
			else if(isOpenUp && isOpenDown && isOpenRight) return icons[12];
			else if(isOpenUp && isOpenLeft && isOpenRight) return icons[13];
			else if(isOpenDown && isOpenLeft && isOpenRight) return icons[14];
			else if(isOpenDown && isOpenUp) return icons[5];
			else if(isOpenLeft && isOpenRight) return icons[6];
			else if(isOpenDown && isOpenLeft) return icons[8];
			else if(isOpenDown && isOpenRight) return icons[10];
			else if(isOpenUp && isOpenLeft) return icons[7];
			else if(isOpenUp && isOpenRight) return icons[9];
			else if(isOpenDown) return icons[3];
			else if(isOpenUp) return icons[4];
			else if(isOpenLeft) return icons[2];
			else if(isOpenRight) return icons[1];
			break;
		case 1:
			if(shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) isOpenDown = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) isOpenUp = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) isOpenLeft = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) isOpenRight = true;
			
			if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) return icons[15];
			else if(isOpenUp && isOpenDown && isOpenLeft) return icons[11];
			else if(isOpenUp && isOpenDown && isOpenRight) return icons[12];
			else if(isOpenUp && isOpenLeft && isOpenRight) return icons[13];
			else if(isOpenDown && isOpenLeft && isOpenRight) return icons[14];
			else if(isOpenDown && isOpenUp) return icons[5];
			else if(isOpenLeft && isOpenRight) return icons[6];
			else if(isOpenDown && isOpenLeft) return icons[8];
			else if(isOpenDown && isOpenRight) return icons[10];
			else if(isOpenUp && isOpenLeft) return icons[7];
			else if(isOpenUp && isOpenRight) return icons[9];
			else if(isOpenDown) return icons[3];
			else if(isOpenUp) return icons[4];
			else if(isOpenLeft) return icons[2];
			else if(isOpenRight) return icons[1];
			break;
		case 2:
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) isOpenDown = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) isOpenUp = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) isOpenLeft = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) isOpenRight = true;
			
			if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) return icons[15];
			else if(isOpenUp && isOpenDown && isOpenLeft) return icons[13];
			else if(isOpenUp && isOpenDown && isOpenRight) return icons[14];
			else if(isOpenUp && isOpenLeft && isOpenRight) return icons[11];
			else if(isOpenDown && isOpenLeft && isOpenRight) return icons[12];
			else if(isOpenDown && isOpenUp) return icons[6];
			else if(isOpenLeft && isOpenRight) return icons[5];
			else if(isOpenDown && isOpenLeft) return icons[9];
			else if(isOpenDown && isOpenRight) return icons[10];
			else if(isOpenUp && isOpenLeft) return icons[7];
			else if(isOpenUp && isOpenRight) return icons[8];
			else if(isOpenDown) return icons[1];
			else if(isOpenUp) return icons[2];
			else if(isOpenLeft) return icons[4];
			else if(isOpenRight) return icons[3];
			break;
		case 3:
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) isOpenDown = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) isOpenUp = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) isOpenLeft = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) isOpenRight = true;
			
			if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) return icons[15];
			else if(isOpenUp && isOpenDown && isOpenLeft) return icons[14];
			else if(isOpenUp && isOpenDown && isOpenRight) return icons[13];
			else if(isOpenUp && isOpenLeft && isOpenRight) return icons[11];
			else if(isOpenDown && isOpenLeft && isOpenRight) return icons[12];
			else if(isOpenDown && isOpenUp) return icons[6];
			else if(isOpenLeft && isOpenRight) return icons[5];
			else if(isOpenDown && isOpenLeft) return icons[10];
			else if(isOpenDown && isOpenRight) return icons[9];
			else if(isOpenUp && isOpenLeft) return icons[8];
			else if(isOpenUp && isOpenRight) return icons[7];
			else if(isOpenDown) return icons[1];
			else if(isOpenUp) return icons[2];
			else if(isOpenLeft) return icons[3];
			else if(isOpenRight) return icons[4];
			break;
		case 4:
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) isOpenDown = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) isOpenUp = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) isOpenLeft = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) isOpenRight = true;

			if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) return icons[15];
			else if(isOpenUp && isOpenDown && isOpenLeft) return icons[14];
			else if(isOpenUp && isOpenDown && isOpenRight) return icons[13];
			else if(isOpenUp && isOpenLeft && isOpenRight) return icons[11];
			else if(isOpenDown && isOpenLeft && isOpenRight) return icons[12];
			else if(isOpenDown && isOpenUp) return icons[6];
			else if(isOpenLeft && isOpenRight) return icons[5];
			else if(isOpenDown && isOpenLeft) return icons[10];
			else if(isOpenDown && isOpenRight) return icons[9];
			else if(isOpenUp && isOpenLeft) return icons[8];
			else if(isOpenUp && isOpenRight) return icons[7];
			else if(isOpenDown) return icons[1];
			else if(isOpenUp) return icons[2];
			else if(isOpenLeft) return icons[3];
			else if(isOpenRight) return icons[4];
			
			break;
		case 5:
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) isOpenDown = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) isOpenUp = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) isOpenLeft = true;
			if(shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) isOpenRight = true;
			
			if(isOpenUp && isOpenDown && isOpenLeft && isOpenRight) return icons[15];
			else if(isOpenUp && isOpenDown && isOpenLeft) return icons[13];
			else if(isOpenUp && isOpenDown && isOpenRight) return icons[14];
			else if(isOpenUp && isOpenLeft && isOpenRight) return icons[11];
			else if(isOpenDown && isOpenLeft && isOpenRight) return icons[12];
			else if(isOpenDown && isOpenUp) return icons[6];
			else if(isOpenLeft && isOpenRight) return icons[5];
			else if(isOpenDown && isOpenLeft) return icons[9];
			else if(isOpenDown && isOpenRight) return icons[10];
			else if(isOpenUp && isOpenLeft) return icons[7];
			else if(isOpenUp && isOpenRight) return icons[8];
			else if(isOpenDown) return icons[1];
			else if(isOpenUp) return icons[2];
			else if(isOpenLeft) return icons[4];
			else if(isOpenRight) return icons[3];
			break;
		}
		return icons[0];
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int getRenderBlockPass() {
		return 1;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public void registerBlockIcons(IIconRegister r) {
		for(int i = 0; i < textures.length; i++) {
			icons[i] = r.registerIcon(textures[i]);
		}
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2, int par3) {
		return null;
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}
	
	@Override
	public IIcon getIcon(int s, int m) {
		return icons[0];
	}
	
    @Override
    public boolean shouldSideBeRendered (IBlockAccess w, int x, int y, int z, int s) {
        return w.getBlock(x, y, z) == this ? false : super.shouldSideBeRendered(w, x, y, z, s);
    }

	@Override
	public IIcon getIcon(IBlockAccess w, int x, int y, int z, int s) {
		return getConnectedTexture(w, x, y, z, s);
	}
}