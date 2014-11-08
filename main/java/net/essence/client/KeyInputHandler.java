package net.essence.client;

import net.essence.Essence;
import net.essence.client.GuiHandler.GuiIDs;
import net.essence.network.PacketOpenGui;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class KeyInputHandler {

	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		//if(Keybinding.stats.isPressed())
		//	Essence.packetHandler.sendToServer(new PacketOpenGui().setID(GuiIDs.STATS.ordinal()));
		
	}
}