package net.essence.entity.mob.boiling;

import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityBurntAsh extends EntityModMob{

	public EntityBurntAsh(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.burntAshDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.burntAshHealth;
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
	protected void attackEntity(Entity e, float a) {
		super.attackEntity(e, a);
		((EntityPlayer)e).setFire(5 + rand.nextInt(7));
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.ash;
	}
}