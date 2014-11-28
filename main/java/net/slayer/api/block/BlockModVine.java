package net.slayer.api.block;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.slayer.api.EnumMaterialTypes;

public class BlockModVine extends BlockMod implements IShearable {

    public static final PropertyBool field_176277_a = PropertyBool.create("up");
    public static final PropertyBool field_176273_b = PropertyBool.create("north");
    public static final PropertyBool field_176278_M = PropertyBool.create("east");
    public static final PropertyBool field_176279_N = PropertyBool.create("south");
    public static final PropertyBool field_176280_O = PropertyBool.create("west");
	
    public BlockModVine(String name) {
        super(EnumMaterialTypes.VINES, name, 0.0F);
        this.setTickRandomly(true);
        setCreativeTab(EssenceTabs.blocks);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public int getRenderType() {
        return 20;
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
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos)
    {
        float f = 0.0625F;
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = 1.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag = false;

        if (((Boolean)access.getBlockState(pos).getValue(field_176280_O)).booleanValue())
        {
            f4 = Math.max(f4, 0.0625F);
            f1 = 0.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
            flag = true;
        }

        if (((Boolean)access.getBlockState(pos).getValue(field_176278_M)).booleanValue())
        {
            f1 = Math.min(f1, 0.9375F);
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
            flag = true;
        }

        if (((Boolean)access.getBlockState(pos).getValue(field_176273_b)).booleanValue())
        {
            f6 = Math.max(f6, 0.0625F);
            f3 = 0.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }

        if (((Boolean)access.getBlockState(pos).getValue(field_176279_N)).booleanValue())
        {
            f3 = Math.min(f3, 0.9375F);
            f6 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }

        if (!flag && this.func_150093_a(access.getBlockState(pos.offsetUp()).getBlock()))
        {
            f2 = Math.min(f2, 0.9375F);
            f5 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
        }

        this.setBlockBounds(f1, f2, f3, f4, f5, f6);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState a) {
        return null;
    }
        
    @Override
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
    	return super.canPlaceBlockOnSide(worldIn, pos, side);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.rand.nextInt(4) == 0)
            {
                byte b0 = 4;
                int i = 5;
                boolean flag = false;
                label189:

                for (int j = -b0; j <= b0; ++j)
                {
                    for (int k = -b0; k <= b0; ++k)
                    {
                        for (int l = -1; l <= 1; ++l)
                        {
                            if (worldIn.getBlockState(pos.add(j, l, k)).getBlock() == this)
                            {
                                --i;

                                if (i <= 0)
                                {
                                    flag = true;
                                    break label189;
                                }
                            }
                        }
                    }
                }

                EnumFacing enumfacing1 = EnumFacing.random(rand);
                EnumFacing enumfacing2;

                if (enumfacing1 == EnumFacing.UP && pos.getY() < 255 && worldIn.isAirBlock(pos.offsetUp()))
                {
                    if (!flag)
                    {
                        IBlockState iblockstate2 = state;
                        Iterator iterator1 = EnumFacing.Plane.HORIZONTAL.iterator();

                        while (iterator1.hasNext())
                        {
                            enumfacing2 = (EnumFacing)iterator1.next();

                            if (rand.nextBoolean() || !this.func_150093_a(worldIn.getBlockState(pos.offset(enumfacing2).offsetUp()).getBlock()))
                            {
                                iblockstate2 = iblockstate2.withProperty(func_176267_a(enumfacing2), Boolean.valueOf(false));
                            }
                        }

                        if (((Boolean)iblockstate2.getValue(field_176273_b)).booleanValue() || ((Boolean)iblockstate2.getValue(field_176278_M)).booleanValue() || ((Boolean)iblockstate2.getValue(field_176279_N)).booleanValue() || ((Boolean)iblockstate2.getValue(field_176280_O)).booleanValue())
                        {
                            worldIn.setBlockState(pos.offsetUp(), iblockstate2, 2);
                        }
                    }
                }
                else
                {
                    BlockPos blockpos2;

                    if (enumfacing1.getAxis().isHorizontal() && !((Boolean)state.getValue(func_176267_a(enumfacing1))).booleanValue())
                    {
                        if (!flag)
                        {
                            blockpos2 = pos.offset(enumfacing1);
                            Block block1 = worldIn.getBlockState(blockpos2).getBlock();

                            if (block1.getMaterial() == Material.air)
                            {
                                enumfacing2 = enumfacing1.rotateY();
                                EnumFacing enumfacing3 = enumfacing1.rotateYCCW();
                                boolean flag1 = ((Boolean)state.getValue(func_176267_a(enumfacing2))).booleanValue();
                                boolean flag2 = ((Boolean)state.getValue(func_176267_a(enumfacing3))).booleanValue();
                                BlockPos blockpos3 = blockpos2.offset(enumfacing2);
                                BlockPos blockpos1 = blockpos2.offset(enumfacing3);

                                if (flag1 && this.func_150093_a(worldIn.getBlockState(blockpos3).getBlock()))
                                {
                                    worldIn.setBlockState(blockpos2, this.getDefaultState().withProperty(func_176267_a(enumfacing2), Boolean.valueOf(true)), 2);
                                }
                                else if (flag2 && this.func_150093_a(worldIn.getBlockState(blockpos1).getBlock()))
                                {
                                    worldIn.setBlockState(blockpos2, this.getDefaultState().withProperty(func_176267_a(enumfacing3), Boolean.valueOf(true)), 2);
                                }
                                else if (flag1 && worldIn.isAirBlock(blockpos3) && this.func_150093_a(worldIn.getBlockState(pos.offset(enumfacing2)).getBlock()))
                                {
                                    worldIn.setBlockState(blockpos3, this.getDefaultState().withProperty(func_176267_a(enumfacing1.getOpposite()), Boolean.valueOf(true)), 2);
                                }
                                else if (flag2 && worldIn.isAirBlock(blockpos1) && this.func_150093_a(worldIn.getBlockState(pos.offset(enumfacing3)).getBlock()))
                                {
                                    worldIn.setBlockState(blockpos1, this.getDefaultState().withProperty(func_176267_a(enumfacing1.getOpposite()), Boolean.valueOf(true)), 2);
                                }
                                else if (this.func_150093_a(worldIn.getBlockState(blockpos2.offsetUp()).getBlock()))
                                {
                                    worldIn.setBlockState(blockpos2, this.getDefaultState(), 2);
                                }
                            }
                            else if (block1.getMaterial().isOpaque() && block1.isFullCube())
                            {
                                worldIn.setBlockState(pos, state.withProperty(func_176267_a(enumfacing1), Boolean.valueOf(true)), 2);
                            }
                        }
                    }
                    else
                    {
                        if (pos.getY() > 1)
                        {
                            blockpos2 = pos.offsetDown();
                            IBlockState iblockstate3 = worldIn.getBlockState(blockpos2);
                            Block block = iblockstate3.getBlock();
                            IBlockState iblockstate1;
                            Iterator iterator;
                            EnumFacing enumfacing;

                            if (block.getMaterial() == Material.air)
                            {
                                iblockstate1 = state;
                                iterator = EnumFacing.Plane.HORIZONTAL.iterator();

                                while (iterator.hasNext())
                                {
                                    enumfacing = (EnumFacing)iterator.next();

                                    if (rand.nextBoolean())
                                    {
                                        iblockstate1 = iblockstate1.withProperty(func_176267_a(enumfacing), Boolean.valueOf(false));
                                    }
                                }

                                if (((Boolean)iblockstate1.getValue(field_176273_b)).booleanValue() || ((Boolean)iblockstate1.getValue(field_176278_M)).booleanValue() || ((Boolean)iblockstate1.getValue(field_176279_N)).booleanValue() || ((Boolean)iblockstate1.getValue(field_176280_O)).booleanValue())
                                {
                                    worldIn.setBlockState(blockpos2, iblockstate1, 2);
                                }
                            }
                            else if (block == this)
                            {
                                iblockstate1 = iblockstate3;
                                iterator = EnumFacing.Plane.HORIZONTAL.iterator();

                                while (iterator.hasNext())
                                {
                                    enumfacing = (EnumFacing)iterator.next();
                                    PropertyBool propertybool = func_176267_a(enumfacing);

                                    if (rand.nextBoolean() || !((Boolean)state.getValue(propertybool)).booleanValue())
                                    {
                                        iblockstate1 = iblockstate1.withProperty(propertybool, Boolean.valueOf(false));
                                    }
                                }

                                if (((Boolean)iblockstate1.getValue(field_176273_b)).booleanValue() || ((Boolean)iblockstate1.getValue(field_176278_M)).booleanValue() || ((Boolean)iblockstate1.getValue(field_176279_N)).booleanValue() || ((Boolean)iblockstate1.getValue(field_176280_O)).booleanValue())
                                {
                                    worldIn.setBlockState(blockpos2, iblockstate1, 2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private boolean func_150093_a(Block p_150093_1_)
    {
        return p_150093_1_.isFullCube() && p_150093_1_.getMaterial().blocksMovement();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState iblockstate = this.getDefaultState().withProperty(field_176277_a, Boolean.valueOf(false)).withProperty(field_176273_b, Boolean.valueOf(false)).withProperty(field_176278_M, Boolean.valueOf(false)).withProperty(field_176279_N, Boolean.valueOf(false)).withProperty(field_176280_O, Boolean.valueOf(false));
        return facing.getAxis().isHorizontal() ? iblockstate.withProperty(func_176267_a(facing.getOpposite()), Boolean.valueOf(true)) : iblockstate;
    }
    
    public static PropertyBool func_176267_a(EnumFacing p_176267_0_)
    {
        switch (BlockModVine.SwitchEnumFacing.field_177057_a[p_176267_0_.ordinal()])
        {
            case 1:
                return field_176277_a;
            case 2:
                return field_176273_b;
            case 3:
                return field_176279_N;
            case 4:
                return field_176278_M;
            case 5:
                return field_176280_O;
            default:
                throw new IllegalArgumentException(p_176267_0_ + " is an invalid choice");
        }
    }

    @Override
    public Item getItemDropped(IBlockState par1, Random rand, int par3) {
        return null;
    }

    @Override
    public int quantityDropped(Random rand) {
        return 0;
    }

    @Override
    public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return true;
    }

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return Arrays.asList(new ItemStack(this, 1));
	}
	
	static final class SwitchEnumFacing
    {
        static final int[] field_177057_a = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00002049";

        static
        {
            try
            {
                field_177057_a[EnumFacing.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                field_177057_a[EnumFacing.NORTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_177057_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_177057_a[EnumFacing.EAST.ordinal()] = 4;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_177057_a[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}