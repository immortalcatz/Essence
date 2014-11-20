package net.essence.client;

import java.awt.Color;
import java.awt.Point;

import net.essence.util.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class BarTickHandler {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.END)
			onTickEnd();
	}

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		if(mc.currentScreen == null || mc.currentScreen instanceof GuiChat) {
			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GuiIngame gig = mc.ingameGUI;
			ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth(), k = scaledresolution.getScaledHeight();
			this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.MOD_ID, "textures/gui/misc.png"));
			int y = k - 35;
			int x = i - 110;
			gig.drawTexturedModalRect(x - 10, y + 10, 0, 177, 108, 19);
			gig.drawTexturedModalRect(x - 10, y - 15, 0, 177, 108, 19);
			gig.drawTexturedModalRect(x - 6, y - 10, 0, 145, 100, 10);
			gig.drawTexturedModalRect(x - 6, y - 10, 0, 135, (int)(EssenceBar.getBarValue() / 4), 10);
			y += 15;
			gig.drawTexturedModalRect(x - 6, y, 0, 165, 100, 10);
			gig.drawTexturedModalRect(x - 6, y, 0, 155, (int)((DarkEnergyBar.getBarValue() / 4)), 10);
			GL11.glPopMatrix();
		}
	}

	private void onTickEnd() {
		DarkEnergyBar.updateAllBars();
		EssenceBar.updateAllBars();
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){ 
		DarkEnergyBar.addBarPoints(0);
		EssenceBar.addBarPoints(0);
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event){ 
		DarkEnergyBar.addBarPoints(0);
		EssenceBar.addBarPoints(0);
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event){ 
		DarkEnergyBar.addBarPoints(200);
		EssenceBar.addBarPoints(200);
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event){
		DarkEnergyBar.addBarPoints(200);
		EssenceBar.addBarPoints(200);
	}
}