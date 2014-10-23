package net.essence.items;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EnumSounds;
import net.essence.client.EssenceBar;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemStaff extends ItemMod {

	private int usage, damage;
	private boolean essence, unBreakable;

	public ItemStaff(String name, int magic, int uses, int dam, boolean essence, boolean unbreakable) {
		super(name);
		damage = dam;
		usage = magic;
		this.unBreakable = unbreakable;
		this.essence = essence;
		setMaxDamage(uses);
		setMaxStackSize(1);
		setFull3D();
		setCreativeTab(EssenceTabs.weapons);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(essence) spawnEntityIntoWorld(world, player, new EntityBasicProjectile(world, player, damage), EssenceBar.useBar(usage), EnumSounds.STAFF.getPrefixedName(), unBreakable, stack, 1);
		else spawnEntityIntoWorld(world, player, new EntityBasicProjectile(world, player, damage), DarkEnergyBar.useBar(usage), EnumSounds.STAFF.getPrefixedName(), unBreakable, stack, 1);
		return stack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add(SlayerAPI.Colour.DARK_AQUA + "Staff");
		list.add(SlayerAPI.Colour.DARK_GREEN + "Does " + damage + " ranged damage.");
		if(essence) list.add(SlayerAPI.Colour.DARK_GREEN + "Uses " + SlayerAPI.Colour.DARK_BLUE + usage * 2 + SlayerAPI.Colour.DARK_GREEN + " Essence.");
		else list.add(SlayerAPI.Colour.DARK_GREEN + "Uses " + SlayerAPI.Colour.DARK_BLUE + usage * 2 + SlayerAPI.Colour.DARK_GREEN + " Dark Energy.");
		if(unBreakable) list.add("Unbreakable");
		else list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining.");
	}
}