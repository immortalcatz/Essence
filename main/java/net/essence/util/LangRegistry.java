package net.essence.util;

import java.util.ArrayList;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry extends RegistryFile {

    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<EssenceTabs> tabs = new ArrayList<EssenceTabs>();
    private static ArrayList<String> mobs = new ArrayList<String>();
    private final static String FILE_NAME = "/en_US.lang";
    private final static String[] PATHS = new String[] {"./Essence/resources/assets/eotg/lang", "./resources/assets/eotg/lang", "./main/resources/assets/eotg/lang", "./src/main/resources/assets/eotg/lang"};

    private static final RegistryFile instance = new LangRegistry();
    
    public LangRegistry() {
        super(FILE_NAME, PATHS);
    }

    public static void registerNames(){
        instance.addNames();
        instance.closeFile();
    }

	public static void addMisc() {
		instance.addToFile("itemGroup.blocks=Essence Of The Gods: Blocks");
		instance.addToFile("itemGroup.items=Essence Of The Gods: Items");
		instance.addToFile("itemGroup.weapons=Essence Of The Gods: Weapons");
		instance.addToFile("itemGroup.tools1=Essence Of The Gods: Tools");
		instance.addToFile("itemGroup.util=Essence Of The Gods: Utilities");
		instance.addToFile("itemGroup.misc1=Essence Of The Gods: Misc.");
		instance.addToFile("itemGroup.armor=Essence Of The Gods: Armor");
		instance.addToFile("enchantment.HotTouch=Hot Touch");
	}

	public static void addMob(String name) {
		mobs.add(name);
	}
    
    public static void addBlock(Block block) {
        blocks.add(block);
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void addNames() {
        for(Block block : blocks)
            localizeName("tile", block.getUnlocalizedName());
        for(Item item : items)
            localizeName("item", item.getUnlocalizedName());
        addMobNames();
        addMisc();
    }
    
    public static void addMobNames(){
    	for(int i = 0; i < mobs.size(); i++){
    		String mob = mobs.get(i);
    		instance.addToFile("entity." + mob + ".name=" + mob);
    	}
    }
}