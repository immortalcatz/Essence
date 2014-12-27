package net.essence.client.render.gui;

import net.essence.enums.EnumSounds;

public class GuiItemWiki extends GuiBookWiki {

	private int page = 0;
	
	@Override
	public void drawBckground() {
		switch(page) {
		case 0:
			fontRendererObj.drawString("HELLO", 50, 50, 0);
			break;
		}
	}


	@Override
	public void drawForeground() {

	}
	
	@Override
	public void initGui() {
		super.initGui();
		page1();
	}

	@Override
	public void buttonPressed(int id) {
		switch(id) {
		case 1:
			page1();
			EnumSounds.playSound(EnumSounds.PAGE_FLIP, mc.theWorld, mc.thePlayer);
			break;
		case 2:
			page1();
			EnumSounds.playSound(EnumSounds.PAGE_FLIP, mc.theWorld, mc.thePlayer);
			break;
		case 3:
			mc.thePlayer.closeScreen();
			break;
		}
	}

	private void page1() {
		buttonList.clear();
		final int x = this.width / 2;
		final int z = this.height / 2;
		fontRendererObj.drawString("HELLO", 50, 50, 0);
		addButtons();
		page = 1;
	}

	@Override
	public int maxPages() {
		return 0;
	}
}