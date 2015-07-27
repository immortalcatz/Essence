package net.essence.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry {

	public static LangRegistry instance = new LangRegistry();

	public String location = "../src/main/Essence/main/resources/assets/essence/lang";
	private BufferedWriter writer;
	public static ArrayList<String> blockUnloc = new ArrayList<String>(), blockFinal = new ArrayList<String>(), itemUnloc = new ArrayList<String>(), itemFinal = new ArrayList<String>()
			, fileText = new ArrayList<String>();
	public static String[] brickNames = {"Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};
	public static String[] brickTextures = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};
	
	public static ArrayList<String> mobUnloc = new ArrayList<String>(), mobFinal = new ArrayList<String>();
	
	public LangRegistry() {
		File en_US = new File(location + "en_US.lang");
		try {
			en_US.mkdirs();
			if(en_US.exists()) en_US.delete();
			en_US.createNewFile();
			writer = new BufferedWriter(new FileWriter(en_US));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void misc() {
		writeToFile("itemGroup.essence.blocks=Essence Of The Gods: Blocks");
		writeToFile("itemGroup.essence.items=Essence Of The Gods: Items");
		writeToFile("itemGroup.essence.weapons=Essence Of The Gods: Weapons");
		writeToFile("itemGroup.essence.ranged=Essence Of The Gods: Ranged");
		writeToFile("itemGroup.essence.tools=Essence Of The Gods: Tools");
		writeToFile("itemGroup.essence.util=Essence Of The Gods: Utilities");
		writeToFile("itemGroup.essence.misc=Essence Of The Gods: Misc.");
		writeToFile("itemGroup.essence.armor=Essence Of The Gods: Armor");
		writeToFile("itemGroup.essence.decoration=Essence Of The Gods: Decoration");
		writeToFile("itemGroup.essence.spawners=Essence Of The Gods: Spawners");
		writeToFile("item.record.underwaterWorld.desc=Chris Geddes - Underwater World");
		writeToFile("item.record.blueWater.desc=Chris Geddes - Blue Water");
		writeToFile("item.record.raceStar.desc=Chris Geddes - Race Star");
		writeToFile("item.record.compBegins.desc=Chris Geddes - Comp Begins");
		writeToFile("item.record.deepBlue.desc=Chris Geddes - Deep Blue");
		writeToFile("item.record.raceShore.desc=Chris Geddes - Race Shore");
		writeToFile("enchantment.Hot Touch=Hot Touch");
		writeToFile("enchantment.Water Walker=Water Walker");
		for(int j = 0; j < 13; j++) writeToFile("tile." + brickTextures[j] + "ColouredBricks.name=" + brickNames[j] + " Coloured Brick");
		for(int j = 0; j < 13; j++) writeToFile("tile." + brickTextures[j] + "MiniColouredBricks.name=" + brickNames[j] + " Coloured Mini Brick");
	}

	public void register() {
		block();
		item();
		mob();
		misc();
		closeFile();
	}

	public static void addBlock(String unloc, String finalName) {
		blockUnloc.add(unloc);
		blockFinal.add(finalName);
	}

	public static void addItem(String unloc, String finalName) {
		itemUnloc.add(unloc);
		itemFinal.add(finalName);
	}
	
	public static void addMob(String unloc, String finalName) {
		mobUnloc.add(unloc);
		mobFinal.add(finalName);
	}

	public void block() {
		for(int i = 0; i < blockUnloc.size(); i++)
			writeToFile("tile." + blockUnloc.get(i) + ".name=" + blockFinal.get(i));
	}
	
	public void mob() {
		for(int i = 0; i < mobUnloc.size(); i++)
			writeToFile("entity." + mobUnloc.get(i) + ".name=" + mobFinal.get(i));
	}

	public void item() {
		for(int i = 0; i < itemUnloc.size(); i++)
			writeToFile("item." + itemUnloc.get(i) + ".name=" + itemFinal.get(i));
	}

	private void writeToFile(String s) {
		try {
			instance.writer.write(s + "\n");
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

	private void closeFile() {
		try {
			instance.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}