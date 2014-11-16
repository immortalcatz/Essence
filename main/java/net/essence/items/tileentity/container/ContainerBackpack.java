package net.essence.items.tileentity.container;

import net.essence.items.tileentity.TileEntityBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerBackpack extends Container {

	TileEntityBackpack backpack;
	
	public ContainerBackpack(IInventory ii, TileEntityBackpack pack) {
		int j;
		int k; 
		backpack = pack;

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(pack, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}
		
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(ii, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + j));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(ii, j, 8 + j * 18, 161 + j));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}