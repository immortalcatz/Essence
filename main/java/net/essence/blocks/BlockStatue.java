package net.essence.blocks;

import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityStatue;
import net.essence.client.EnumSounds;
import net.essence.client.render.mob.model.statue.ModelStatue;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockStatue extends BlockContainer {

	protected ModelStatue model;
	protected ResourceLocation texture;
	protected EnumSounds sound;
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockStatue(String name, ModelStatue model, EnumSounds s) {
		super(EnumMaterialTypes.STONE.getMaterial());
		setUnlocalizedName(name);
		setStepSound(soundTypeStone);
		setHardness(3.0F);
		setCreativeTab(EssenceTabs.decoraton);
		this.texture = new ResourceLocation(SlayerAPI.PREFIX + "textures/models/statues/" + name + ".png");
		this.model = model;
		this.sound = s;
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(World w, BlockPos pos) {
		return AxisAlignedBB.fromBounds(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1F, pos.getY() + 1.9F, pos.getZ() + 1F);
	}

	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!w.isRemote) EnumSounds.playSound(sound.getPrefixedName(), w, p);
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return AxisAlignedBB.fromBounds(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1F, pos.getY() + 1.9F, pos.getZ() + 1F);
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityStatue(texture, model);
	}

	@Override
	public int getRenderType() {
		return 2;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
		state = state.withProperty(FACING, enumfacing);
		BlockPos blockpos1 = pos.north();
		BlockPos blockpos2 = pos.south();
		BlockPos blockpos3 = pos.west();
		BlockPos blockpos4 = pos.east();
		boolean flag = this == worldIn.getBlockState(blockpos1).getBlock();
		boolean flag1 = this == worldIn.getBlockState(blockpos2).getBlock();
		boolean flag2 = this == worldIn.getBlockState(blockpos3).getBlock();
		boolean flag3 = this == worldIn.getBlockState(blockpos4).getBlock();

		if(!flag && !flag1 && !flag2 && !flag3) worldIn.setBlockState(pos, state, 2);

		else if(enumfacing.getAxis() == EnumFacing.Axis.X && (flag || flag1)) {
			if(flag) worldIn.setBlockState(blockpos1, state, 2);
			else worldIn.setBlockState(blockpos2, state, 2);
			worldIn.setBlockState(pos, state, 2);
		}
		
		else if(enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3)) {
			if(flag2) worldIn.setBlockState(blockpos3, state, 2);
			else worldIn.setBlockState(blockpos4, state, 2);
			worldIn.setBlockState(pos, state, 2);
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);
		if(enumfacing.getAxis() == EnumFacing.Axis.Y) enumfacing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {FACING});
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityStatue(texture, model);
	}
}