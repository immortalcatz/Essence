package net.essence.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.essence.EssenceTabs;
import net.essence.blocks.BlockColouredBricks;
import net.essence.blocks.BlockMiniColouredBricks;
import net.essence.blocks.BlockStorageBlocks;
import net.essence.blocks.BlockStorageBlocks1;
import net.essence.blocks.BlockStorageBlocks2;
import net.essence.blocks.BlockStorageBlocks3;
import net.essence.items.ItemBackpack;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry {

    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<EssenceTabs> tabs = new ArrayList<EssenceTabs>();
    private static ArrayList<String> mobs = new ArrayList<String>();
    private final static String FILE_NAME = "/en_US.lang";
    private final static String[] PATHS = new String[] {"./Essence/resources/assets/eotg/lang", "./resources/assets/eotg/lang", "./main/resources/assets/eotg/lang", "./src/main/resources/assets/eotg/lang"};

    private static final LangRegistry instance = new LangRegistry();
    
    protected String fileName;
	protected String[] paths;
	protected BufferedWriter writer;

	public LangRegistry() {
		this.fileName = FILE_NAME;
		this.paths = PATHS;
		File file = null;
		boolean exists = false;
		for (int i = 0; i < paths.length; i++) {
			file = new File(paths[i]);
			exists = file.exists();
			if (exists) {
				file = new File(paths[i] + fileName);
				break;
			}
		}
		if(!exists) {
			file = new File("." + fileName);
		}
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void init(){
        instance.addNames();
        try {
			instance.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public static void addMisc() {
		instance.writeToFile("itemGroup.essence.blocks=Essence Of The Gods: Blocks");
		instance.writeToFile("itemGroup.essence.items=Essence Of The Gods: Items");
		instance.writeToFile("itemGroup.essence.weapons=Essence Of The Gods: Weapons");
		instance.writeToFile("itemGroup.essence.ranged=Essence Of The Gods: Ranged");
		instance.writeToFile("itemGroup.essence.tools=Essence Of The Gods: Tools");
		instance.writeToFile("itemGroup.essence.util=Essence Of The Gods: Utilities");
		instance.writeToFile("itemGroup.essence.misc=Essence Of The Gods: Misc.");
		instance.writeToFile("itemGroup.essence.armor=Essence Of The Gods: Armor");
		instance.writeToFile("itemGroup.essence.decoration=Essence Of The Gods: Decoration");
		for(int j = 0; j < 13; j++) instance.writeToFile("tile." + BlockColouredBricks.textures[j] + "ColouredBricks.name=" + BlockColouredBricks.names[j] + " Coloured Brick");
		for(int j = 0; j < 13; j++) instance.writeToFile("tile." + BlockMiniColouredBricks.textures[j] + "MiniColouredBricks.name=" + BlockMiniColouredBricks.names[j] + " Coloured Mini Brick");
		for(int j = 0; j < 13; j++) instance.writeToFile("item." + ItemBackpack.textures[j] + "backpack.name=" + ItemBackpack.names[j] + " Backpack");
		instance.writeToFile("tile.glowshroom_top.name=Glowshroom");
		instance.writeToFile("tile.glowshroom_bottom.name=Glowshroom");
		instance.writeToFile("tile.depthsSlab.name=Depths Slab");
		instance.writeToFile("tile.eucaSlab.name=Euca Slab");
		for(int j = 0; j < 16; j++) instance.writeToFile("tile." + BlockStorageBlocks.allNames[j] + "Storage.name=" + BlockStorageBlocks.allFinalNames[j] + " Storage Block");
		for(int j = 0; j < 16; j++) instance.writeToFile("tile." + BlockStorageBlocks1.names[j] + "Storage.name=" + BlockStorageBlocks1.allFinalNames[j] + " Storage Block");
		for(int j = 0; j < 16; j++) instance.writeToFile("tile." + BlockStorageBlocks2.names[j] + "Storage.name=" + BlockStorageBlocks2.allFinalNames[j] + " Storage Block");
		for(int j = 0; j < 11; j++) instance.writeToFile("tile." + BlockStorageBlocks3.names[j] + "Storage.name=" + BlockStorageBlocks3.allFinalNames[j] + " Storage Block");
	}
	
	public static void addOPFood(String name, String actual) {
		instance.writeToFile("item." + name + ".name=" + actual);
	}
	
	public static void addEnchantment(String name){
		instance.writeToFile("enchantment." + name + "=" + name);
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
    
    public void addItems(String un) {
		String name = un.substring(5);
		char firstLetter = name.charAt(0);
		int numChars = 0;
		if(Character.isLowerCase(firstLetter)) firstLetter = Character.toUpperCase(firstLetter);
		String inGame = name.substring(1);
		String temp = inGame;
		for(int p = 1; p < temp.length(); p++) {
			char c = inGame.charAt(p);
			int code = (int) c;
			if(inGame.charAt(p - 1) != ' ') {
				for(int n = 65; n < 90; n++) {
					if(code == n) inGame = new StringBuffer(inGame).insert(p, " ").toString();
				}
			}
		}
		String finalName = firstLetter + inGame;
		writeToFile("item." + name + ".name=" + finalName);
	}

	public void addBlocks(String un) {
		String name = un.substring(5);
		char firstLetter = name.charAt(0);
		int numChars = 0;
		if(Character.isLowerCase(firstLetter)) firstLetter = Character.toUpperCase(firstLetter);
		String inGame = name.substring(1);
		String temp = inGame;
		for(int p = 1; p < temp.length(); p++) {
			char c = inGame.charAt(p);
			int code = (int) c;
			if(inGame.charAt(p - 1) != ' ') {
				for(int n = 65; n < 90; n++) {
					if(code == n) inGame = new StringBuffer(inGame).insert(p, " ").toString();
				}
			}
		}
		String finalName = firstLetter + inGame;
		writeToFile("tile." + name + ".name=" + finalName);
	}

	public void addName(String kind, String name, String gameName){
		writeToFile(kind + '.' + name + '=' + gameName);
	}

	public void writeToFile(String text){
		try {
			writer.write(text + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void addNames() {
        for(Block block : blocks)
            addBlocks(block.getUnlocalizedName());
        for(Item item : items)
            addItems(item.getUnlocalizedName());
        addMobNames();
        addMisc();
    }
    
    public static void addMobNames(){
    	for(int i = 0; i < mobs.size(); i++){
    		String mob = mobs.get(i);
    		instance.writeToFile("entity." + mob + ".name=" + mob);
    	}
    }
}