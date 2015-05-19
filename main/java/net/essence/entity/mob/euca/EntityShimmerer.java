package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityShimmerer extends EntityModMob {

	public EntityShimmerer(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.2F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.silverbotDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.silverbotHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.SHIMMERER;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SHIMMERER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SHIMMERER_DEATH;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(1) == 0) dropItem(EssenceItems.shimmerdust, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(1) == 0) dropItem(EssenceItems.shimmerdust, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(30) == 0) dropItem(EssenceItems.gateKeys, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(60) == 0) dropItem(EssenceItems.gateKeys, 4);
		super.dropFewItems(b, j);
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}