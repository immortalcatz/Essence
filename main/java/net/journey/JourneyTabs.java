package net.journey;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JourneyTabs extends CreativeTabs {
	
	public static final JourneyTabs blocks = new JourneyTabs("Blocks");
	public static final JourneyTabs decoraton = new JourneyTabs("Decoration");
	public static final JourneyTabs items = new JourneyTabs("Items");
	public static final JourneyTabs tools = new JourneyTabs("Tools");
	public static final JourneyTabs swords = new JourneyTabs("Swords");
	public static final JourneyTabs battleaxes = new JourneyTabs("Battleaxes");
	public static final JourneyTabs bows = new JourneyTabs("Bows");
	public static final JourneyTabs wands_staves = new JourneyTabs("Wands_Staves");
	public static final JourneyTabs util = new JourneyTabs("Utility");
	//public static final JourneyTabs misc = new JourneyTabs("Miscellaneous");
	public static final JourneyTabs armor = new JourneyTabs("Armor");
	public static final JourneyTabs spawners = new JourneyTabs("Spawners");
	public static final JourneyTabs crops = new JourneyTabs("Crops");
	public static final JourneyTabs ammunition = new JourneyTabs("Ammo");
	public static final JourneyTabs piercers = new JourneyTabs("Piercers");

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
		decoraton.setIcon(JourneyBlocks.terraniaLamp);
		spawners.setIcon(JourneyItems.sentryKingOrb);
		blocks.setIcon(JourneyBlocks.celestiumBlock);
		items.setIcon(JourneyItems.koriteIngot);
		tools.setIcon(JourneyItems.multiToolOfEternalSmelting);
		swords.setIcon(JourneyItems.fluffyBlade);
		bows.setIcon(JourneyItems.starlightBow);
		wands_staves.setIcon(JourneyItems.wizardsStar);
		util.setIcon(JourneyItems.flameCoin);
		//misc.setIcon(JourneyItems.weakDarkEnergyPotion);
		armor.setIcon(JourneyItems.twilightHelmet);
		crops.setIcon(JourneyItems.crackenCaneSeeds);
		ammunition.setIcon(JourneyItems.essenceArrow);
	}
}
