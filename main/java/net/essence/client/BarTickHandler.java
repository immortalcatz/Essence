package net.essence.client;

import java.awt.Color;
import java.awt.Point;

import net.essence.util.Config;
import net.minecraft.client.Minecraft;
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
		if(Config.smallEnergyBars) {
			if(mc.currentScreen == null) {
				GL11.glPushMatrix();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GuiIngame gig = mc.ingameGUI;
				ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
				int i = scaledresolution.getScaledWidth(), k = scaledresolution.getScaledHeight();
				this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.MOD_ID, "textures/gui/misc.png"));
				int y = k - 35;
				int x = i - 110;
				gig.drawTexturedModalRect(x, y, 0, 10, 100, 10);
				gig.drawTexturedModalRect(x, y, 0, 0, (int)(EssenceBar.getBarValue() / 4), 10);
				y += 15;
				gig.drawTexturedModalRect(x, y, 0, 30, 100, 10);
				gig.drawTexturedModalRect(x, y, 0, 20, (int)((DarkEnergyBar.getBarValue() / 4)), 10);
				GL11.glPopMatrix();
			}
		} else {
			if(mc.currentScreen == null) {
				ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
				int width = scaledresolution.getScaledWidth();
				int height = scaledresolution.getScaledHeight();
				
				int tempMagic = (int)((DarkEnergyBar.getBarValue() / 1.26));
				int startY = (height - 30) * 2;
				int startX = (width - 180) * 2;
				int barHeight = 40;
				int barWidth = 300;
				int lines = 6;
				int vertexes = 14;
				int vertexSpread = 30;
				int colorOutline = Color.BLUE.getRGB();
				int colorInside = Color.blue.getRGB();
				int colorGray = 0x888888;
				float insideBarWidth = 1.5F;
				float outlineBarWidth =  3F;
				float grayBarWidth = 2F;

				GL11.glPushMatrix();
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				startDrawingLines();
				int distancePerVertex = (tempMagic / vertexes);
				int distancePer = (barHeight / lines);
				int lastX = 0;
				
				for(int i = 0; i < lines; i++) {
					int[] vertexArray = new int[vertexes + 1];
					vertexArray[0] = vertexArray[vertexes] = startY + distancePer * i;
					for(int j = 0; j < (vertexes - 1); j++)
						vertexArray[j + 1] = (int) Math.round(((startY + distancePer * i) + (Math.random() - 0.5) * vertexSpread));

					for(int j = 0; j < vertexes; j++) {
						drawSimpleLine(new Point(startX + distancePerVertex * j, vertexArray[j]), new Point(startX + distancePerVertex * (j + 1), vertexArray[j + 1]), outlineBarWidth, colorOutline, 0.6F);
						drawSimpleLine(new Point(startX + distancePerVertex * j, vertexArray[j]), new Point(startX + distancePerVertex * (j + 1), vertexArray[j + 1]), insideBarWidth, colorInside, 1F);
						lastX = startX + distancePerVertex * (j + 1);
					}	 
				}

				for(int i = 0; i < lines; i++)
					drawSimpleLine(new Point(lastX, startY + distancePer * i), new Point(startX + barWidth, startY + distancePer * i), grayBarWidth, colorGray, 1F);
				endDrawingLines();
				GL11.glPopMatrix();

				GL11.glPushMatrix();
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				startDrawingLines();
				tempMagic = (int)((EssenceBar.getBarValue() / 1.26));
				startY = (height - 70) * 2;
				startX = (width - 180) * 2;
				barHeight = 40;
				barWidth = 300;
				lines = 6;
				vertexes = 14;
				vertexSpread = 30;
				colorOutline = Color.GREEN.getRGB();
				colorInside = Color.green.getRGB();
				colorGray = 0x888888;
				insideBarWidth = 1.5F;
				outlineBarWidth =  3F;
				grayBarWidth = 2F;

				distancePerVertex = (tempMagic / vertexes);
				distancePer = (barHeight / lines);
				lastX = 0;

				
				for(int i = 0; i < lines; i++) {
					int[] vertexArray = new int[vertexes + 1];
					vertexArray[0] = vertexArray[vertexes] = startY + distancePer * i;
					for(int j = 0; j < (vertexes - 1); j++)
						vertexArray[j + 1] = (int) Math.round(((startY + distancePer * i) + (Math.random() - 0.5) * vertexSpread));

					for(int j = 0; j < vertexes; j++) {
						drawSimpleLine(new Point(startX + distancePerVertex * j, vertexArray[j]), new Point(startX + distancePerVertex * (j + 1), vertexArray[j + 1]), outlineBarWidth, colorOutline, 0.6F);
						drawSimpleLine(new Point(startX + distancePerVertex * j, vertexArray[j]), new Point(startX + distancePerVertex * (j + 1), vertexArray[j + 1]), insideBarWidth, colorInside, 1F);
						lastX = startX + distancePerVertex * (j + 1);
					}	 
				}

				for(int i = 0; i < lines; i++)
					drawSimpleLine(new Point(lastX, startY + distancePer * i), new Point(startX + barWidth, startY + distancePer * i), grayBarWidth, colorGray, 1F);
				endDrawingLines();
				GL11.glPopMatrix();
				mc.fontRenderer.drawString("Dark Energy", width - 140, height - 27, 0xF);
				mc.fontRenderer.drawString("Essence", width - 125, height - 67, 0xF);
			}
		}
	}


	public static void startDrawingLines() {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	public static void drawSimpleLine(Point pointA, Point pointB, float width, int color, float transparency) {
		GL11.glLineWidth(width);
		GL11.glBegin(GL11.GL_LINES);
		Color colorRGB = new Color(color);
		GL11.glColor4ub((byte) colorRGB.getRed(), (byte) colorRGB.getGreen(), (byte) colorRGB.getBlue(), (byte) (transparency * 255));
		GL11.glVertex2i(pointA.x, pointA.y);
		GL11.glVertex2i(pointB.x, pointB.y);
		GL11.glEnd();
	}

	public static void endDrawingLines() {
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(1F, 1F, 1F, 1F);
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