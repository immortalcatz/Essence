package net.essence.client.render;

import java.nio.FloatBuffer;
import java.util.Random;

import net.essence.util.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

@SideOnly(Side.CLIENT)
public class CorbaPortalRenderer extends TileEntitySpecialRenderer {

	private static final ResourceLocation sky = new ResourceLocation(SlayerAPI.PREFIX + "textures/entity/corbaSky.png");
	private static final ResourceLocation portalCorba = new ResourceLocation(SlayerAPI.PREFIX + "textures/entity/corbaPortal.png");
	private static final ResourceLocation portalOverworld = new ResourceLocation(SlayerAPI.PREFIX + "textures/entity/overworldPortal.png");

	private static final Random random = new Random(31100L);
	private FloatBuffer buffer = GLAllocation.createDirectFloatBuffer(16);

	private FloatBuffer buff(float f, float x, float y, float z) {
		this.buffer.clear();
		this.buffer.put(f).put(x).put(y).put(z);
		this.buffer.flip();
		return this.buffer;
	}

	@Override
	public void renderTileEntityAt(TileEntity e, double x, double y, double z, float t, int i) {
		float f1 = (float)this.rendererDispatcher.entityX;
		float f2 = (float)this.rendererDispatcher.entityY;
		float f3 = (float)this.rendererDispatcher.entityZ;
		GlStateManager.disableLighting();
		random.setSeed(31100L);
		float f4 = 0.75F;
		for(int j = 0; j < 16; ++j) {
			GlStateManager.pushMatrix();
			float f5 = (float)(16 - j);
			float f6 = 0.0625F;
			float f7 = 1.0F / (f5 + 1.0F);
			if(e.getWorld().provider.getDimensionId() == Config.corba) {
				this.bindTexture(portalOverworld);
			} else {
				this.bindTexture(portalCorba);
			}
			if(j == 1) {
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(1, 1);
				f6 = 3.5F;
			}
			float f8 = (float)(-(y + (double)f4));
			float f9 = f8 + (float)ActiveRenderInfo.getPosition().yCoord;
			float f10 = f8 + f5 + (float)ActiveRenderInfo.getPosition().yCoord;
			float f11 = f9 / f10;
			f11 += (float)(y + (double)f4);
			GlStateManager.translate(f1, y, f3);
			GlStateManager.texGen(GlStateManager.TexGen.S, 9217);
			GlStateManager.texGen(GlStateManager.TexGen.T, 9217);
			GlStateManager.texGen(GlStateManager.TexGen.R, 9217);
			GlStateManager.texGen(GlStateManager.TexGen.Q, 9216);
			GlStateManager.func_179105_a(GlStateManager.TexGen.S, 9473, this.buff(1.0F, 0.0F, 0.0F, 0.0F));
			GlStateManager.func_179105_a(GlStateManager.TexGen.T, 9473, this.buff(0.0F, 0.0F, 1.0F, 0.0F));
			GlStateManager.func_179105_a(GlStateManager.TexGen.R, 9473, this.buff(0.0F, 0.0F, 0.0F, 1.0F));
			GlStateManager.func_179105_a(GlStateManager.TexGen.Q, 9474, this.buff(0.0F, 1.0F, 0.0F, 0.0F));
			GlStateManager.enableTexGenCoord(GlStateManager.TexGen.S);
			GlStateManager.enableTexGenCoord(GlStateManager.TexGen.T);
			GlStateManager.enableTexGenCoord(GlStateManager.TexGen.R);
			GlStateManager.enableTexGenCoord(GlStateManager.TexGen.Q);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.loadIdentity();
			GlStateManager.translate(0.0F, (float)(Minecraft.getSystemTime() % 700000L) / 700000.0F, 0.0F);
			GlStateManager.scale(-f6, -f6, -f6);
			GlStateManager.translate(0.5F, 0.5F, 0.0F);
			//GlStateManager.rotate((float)(j * j * 4321 + j * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.translate(-0.5F, -0.5F, 0.0F);
			GlStateManager.translate(-f1, -f3, -f2);
			f9 = f8 + (float)ActiveRenderInfo.getPosition().yCoord;
			GlStateManager.translate((float)ActiveRenderInfo.getPosition().xCoord * f5 / f9, (float)ActiveRenderInfo.getPosition().zCoord * f5 / f9, -f2);
			Tessellator tessellator = Tessellator.getInstance();
			WorldRenderer worldrenderer = tessellator.getWorldRenderer();
			worldrenderer.startDrawingQuads();
			float f12 = random.nextFloat() * 0.5F + 0.1F;
			float f13 = random.nextFloat() * 0.5F + 0.4F;
			float f14 = random.nextFloat() * 0.5F + 0.5F;
			if(j == 0) {
				f14 = 1.0F;
				f13 = 1.0F;
				f12 = 1.0F;
			}
			worldrenderer.setColorRGBA_F(f12 * f7, f13 * f7, f14 * f7, 1.0F);
			worldrenderer.addVertex(x, y + (double)f4, z);
			worldrenderer.addVertex(x, y + (double)f4, z + 1.0D);
			worldrenderer.addVertex(x + 1.0D, y + (double)f4, z + 1.0D);
			worldrenderer.addVertex(x + 1.0D, y + (double)f4, z);
			tessellator.draw();
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
		GlStateManager.disableBlend();
		GlStateManager.disableTexGenCoord(GlStateManager.TexGen.S);
		GlStateManager.disableTexGenCoord(GlStateManager.TexGen.T);
		GlStateManager.disableTexGenCoord(GlStateManager.TexGen.R);
		GlStateManager.disableTexGenCoord(GlStateManager.TexGen.Q);
		GlStateManager.enableLighting();
	}
}