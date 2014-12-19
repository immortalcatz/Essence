package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockModFire extends BlockMod {
	
    public BlockModFire(String name) {
    	super(EnumMaterialTypes.FIRE, name, 0.0F);
    	setLightLevel(1.0F);
        setUnlocalizedName(name);
    }
    
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World w, BlockPos pos, IBlockState s) {
		return null;
	}
	
	@Override
	public boolean isFullBlock() {
		return false;
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
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(!(entityIn instanceof EntityItem)) entityIn.setFire(6);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
		if(!(entityIn instanceof EntityItem)) entityIn.setFire(6);
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState s) {
		if(!EssenceBlocks.eucaPortal.makePortal(world, pos)) {
			if(!World.doesBlockHaveSolidTopSurface(world, pos.down())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(!EssenceBlocks.depthsPortal.makePortal(world, pos)) {
			if(!World.doesBlockHaveSolidTopSurface(world, pos.down())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(!EssenceBlocks.boilPortal.makePortal(world, pos)) {
			if(!World.doesBlockHaveSolidTopSurface(world, pos.down())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(!EssenceBlocks.frozenPortal.makePortal(world, pos)) {
			if(!World.doesBlockHaveSolidTopSurface(world, pos.down())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
	}
}