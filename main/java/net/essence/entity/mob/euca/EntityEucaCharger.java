package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityEucaCharger extends EntityModMob {

	public EntityEucaCharger(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.2F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.eucaChargerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.eucaChargerHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.HONGO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SAND_CRAWLER;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SAND_CRAWLER;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(54) == 0) dropItem(EssenceItems.gateKeys, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(5) == 0) dropItem(EssenceItems.shimmerdust, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(10) == 0) dropItem(EssenceItems.shimmerdust, 4);
		super.dropFewItems(b, j);
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}