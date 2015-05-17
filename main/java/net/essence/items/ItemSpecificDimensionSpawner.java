package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.entity.mob.boss.EntityBlazier;
import net.essence.entity.mob.boss.EntitySentryKing;
import net.essence.entity.mob.boss.EntitySoulWatcher;
import net.essence.entity.mob.depths.EntityTameRoc;
import net.essence.util.Config;
import net.essence.util.LangHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemSpecificDimensionSpawner extends ItemMod {

	public String dimName;
	public int dimID;
	
	public ItemSpecificDimensionSpawner(int dimID, String name, String dimName) {
		super(name, EssenceTabs.spawners);
		setMaxStackSize(1);
		this.dimID = dimID;
		this.dimName = dimName;
	}
	
	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, BlockPos pos, EnumFacing fa, float par8, float par9, float par10) {
		Item item = i.getItem();
		if(!w.isRemote) {
			if(w.provider.getDimensionId() == dimID) {
				EntityBlazier blaze = new EntityBlazier(w);
				EntitySoulWatcher soul = new EntitySoulWatcher(w);
				EntitySentryKing sentry = new EntitySentryKing(w);
				EntityTameRoc roc = new EntityTameRoc(w, p);
				if(item == EssenceItems.blazierOrb) {
					SlayerAPI.sendMessageToAll("Blazier has been summoned", true);
					blaze.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(blaze);
				}
				if(item == EssenceItems.rocSpawnEgg) {
					blaze.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(roc);
				}
				if(item == EssenceItems.soulWatcherOrb) {
					SlayerAPI.sendMessageToAll("Soul Watcher has been summoned", true);
					soul.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(soul);
				}
				if(item == EssenceItems.sentryKingOrb) {
					SlayerAPI.sendMessageToAll("Sentry King has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(sentry);
				}
				if(!p.capabilities.isCreativeMode) i.stackSize--;
			} else {
				SlayerAPI.addChatMessage(p, EnumChatFormatting.GREEN + "Cannot be spawned unless in the " + dimName + " dimension.");
			}
		}
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		Item item = stack.getItem();
		if(item == EssenceItems.blazierOrb) list.add(LangHelper.setBossSpawner("Blazier"));
		if(item == EssenceItems.rocSpawnEgg) list.add(LangHelper.setPetSpawner("Roc"));
		
	}
}