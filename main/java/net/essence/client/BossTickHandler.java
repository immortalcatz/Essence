package net.essence.client;

import net.essence.entity.MobStats;
import net.essence.util.EssenceBossStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BossTickHandler {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	@SideOnly(Side.CLIENT)
	private void onTickRender() {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		this.mc.mcProfiler.startSection("essenceBossHealth");
		this.renderBossHealth();
		this.mc.mcProfiler.endSection();
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void renderBossHealth() {
		ResourceLocation r = null;

		switch(EssenceBossStatus.id){
		case MobStats.netherBeastBossID:
			r = set("netherBeast");
			break;
		case MobStats.witheringBeastBossID:
			r = set("witherBeast");
			break;
		case MobStats.calciaBossID:
			r = set("calcia");
			break;
		case MobStats.wraithBossID:
			r = set("wraith");
			break;
		case MobStats.eudorBossID:
			r = set("eudor");
			break;
		}

		if(EssenceBossStatus.statusBarTime > 0 && mc.currentScreen == null) {
			EssenceBossStatus.statusBarTime--;
			GuiIngame gig = mc.ingameGUI;
			FontRenderer fontrenderer = this.mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			int barLength = 182;
			int finalBarLength = barLength + 1;
			int barDisX = i / 2 - barLength / 2;
			int barDisY = 12;
			int health = (int)(EssenceBossStatus.healthScale * (float)(finalBarLength));
			int barHeight = 10;
			this.mc.getTextureManager().bindTexture(r);
			gig.drawTexturedModalRect(barDisX, barDisY, 0, 0, health, barHeight);
			gig.drawTexturedModalRect(barDisX, barDisY, 0, barHeight, finalBarLength, barHeight);
			if(health > 0) gig.drawTexturedModalRect(barDisX, barDisY, 0, 0, health, 10);
		}
	}

	private ResourceLocation set(String name){
		return new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/bossBars/" + name + ".png");
	}
}