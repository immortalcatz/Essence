package net.essence.client.render;

import net.essence.EssenceBlocks;
import net.essence.blocks.BlockModOre;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class OreRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Tessellator tess = Tessellator.instance;
		block.setBlockBoundsForItemRender();
		renderer.setRenderBoundsFromBlock(block);
		Block render = Blocks.sandstone;
		
		if(block == EssenceBlocks.celestiumOre) render = EssenceBlocks.eucaStone;
		else if(block == EssenceBlocks.flairiumOre) render = EssenceBlocks.depthsStone;
		else if(block == EssenceBlocks.celestiumBlock) render = EssenceBlocks.celestiumBlockOverlay;
		else if(block == EssenceBlocks.flairiumBlock) render = EssenceBlocks.flairiumBlockOverlay;
		else if(block == EssenceBlocks.hellstoneBlock) render = EssenceBlocks.hellstoneBlockOverlay;
		else if(block == EssenceBlocks.shadiumBlock) render = EssenceBlocks.shadiumBlockOverlay;
		else if(block == EssenceBlocks.luniumBlock) render = EssenceBlocks.luniumBlockOverlay;
		else if(block == EssenceBlocks.hellstoneOre) render = Blocks.netherrack;
		else if(block == EssenceBlocks.sapphireOre) render = Blocks.stone;

		else render = Blocks.stone;
		
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);  
		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, render.getBlockTextureFromSide(0));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 0));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, render.getBlockTextureFromSide(1));  
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 1));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, render.getBlockTextureFromSide(2));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 2));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, render.getBlockTextureFromSide(3));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 3));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, render.getBlockTextureFromSide(4));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 4));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, render.getBlockTextureFromSide(5));
		tess.draw();
		tess.startDrawingQuads();
		tess.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSide(block, 5));
		tess.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		boolean out = false;
		if(block == EssenceBlocks.celestiumOre) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.eucaStone, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.celestiumOre, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.shadiumOre) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(Blocks.stone, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.shadiumOre, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.luniumOre) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(Blocks.stone, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.luniumOre, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.flairiumOre) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.depthsStone, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.flairiumOre, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.celestiumBlock) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.celestiumBlockOverlay, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.celestiumBlock, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.flairiumBlock) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.flairiumBlockOverlay, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.flairiumBlock, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.luniumBlock) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.luniumBlockOverlay, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.luniumBlock, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.hellstoneBlock) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.hellstoneBlockOverlay, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.hellstoneBlock, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.shadiumBlock) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(EssenceBlocks.shadiumBlockOverlay, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.shadiumBlock, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.hellstoneOre) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(Blocks.netherrack, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.hellstoneOre, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		
		if(block == EssenceBlocks.sapphireOre) {
			BlockModOre blk = (BlockModOre) block;
			blk.enhanceBrightness = false;
			renderer.renderStandardBlock(Blocks.stone, x, y, z);
			renderer.renderStandardBlock(EssenceBlocks.sapphireOre, x, y, z);
			blk.enhanceBrightness = true;

			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
			out = renderInWorld(blk, world, x, y, z, renderer);
			blk.getRendererInstance().setTemporaryRenderIcon(ExtraBlockTextures.getMissing());
		}
		return true;
	}
	
	public boolean renderInWorld(BlockModOre block, IBlockAccess world, int x, int y, int z, RenderBlocks renderer) {
		BaseBlockRender.preRenderInWorld(block, world, x, y, z, renderer);
		boolean o = renderer.renderStandardBlock(block, x, y, z);
		BaseBlockRender.postRenderInWorld(renderer );
		return o;
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