package net.essence.blocks;

import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityStatue;
import net.essence.client.EnumSounds;
import net.essence.client.render.mob.model.statue.ModelStatue;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockStatue extends BlockMod {

	protected ModelStatue model;
	protected ResourceLocation texture;
	protected EnumSounds sound;

	public BlockStatue(String name, ModelStatue model, EnumSounds s) {
		super(name, 3.0F);
		setCreativeTab(EssenceTabs.decoraton);
		this.texture = new ResourceLocation(SlayerAPI.PREFIX + "textures/models/statues/" + name + ".png");
		this.model = model;
		this.sound = s;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(World w, BlockPos pos) {
		Block b = (Block) w.getBlockState(pos);
		float f = 0.0625F;
		AxisAlignedBB bb = null;
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1F, y + 1.9F, z + 1F);
	}
	
	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!w.isRemote) EnumSounds.playSound(sound.getPrefixedName(), w, p);
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		Block b = worldIn.getBlockState(pos).getBlock();
		float f = 0.0625F;
		AxisAlignedBB bb = null;

		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1F, y + 1.9F, z + 1F);
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityStatue(texture, model);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
		int l = ((MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 1) % 4;
		int i1 = w.getBlockMetadata(x, y, z);
		if(l == 0) w.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if(l == 1) w.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if(l == 2) w.setBlockMetadataWithNotify(x, y, z, 1, 2);
		if(l == 3) w.setBlockMetadataWithNotify(x, y, z, 0, 2);
	}
}