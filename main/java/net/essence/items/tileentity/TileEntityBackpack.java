package net.essence.items.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

public class TileEntityBackpack extends TileEntity implements IInventory {
    
	private ItemStack[] backpackContents = new ItemStack[27];
    private String customName;

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int s) {
        return this.backpackContents[s];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.backpackContents[i] != null) {
            ItemStack itemstack;

            if (this.backpackContents[i].stackSize <= j) {
                itemstack = this.backpackContents[i];
                this.backpackContents[i] = null;
                return itemstack;
            } else {
                itemstack = this.backpackContents[i].splitStack(j);

                if (this.backpackContents[i].stackSize == 0) {
                    this.backpackContents[i] = null;
                }
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.backpackContents[p_70304_1_] != null) {
            ItemStack itemstack = this.backpackContents[p_70304_1_];
            this.backpackContents[p_70304_1_] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack s) {
        this.backpackContents[i] = s;
        if(s != null && s.stackSize > this.getInventoryStackLimit()) {
            s.stackSize = this.getInventoryStackLimit();
        }
    }
    
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "container.backpack";
    }

    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomName(String p_145976_1_) {
        this.customName = p_145976_1_;
    }

    @Override
    public void readFromNBT(NBTTagCompound n) {
        super.readFromNBT(n);
        NBTTagList nbttaglist = n.getTagList("Items", 10);
        this.backpackContents = new ItemStack[this.getSizeInventory()];

        if (n.hasKey("CustomName", 8)) {
            this.customName = n.getString("CustomName");
        }

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.backpackContents.length) {
                this.backpackContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound n) {
        super.writeToNBT(n);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.backpackContents.length; ++i) {
            if (this.backpackContents[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.backpackContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        n.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName()) {
            n.setString("CustomName", this.customName);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p) {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack i1) {
        return true;
    }

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {
		
	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {
		
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clearInventory() {
		
	}
}