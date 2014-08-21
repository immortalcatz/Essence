package net.essence.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class LevelBarTickHandler {

	private static ResourceLocation level = new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/misc.png");

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		if(Minecraft.getMinecraft().currentScreen == null){
			//drawLevelBar();
		}
	}

	public void drawLevelBar(){
		Minecraft mc = Minecraft.getMinecraft();
		PlayerLevels levels = new PlayerLevels(mc.thePlayer);
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int j1, l1, j2, k2, j, i1, i2;
		ScaledResolution s = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		int h = s.getScaledHeight();
		int w = s.getScaledWidth();
		GuiIngame g = mc.ingameGUI;
		int h1 = h - 490;
		int w1 = w - 610;
		short short1 = 256;
		int width = w / 2 - short1 / 2;
		FontRenderer f = mc.fontRenderer;
		mc.mcProfiler.startSection("levelBar");
		mc.getTextureManager().bindTexture(level);
		j1 = levels.xpBarCap();

		if (j1 > 0) {
			l1 = (int)(levels.levelXP * (float)(short1));
			g.drawTexturedModalRect(width, 30, 0, 47, short1, 19);
			g.drawTexturedModalRect(width + 5, 35, 0, 75, 245, 9);
			if(l1 > 0) g.drawTexturedModalRect(width + 5, 35, 0, 66, l1, 9);
		}

		if(levels.getPlayerLevel() >= 245) mc.fontRenderer.drawString(SlayerAPI.Colour.GOLD + "Lv: " + levels.getPlayerLevel() + " (Max)", width + 100, 30 + 5, 0, false);
		if(levels.getPlayerLevel() == 0) mc.fontRenderer.drawString(SlayerAPI.Colour.GOLD + "Lv: 0", width + 118, 30 + 6, 0, false);
		else mc.fontRenderer.drawString(SlayerAPI.Colour.GOLD + "Lv: " + levels.getPlayerLevel(), width + 118, 30 + 5, 0, false);
		String st = "Time: " + formatTime(getWorldTime(mc));
		mc.fontRenderer.drawString(SlayerAPI.Colour.GOLD + st, width + 95, 20 + 30, 0, false);
		GL11.glPopMatrix();
	}

	public static Long getWorldTime(Minecraft mc){	
		Long time = Long.valueOf(mc.theWorld.provider.getWorldTime());
		return time;
	}

	public static String formatTime(Long time) {
		int hours24 = (int)(time.longValue() / 1000L + 6L) % 24;
		int hours = hours24 % 12;
		int minutes = (int)((float)time.longValue() / 16.666666F % 60.0F);
		String time1 = String.format("%02d:%02d %s", new Object[] { Integer.valueOf(hours < 1 ? 12 : hours), Integer.valueOf(minutes), hours24 < 12 ? "AM" : "PM" });
		return time1;
	}	
}