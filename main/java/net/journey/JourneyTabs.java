package net.journey;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JourneyTabs extends CreativeTabs {
	
	public static final JourneyTabs blocks = new JourneyTabs("journey.blocks");
	public static final JourneyTabs decoraton = new JourneyTabs("journey.decoration");
	public static final JourneyTabs items = new JourneyTabs("journey.items");
	public static final JourneyTabs tools = new JourneyTabs("journey.tools");
	public static final JourneyTabs weapons = new JourneyTabs("journey.weapons");
	public static final JourneyTabs ranged = new JourneyTabs("journey.ranged");
	public static final JourneyTabs util = new JourneyTabs("journey.util");
	public static final JourneyTabs misc = new JourneyTabs("journey.misc");
	public static final JourneyTabs armor = new JourneyTabs("journey.armor");
	public static final JourneyTabs spawners = new JourneyTabs("journey.spawners");
	public static final JourneyTabs crops = new JourneyTabs("journey.crops");

	public Item item;
	
	public JourneyTabs(String name) {
		super(name);
	}
	
    public void setIcon(Item icon) {
        this.item = icon;
    }

    public void setIcon(Block icon) {
        this.item = Item.getItemFromBlock(icon);
    }
    
    public void setIcon(ItemStack icon) {
        this.item = icon.getItem();
    }
	
	@Override
	public Item getTabIconItem() {
		return item;
	}
	
	public static void init(){
		decoraton.setIcon(new ItemStack(JourneyBlocks.colouredBricks, 1, 5));
		spawners.setIcon(JourneyItems.sentryKingOrb);
		blocks.setIcon(JourneyBlocks.celestiumBlock);
		items.setIcon(JourneyItems.koriteIngot);
		tools.setIcon(JourneyItems.multiToolOfEternalSmelting);
		weapons.setIcon(JourneyItems.fluffyBlade);
		ranged.setIcon(JourneyItems.frozenBow);
		util.setIcon(JourneyItems.flameCoin);
		misc.setIcon(JourneyItems.weakDarkEnergyPotion);
		armor.setIcon(JourneyItems.twilightHelmet);
		crops.setIcon(JourneyItems.crackenCaneSeeds);
	}
}
