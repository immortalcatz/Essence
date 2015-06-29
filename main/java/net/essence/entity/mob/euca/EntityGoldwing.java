package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityGoldwing extends EntityPeacefullUntillAttacked {

	@SuppressWarnings("do this")
	public EntityGoldwing(World w) {
		super(w);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.rocDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.rocHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.rocMeat;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(6) == 0) dropItem(EssenceItems.rocFeather, 4);
		super.dropFewItems(b, j);
	}

}