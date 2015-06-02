package net.essence.misc;

import java.util.Random;

import net.essence.EssenceItems;
import net.minecraft.item.Item;

public class RandomItems {

	private Item[] overIngot = new Item[] {EssenceItems.shadiumIngot, EssenceItems.luniumIngot, EssenceItems.sapphire};
	private Item[] eucaIngot = new Item[] {EssenceItems.mekyumIngot, EssenceItems.storonIngot, EssenceItems.koriteIngot, EssenceItems.celestiumIngot};
	private Random r = new Random();
	
	private int random(int i) {
		return r.nextInt(i);
	}
	
	public Item getItemFromArrayIndex(Item[] item, int index) {
		return item[index];
	}
	
	public Item getRandomOverworldIngot() {
		return overIngot[random(overIngot.length)];
	}
	
	public Item getRandomEucaIngot() {
		return eucaIngot[random(eucaIngot.length)];
	}
}