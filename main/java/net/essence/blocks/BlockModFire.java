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