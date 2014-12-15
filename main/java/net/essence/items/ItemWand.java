package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;

public class ItemWand extends ItemStaff {

	public ItemWand(String name, int magic, int uses, int dam, boolean essence, boolean unbreakable, Class<? extends EntityBasicProjectile> projectile) {
		super(name, magic, uses, dam, essence, unbreakable, projectile);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(essence) {
			try {
				spawnEntityIntoWorld(world, player, projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage), EssenceBar.useBar(usage), EnumSounds.SPARKLE.getPrefixedName(), unBreakable, stack, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				spawnEntityIntoWorld(world, player, projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage), DarkEnergyBar.useBar(usage), EnumSounds.SPARKLE.getPrefixedName(), unBreakable, stack, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list) {
		list.add(SlayerAPI.Colour.DARK_AQUA + "Wand");
		list.add(SlayerAPI.Colour.DARK_GREEN + "Does " + damage + " ranged damage.");
		if(this == EssenceItems.fireWand) list.add("Sets the victim on fire for 5 seconds.");
		if(essence) list.add(SlayerAPI.Colour.DARK_GREEN + "Uses " + SlayerAPI.Colour.DARK_BLUE + usage * 2 + SlayerAPI.Colour.DARK_GREEN + " Essence.");
		else list.add(SlayerAPI.Colour.DARK_GREEN + "Uses " + SlayerAPI.Colour.DARK_BLUE + usage * 2 + SlayerAPI.Colour.DARK_GREEN + " Dark Energy.");
		if(unBreakable) list.add("Unbreakable");
		else list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining.");
	}
}