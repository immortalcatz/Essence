package net.journey.items;

import java.util.List;

import net.journey.JourneyItems;
import net.journey.JourneyTabs;
import net.journey.entity.mob.boss.EntityBlazier;
import net.journey.entity.mob.boss.EntityCorallator;
import net.journey.entity.mob.boss.EntityLogger;
import net.journey.entity.mob.boss.EntitySentryKing;
import net.journey.entity.mob.boss.EntitySkyStalker;
import net.journey.entity.mob.boss.EntitySoulWatcher;
import net.journey.entity.mob.boss.EntityTerranianProtector;
import net.journey.entity.mob.boss.EntityThunderbird;
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
				EntityLogger logger = new EntityLogger(w);
				EntityThunderbird thunder = new EntityThunderbird(w);
				EntityTerranianProtector terrastar = new EntityTerranianProtector(w);
				if(item == JourneyItems.blazierOrb) {
					SlayerAPI.sendMessageToAll("Blazier has been summoned", true);
					blaze.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(blaze);
				}
				if(item == JourneyItems.rocSpawnEgg) {
					blaze.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(roc);
				}
				if(item == JourneyItems.sentryKingOrb) {
					SlayerAPI.sendMessageToAll("Sentry King has been summoned", true);
					sentry.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(sentry);
				}
				if(item == JourneyItems.mysteriousDisk) {
					SlayerAPI.sendMessageToAll("The Sky Stalker has been summoned", true);
					sky.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(sky);
				}
				if(item == JourneyItems.corallatorOrb) {
					SlayerAPI.sendMessageToAll("The Corallator has been summoned", true);
					corallator.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(corallator);
				}
				if(item == JourneyItems.loggerOrb) {
					SlayerAPI.sendMessageToAll("The Logger has been summoned", true);
					logger.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(logger);
				}
				if(item == JourneyItems.thunderbirdOrb) {
					SlayerAPI.sendMessageToAll("The Thunderbird has been summoned", true);
					thunder.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(thunder);
				}
				if(item == JourneyItems.enchantedTerrastar) {
					SlayerAPI.sendMessageToAll("The Terrastar has been summoned", true);
					terrastar.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
					w.spawnEntityInWorld(terrastar);
					
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
		if(item == JourneyItems.sentryKingOrb) list.add(LangHelper.setBossSpawner("Sentry King"));
		if(item == JourneyItems.mysteriousDisk) list.add(LangHelper.setBossSpawner("Sky Stalker"));
		if(item == JourneyItems.corallatorOrb) list.add(LangHelper.setBossSpawner("Corallator"));
		if(item == JourneyItems.loggerOrb) list.add(LangHelper.setBossSpawner("Logger"));
		if(item == JourneyItems.thunderbirdOrb) list.add(LangHelper.setBossSpawner("Thunderbird"));
		if(item == JourneyItems.enchantedTerrastar) list.add(LangHelper.setBossSpawner("Terranian Protector"));
		if(item == JourneyItems.rocSpawnEgg) list.add(LangHelper.setPetSpawner("Roc"));
		
	}
}