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

public class EntityInsecto extends EntityModMob{

	public static final int ENTITY_TYPE = 23;
	
	public EntityInsecto(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.7F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.insectoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.insectoHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.INSECTO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.INSECTO_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.INSECTO_HURT.getPrefixedName();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaMeat;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(70) == 0) dropItem(EssenceItems.eucaTablet, 1);
		super.dropFewItems(b, j);
	}
}