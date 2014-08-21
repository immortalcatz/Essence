package net.essence.client;

import net.essence.util.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class PlayerStats {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void renderEvent(RenderGameOverlayEvent event) {

		if(Config.reRenderPlayerStats){
			mc.mcProfiler.startSection("Essence Stats");
			if(event.type == ElementType.EXPERIENCE || event.type == ElementType.HEALTH || event.type == ElementType.FOOD || event.type == ElementType.AIR || event.type == ElementType.ARMOR)
				event.setCanceled(true);

			if(!Minecraft.getMinecraft().playerController.shouldDrawHUD() || !event.isCanceled())
				return;
			mc.mcProfiler.endSection();
		}
	}

	@SubscribeEvent
	public void tickEvent(RenderTickEvent event) {
		GuiIngame gig = mc.ingameGUI;
		FontRenderer font = mc.fontRenderer;
		EntityPlayer player = mc.thePlayer;
		if(Config.reRenderPlayerStats && mc.currentScreen == null || mc.currentScreen instanceof GuiChat){
			mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/playerStats.png"));
			float health = player.getHealth() * 10;
			float hunger = player.getFoodStats().getFoodLevel() * 10;
			float experience = player.experience;
			float armor = player.getTotalArmorValue() * 10;
			float air = (float)player.getAir() / 1.5F;
			ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int w = res.getScaledWidth() - 210, h = 12;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			gig.drawTexturedModalRect(w, h, 0, 0, 202, 54);

			gig.drawTexturedModalRect(w + 1, h, 1, 54, (int)health, 18);
			gig.drawTexturedModalRect(w + 3, h + 3, 0, 108, 12, 11);

			gig.drawTexturedModalRect(w + 1, h + 18, 1, 72, (int)hunger, 18);
			gig.drawTexturedModalRect(w + 3, h + 21, 0, 119, 12, 11);

			gig.drawTexturedModalRect(w + 1, h + 36 + 18, 1, 216, (int)armor, 18);
			gig.drawTexturedModalRect(w, h + 36 + 18, 0, 180, 202, 18);
			gig.drawTexturedModalRect(w + 3, h + 36 + 22, 17, 119, 9, 9);

			gig.drawTexturedModalRect(w, h + 36 + 36, 0, 198, (int)air, 18);
			gig.drawTexturedModalRect(w, h + 36 + 36, 0, 162, 202, 18);
			gig.drawTexturedModalRect(w + 3, h + 36 + 40, 17, 109, 9, 9);

			gig.drawTexturedModalRect(w, h + 54 + 36, 0, 144, 78, 18);

			experience = (int)(mc.thePlayer.experience * (float)(200));
			gig.drawTexturedModalRect(w + 1, h + 36, 1, 90, (int)experience, 18);

			GL11.glPushMatrix();
			GL11.glColor4f(0.4F, 1.0F, 0.3F, 1.0F);
			gig.drawTexturedModalRect(w + 3, h + 38, 0, 130, 14, 14);
			GL11.glPopMatrix();

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			font.drawString("Health: " + (int)player.getHealth() + "/" + (int)player.getMaxHealth() , w + 20, h + 5, 0xFFFFFF);
			font.drawString("Hunger: " + (int)player.getFoodStats().getFoodLevel() + "/20" , w + 20, h + 23, 0xFFFFFF);
			font.drawString("Level: " + mc.thePlayer.experienceLevel , w + 20, h + 41, 0xFFFFFF);
			String st = "Time: " + formatTime(getWorldTime(mc));
			font.drawString(st, w + 3, h + 41 + 36 + 18, 0xFFFFFF);
			font.drawString("Armor", w + 20, h + 36 + 23, 0xFFFFFF);
			font.drawString("Health: " + (int)player.getHealth() + "/20" , w + 20, h + 5, 0xFFFFFF);
			if(player.getAir() <= 0) font.drawString("Air: " + "0/300" , w + 20, h + 36 + 40, 0xFFFFFF);
			else font.drawString("Air: " + (int)player.getAir() + "/300" , w + 20, h + 36 + 42, 0xFFFFFF);
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