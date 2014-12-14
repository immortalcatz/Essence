package net.essence.client.render;

import net.essence.EssenceBlocks;
import net.essence.blocks.tileentity.TileEntityGrindstone;
import net.essence.client.render.mob.model.block.ModelGrindstone;
import net.essence.util.GL11Helper;
import net.essence.util.Textures;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class GrindstoneRenderer extends TileEntitySpecialRenderer {

	private Minecraft mc = Minecraft.getMinecraft();
	private RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

	@Override
	public void renderTileEntityAt(TileEntity e, double x, double y, double z, float f, int i) {
		ModelGrindstone stone = new ModelGrindstone();
		GL11.glPushMatrix();
		bindTexture(Textures.grindstone);
		GL11.glTranslated(x + 0.55, y + 2.3, z + 0.5);
		GL11.glRotatef(180F, 0.0F, 0F, 1.0F);
		float scale = 1.5F;
		GL11.glScalef(scale, scale, scale);
		if(((TileEntityGrindstone)e).isActivated()) {
			stone.render(0.0625F, false, ((TileEntityGrindstone)e).getRotaton());
			GL11.glPushMatrix();
			stone.setGrindstoneRotation(((TileEntityGrindstone)e).getRotaton());
			GL11.glPopMatrix();
		} else {
			stone.render(0.0625F, true, 0F);
		}
		GL11.glPopMatrix();

		Item toRender = ((TileEntityGrindstone)e).itemOnGrind;

		GL11.glPushMatrix();
		if(toRender != null) {
			GL11.glTranslated(x + 0.08, y + 1.2, z + 0.5);
			GL11Helper.scale(0.8F);
			renderItem.renderItemModel(new ItemStack(toRender));
		}
		GL11.glPopMatrix();
	}
}