package net.journey.entity.mob.overworld;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntitySpectre extends EntityModMob {

	public static final int ENTITY_TYPE = 24;
	
	public EntitySpectre(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(2.0F, 1.0F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.lowJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.overworldHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.WRAITH;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.WRAITH_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.WRAITH_DEATH;
	}

	@Override
	public Item getItemDropped() {
		return JourneyItems.demonicBone;
		
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(5) == 0) dropItem(JourneyItems.demonicDust, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(10) == 0) dropItem(JourneyItems.demonicDust, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(20) == 0) dropItem(JourneyItems.demonicDust, 5);
		super.dropFewItems(b, j);
		
	}
}