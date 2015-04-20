package net.essence.items;

import net.essence.EssenceTabs;
import net.essence.entity.projectile.EntityPower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemPower extends ItemMod {

	private float damage;

	public ItemPower(String name, float dam) {
		super(name, EssenceTabs.ranged);
		damage = dam;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		EntityPower power = new EntityPower(world, player, damage);
		if(!world.isRemote) world.spawnEntityInWorld(power);
		return stack;
	}
}