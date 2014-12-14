package net.essence.blocks.tileentity;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.slayer.api.SlayerAPI;

public class TileEntityGrindstone extends TileEntity implements IUpdatePlayerListBox {

	public Item itemOnGrind = null;
	public int state = 0;
	public float rotation = 0.0F;
	public boolean isActive = false;

	public TileEntityGrindstone() { }

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("ItemOnGrind", itemOnGrind.getIdFromItem(itemOnGrind));
		nbt.setInteger("GrindItemState", state);
		nbt.setBoolean("active", isActive);
		nbt.setFloat("Rotation", rotation);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		itemOnGrind = Item.getItemById(nbt.getInteger("ItemOnGrind"));
		state = nbt.getInteger("GrindItemState");
		isActive = nbt.getBoolean("active");
		rotation = nbt.getFloat("Rotation");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		this.writeToNBT(var1);
		return new S35PacketUpdateTileEntity(pos, 1, var1);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	}
	
	public boolean isActivated() {
		return isActive;
	}
	
	public float getRotaton() {
		return rotation;
	}
	
	public void setActivated(boolean a) {
		isActive = a;
	}

	public boolean blockHit(int f, EntityPlayer player) {
		boolean returnVal = false;
		int count = 0;
		if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.celestiumOre)) {
			count += f;
			if(count >= 15) {
				count = 0;
				state++;
				returnVal = true;
				EnumSounds.playSound("random.anvil_land", worldObj, this);
				if(state == 3) {
					state = 0;
					count = 0;
					itemOnGrind = EssenceItems.celestiumDust;
				}
			}
			else if(itemOnGrind == EssenceItems.celestiumDust){
				count += f;
				if(count >= 5) {
					SlayerAPI.giveItemStackToPlayer(player, 1, new ItemStack(itemOnGrind));
				}
			}
		} else {
			itemOnGrind = null;
			state = 0;
			count = 0;
		}
		return returnVal;
	}

	@Override
	public void update() {
		if(worldObj.isBlockPowered(getPos())) {
			setActivated(true);
			rotation += 20.0F;
		} else {
			setActivated(false);
		}
		
		if(rotation == 360F) rotation = 0.0F;
	}
}