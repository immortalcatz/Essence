package net.essence.blocks;

import java.util.Random;

import net.essence.Essence;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.client.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class BlockIncubator extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	protected boolean active;
	protected static boolean keepInventory;
	protected Random rand = new Random();

	public BlockIncubator(String name, boolean act) {
		super(Material.rock);
		setStepSound(Block.soundTypeStone);
		if(!act) setCreativeTab(EssenceTabs.blocks);
		setUnlocalizedName(name);
		active = act;
		if(act) setLightLevel(0.875F);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public Item getItemDropped(IBlockState i, Random r, int j) {
		return SlayerAPI.toItem(this);
	}

	@Override
	public void onBlockAdded(World w, BlockPos pos, IBlockState s) {
		super.onBlockAdded(w, pos, s);
		if(!w.isRemote) {
			Block block = w.getBlockState(pos.north()).getBlock();
			Block block1 = w.getBlockState(pos.south()).getBlock();
			Block block2 = w.getBlockState(pos.west()).getBlock();
			Block block3 = w.getBlockState(pos.east()).getBlock();
			EnumFacing enumfacing = (EnumFacing)s.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			}
			else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			}
			else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			}
			else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}
			w.setBlockState(pos, s.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityIncubator furnace  = (TileEntityIncubator)w.getTileEntity(pos);
		if(!w.isRemote && furnace != null){
			if(!p.isSneaking()){
				p.openGui(Essence.instance, GuiHandler.GuiIDs.INCUBATOR.ordinal(), w, 0, 0, 0);
			}
		}
		return false;
	}

	public static void updateActiveStates(boolean active, World w, int x, int y, int z) {
		/*int meta = w.getBlockMetadata(x, y, z);
		TileEntity tileentity = w.getTileEntity(x, y, z);
		keepInventory = true;
		if(active) w.setBlock(x, y, z, FURNACEON);
		else w.setBlock(x, y, z, FURNACE);
		keepInventory = false;
		w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		if(tileentity != null) {
			tileentity.validate();
			w.setTileEntity(x, y, z, tileentity);
		}*/
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityIncubator) {
				((TileEntityIncubator)tileentity).setCustomInventoryName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if(!keepInventory) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityIncubator) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityIncubator)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(this.active) {
			EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
			double d0 = (double)pos.getX() + 0.5D;
			double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
			double d2 = (double)pos.getZ() + 0.5D;
			double d3 = 0.52D;
			double d4 = rand.nextDouble() * 0.6D - 0.3D;

			switch (BlockIncubator.SwitchEnumFacing.field_180356_a[enumfacing.ordinal()])
			{
			case 1:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case 2:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case 3:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case 4:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}
	}
	
    public static void setState(boolean active, World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        keepInventory = true;
        if (active) {
           // worldIn.setBlockState(pos, EssenceBlocks.lit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
           // worldIn.setBlockState(pos, Blocks.lit_furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        } else {
          //  worldIn.setBlockState(pos, Blocks.furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
           // worldIn.setBlockState(pos, Blocks.furnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

	@Override
	public Item getItem(World w, BlockPos pos) {
		return SlayerAPI.toItem(this);
	}

	@SideOnly(Side.CLIENT)

	static final class SwitchEnumFacing {
		static final int[] field_180356_a = new int[EnumFacing.values().length];
		private static final String __OBFID = "CL_00002111";

		static {
			try {
				field_180356_a[EnumFacing.WEST.ordinal()] = 1;
			}
			catch (NoSuchFieldError var4) {
				;
			} try {
				field_180356_a[EnumFacing.EAST.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			} try {
				field_180356_a[EnumFacing.NORTH.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			} try {
				field_180356_a[EnumFacing.SOUTH.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityIncubator();
	}
}