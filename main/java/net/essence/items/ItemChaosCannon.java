package net.essence.items;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.EssenceBar;
import net.essence.entity.projectile.EntityChaosProjectile;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemChaosCannon extends ItemMod {

	public ItemChaosCannon(String name) {
		super(name, EssenceTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(500);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		spawnEntityIntoWorld(world, player, new EntityChaosProjectile(world, player), EssenceBar.useBar(10), EnumSounds.STAFF.getPrefixedName(), true, stack, 1);
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l) {
		l.add(SlayerAPI.Colour.DARK_GREEN + "Spawns a weak bouncing projectile");
		l.add(SlayerAPI.Colour.DARK_GREEN + "Rapid fire");
		l.add(SlayerAPI.Colour.DARK_GREEN + "Infinite ammo");
		l.add(SlayerAPI.Colour.DARK_GREEN + "Uses 10 Essence");
		l.add(i.getMaxDamage() - i.getItemDamage() + SlayerAPI.Colour.DARK_GREEN + " Uses remaining");
	}
}