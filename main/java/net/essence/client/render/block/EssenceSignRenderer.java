package net.essence.client.render.block;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.blocks.tileentity.TileEntityEssenceSign;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EssenceSignRenderer extends TileEntitySpecialRenderer {
	
    private static final ResourceLocation tex = new ResourceLocation("textures/entity/sign.png");
    private final ModelSign model = new ModelSign();

    public void render(TileEntityEssenceSign sign, double x, double y, double z, float ticks, int i) {
        Block block = sign.getBlockType();
        GlStateManager.pushMatrix();
        float f1 = 0.6666667F;
        float f3;

        if (block == EssenceBlocks.essenceStandingSign) {
            GlStateManager.translate((float)x + 0.5F, (float)y + 0.75F * f1, (float)z + 0.5F);
            float f2 = (float)(sign.getBlockMetadata() * 360) / 16.0F;
            GlStateManager.rotate(-f2, 0.0F, 1.0F, 0.0F);
            this.model.signStick.showModel = true;
        } else {
            int k = sign.getBlockMetadata();
            f3 = 0.0F;

            if (k == 2) {
                f3 = 180.0F;
            }

            if (k == 4) {
                f3 = 90.0F;
            }

            if (k == 5) {
                f3 = -90.0F;
            }

            GlStateManager.translate((float)x + 0.5F, (float)y + 0.75F * f1, (float)z + 0.5F);
            GlStateManager.rotate(-f3, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, -0.3125F, -0.4375F);
            this.model.signStick.showModel = false;
        }

        if (i >= 0) {
            this.bindTexture(DESTROY_STAGES[i]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 2.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        } else {
            this.bindTexture(tex);
        }

        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.scale(f1, -f1, -f1);
        this.model.renderSign();
        GlStateManager.popMatrix();
        FontRenderer fontrenderer = this.getFontRenderer();
        f3 = 0.015625F * f1;
        GlStateManager.translate(0.0F, 0.5F * f1, 0.07F * f1);
        GlStateManager.scale(f3, -f3, f3);
        GL11.glNormal3f(0.0F, 0.0F, -1.0F * f3);
        GlStateManager.depthMask(false);
        byte b0 = 0;

        if (i < 0) {
            for (int j = 0; j < sign.signText.length; ++j) {
                if (sign.signText[j] != null) {
                    IChatComponent ichatcomponent = sign.signText[j];
                    List list = GuiUtilRenderComponents.func_178908_a(ichatcomponent, 90, fontrenderer, false, true);
                    String s = list != null && list.size() > 0 ? ((IChatComponent)list.get(0)).getFormattedText() : "";

                    if (j == sign.lineBeingEdited) {
                        s = "> " + s + " <";
                        fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - sign.signText.length * 5, b0);
                    } else {
                        fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - sign.signText.length * 5, b0);
                    }
                }
            }
        }

        GlStateManager.depthMask(true);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();

        if (i >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int i) {
        this.render((TileEntityEssenceSign)entity, x, y, z, f, i);
    }
}