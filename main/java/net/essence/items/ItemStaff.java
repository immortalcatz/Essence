package net.essence.items;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.server.DarkEnergyBar;
import net.essence.client.server.EssenceBar;
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

	protected int usage;
	protected int damage;
	protected boolean essence, unBreakable;
	protected Class<? extends EntityBasicProjectile> projectile; 

	public ItemStaff(String name, boolean essence, int magic, int uses, int dam, boolean unbreakable, Class<? extends EntityBasicProjectile> projectile) {
		super(name);
		this.projectile = projectile;
		damage = dam;
		usage = magic;
		this.essence = essence;
		this.unBreakable = unbreakable;
		setMaxDamage(uses);
		setMaxStackSize(1);
		setFull3D();
		setCreativeTab(EssenceTabs.ranged);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(essence) {
			if(!world.isRemote && EssenceBar.getProperties(player).useBar(usage)) {
				EnumSounds.playSound(EnumSounds.SPARKLE, world, player);
				if(!unBreakable) stack.damageItem(1, player);
				try {
					world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if(!world.isRemote && DarkEnergyBar.getProperties(player).useBar(usage)) {
					EnumSounds.playSound(EnumSounds.SPARKLE, world, player);
					if(!unBreakable) stack.damageItem(1, player);
					try {
						world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return stack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add(SlayerAPI.Colour.DARK_GREEN + "Does " + damage + " ranged damage.");
		if(essence) list.add("Uses " + usage + " Essence.");
		else list.add("Uses " + usage + " Dark Energy.");
		if(unBreakable) list.add("Unbreakable");
		else list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses Remaining.");
	}
}