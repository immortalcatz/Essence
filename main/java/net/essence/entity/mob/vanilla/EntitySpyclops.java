package net.essence.entity.mob.vanilla;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntitySpyclops extends EntityModMob {

	public static final int ENTITY_TYPE = 24;
	
	public EntitySpyclops(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.5F, 2.0F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.spyclopsDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.spyclopsHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.SPYCLOPS.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SPYCLOPS.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SPYCLOPS_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return Items.spider_eye;
	}
}