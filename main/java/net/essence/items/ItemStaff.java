package net.essence.items;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.enums.EnumSounds;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemStaff extends ItemMod {

	private int usage, damage;
	private boolean essence, unBreakable;
	private Class<? extends EntityBasicProjectile> projectile; 
	
	public ItemStaff(String name, int magic, int uses, int dam, boolean essence, boolean unbreakable, Class<? extends EntityBasicProjectile> projectile) {
		super(name);
		this.projectile = projectile;
		damage = dam;
		usage = magic;
		this.unBreakable = unbreakable;
		this.essence = essence;
		setMaxDamage(uses);
		setMaxStackSize(1);
		setFull3D();
		setCreativeTab(EssenceTabs.ranged);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(essence) {
			try {
				spawnEntityIntoWorld(world, player, projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage), EssenceBar.useBar(usage), EnumSounds.STAFF.getPrefixedName(), unBreakable, stack, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				spawnEntityIntoWorld(world, player, projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage), DarkEnergyBar.useBar(usage), EnumSounds.STAFF.getPrefixedName(), unBreakable, stack, 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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