package net.journey.items;

import java.util.Iterator;
import java.util.List;

import net.journey.JourneyTabs;
import net.journey.blocks.tileentity.TileEntityJourneyChest;
import net.journey.client.server.DarkEnergyBar;
import net.journey.client.server.EssenceBar;
import net.journey.entity.projectile.EntityBasicProjectile;
import net.journey.enums.EnumSounds;
import net.journey.util.LangHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemStorage extends ItemMod {

	protected int usage;
	protected int damage;
	protected boolean essence, unBreakable;
	protected Class<? extends EntityBasicProjectile> projectile; 

	public ItemStorage(String name, String f, boolean essence, int magic, int uses, int dam, boolean unbreakable, Class<? extends EntityBasicProjectile> projectile) {
		super(name, f);
		setMaxDamage(uses);
		setMaxStackSize(1);
		setFull3D();
		setCreativeTab(JourneyTabs.util);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		//EnumSounds.playSound(EnumSounds.CHEST_OPEN_0, worldIn, playerIn);
				EnumSounds.playSound(EnumSounds.CHEST_OPEN, world, player);
		        if (world.isRemote)
		        {
		            ILockableContainer ilockablecontainer = this.getLockableContainer(world, null);

		            if (ilockablecontainer != null)
		            {
		                player.displayGUIChest(ilockablecontainer);
		            }
		        }
				return stack;
		    }

		    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
		    {
		        TileEntity tileentity = worldIn.getTileEntity(pos);

		        if (!(tileentity instanceof TileEntityJourneyChest))
		        {
		            return null;
		        }
		        else
		        {
		            Object object = (TileEntityJourneyChest)tileentity;

		            if (this.isBlocked(worldIn, pos))
		            {
		                return null;
		            }
		            else
		            {
		                Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

		                while (iterator.hasNext())
		                {
		                    EnumFacing enumfacing = (EnumFacing)iterator.next();
		                    BlockPos blockpos1 = pos.offset(enumfacing);
		                    Block block = worldIn.getBlockState(blockpos1).getBlock();
		                    {
		                        if (this.isBlocked(worldIn, blockpos1))
		                        {
		                            return null;
		                        }

		                        TileEntity tileentity1 = worldIn.getTileEntity(blockpos1);

		                        if (tileentity1 instanceof TileEntityJourneyChest)
		                        {
		                            if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
		                            {
		                                object = new InventoryLargeChest("container.chestDouble", (ILockableContainer)object, (TileEntityJourneyChest)tileentity1);
		                            }
		                            else
		                            {
		                                object = new InventoryLargeChest("container.chestDouble", (TileEntityJourneyChest)tileentity1, (ILockableContainer)object);
		                            }
		                        }
		                    }
		                }

		                return (ILockableContainer)object;
		            }
		        }
		    }

		    public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
		    {
		        {
		            return 0;
		        }
		    }

		    public int isProvidingStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
		    {
		        return side == EnumFacing.UP ? this.isProvidingWeakPower(worldIn, pos, state, side) : 0;
		    }

		    private boolean isBlocked(World worldIn, BlockPos pos)
		    {
		        return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
		    }

		    private boolean isBelowSolidBlock(World worldIn, BlockPos pos)
		    {
		        return worldIn.isSideSolid(pos.up(), EnumFacing.DOWN, false);
		    }

		    private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos)
		    {
		        Iterator iterator = worldIn.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB((double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 2), (double)(pos.getZ() + 1))).iterator();
		        EntityOcelot entityocelot;

		        do
		        {
		            if (!iterator.hasNext())
		            {
		                return false;
		            }

		            Entity entity = (Entity)iterator.next();
		            entityocelot = (EntityOcelot)entity;
		        }
		        while (!entityocelot.isSitting());

		        return true;
		    }

		    public boolean hasComparatorInputOverride()
		    {
		        return true;
		    }

		    public int getComparatorInputOverride(World worldIn, BlockPos pos)
		    {
		        return Container.calcRedstoneFromInventory(this.getLockableContainer(worldIn, pos));
		    }
{
	}
}