package net.essence.blocks.tileentity;

import net.essence.EssenceItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileEntitySummoningTable extends TileEntity implements IUpdatePlayerListBox, IInventory {

	private ItemStack[] inventory;

	public TileEntitySummoningTable() {
		this.inventory = new ItemStack[7];
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();
		for(int i = 0; i < inventory.length; i++) {
			if(this.inventory[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		for(int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			if(b0 >= 0 && b0 < this.inventory.length)
				this.inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		} 
	}

	@Override
	public void update() {
		/*if(inventory[0] != null && inventory[1] != null && inventory[2] != null && inventory[3] != null && inventory[4] != null && inventory[5] != null && inventory[6] != null) {
			Item item1 = inventory[0].getItem(), item2 = inventory[1].getItem(), item3 = inventory[2].getItem(), item4 = inventory[3].getItem(), item5 = inventory[4].getItem(), item6 = inventory[5].getItem(), item7 = inventory[6].getItem();
			if(item1 == EssenceItems.boilPowder && item2 == EssenceItems.boilPowder && item3 == EssenceItems.boilPowder && item4 == EssenceItems.blazingFireball && item5 == EssenceItems.boilPowder && item6 == EssenceItems.boilPowder && item7 == EssenceItems.boilPowder) {
				inventory[3].setItem(EssenceItems.blazierOrb);
			}
		}*/
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public String getName() {
		return "Summoning Table";
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(inventory[i] != null) {
			if(inventory[i].stackSize <= j) {
				ItemStack itemstack = inventory[i];
				inventory = null;
				return itemstack;
			} else {
				inventory[i].stackSize -= j;
				return new ItemStack(inventory[i].getItem(), j, inventory[i].getMetadata());
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if(this.inventory[index] != null)  {
			ItemStack itemstack = inventory[index];
			this.inventory = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
		this.inventory[index] = stack;
		if(stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();
		if(index == 0 && !flag) this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) { }

	@Override
	public void closeInventory(EntityPlayer player) { }

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return stack.getItem() != null;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) { }

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		for(int i = 0; i < getSizeInventory(); i++) inventory[i] = null;
	}
}