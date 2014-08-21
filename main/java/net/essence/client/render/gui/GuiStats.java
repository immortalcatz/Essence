package net.essence.client.render.gui;

import net.essence.client.PlayerLevels;
import net.essence.util.ContainerEmpty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class GuiStats extends GuiContainer {

	public GuiStats() {
		super(new ContainerEmpty());
	}

	private static final ResourceLocation stats = new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/stats.png");
	private static final ResourceLocation bar = new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/misc.png");

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) { }

	public void drawDefaultLevels(){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(bar);
		int w = (this.width - this.xSize) / 2;
		int h = (this.height - this.ySize) / 2;
		drawTexturedModalRect(w + 20, h - 5, 0, 103, 190, 19);
		drawTexturedModalRect(w + 20, h + 37, 0, 103, 190, 19);
		drawTexturedModalRect(w + 20, h + 78, 0, 103, 190, 19);
		drawTexturedModalRect(w + 20, h + 119, 0, 103, 190, 19);

		String text = SlayerAPI.MOD_NAME + ": " + SlayerAPI.MOD_VERSION;
		Minecraft.getMinecraft().fontRenderer.drawString(SlayerAPI.Colour.BLUE + text, w + 30, h + 155, 4210752);
		text = "Enemys around: " + Minecraft.getMinecraft().theWorld.countEntities(EnumCreatureType.monster, true);
		Minecraft.getMinecraft().fontRenderer.drawString(SlayerAPI.Colour.RED + text, w - 10, h + 175, 4210752);
		text = "Friendly creatures around: " + Minecraft.getMinecraft().theWorld.countEntities(EnumCreatureType.creature, true);
		Minecraft.getMinecraft().fontRenderer.drawString(SlayerAPI.Colour.DARK_GREEN + text, w - 10, h + 185, 4210752);
	}

	public void drawLevels(){
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		PlayerLevels props = new PlayerLevels(mc.thePlayer);
		mc.getTextureManager().bindTexture(bar);
		int w = (width - xSize) / 2;
		int h = (height - ySize) / 2;
		int cap = props.normalCap();
		short short1 = 190;
		int xp;
		xp = (int)(props.bowXP * (float)(short1));
		drawTexturedModalRect(w + 20, h - 5, 0, 84, xp, 19);
		xp = (int)(props.hoeXP * (float)(short1));
		drawTexturedModalRect(w + 20, h + 37, 0, 84, xp, 19);
		xp = (int)(props.pickXP * (float)(short1));
		drawTexturedModalRect(w + 20, h + 78, 0, 84, xp, 19);
		xp = (int)(props.witherXP * (float)(short1));
		drawTexturedModalRect(w + 20, h + 119, 0, 84, xp, 19);
		String s = "Lv: ";
		fontRendererObj.drawString(s + props.getBowExperience(), w + 100, h + 1, 0xF0F0F0);
		fontRendererObj.drawString(s + props.getHoeExperience(), w + 100, h + 43, 0xF0F0F0);
		fontRendererObj.drawString(s + props.getPickaxeExperience(), w + 100, h + 84, 0xF0F0F0);
		fontRendererObj.drawString(s + props.getWitherExperience(), w + 100, h + 125, 0xF0F0F0);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int par1, int par2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int width = (this.width - this.xSize) / 2;
		int height = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(stats);
		drawTexturedModalRect(width - 25, height - 25, 0, 0, 250, 238);
		drawDefaultLevels();
		drawLevels();
	}
}