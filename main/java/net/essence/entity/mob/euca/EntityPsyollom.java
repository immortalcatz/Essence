package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityPsyollom extends EntityModMob {

	public static final int ENTITY_TYPE = 25;
	
	public EntityPsyollom(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.7F, 2.7F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.psyollomDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.psyollomHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.PSYOLLOM.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.PSYOLLOM_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.PSYOLLOM_HURT.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaMeat;
	}
}