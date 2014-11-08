package net.essence.entity.mob.boiling;

import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityCrisp extends EntityModMob{

	public EntityCrisp(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.crispDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.crispHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.SPIKED_BEAST.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SPIKED_BEAST_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SPIKED_BEAST_HURT.getPrefixedName();
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