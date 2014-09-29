package net.slayer.api.block;

import java.util.Random;

import net.essence.EssenceTabs;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModGrass extends BlockMod implements IGrowable {

    protected IIcon top;
    protected IIcon bottom;
    protected IIcon side;
    protected BlockMod dirt; 
    protected String tex;

    public BlockModGrass(BlockMod dirt, String name, float hardness, String texture) {
        super(EnumMaterialTypes.GRASS, name, hardness);
        this.dirt = dirt;
        this.tex = SlayerAPI.PREFIX + texture;
        setCreativeTab(EssenceTabs.blocks);
        setBlockTextureName(SlayerAPI.PREFIX + name);
        setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int intSide, int meta) {
        return intSide == 1 ? top : (intSide == 0 ? bottom : side);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        side = icon.registerIcon(getTextureName() + "_side");
        top = icon.registerIcon(getTextureName() + "_top");
        bottom = icon.registerIcon(tex);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote) {
            if(world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) world.setBlock(x, y, z, dirt);
            else if(world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int l = 0; l < 4; ++l) {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    if(world.getBlock(i1, j1, k1) == dirt && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                        world.setBlock(i1, j1, k1, this);
                }
            }
        }
    }
    
    @Override
    public Item getItemDropped(int par1, Random par2, int par3) {
    	return Item.getItemFromBlock(dirt);
    }
    
    @Override
    public Item getItem(World w, int x, int y, int z) {
    	return Item.getItemFromBlock(dirt);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        return true;
    }

    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean flag) {
        return true;
    }

    @Override
    public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
        return true;
    }

    @Override
    public void func_149853_b(World world, Random rand, int x, int y, int z) {}
}