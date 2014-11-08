package net.essence.entity.mob.depths;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityDepthsHunter extends EntityModMob{

	public EntityDepthsHunter(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.2F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.depthsHunterDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.depthsHunterHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.DEPTHS_HUNTER.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.DEPTHS_HUNTER_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.DEPTHS_HUNTER_HURT.getPrefixedName();
	}
	
	@Override
	protected void attackEntity(Entity e, float a) {
		super.attackEntity(e, a);
		((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.jump.id, 60, 5));
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}