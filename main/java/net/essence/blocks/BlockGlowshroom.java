package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemBlockGlowshroom;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

public class BlockGlowshroom extends Block {

	public static String[] names = {"glowshroom_bottom", "glowshroom_top"};
	private String[] textures = {SlayerAPI.PREFIX + "glowshroom_bottom", SlayerAPI.PREFIX + "glowshroom_top"};
	//private IIcon[] icons;

	public BlockGlowshroom(String name) {
		super(EnumMaterialTypes.PLANT.getMaterial());
		setStepSound(EnumMaterialTypes.PLANT.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(0.0F);
		setLightLevel(0.6F);
		setTickRandomly(true);
		GameRegistry.registerBlock(this, ItemBlockGlowshroom.class, "glowshroom");
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return null;
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		l.add(new ItemStack(it, 1, 0));
		l.add(new ItemStack(it, 1, 1));
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public void onBlockPlacedBy(World w, BlockPos pos, IBlockState s, EntityLivingBase e, ItemStack i) {
		w.setBlockState(pos, this.getStateFromMeta(i.getItemDamage()), 2);
	}
	
	@Override
	public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos) {
		return 900;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		/*if(m == 0 && w.getBlock(x, y + 1, z) == this) {
			w.setBlock(x, y + 1, z, Blocks.air);
		}
		if(m == 1 && w.getBlock(x, y - 1, z) == this) {
			w.setBlock(x, y - 1, z, Blocks.air);
		}*/
	}

	/*@Override
	public boolean canPlaceBlockAt(World w, int x, int y, int z)  {
		return w.getBlock(x, y - 1, z) == Blocks.stone || w.getBlock(x, y - 1, z) == this;
	}

	@Override
	public boolean canBlockStay(World w, int x, int y, int z) {
		return canPlaceBlockAt(w, x, y, z);
	}*/
}