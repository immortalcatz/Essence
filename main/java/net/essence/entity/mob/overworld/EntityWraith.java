package net.essence.entity.mob.overworld;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityWraith extends EntityModMob {

	public static final int ENTITY_TYPE = 24;
	
	public EntityWraith(World par1World) {
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

	@SuppressWarnings("static-access")
	@Override
	public double setAttackDamage(MobStats s) {
		return s.mobWraithDamage;
	}

	@SuppressWarnings("static-access")
	@Override
	public double setMaxHealth(MobStats s) {
		return s.mobWraithHealth;
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
		return EssenceItems.demonicBone;
		
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(5) == 0) dropItem(EssenceItems.demonicDust, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(10) == 0) dropItem(EssenceItems.demonicDust, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(20) == 0) dropItem(EssenceItems.demonicDust, 5);
		super.dropFewItems(b, j);
		
	}
}