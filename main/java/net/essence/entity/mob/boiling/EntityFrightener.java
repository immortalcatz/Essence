package net.essence.entity.mob.boiling;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityFrightener extends EntityModMob{

	public EntityFrightener(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.frightenerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.frightenerHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.SPIKED_BEAST;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.HONGO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.HONGO_HURT;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).setFire(5 + rand.nextInt(7));
		return super.attackEntityFrom(e, a);
	}

	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.diamond_axe);
	}
	
	@Override
	public Item getItemDropped() {
		return null;

	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		Item it = getItemDropped();
		this.dropItem(it, 1);
		if(rand.nextInt(14) == 0) dropItem(EssenceItems.boilPowder, 2);
		super.dropFewItems(b, j);
	    if(rand.nextInt(20) == 0) dropItem(EssenceItems.boilPowder, 4);
		super.dropFewItems(b, j); 
		if(rand.nextInt(50) == 0) dropItem(EssenceItems.sizzlingEye, 2);
		super.dropFewItems(b, j); 
		if(rand.nextInt(65) == 0) dropItem(EssenceItems.sizzlingEye, 4);
		super.dropFewItems(b, j); 
		}
	}