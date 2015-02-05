package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.entity.projectile.EntityChaosProjectile;
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
				if(!world.isRemote) {
					if(EssenceBar.instance.useBar(usage, world)) {
						world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
						EnumSounds.playSound(EnumSounds.SPARKLE, world, player);
						stack.damageItem(1, player);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				if(!world.isRemote) {
					if(DarkEnergyBar.instance.useBar(usage, world)) {
						world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
						EnumSounds.playSound(EnumSounds.SPARKLE, world, player);
						stack.damageItem(1, player);
					}
				}
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
		if(this == EssenceItems.lightningWand) list.add("Spawns lightning on impact.");
		if(essence) list.add(SlayerAPI.Colour.DARK_GREEN + "Uses " + SlayerAPI.Colour.DARK_BLUE + usage + SlayerAPI.Colour.DARK_GREEN + " Essence.");
		else list.add(SlayerAPI.Colour.DARK_GREEN + "Uses " + SlayerAPI.Colour.DARK_BLUE + usage + SlayerAPI.Colour.DARK_GREEN + " Dark Energy.");
		if(unBreakable) list.add("Unbreakable");
		else list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining.");
	}
}