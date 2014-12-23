package net.essence.client.render.gui;

import net.minecraft.entity.IMerchant;
import net.slayer.api.client.gui.GuiModVillager;
import net.slayer.api.entity.tileentity.container.ContainerModVillager;

public class GuiGreenElf extends GuiModVillager {

	public GuiGreenElf(ContainerModVillager container, IMerchant mer) {
		super(container, mer, "Green Elf", "basicVillager");
	}
}