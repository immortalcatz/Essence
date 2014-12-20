package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.entity.mob.boss.EntityEudor;
import net.essence.util.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemEssenceBossSpawner extends ItemMod {

	public ItemEssenceBossSpawner(String name) {
		super(name, EssenceTabs.util);
		setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, BlockPos pos, EnumFacing fa, float par8, float par9, float par10) {
		Item item = i.getItem();
		if(!w.isRemote){
			if(w.provider.getDimensionId() == Config.euca || w.provider.getDimensionId() == Config.depths || w.provider.getDimensionId() == Config.boil) {
				EntityEudor eudor = new EntityEudor(w);
				if(item == EssenceItems.eudorOrb){
					SlayerAPI.sendMessageToAll("Eudor has been summoned", true);
					eudor.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(eudor);
				}
				if(!p.capabilities.isCreativeMode) i.stackSize--;
			} else {
				SlayerAPI.addChatMessage(p, EnumChatFormatting.GREEN + "Cannot be spawned unless in an Essence dimension.");
			}
		}
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		Item item = stack.getItem();
		String spawn = "";
		if(item == EssenceItems.eudorOrb)
			spawn = "Eudor";
		list.add("Spawns the boss: " + spawn);
	}
}