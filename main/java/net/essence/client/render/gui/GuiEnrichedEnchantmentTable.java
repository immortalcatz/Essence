package net.essence.client.render.gui;

import java.util.Random;

import net.essence.blocks.tileentity.container.ContainerEnrichedTable;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEnrichedEnchantmentTable extends GuiContainer {
	
    private static final ResourceLocation tex1 = new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/enrichedEnchantmentTable.png");
    private static final ResourceLocation tex2 = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private static final ModelBook bookModel = new ModelBook();
    private Random rand = new Random();
    private ContainerEnrichedTable container;
    public int flipPages;
    public float bookX;
    public float bookX1;
    public float bookY;
    public float bookY1;
    public float bookZ;
    public float bookZ1;
    private ItemStack itemstack;
    private float xSizeFloat;
    private float ySizeFloat;
    
    public GuiEnrichedEnchantmentTable(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5, EntityPlayer player) {
        super(new ContainerEnrichedTable(par1InventoryPlayer, par2World, par3, par4, par5, player));
        this.container = (ContainerEnrichedTable)this.inventorySlots;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString("Enriched Enchanting Table", 0, 5, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ItemStack itemstack = this.inventorySlots.getSlot(0).getStack();
        if(!ItemStack.areItemStacksEqual(itemstack, this.itemstack)) {
            this.itemstack = itemstack;
            do this.bookY += (float)(this.rand.nextInt(4) - this.rand.nextInt(4));
            while (this.bookX <= this.bookY + 1.0F && this.bookX >= this.bookY - 1.0F);
        }

        ++this.flipPages;
        this.bookX1 = this.bookX;
        this.bookZ1 = this.bookZ;
        boolean flag = false;

        for(int i = 0; i < 3; ++i) {
            if(this.container.enchantLevels[i] != 0) 
                flag = true;
        }
        
        if(flag) this.bookZ += 0.2F;     
        else this.bookZ -= 0.2F;
        if(this.bookZ < 0.0F) this.bookZ = 0.0F;
        if(this.bookZ > 1.0F) this.bookZ = 1.0F;
        float f1 = (this.bookY - this.bookX) * 0.4F;
        float f = 0.2F;
        if(f1 < -f) f1 = -f;
        if(f1 > f) f1 = f;
        this.bookY1 += (f1 - this.bookY1) * 0.9F;
        this.bookX += this.bookY1;
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {
        super.mouseClicked(par1, par2, par3);
        int l = (this.width - this.xSize) / 2;
        int i1 = (this.height - this.ySize) / 2;
        for(int j1 = 0; j1 < 3; ++j1) {
            int k1 = par1 - (l + 60);
            int l1 = par2 - (i1 + 14 + 19 * j1);
            if(k1 >= 0 && l1 >= 0 && k1 < 108 && l1 < 19 && this.container.enchantItem(this.mc.thePlayer, j1))
                this.mc.playerController.sendEnchantPacket(this.container.windowId, j1);
        }
    }
    
    @Override
    public void drawScreen(int x, int y, float f) {
        super.drawScreen(x, y, f);
        this.xSizeFloat = (float)x;
        this.ySizeFloat = (float)y;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex1);
        xSize = 254;
        ySize = 166;
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
        //this.drawTexturedModalRect(k + 183, l + 163, 189, 175, 67, 81);
        
        GL11.glPushMatrix();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        GL11.glViewport((scaledresolution.getScaledWidth() - 320) / 2 * scaledresolution.getScaleFactor(), (scaledresolution.getScaledHeight() - 240) / 2 * scaledresolution.getScaleFactor(), 320 * scaledresolution.getScaleFactor(), 240 * scaledresolution.getScaleFactor());
        GL11.glTranslatef(-0.62F, 0.26F, 0.0F);
        Project.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
        float f1 = 1.0F;
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        RenderHelper.enableStandardItemLighting();
        GL11.glTranslatef(0.0F, 3.3F, -16.0F);
        GL11.glScalef(f1, f1, f1);
        float f2 = 5.0F;
        GL11.glScalef(f2, f2, f2);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(tex2);
        GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
        float f3 = this.bookZ1 + (this.bookZ - this.bookZ1) * f;
        GL11.glTranslatef((1.0F - f3) * 0.2F, (1.0F - f3) * 0.1F, (1.0F - f3) * 0.25F);
        GL11.glRotatef(-(1.0F - f3) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        float f4 = this.bookX1 + (this.bookX - this.bookX1) * f + 0.25F;
        float f5 = this.bookX1 + (this.bookX - this.bookX1) * f + 0.75F;
        f4 = (f4 - (float)MathHelper.truncateDoubleToInt((double)f4)) * 1.6F - 0.3F;
        f5 = (f5 - (float)MathHelper.truncateDoubleToInt((double)f5)) * 1.6F - 0.3F;
        if(f4 < 0.0F) f4 = 0.0F;
        if(f5 < 0.0F) f5 = 0.0F;      
        if(f4 > 1.0F) f4 = 1.0F;
        if(f5 > 1.0F) f5 = 1.0F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        bookModel.render((Entity)null, 0.0F, f4, f5, f3, 0.0F, 0.0625F);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        EnchantmentNameParts.func_178176_a().reseedRandomGenerator(this.container.nameSeed);
        for (int i1 = 0; i1 < 3; ++i1) {
            String s = EnchantmentNameParts.func_178176_a().generateNewRandomName();
            this.zLevel = 0.0F;
            this.mc.getTextureManager().bindTexture(tex1);
            int j1 = this.container.enchantLevels[i1];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(j1 == 0) this.drawTexturedModalRect(k + 60, l + 14 + 19 * i1, 0, 185, 108, 19);
             else {
                String s1 = "" + j1;
                FontRenderer fontrenderer = this.mc.standardGalacticFontRenderer;
                int k1 = 6839882;
                if(this.mc.thePlayer.experienceLevel < j1 && !this.mc.thePlayer.capabilities.isCreativeMode) {
                    this.drawTexturedModalRect(k + 60, l + 14 + 19 * i1, 0, 185, 108, 19);
                    fontrenderer.drawSplitString(s, k + 62, l + 16 + 19 * i1, 104, (k1 & 16711422) >> 1);
                    fontrenderer = this.mc.fontRendererObj;
                    k1 = 4226832;
                    fontrenderer.drawString(s1, k + 62 + 104 - fontrenderer.getStringWidth(s1), l + 16 + 19 * i1 + 7, k1);
                } else {
                    int l1 = i - (k + 60);
                    int i2 = j - (l + 14 + 19 * i1);
                    if(l1 >= 0 && i2 >= 0 && l1 < 108 && i2 < 19) {
                        this.drawTexturedModalRect(k + 60, l + 14 + 19 * i1, 0, 204, 108, 19);
                        k1 = 16777088;
                    } 
                    else this.drawTexturedModalRect(k + 60, l + 14 + 19 * i1, 0, 166, 108, 19);
                    fontrenderer.drawSplitString(s, k + 62, l + 16 + 19 * i1, 104, k1);
                    fontrenderer = this.mc.fontRendererObj;
                    k1 = 8453920;
                    fontrenderer.drawString(s1, k + 62 + 104 - fontrenderer.getStringWidth(s1), l + 16 + 19 * i1 + 7, k1);
                }
            }
        }
        renderPlayer(k + 220, l + 70, 30, (float)(k + 51) - xSizeFloat, (float)(l + 75 - 50) - ySizeFloat, this.mc.thePlayer);
    }
    
    public static void renderPlayer(int x, int y, int scale, float yaw, float rotation, EntityLivingBase player) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, 50.0F);
        GL11.glScalef((float)(-scale), (float)scale, (float)scale);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = player.renderYawOffset;
        float f3 = player.rotationYaw;
        float f4 = player.rotationPitch;
        float f5 = player.prevRotationYawHead;
        float f6 = player.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(rotation / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        player.renderYawOffset = (float)Math.atan((double)(yaw / 40.0F)) * 20.0F;
        player.rotationYaw = (float)Math.atan((double)(yaw / 40.0F)) * 40.0F;
        player.rotationPitch = -((float)Math.atan((double)(rotation / 40.0F))) * 20.0F;
        player.rotationYawHead = player.rotationYaw;
        player.prevRotationYawHead = player.rotationYaw;
        GL11.glTranslatef(0.0F, player.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(player, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        player.renderYawOffset = f2;
        player.rotationYaw = f3;
        player.rotationPitch = f4;
        player.prevRotationYawHead = f5;
        player.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}