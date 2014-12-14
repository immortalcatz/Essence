package net.essence.blocks;

import net.essence.EssenceBlocks;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockModFire extends BlockFire {
	
    public BlockModFire(String name) {
    	setLightLevel(1.0F);
        setUnlocalizedName(name);
        EssenceBlocks.blockName.add(name);
        GameRegistry.registerBlock(this, name);
    }

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState s) {
		if(world.provider.getDimensionId() > 0 || !EssenceBlocks.eucaPortal.makePortal(world, pos)) {
			if (!World.doesBlockHaveSolidTopSurface(world, pos.down()) && !this.canNeighborBurn(world, pos.getX(), pos.getY(), pos.getZ())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(world.provider.getDimensionId() > 0 || !EssenceBlocks.depthsPortal.makePortal(world, pos)) {
			if (!World.doesBlockHaveSolidTopSurface(world, pos.down()) && !this.canNeighborBurn(world, pos.getX(), pos.getY(), pos.getZ())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(world.provider.getDimensionId() > 0 || !EssenceBlocks.boilPortal.makePortal(world, pos)) {
			if (!World.doesBlockHaveSolidTopSurface(world, pos.down()) && !this.canNeighborBurn(world, pos.getX(), pos.getY(), pos.getZ())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(world.provider.getDimensionId() > 0 || !EssenceBlocks.frozenPortal.makePortal(world, pos)) {
			if (!World.doesBlockHaveSolidTopSurface(world, pos.down()) && !this.canNeighborBurn(world, pos.getX(), pos.getY(), pos.getZ())) world.setBlockToAir(pos);
			else world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
		}
	}
	
	protected boolean canNeighborBurn(World world, int x, int y, int z) {
		return this.canCatchFire(world, new BlockPos(x + 1, y, z), EnumFacing.WEST) || this.canCatchFire(world, new BlockPos(x - 1, y, z), EnumFacing.EAST) || this.canCatchFire(world, new BlockPos(x, y - 1, z), EnumFacing.UP) ||
				this.canCatchFire(world, new BlockPos(x, y + 1, z), EnumFacing.DOWN) || this.canCatchFire(world, new BlockPos(x, y, z - 1), EnumFacing.SOUTH) || this.canCatchFire(world, new BlockPos(x, y, z + 1), EnumFacing.NORTH);
	}
}