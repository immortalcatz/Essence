package net.essence.client.render;

import net.essence.EssenceBlocks;
import net.essence.blocks.tileentity.TileEntityStatue;
import net.essence.client.render.model.statue.ModelEudorStatue;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

public class ModeledBlockInventoryRenderer extends TileEntityItemStackRenderer {

	private TileEntityItemStackRenderer te;

	public ModeledBlockInventoryRenderer(TileEntityItemStackRenderer te) {
		this.te = te;
	}

	@Override public void renderByItem(ItemStack itemStack) {
		Block block = Block.getBlockFromItem(itemStack.getItem());
		if (block == EssenceBlocks.calciaStatue) {
			//TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityStatue(new ResourceLocation(SlayerAPI.PREFIX + "textures/models/statues/eudorStatue.png"), new ModelEudorStatue()), 0, 0, 0, 0F);
			new ModelEudorStatue().render(0.0625F);
		} else {
			te.renderByItem(itemStack);
		}
	}
}