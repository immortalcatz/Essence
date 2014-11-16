package net.slayer.api.block;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.Random;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockModFlower extends BlockMod implements IPlantable {

	public BlockModFlower(String name) {
		super(EnumMaterialTypes.PLANT, name, 0.0F);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.setCreativeTab(EssenceTabs.decoraton);
	}

	@Override
	public boolean canPlaceBlockAt(World w, int x, int y, int z) {
		return super.canPlaceBlockAt(w, x, y, z) && this.canBlockStay(w, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
		super.onNeighborBlockChange(w, x, y, z, b);
		this.checkAndDropBlock(w, x, y, z);
	}

	@Override
	public void updateTick(World w, int x, int y, int z, Random p_149674_5_) {
		this.checkAndDropBlock(w, x, y, z);
	}

	protected void checkAndDropBlock(World w, int x, int y, int z) {
		if(!this.canBlockStay(w, x, y, z)) {
			this.dropBlockAsItem(w, x, y, z, w.getBlockMetadata(x, y, z), 0);
			w.setBlock(x, y, z, getBlockById(0), 0, 2);
		}
	}

	@Override
	public boolean canBlockStay(World w, int x, int y, int z) {
		return w.getBlock(x, y - 1, z).canSustainPlant(w, x, y - 1, z, ForgeDirection.UP, this);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}
}