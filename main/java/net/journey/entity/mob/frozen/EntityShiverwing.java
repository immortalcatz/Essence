package net.journey.entity.mob.frozen;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityShiverwing extends EntityPeacefullUntillAttacked {

	public EntityShiverwing(World w) {
		super(w);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.rocDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.rocHealth;
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
		return JourneyItems.rocMeat;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(6) == 0) dropItem(JourneyItems.rocFeather, 4);
		super.dropFewItems(b, j);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.posY > 40.0D && super.getCanSpawnHere();
	}
}