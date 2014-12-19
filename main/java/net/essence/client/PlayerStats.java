package net.essence.client;

import net.essence.util.Config;
import net.essence.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class PlayerStats {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void renderEvent(RenderGameOverlayEvent event) {
		if(Config.reRenderPlayerStats){
			mc.mcProfiler.startSection("Essence Stats");
			if(event.type == ElementType.EXPERIENCE || event.type == ElementType.HEALTH || event.type == ElementType.FOOD || event.type == ElementType.AIR || event.type == ElementType.ARMOR)
				event.setCanceled(true);
			if(!Minecraft.getMinecraft().playerController.shouldDrawHUD() || !event.isCanceled()) return;
			mc.mcProfiler.endSection();
		}
	}

	@SubscribeEvent
	public void tickEvent(RenderTickEvent event) {
		GuiIngame gig = mc.ingameGUI;
		FontRenderer font = mc.fontRendererObj;
		EntityPlayer player = mc.thePlayer;
		if(mc.currentScreen == null || mc.currentScreen instanceof GuiChat) {
			if(!mc.gameSettings.showDebugInfo) {
				mc.fontRendererObj.drawString(EnumChatFormatting.DARK_GREEN + "Essence of the Gods beta: " + EnumChatFormatting.DARK_RED + "1.8 b1", 5, 5, 0);
				if(!player.capabilities.isCreativeMode) {
					mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/playerStats.png"));
					float health = player.getHealth() * 5F;
					float hunger = player.getFoodStats().getFoodLevel() * 5F;
					float experience = (int)(mc.thePlayer.experience * (float)(200));
					float armor = player.getTotalArmorValue() * 5;
					float air = (float)player.getAir() / 1.5F / 2F;
					ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
					int w = res.getScaledWidth() - 160, h = 10;
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glEnable(GL11.GL_BLEND);
					int lengthOfBar = 151;
					gig.drawTexturedModalRect(w, h, 0, 0, lengthOfBar, 108 - 18);
					gig.drawTexturedModalRect(w, h + 108 - 18, 0, 90, lengthOfBar, 18);
					gig.drawTexturedModalRect(w, h + 108, 0, 235, 182, 18);

					gig.drawTexturedModalRect(w, h, 0, 109, (int)(health * 1.5F), 18);
					gig.drawTexturedModalRect(w + 3, h + 3, 0, 199, 12, 11);

					gig.drawTexturedModalRect(w, h + 18, 0, 127, (int)(hunger * 1.5F), 18);
					gig.drawTexturedModalRect(w + 3, h + 21, 0, 210, 12, 11);

					gig.drawTexturedModalRect(w, h + 36 + 18 + 17, 0, 180, (int)(armor * 1.5F), 18);
					gig.drawTexturedModalRect(w + 3, h + 36 + 40, 17, 210, 9, 9);

					gig.drawTexturedModalRect(w, h + 36 + 36 - 18, 0, 163, (int)(air * 2), 18);
					gig.drawTexturedModalRect(w + 3, h + 36 + 40 - 18, 17, 200, 9, 9);

					gig.drawTexturedModalRect(w, h + 36, 0, 145, (int)experience, 18);
					GL11.glPushMatrix();
					GL11.glColor4f(0.4F, 1.0F, 0.3F, 1.0F);
					gig.drawTexturedModalRect(w + 3, h + 38, 0, 221, 14, 14);
					GL11.glPopMatrix();
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

					font.drawString("Health: " + health + "%", w + 20, h + 5, 0xFFFFFF);
					font.drawString("Hunger: " + hunger + "%" , w + 20, h + 23, 0xFFFFFF);
					font.drawString("Armor: " + armor + "%", w + 20, h + 36 + 23 + 18, 0xFFFFFF);
					if(player.getAir() <= 0) font.drawString("Air: " + "0%" , w + 20, h + 36 - 18 + 42, 0xFFFFFF);
					else font.drawString("Air: " + (int)air + "%" , w + 20, h + 36 - 18 + 42, 0xFFFFFF);
					font.drawString("Level: " + mc.thePlayer.experienceLevel , w + 20, h + 41, 0xFFFFFF);
					String st = "Time: " + formatTime(getWorldTime(mc));
					font.drawString(st, w + 3, h + 41 + 36 + 18, 0xFFFFFF);
					font.drawString("Coords: X: " + (int)player.posX + ", Y: " + (int)(player.posY - 1) + ", Z: " + (int)player.posZ, w + 5, h + 36 + 78, 0xFFFFFF);
					GL11.glDisable(GL11.GL_BLEND);
				}
			}
		}
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