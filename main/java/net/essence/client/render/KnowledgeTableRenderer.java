package net.essence.client.render;

import javax.vecmath.Vector3f;

import org.lwjgl.opengl.GL11;

import net.essence.EssenceItems;
import net.essence.blocks.tileentity.TileEntityKnowledgeTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemTransformVec3f;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;

public class KnowledgeTableRenderer extends TileEntitySpecialRenderer {

	private Minecraft mc = Minecraft.getMinecraft();
	private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f, int j) {
		TileEntityKnowledgeTable tile = (TileEntityKnowledgeTable)t;
		float scale = 0.5F;
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 1.0D, z + 0.5D);
		ItemStack i = new ItemStack(EssenceItems.blankKnowledge);
		GL11.glRotatef(tile.getRotation(), 0.0F, 1.0F, 0.0F);
		GL11.glScalef(scale, scale, scale);
		renderItem.renderItemModel(i);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		renderText(StatCollector.translateToLocal(i.getItem().getUnlocalizedName() + ".name"), x + 0.5F, y + 1.5F, z + 0.5F);
		GL11.glPopMatrix();
	}

	public void renderText(String s, double x, double y, double z) {
		FontRenderer fontrenderer = mc.fontRendererObj;
		float f = 1.6F;
		float f1 = 0.016666668F * f;
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-this.mc.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.mc.getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
		GlStateManager.scale(-f1, -f1, f1);
		GlStateManager.disableLighting();
		GlStateManager.depthMask(false);
		GlStateManager.disableDepth();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		byte b0 = 0;
		GlStateManager.disableTexture2D();
		worldrenderer.startDrawingQuads();
		int j = fontrenderer.getStringWidth(s) / 2;
		worldrenderer.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
		worldrenderer.addVertex((double)(-j - 1), (double)(-1 + b0), 0.0D);
		worldrenderer.addVertex((double)(-j - 1), (double)(8 + b0), 0.0D);
		worldrenderer.addVertex((double)(j + 1), (double)(8 + b0), 0.0D);
		worldrenderer.addVertex((double)(j + 1), (double)(-1 + b0), 0.0D);
		tessellator.draw();
		GlStateManager.enableTexture2D();
		fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, b0, 553648127);
		GlStateManager.enableDepth();
		GlStateManager.depthMask(true);
		fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, b0, -1);
		GlStateManager.enableLighting();
		GlStateManager.disableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.popMatrix();
	}
}