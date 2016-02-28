package net.journey.items;

import java.util.List;

import net.journey.JourneyTabs;
import net.journey.client.server.DarkEnergyBar;
import net.journey.client.server.EssenceBar;
import net.journey.entity.projectile.EntityChaosProjectile;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemChaosCannon extends ItemMod {

	public ItemChaosCannon(String name, String f) {
		super(name, f, JourneyTabs.wands_staves);
		setMaxStackSize(1);
		setMaxDamage(500);
		setFull3D();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			if(DarkEnergyBar.getProperties(player).useBar(1)) {
				world.spawnEntityInWorld(new EntityChaosProjectile(world, player));
				EnumSounds.playSound(EnumSounds.CANNON, world, player);
				stack.damageItem(1, player);
			}
		}
		return stack;
	}

	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l) {
		l.add("Rapid fire");
		l.add("Infinite ammo");
		l.add("Uses 1 Essence");
		l.add(i.getMaxDamage() - i.getItemDamage() + SlayerAPI.Colour.DARK_GREEN + " Uses remaining");
	}
}