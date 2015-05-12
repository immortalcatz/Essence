package net.essence.entity.mob.depths;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
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
	public EnumSounds setLivingSound() {
		return EnumSounds.MAGMA_GIANT;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SPYCLOPS_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SPYCLOPS_HURT;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 1));
		return super.attackEntityFrom(e, a);}
	
	@Override
	public Item getItemDropped() {
		return null;
		
	}
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(6) == 0) dropItem(EssenceItems.beastlyStomach, 2);
		super.dropFewItems(b, j);
		
		
	}
	
}