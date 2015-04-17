package net.essence.items.tileentity.container;

import net.essence.items.tileentity.TileEntityBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerBackpack extends Container {

	private World world;
	private int numRows;

	public ContainerBackpack(IInventory inventory, TileEntityBackpack entity, World w) {
		world = w;
		this.numRows = 3;
		for(int i = 0; i < 3; ++i) for(int j = 0; j < 9; ++j) this.addSlotToContainer(new Slot(entity, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		for(int i = 0; i < 3; ++i) for(int j = 0; j < 9; ++j) this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		for(int i = 0; i < 9; ++i) this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
	}

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index < this.numRows * 9)
			{
				if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
}