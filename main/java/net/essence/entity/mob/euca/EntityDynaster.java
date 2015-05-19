package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityDynaster extends EntityModMob{

	public static final int ENTITY_TYPE = 23;
	
	public EntityDynaster(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.0F, 1.7F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.dynasterDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.dynasterHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.DYNASTER;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.DYNASTER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.DYNASTER_DEATH;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
		return super.attackEntityFrom(e, a);

	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(54) == 0) dropItem(EssenceItems.royalDisk, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(5) == 0) dropItem(EssenceItems.shimmerdust, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(10) == 0) dropItem(EssenceItems.shimmerdust, 4);
		super.dropFewItems(b, j);
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}