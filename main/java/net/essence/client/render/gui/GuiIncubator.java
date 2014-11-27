package net.essence.client.render.gui;

import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.blocks.tileentity.container.ContainerIncubator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiIncubator extends GuiContainer {
	
    private TileEntityIncubator tileFurnace;
    private String name, texture;

    public GuiIncubator(InventoryPlayer par1InventoryPlayer, TileEntityIncubator par2TileEntityFurnace) {
        super(new ContainerIncubator(par1InventoryPlayer, par2TileEntityFurnace));
        this.tileFurnace = par2TileEntityFurnace;
        this.name = "Incubator";
        this.texture = "incubator";
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String s = name;
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        s = "Inventory";
        this.fontRendererObj.drawString(s, 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int p_146j976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/" + texture + ".png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if(this.tileFurnace.isBurning()) {
            i1 = this.tileFurnace.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 57, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.tileFurnace.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 35, 176, 14, i1 + 1, 16);
    }
}