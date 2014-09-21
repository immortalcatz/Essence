package net.essence.client.render;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class OreRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Tessellator tess = Tessellator.instance;

		block.setBlockBoundsForItemRender();
		renderer.setRenderBoundsFromBlock(block);

		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);  

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, Blocks.stone.getBlockTextureFromSide(0));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 0));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, Blocks.stone.getBlockTextureFromSide(1));  
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 1));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, Blocks.stone.getBlockTextureFromSide(2));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 2));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, Blocks.stone.getBlockTextureFromSide(3));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 3));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, Blocks.stone.getBlockTextureFromSide(4));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 4));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, Blocks.stone.getBlockTextureFromSide(5));
		tess.draw();

		tess.startDrawingQuads();
		tess.setBrightness(240);
		tess.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 5));
		tess.draw();

		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if(block == EssenceBlocks.celestiumOre) {
			Tessellator tess = Tessellator.instance;
			
			int l = block.getMixedBrightnessForBlock(world, x, y, z);              
			tess.setBrightness(Blocks.stone.getMixedBrightnessForBlock(world, x, y, z));
			tess.setBrightness(block.getBlockBoundsMinY() > 0.0D ? l : 240);
			renderer.renderFaceYNeg(block, x, y, z, block.getBlockTextureFromSide(1));

			tess.setBrightness(block.getBlockBoundsMaxY() < 1.0D ? l : 240);
			renderer.renderFaceYPos(block, x, y, z, block.getBlockTextureFromSide(1)); 

			tess.setBrightness(block.getBlockBoundsMinZ() > 0.0D ? l : 240);
			renderer.renderFaceZNeg(block, x, y, z, block.getBlockTextureFromSide(2)); 

			tess.setBrightness(block.getBlockBoundsMaxZ() < 1.0D ? l : 240);
			renderer.renderFaceZPos(block, x, y, z, block.getBlockTextureFromSide(3));

			tess.setBrightness(block.getBlockBoundsMinX() > 0.0D ? l : 240);
			renderer.renderFaceXNeg(block, x, y, z, block.getBlockTextureFromSide(4)); 

			tess.setBrightness(block.getBlockBoundsMaxX() < 1.0D ? l : 240);
			renderer.renderFaceXPos(block, x, y, z, block.getBlockTextureFromSide(5));
		}
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderingRegistry.getNextAvailableRenderId();
	}
}