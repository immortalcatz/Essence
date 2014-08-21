package net.essence.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.essence.EssenceBlocks;
import net.essence.util.LangRegistry;
import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFire extends BlockFire {

	@SideOnly(Side.CLIENT)
    private IIcon[] tex;
	
    public BlockModFire(String name) {
    	setLightLevel(1.0F);
        setBlockName(name);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
    }

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		if(world.provider.dimensionId > 0 || !EssenceBlocks.eucaPortal.makePortal(world, x, y, z)) {
			if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) world.setBlockToAir(x, y, z);
			else world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(world.provider.dimensionId > 0 || !EssenceBlocks.depthsPortal.makePortal(world, x, y, z)) {
			if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) world.setBlockToAir(x, y, z);
			else world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
		}
		if(world.provider.dimensionId > 0 || !EssenceBlocks.boilPortal.makePortal(world, x, y, z)) {
			if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) world.setBlockToAir(x, y, z);
			else world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
		}
	}

	protected boolean canNeighborBurn(World world, int x, int y, int z) {
		return this.canCatchFire(world, x + 1, y, z, WEST) || this.canCatchFire(world, x - 1, y, z, EAST) || this.canCatchFire(world, x, y - 1, z, UP) ||
				this.canCatchFire(world, x, y + 1, z, DOWN) || this.canCatchFire(world, x, y, z - 1, SOUTH) || this.canCatchFire(world, x, y, z + 1, NORTH);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.tex[0];
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(int meta) {
        return this.tex[meta];
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.tex = new IIcon[] {icon.registerIcon("fire_layer_0"), icon.registerIcon("fire_layer_1")};
    }
}