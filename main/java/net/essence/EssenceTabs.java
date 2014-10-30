package net.essence;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EssenceTabs extends CreativeTabs {
	
	public static final EssenceTabs blocks = new EssenceTabs("essence.blocks");
	public static final EssenceTabs decoraton = new EssenceTabs("essence.decoraton");
	public static final EssenceTabs items = new EssenceTabs("essence.items");
	public static final EssenceTabs tools = new EssenceTabs("essence.tools");
	public static final EssenceTabs weapons = new EssenceTabs("essence.weapons");
	public static final EssenceTabs ranged = new EssenceTabs("essence.ranged");
	public static final EssenceTabs util = new EssenceTabs("essence.util");
	public static final EssenceTabs misc = new EssenceTabs("essence.misc");
	public static final EssenceTabs armor = new EssenceTabs("essence.armor");

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
    
    public void setIcon(ItemStack icon) {
        this.item = icon.getItem();
    }
	
	@Override
	public Item getTabIconItem() {
		return item;
	}
	
	public static void init(){
		decoraton.setIcon(new ItemStack(EssenceBlocks.colouredBricks, 1, 5));
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