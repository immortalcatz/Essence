package net.essence.client.render.gui;

import net.essence.items.tileentity.TileEntityBackpack;
import net.essence.items.tileentity.container.ContainerBackpack;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBackpack extends GuiContainer {
	
    public GuiBackpack(IInventory i, TileEntityBackpack i1) {
        super(new ContainerBackpack(i, i1));
    } 

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(I18n.format("container.backpack", new Object[0]), this.xSize / 2 - this.fontRendererObj.getStringWidth(I18n.format("container.backpack", new Object[0])) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/backpack.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, 176, 168);
    }
}