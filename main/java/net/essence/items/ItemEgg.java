package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.entity.EntityDragonEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemEgg extends ItemMod {

	public ItemEgg(String name) {
		super(name, EssenceTabs.misc);
	}
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer p, World w, BlockPos pos, EnumFacing fa, float f, float f1, float f2) {
		/*Item i = item.getItem();
		EntityDragonEgg egg = new EntityDragonEgg(w, "");
		if(!w.isRemote) {
			if(i == EssenceItems.incubatedBlueEgg) {
				egg = new EntityDragonEgg(w, "blue");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedCyanEgg) {
				egg = new EntityDragonEgg(w, "cyan");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedGreenEgg) {
				egg = new EntityDragonEgg(w, "green");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedOrangeEgg) {
				egg = new EntityDragonEgg(w, "orange");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedPurpleEgg) {
				egg = new EntityDragonEgg(w, "purple");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedRedEgg) {
				egg = new EntityDragonEgg(w, "red");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedYellowEgg) {
				egg = new EntityDragonEgg(w, "yellow");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(i == EssenceItems.incubatedPinkEgg) {
				egg = new EntityDragonEgg(w, "pink");
				egg.setLocationAndAngles(x + 0.5F, y + 1.0F, z + 0.5F, 0.0F, 0.0F);
				w.spawnEntityInWorld(egg);
			}

			if(!p.capabilities.isCreativeMode) item.stackSize--;
			return true;
		}*/
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add("Used to spawn a pet dragon");
	}
}