package net.essence.items;

import java.util.Iterator;
import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.entity.EssenceEntityList;
import net.essence.util.Helper;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class ItemSpawnEggs extends Item {

	public ItemSpawnEggs() {
		this.setHasSubtypes(true);
		GameRegistry.registerItem(this, "essenceSpawners");
		setUnlocalizedName("essenceSpawner");
		this.setCreativeTab(EssenceTabs.spawners);
		EssenceItems.itemNames.add("essenceSpawners");
	}

	@Override
	public String getItemStackDisplayName(ItemStack i) {
		String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
		String s1 = EssenceEntityList.getStringFromID(i.getItemDamage());
		if(s1 != null) s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
		return s;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack i, int j) {
		EssenceEntityList.EntityEggInfo entityegginfo = (EssenceEntityList.EntityEggInfo)EssenceEntityList.entityEggs.get(Integer.valueOf(i.getItemDamage()));
		return entityegginfo != null ? (j == 0 ? entityegginfo.primaryColor : entityegginfo.secondaryColor) : 16777215;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		}
		else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack)) {
			return false;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos);

			if (iblockstate.getBlock() == Blocks.mob_spawner) {
				TileEntity tileentity = worldIn.getTileEntity(pos);

				if (tileentity instanceof TileEntityMobSpawner) {
					MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
					mobspawnerbaselogic.setEntityName(EssenceEntityList.getStringFromID(stack.getMetadata()));
					tileentity.markDirty();
					worldIn.markBlockForUpdate(pos);

					if (!playerIn.capabilities.isCreativeMode) {
						--stack.stackSize;
					}

					return true;
				}
			}

			pos = pos.offset(side);
			double d0 = 0.0D;

			if (side == EnumFacing.UP && iblockstate instanceof BlockFence) {
				d0 = 0.5D;
			}

			Entity entity = spawnCreature(worldIn, stack.getMetadata(), (double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D);

			if (entity != null) {
				if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
					entity.setCustomNameTag(stack.getDisplayName());
				}

				if (!playerIn.capabilities.isCreativeMode) {
					--stack.stackSize;
				}
			}

			return true;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (worldIn.isRemote)
		{
			return itemStackIn;
		}
		else
		{
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

			if (movingobjectposition == null)
			{
				return itemStackIn;
			}
			else
			{
				if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
				{
					BlockPos blockpos = movingobjectposition.getBlockPos();

					if (!worldIn.isBlockModifiable(playerIn, blockpos))
					{
						return itemStackIn;
					}

					if (!playerIn.canPlayerEdit(blockpos, movingobjectposition.sideHit, itemStackIn))
					{
						return itemStackIn;
					}

					if (worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid) {
						Entity entity = spawnCreature(worldIn, itemStackIn.getMetadata(), (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.5D, (double)blockpos.getZ() + 0.5D);

						if (entity != null)
						{
							if (entity instanceof EntityLivingBase && itemStackIn.hasDisplayName())
							{
								((EntityLiving)entity).setCustomNameTag(itemStackIn.getDisplayName());
							}

							if (!playerIn.capabilities.isCreativeMode)  {
								--itemStackIn.stackSize;
							}

							playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
						}
					}
				}
				return itemStackIn;
			}
		}
	}

	public static Entity spawnCreature(World w, int id, double x, double y, double z) {
		if (!EssenceEntityList.entityEggs.containsKey(Integer.valueOf(id))) {
			return null;
		} else {
			Entity entity = null;

			for (int j = 0; j < 1; ++j) {
				entity = EssenceEntityList.createEntityByID(id, w);

				if (entity != null && entity instanceof EntityLivingBase) {
					EntityLiving entityliving = (EntityLiving)entity;
					entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(w.rand.nextFloat() * 360.0F), 0.0F);
					entityliving.rotationYawHead = entityliving.rotationYaw;
					entityliving.renderYawOffset = entityliving.rotationYaw;
					entityliving.func_180482_a(w.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
					w.spawnEntityInWorld(entity);
					entityliving.playLivingSound();
				}
			}
			return entity;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs c, List l) {
		Iterator iterator = EssenceEntityList.entityEggs.values().iterator();
		while (iterator.hasNext()) {
			EssenceEntityList.EntityEggInfo entityegginfo = (EssenceEntityList.EntityEggInfo)iterator.next();
			l.add(new ItemStack(i, 1, entityegginfo.entityID));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
		int i = stack.getItemDamage();
		switch(i) {
		case 0:
			return new ModelResourceLocation(SlayerAPI.PREFIX + "spawnerRobot", "inventory");
		}
		return null;
	}
}