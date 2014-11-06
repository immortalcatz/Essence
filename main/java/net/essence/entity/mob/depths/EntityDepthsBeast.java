package net.essence.entity.mob.depths;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityDepthsBeast extends EntityModMob{

	public EntityDepthsBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.2F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.depthsBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.depthsBeastHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.MAGMA_GIANT.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}