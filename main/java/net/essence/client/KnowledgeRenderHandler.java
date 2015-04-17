package net.essence.client;

import java.util.Random;

import net.essence.enums.EnumKnowledge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class KnowledgeRenderHandler {

	private Minecraft mc = Minecraft.getMinecraft();
	private PlayerKnowledge knowledge = new PlayerKnowledge(mc.thePlayer);

	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		if(mc.currentScreen == null) {
			if(!mc.thePlayer.capabilities.isCreativeMode) {
				int dimID = mc.thePlayer.dimension;
				GL11.glPushMatrix();
				GlStateManager.enableBlend();
				GlStateManager.enableAlpha();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GuiIngame gig = mc.ingameGUI;
				ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
				this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.MOD_ID, "textures/gui/knowledgeSprite.png"));
				int y = scaledresolution.getScaledHeight() - 30, x = 10;
				int xpCap = knowledge.xpBarCap(knowledge.getKnowledgeFromDimension(dimID));

				if(xpCap > 0) {
					int xp = (int)knowledge.xp[knowledge.getKnowledgeID(knowledge.getKnowledgeFromDimension(dimID))];
					gig.drawTexturedModalRect(x, 40, 0, 5, 50, 5);
					if(xp > 0) gig.drawTexturedModalRect(x, 40, 0, 0, xp * 2, 5);
				}
				gig.drawTexturedModalRect(19, 5, getXFromKnowledge(knowledge.getKnowledgeFromDimension(dimID)), getYFromKnowledge(knowledge.getKnowledgeFromDimension(dimID)), 32, 32);
				mc.fontRendererObj.drawString(knowledge.knowledge[knowledge.getKnowledgeID(knowledge.getKnowledgeFromDimension(dimID))] + "%", x + 20, 50, 0x000000);
				GlStateManager.disableAlpha();
				GlStateManager.disableBlend();
				GL11.glPopMatrix();
			}
		}
	}

	public int getYFromKnowledge(EnumKnowledge k) {
		return k == EnumKnowledge.CORBA || k == EnumKnowledge.CLOUDIA  || k == EnumKnowledge.WASTELANDS
				|| k == EnumKnowledge.LITHIUM || k == EnumKnowledge.LIBRARY || k == EnumKnowledge.BLAZE || k == EnumKnowledge.WITHER ? 42 : 10;
	}

	public int getXFromKnowledge(EnumKnowledge k) {
		switch(k) {
		case UNKNOWN: return 0;
		case OVERWORLD: return 32;
		case NETHER: return 64;
		case END: return 96;
		case BOIL: return 128;
		case FROZEN: return 160;
		case EUCA: return 192;
		case DEPTHS: return 224;
		case CORBA: return 0;
		case CLOUDIA: return 32;
		case WASTELANDS: return 64;
		case LITHIUM: return 96;
		case LIBRARY: return 128;
		case BLAZE:	return 160;
		case WITHER: return 192;
		default: return 0;
		}
	}
}