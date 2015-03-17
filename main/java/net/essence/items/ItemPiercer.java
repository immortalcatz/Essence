package net.essence.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemPiercer extends ItemMod {

	private Class<? extends EntityThrowable> entity;

	public ItemPiercer(String name, Class<? extends EntityThrowable> entity) {
		super(name);
		this.entity = entity;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		try {
			if(!world.isRemote) {
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				world.spawnEntityInWorld(Entity.class.getConstructor(World.class, EntityPlayer.class, float.class).newInstance(World.class, EntityPlayer.class, float.class));
				if(!player.capabilities.isCreativeMode) stack.stackSize--;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stack;
	}
}