package net.essence.entity.mob.vanilla;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityReaper extends EntityModMob{

	public EntityReaper(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.diamond_sword);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.reaperDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.reaperHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.REAPER.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.REAPER_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.REAPER_HURT.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return Items.coal;
	}
}