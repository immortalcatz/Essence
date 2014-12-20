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
	public String setLivingSound() {
		return EnumSounds.HONGO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaMeat;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(70) == 0) dropItem(EssenceItems.eucaTablet, 1);
		super.dropFewItems(b, j);
	}
}