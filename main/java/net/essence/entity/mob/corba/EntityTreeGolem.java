package net.essence.entity.mob.corba;

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

public class EntityTreeGolem extends EntityModMob{

	public EntityTreeGolem(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.2F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.treeGolemDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.treeGolemHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.BUSH;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.BUSH_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.BUSH_DEATH;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(1) == 0) dropItem(EssenceItems.corbaStick, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(10) == 0) dropItem(EssenceItems.corbaStick, 3);
		super.dropFewItems(b, j);
		if(rand.nextInt(5) == 0) dropItem(EssenceItems.enchantedLeaf, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(10) == 0) dropItem(EssenceItems.enchantedLeaf, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(15) == 0) dropItem(EssenceItems.natureTablet, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(30) == 0) dropItem(EssenceItems.natureTablet, 2);
		super.dropFewItems(b, j);
	
	}
}