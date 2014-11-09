package net.essence.event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UpdateCheckerEvent {

	public boolean hasSeen = false;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerLogin(EntityJoinWorldEvent e) {
		if (e.entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) e.entity;
			if (p.worldObj.isRemote) {
				if(!hasSeen) {
					try {
						if(!UpdateChecker.isOnline()){
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.AQUA, "[Version: " + SlayerAPI.MOD_VERSION + "]"));
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.DARK_AQUA, "Unable to check for latest version, you may want to check your internet connection!"));
						}
						if(UpdateChecker.isUpdateAvailable() && UpdateChecker.isOnline()) {
								BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/TheSlayerMC/Essence/master/Version.txt").openStream()));
								String curVersion = versionFile.readLine();
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.AQUA, "[Version: " + SlayerAPI.MOD_VERSION + "]"));
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.RED, "An Essence Of The Gods update is avaliable."));
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.AQUA, "[New Version: " + curVersion + "]")); 
						}
						if((!UpdateChecker.isUpdateAvailable()) && UpdateChecker.isOnline()) {
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.AQUA, "[Version: " + SlayerAPI.MOD_VERSION + "]"));
								p.addChatMessage(SlayerAPI.addChatMessageWithColour(EnumChatFormatting.GREEN, "Essence Of The Gods is up to date."));
						}
					} catch (MalformedURLException e1) {
						e1.printStackTrace();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				hasSeen = true;
			}
		}
	} 
}