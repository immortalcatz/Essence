package net.essence.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class BarTickHandler {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.END)
			tickEnd();
	}

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		if(mc.currentScreen == null) {
			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GuiIngame gig = mc.ingameGUI;
			ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.MOD_ID, "textures/gui/misc.png"));
			int sw = scaledresolution.getScaledWidth(), sh = scaledresolution.getScaledHeight();
			int y = sh - 35, x = sw - 110;
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

	private void tickEnd() {
		DarkEnergyBar.updateAllBars();
		EssenceBar.updateAllBars();
	}

	@SubscribeEvent
	public void playerLogIn(PlayerLoggedInEvent event){ 
		DarkEnergyBar.addBarPoints(0);
		EssenceBar.addBarPoints(0);
	}

	@SubscribeEvent
	public void playerLogOut(PlayerLoggedOutEvent event){ 
		DarkEnergyBar.addBarPoints(0);
		EssenceBar.addBarPoints(0);
	}
	
	@SubscribeEvent
	public void playerChangedDimension(PlayerChangedDimensionEvent event){
		DarkEnergyBar.addBarPoints(200);
		EssenceBar.addBarPoints(200);
	}

	@SubscribeEvent
	public void playerSpawn(PlayerRespawnEvent event){ 
		DarkEnergyBar.addBarPoints(200);
		EssenceBar.addBarPoints(200);
	}
}