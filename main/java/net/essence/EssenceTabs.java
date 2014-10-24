package net.essence;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class EssenceTabs extends CreativeTabs {
	
	public static final EssenceTabs blocks = new EssenceTabs("blocks");
	public static final EssenceTabs items = new EssenceTabs("items");
	public static final EssenceTabs tools = new EssenceTabs("tools1");
	public static final EssenceTabs weapons = new EssenceTabs("weapons");
	public static final EssenceTabs ranged = new EssenceTabs("ranged");
	public static final EssenceTabs util = new EssenceTabs("util");
	public static final EssenceTabs misc = new EssenceTabs("misc1");
	public static final EssenceTabs armor = new EssenceTabs("armor");

	public Item item;
	
	public EssenceTabs(String name) {
		super(name);
	}
	
    public void setIcon(Item icon) {
        this.item = icon;
    }

    public void setIcon(Block icon) {
        this.item = Item.getItemFromBlock(icon);
    }
	
	@Override
	public Item getTabIconItem() {
		return item;
	}
	
	public static void init(){
		blocks.setIcon(EssenceBlocks.celestiumBlock);
		items.setIcon(EssenceItems.hellstoneIngot);
		tools.setIcon(EssenceItems.hellstoneMultiTool);
		weapons.setIcon(EssenceItems.flairiumSword);
		ranged.setIcon(EssenceItems.staffOfHellstone);
		util.setIcon(EssenceItems.flameCoin);
		misc.setIcon(EssenceItems.weakDarkEnergyPotion);
		armor.setIcon(EssenceItems.hellstoneHelmet);
	}
}