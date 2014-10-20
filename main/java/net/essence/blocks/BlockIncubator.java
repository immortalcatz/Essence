package net.essence.blocks;

import java.util.Random;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.client.GuiHandler;
import net.essence.client.GuiHandler.GuiIDs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIncubator extends BlockContainer {

	protected boolean active;
	protected static boolean keepInventory;
	protected Random rand = new Random();

	public BlockIncubator(String name, boolean act) {
		super(Material.rock);
		setStepSound(Block.soundTypeStone);
		if(!act) setCreativeTab(EssenceTabs.blocks);
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		active = act;
		LangRegistry.addBlock(this);
		if(act) setLightLevel(0.875F);
	}

	@Override
	public Item getItemDropped(int i, Random r, int j) {
		return SlayerAPI.toItem(this);
	}

	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		super.onBlockAdded(w, x, y, z);
		if(!w.isRemote) {
			int meta = 3;
			Block block = w.getBlock(x, y, z - 1), block1 = w.getBlock(x, y, z + 1), block2 = w.getBlock(x - 1, y, z), block3 = w.getBlock(x + 1, y, z);
			if(block.func_149730_j() && !block1.func_149730_j()) meta = 3;
			if(block1.func_149730_j() && !block.func_149730_j()) meta = 2;
			if(block2.func_149730_j() && !block3.func_149730_j()) meta = 5;
			if(block3.func_149730_j() && !block2.func_149730_j()) meta = 4;
			w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float j, float k, float f) {
		TileEntityIncubator furnace  = (TileEntityIncubator)w.getTileEntity(x, y, z);
		if(!w.isRemote && furnace != null){
			if(!p.isSneaking()){
				p.openGui(Essence.instance, GuiIDs.INCUBATOR.ordinal(), w, x, y, z);
			}
		}
		return false;
	}

	public static void update(boolean active, World w, int x, int y, int z) {
		/*int meta = w.getBlockMetadata(x, y, z);
		TileEntity tileentity = w.getTileEntity(x, y, z);
		keepInventory = true;
		if(active) w.setBlock(x, y, z, EssenceBlocks.incubatorActive);
		else w.setBlock(x, y, z, EssenceBlocks.incubatorIdle);
		keepInventory = false;
		w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		if(tileentity != null) {
			tileentity.validate();
			w.setTileEntity(x, y, z, tileentity);
		}*/
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase living, ItemStack item) {
		int meta = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(meta == 0) w.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if(meta == 1) w.setBlockMetadataWithNotify(x, y, z, 5, 2);
		if(meta == 2) w.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if(meta == 3) w.setBlockMetadataWithNotify(x, y, z, 4, 2);
		if(item.hasDisplayName()) ((TileEntityIncubator)w.getTileEntity(x, y, z)).setCustomName(item.getDisplayName());
	}

	@Override
	public void breakBlock(World w, int x, int y, int z, Block b, int meta) {
		if(!keepInventory) {
			TileEntityIncubator entity = (TileEntityIncubator)w.getTileEntity(x, y, z);
			if(entity != null) {
				for(int i1 = 0; i1 < entity.getSizeInventory(); ++i1) {
					ItemStack itemstack = entity.getStackInSlot(i1);
					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						while(itemstack.stackSize > 0) {
							int j1 = this.rand.nextInt(21) + 10;
							if(j1 > itemstack.stackSize) j1 = itemstack.stackSize;
							itemstack.stackSize -= j1;
							EntityItem entityitem = new EntityItem(w, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
							if(itemstack.hasTagCompound()) entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							float f3 = 0.05F;
							entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
							entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
							w.spawnEntityInWorld(entityitem);
						}
					}
				}
				w.func_147453_f(x, y, z, b);
			}
		}
		super.breakBlock(w, x, y, z, b, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, int x, int y, int z, Random r) {
		if(active) {
			int meta = w.getBlockMetadata(x, y, z);
			float f = (float)x + 0.5F;
			float f1 = (float)y + 1.1F;
			float f2 = (float)z + 0.5F;
			float f4 = r.nextFloat() * 0.6F - 0.2F;
			w.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			w.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
			w.spawnParticle("smoke", (double)(f - f4), (double)f1, (double)(f2 - f4), 0.0D, 0.0D, 0.0D);
			w.spawnParticle("flame", (double)(f - f4), (double)f1, (double)(f2 - f4), 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public Item getItem(World w, int x, int y, int z) {
		return SlayerAPI.toItem(this);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityIncubator();
	}
}