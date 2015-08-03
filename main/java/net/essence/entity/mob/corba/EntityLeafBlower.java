package net.essence.entity.mob.corba;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityLeafBlower extends EntityModMob{

	public EntityLeafBlower(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.2F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.leafBlowerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.leafBlowerHealth;
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
	public Item getItemDropped() {
		return null; 
	
	}
		
	@Override
	protected void dropFewItems(boolean b, int j) {
		Item it = getItemDropped();
		this.dropItem(it, 1);
		if(rand.nextInt(6) == 0) dropItem(EssenceItems.corbaStick, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(12) == 0) dropItem(EssenceItems.corbaStick, 4);
		super.dropFewItems(b, j); 
		if(rand.nextInt(6) == 0) dropItem(EssenceItems.enchantedLeaf, 2);
		super.dropFewItems(b, j); 
		if(rand.nextInt(12) == 0) dropItem(EssenceItems.enchantedLeaf, 4);
		super.dropFewItems(b, j); 
		if(rand.nextInt(24) == 0) dropItem(EssenceItems.natureTablet, 2);
		super.dropFewItems(b, j); 
		if(rand.nextInt(48) == 0) dropItem(EssenceItems.natureTablet, 4);
			super.dropFewItems(b, j); 
	}
}