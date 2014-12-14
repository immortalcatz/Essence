package net.essence.blocks.machines;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityGrindstone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

public class BlockGrindstone extends BlockContainer {

	public BlockGrindstone(String name) {
		super(EnumMaterialTypes.STONE.getMaterial());
		setUnlocalizedName(name);
		setStepSound(soundTypeStone);
		setHardness(3.0F);
		setCreativeTab(EssenceTabs.decoraton);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGrindstone();
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullBlock() {
		return false;
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		TileEntityGrindstone stone = (TileEntityGrindstone)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote) {
			if(worldIn.isBlockPowered(pos)) {
				stone.setActivated(true);
			} else {
				stone.setActivated(false);
			}
		}
	}

	@Override
	public int getRenderType() {
		return 2;
	}

	public void setBlockBounds(int stage) {
		this.setBlockBounds(0f, 0, 0f, 1f, 0.8f, 1f);
	}

	@Override
	public boolean removedByPlayer(World world, BlockPos pos, EntityPlayer player, boolean b) {
		onBlockDestroyed(world, pos);
		return super.removedByPlayer(world, pos, player, b);
	}

	private void onBlockDestroyed(World world, BlockPos pos) {
		if(!world.isRemote) {
			if(((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind != null) {
				Item item = ((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind;
				EntityItem var3 = null;
				if(item != null) var3 = new EntityItem(world, pos.getX(), pos.getY() + maxY, pos.getZ(), new ItemStack(item));
				world.spawnEntityInWorld(var3);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) return false;
		if(((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind != null) {
			Item item = ((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind;
			if(item == null) {
				((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind = null;
				return true;
			}
			SlayerAPI.giveItemStackToPlayer(player, new Random().nextInt(2) + 1, new ItemStack(item));
			((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind = null;
			((TileEntityGrindstone) world.getTileEntity(pos)).state = 0;
		}
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == SlayerAPI.toItem(EssenceBlocks.celestiumOre)) {
			((TileEntityGrindstone) world.getTileEntity(pos)).itemOnGrind = player.getCurrentEquippedItem().getItem();
			player.getCurrentEquippedItem().stackSize--;
			world.playAuxSFX(1022, pos, 0);
			((WorldServer)world).getPlayerManager().markBlockForUpdate(pos);
			return true;
		}
		((WorldServer)world).getPlayerManager().markBlockForUpdate(pos);
		return false;
	}
}