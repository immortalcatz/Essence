package net.essence.items;

import net.essence.enums.EnumKnowledge;
import net.slayer.api.item.ItemMod;

public class ItemKnowledge extends ItemMod {

	private EnumKnowledge[] knowledge;
	
	public ItemKnowledge(String name, EnumKnowledge...knowledge) {
		super(name);
		this.knowledge = knowledge;
	}
	
	private EnumKnowledge getPrefferedKnowledge() {
		return knowledge[0];
	}
	
	private EnumKnowledge[] getKnowledges() {
		return knowledge;
	}
	
	private EnumKnowledge getKnowledge(int index) {
		return knowledge[index];
	}
}