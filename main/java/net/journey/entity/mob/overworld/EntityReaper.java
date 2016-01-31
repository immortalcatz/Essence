package net.journey.entity.mob.overworld;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityReaper extends EntityModMob {

	protected int animID = 1;
	protected int animTick = 1;
	
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
	public EnumSounds setLivingSound() {
		return EnumSounds.REAPER;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.REAPER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.REAPER_HURT;
	}
	
	@Override
	public Item getItemDropped() {
		return JourneyItems.withicDust;
	}
}