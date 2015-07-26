package net.essence.items;

import net.essence.EssenceTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemPiercer extends ItemMod {

	private Class<? extends EntityThrowable> entity;
	private float damage = 0;
	
	public ItemPiercer(String name, String f, float damage, Class<? extends EntityThrowable> entity) {
		super(name, f);
		this.damage = damage;
		this.entity = entity;
		setCreativeTab(EssenceTabs.ranged);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		try {
			if(!world.isRemote) {
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				world.spawnEntityInWorld(entity.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
				if(!player.capabilities.isCreativeMode) stack.stackSize--;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stack;
	}
}