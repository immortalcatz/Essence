package net.journey.client;

import net.journey.entity.MobStats;
import net.journey.util.EssenceBossStatus;
import net.journey.util.GL11Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class BossTickHandler {

	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRender(RenderTickEvent event){
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
		int imageY = 0, barX = -50;
		switch(EssenceBossStatus.id){
		case MobStats.netherBeastBossID:
			imageY = 80;
			barX = 5;
			r = set("netherBeast");
			break;
		case MobStats.witheringBeastBossID:
			imageY = 60;
			barX = 20;
			r = set("witherBeast");
			break;
		case MobStats.calciaBossID:
			imageY = 0;
			r = set("calcia");
			break;
		case MobStats.wraithBossID:
			r = set("wraith");
			break;
		case MobStats.eudorBossID:
			imageY = 40;
			r = set("eudor");
			break;
		case MobStats.fourfaBossID:
			imageY = 20;
			barX = -40;
			r = set("fourfa");
			break;
		case MobStats.blazierBossID:
			imageY = 101;
			barX = -40;
			r = set("blazier");
		case MobStats.soulWatcherBossID:
			imageY = 121;
			barX = -20;
			r = set("soulWatcher");
		case MobStats.sentryKingBossID:
			imageY = 141;
			barX = -5;
			r = set("sentryKing");
		case MobStats.thunderbirdBossID:
			imageY = 141;
			barX = -5;
			r = set("thunderbird");
		case MobStats.loggerBossID:
			imageY = 141;
			barX = -5;
			r = set("logger");
		case MobStats.corallatorBossID:
			imageY = 141;
			barX = -5;
			r = set("corallator");
		case MobStats.skyStalkerBossID:
			imageY = 141;
			barX = -5;
			r = set("skyStalker");
		}

		if(EssenceBossStatus.statusBarTime > 0 && mc.currentScreen == null) {
			EssenceBossStatus.statusBarTime--;
			GuiIngame gig = mc.ingameGUI;
			FontRenderer fontrenderer = this.mc.fontRendererObj;
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
			addScaledImage(barDisX - barX, barDisY + 10, imageY, 1);
		}
	}
	
	public void addScaledImage(float x, float y, int imageY, float scale) {
		addScaledImage(x, y, imageY, 0, scale);
	}
	
	public void addScaledImage(float x, float y, int imageY, int imageX, float scale) {
		GuiIngame gig = mc.ingameGUI;
		GL11.glPushMatrix();
		this.mc.getTextureManager().bindTexture(set("names"));
		GL11.glTranslatef(x, y, 0);
		GL11Helper.scale(scale);
		gig.drawTexturedModalRect(0, 0, imageX, imageY, 250, 20);
		GL11.glPopMatrix();
	}

	private ResourceLocation set(String name){
		return new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/bossBars/" + name + ".png");
	}
}