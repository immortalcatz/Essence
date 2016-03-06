package net.journey.items;

import java.util.List;

import net.journey.JourneyItems;
import net.journey.JourneyTabs;
import net.journey.entity.mob.boss.EntityBlazier;
import net.journey.entity.mob.boss.EntityCorallator;
import net.journey.entity.mob.boss.EntitySentryKing;
import net.journey.entity.mob.boss.EntitySkyStalker;
import net.journey.entity.mob.boss.EntitySoulWatcher;
import net.journey.entity.mob.depths.EntityTameRoc;
import net.journey.util.Config;
import net.journey.util.LangHelper;
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
	
	public ItemSpecificDimensionSpawner(int dimID, String name, String f, String dimName) {
		super(name, f, JourneyTabs.spawners);
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
				EntitySkyStalker sky = new EntitySkyStalker(w);
				EntityTameRoc roc = new EntityTameRoc(w, p);
				EntityCorallator corallator = new EntityCorallator(w);
				if(item == JourneyItems.blazierOrb) {
					SlayerAPI.sendMessageToAll("Blazier has been summoned", true);
					blaze.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(blaze);
				}
				if(item == JourneyItems.rocSpawnEgg) {
					blaze.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(roc);
				}
				if(item == JourneyItems.soulWatcherOrb) {
					SlayerAPI.sendMessageToAll("Soul Watcher has been summoned", true);
					soul.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(soul);
				}
				if(item == JourneyItems.sentryKingOrb) {
					SlayerAPI.sendMessageToAll("Sentry King has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(sentry);
				}
				if(item == JourneyItems.mysteriousDisk) {
					SlayerAPI.sendMessageToAll("The Sky Stalker has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(sky);
				}
				if(item == JourneyItems.corallatorOrb) {
					SlayerAPI.sendMessageToAll("The Corallator has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(corallator);
				}
				if(item == JourneyItems.loggerOrb) {
					SlayerAPI.sendMessageToAll("The Logger has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(corallator);
				}
				if(item == JourneyItems.thunderbirdOrb) {
					SlayerAPI.sendMessageToAll("The Thunderbird has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(corallator);
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
		if(item == JourneyItems.blazierOrb) list.add(LangHelper.setBossSpawner("Blazier"));
		if(item == JourneyItems.rocSpawnEgg) list.add(LangHelper.setPetSpawner("Roc"));
		
	}
}