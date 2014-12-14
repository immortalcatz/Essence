package net.essence.blocks.tileentity;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.slayer.api.SlayerAPI;

public class TileEntityGrindstone extends TileEntity implements IUpdatePlayerListBox {

	public Item itemOnGrind = null;
	public int state = 0, count = 0;
	public float rotation = 0.0F;
	public boolean isActive = false;

	public TileEntityGrindstone() { }

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("ItemOnGrind", itemOnGrind.getIdFromItem(itemOnGrind));
		nbt.setInteger("GrindItemState", state);
		nbt.setBoolean("Active", isActive);
		nbt.setFloat("Rotation", rotation);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		itemOnGrind = Item.getItemById(nbt.getInteger("ItemOnGrind"));
		state = nbt.getInteger("GrindItemState");
		isActive = nbt.getBoolean("Active");
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

	public Item getItem() {
		return itemOnGrind;
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
		if(isActivated()) {
			if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.celestiumOre)) setItem(EssenceItems.celestiumDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.hellstoneOre)) setItem(EssenceItems.hellstoneDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.luniumOre)) setItem(EssenceItems.luniumDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.shadiumOre)) setItem(EssenceItems.shadiumDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.flairiumOre)) setItem(EssenceItems.flairiumDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.ashual)) setItem(EssenceItems.ashDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.sapphireOre)) setItem(EssenceItems.sapphireDust, f, returnVal);
			else if(itemOnGrind == SlayerAPI.toItem(EssenceBlocks.enderilliumOre)) setItem(EssenceItems.enderilliumDust, f, returnVal);
			else {
				state = 0;
				count = 0;
			}
			if(itemOnGrind != null) {
				Item item = itemOnGrind;
				if(item == EssenceItems.celestiumDust || item == EssenceItems.hellstoneDust || item == EssenceItems.shadiumDust || item == EssenceItems.luniumDust || item == EssenceItems.flairiumDust
						|| item == EssenceItems.ashDust || item == EssenceItems.sapphireDust || item == EssenceItems.enderilliumDust) {
					count += f;
					if(count >= 50) {
						count = 0;
						state++;
						returnVal = true;
						worldObj.playAuxSFX(1022, pos, 0);
						if(state == 3) {
							count = 0;
							state = 0;
							if(item == SlayerAPI.toItem(EssenceBlocks.celestiumOre)) itemOnGrind = EssenceItems.celestiumDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.hellstoneOre)) itemOnGrind = EssenceItems.hellstoneDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.shadiumOre)) itemOnGrind = EssenceItems.shadiumDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.luniumOre)) itemOnGrind = EssenceItems.luniumDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.flairiumOre)) itemOnGrind = EssenceItems.flairiumDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.ashual)) itemOnGrind = EssenceItems.ashDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.sapphireOre)) itemOnGrind = EssenceItems.sapphireDust;
							else if(item == SlayerAPI.toItem(EssenceBlocks.enderilliumOre)) itemOnGrind = EssenceItems.enderilliumDust;
							else itemOnGrind = null;
						}
					}
				}
			}
		}
		return returnVal;
	}

	public void setItem(Item d, int f, boolean returnVal) {
		count += f;
		if(count >= 400) {
			count = 0;
			state++;
			returnVal = true;
			if(state == 3) {
				state = 0;
				count = 0;
				itemOnGrind = d;
			}
		}
		if(itemOnGrind == d) count += f;
	}

	@Override
	public void update() {
		if(worldObj.isBlockPowered(getPos())) {
			setActivated(true);
			blockHit(2, null);
			rotation += 20.0F;
		} else {
			setActivated(false);
		}
		if(rotation == 360F) rotation = 0.0F;
	}
}