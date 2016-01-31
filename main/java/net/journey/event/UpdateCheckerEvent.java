package net.journey.event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class UpdateCheckerEvent {

	private boolean hasSeen = false;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerLogin(EntityJoinWorldEvent e) {
		if(e.entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer)e.entity;
			if(p.worldObj.isRemote) {
				if(!hasSeen) {
					try {
						if(!UpdateChecker.isOnline()){
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[Version: " + SlayerAPI.MOD_VERSION + "]");
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.DARK_AQUA, "Unable to check for latest version, you may want to check your internet connection!");
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.GREEN, "Follow The_SlayerMC on twitter for spoilers, when you're connected to internet :P");
						}
						if(UpdateChecker.isUpdateAvailable() && UpdateChecker.isOnline()) {
							BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://essence-of-the-gods.net/version.txt").openStream()));
							String curVersion = versionFile.readLine();
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[Version: " + SlayerAPI.MOD_VERSION + "]");
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.RED, "An Essence Of The Gods update is avaliable.");
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[New Version: " + curVersion + "]"); 
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.GREEN, "Follow The_SlayerMC on twitter for spoilers.");
						}
						if((!UpdateChecker.isUpdateAvailable()) && UpdateChecker.isOnline()) {
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[Version: " + SlayerAPI.MOD_VERSION + "]");
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.GREEN, "Essence Of The Gods is up to date.");
							SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.GREEN, "Follow The_SlayerMC on twitter for spoilers.");
						}
					} catch(MalformedURLException e1) {
						e1.printStackTrace();

					} catch(IOException e1) {
						e1.printStackTrace();
					}
				}
				hasSeen = true;
			}
		}
	} 
}