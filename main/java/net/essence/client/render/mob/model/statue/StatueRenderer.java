package net.essence.client.render.mob.model.statue;

import net.essence.blocks.tileentity.TileEntityStatue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class StatueRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tick, int i) {
		float scale = 0.0F;
		if(te instanceof TileEntityStatue) {
			TileEntityStatue tes = (TileEntityStatue)te;
			int rotation = 0;
			if(tes.getWorld() != null) rotation = tes.getBlockMetadata();            
			Minecraft.getMinecraft().getTextureManager().bindTexture(tes.texture);
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			scale = 1.0F;
			if(tes.model instanceof ModelWraithStatue){
				scale = 0.5F;
				GL11.glTranslatef((float)x + 0.5F, (float)y + 0.7F, (float)z + 0.5F);
			} else if(tes.model instanceof ModelEnderChampionStatue){
				scale = 0.6F;
				GL11.glTranslatef((float)x + 0.5F, (float)y + 1.0F, (float)z + 0.5F);
			} else {
				GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
			}

			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			tes.model.render(0.0625F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}
}