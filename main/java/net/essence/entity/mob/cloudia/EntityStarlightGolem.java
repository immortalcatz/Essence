package net.essence.entity.mob.cloudia;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityStarlightGolem extends EntityModMob {

	public EntityStarlightGolem(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(3F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.starlightGolemDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.starlightGolemHealth;
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
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(6) == 0) dropItem(EssenceItems.golemChunk, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(12) == 0) dropItem(EssenceItems.golemChunk, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(18) == 0) dropItem(EssenceItems.golemChunk, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(40) == 0) dropItem(EssenceItems.cloudiaOrb, 1);
		super.dropFewItems(b, j);
		
	}

	@Override
	public Item getItemDropped() {
		return null;
	}

}