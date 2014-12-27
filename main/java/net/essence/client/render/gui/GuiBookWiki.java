package net.essence.client.render.gui;

import net.essence.enums.EnumSounds;
import net.essence.util.ContainerEmpty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public abstract class GuiBookWiki extends GuiContainer{

	private int page;

	private static final ResourceLocation texture = new ResourceLocation(SlayerAPI.PREFIX + "textures/gui/wiki.png");
	private int bookImageWidth = 242;
	private int bookImageHeight = 150;

	public GuiBookWiki() {
		super(new ContainerEmpty());
	}

	public abstract int maxPages();
	public abstract void drawBckground();
	public abstract void drawForeground();
	public abstract void buttonPressed(int id);

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		drawForeground();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int b0 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
		drawBckground();
	}

	@Override
	protected void actionPerformed(GuiButton b) {
		buttonPressed(b.id);
	}

	public int xSize(){
		return (xSize / 2);
	}

	public int ySize(){
		return (ySize / 2);
	}
	
	public int height(){
		return (height / 2);
	}

	public int width(){
		return (width / 2);
	}

	public void addButtons(){
		final int x = this.width / 2 - 100;
		final int z = this.height / 2 - 175;
		this.buttonList.add(new GuiBookWiki.NextPageButton(1, x + 26, z + 220, false));
		this.buttonList.add(new GuiBookWiki.NextPageButton(2, x + 216, z + 220, true));
		this.buttonList.add(new GuiButton(3, x + 35, z + 250, "Exit"));
	}

	@SideOnly(Side.CLIENT)
	public class NextPageButton extends GuiButton {
		private final boolean reverseTex;

		public NextPageButton(int par1, int par2, int par3, boolean par4) {
			super(par1, par2, par3, 23, 13, "");
			this.reverseTex = par4;
		}

		@Override
		public void drawButton(Minecraft m, int p_146112_2_, int p_146112_3_) {
			if (this.visible) {
				boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				m.getTextureManager().bindTexture(GuiBookWiki.texture);
				int k = 0, l = 192;
				if(flag) 
					k += 23;
				if(!this.reverseTex) 
					l += 13;
				this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
			}
		}

		@Override
		public void playPressSound(SoundHandler soundHandlerIn) {
			soundHandlerIn.playSound(new PositionedSoundRecord(new ResourceLocation(EnumSounds.PAGE_FLIP.getNonPrefixedName()), 1.0F, 1.0F, (float)mc.thePlayer.posX, (float)mc.thePlayer.posY, (float)mc.thePlayer.posZ));
		}
	}
}