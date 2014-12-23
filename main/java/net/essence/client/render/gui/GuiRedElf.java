package net.essence.client.render.gui;

import net.minecraft.entity.IMerchant;
import net.slayer.api.client.gui.GuiModVillager;
import net.slayer.api.entity.tileentity.container.ContainerModVillager;

public class GuiRedElf extends GuiModVillager {

	public GuiRedElf(ContainerModVillager container, IMerchant mer) {
		super(container, mer, "Red Elf", "basicVillager");
	}
}