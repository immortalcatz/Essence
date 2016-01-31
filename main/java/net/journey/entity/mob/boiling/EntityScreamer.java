package net.journey.entity.mob.boiling;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityScreamer extends EntityModMob{

	public EntityScreamer(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.2F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.screamerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.screamerHealth;
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
	public boolean getCanSpawnHere() {
		return this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == JourneyBlocks.hotBlock;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).setFire(5 + rand.nextInt(7));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return JourneyItems.ash;
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.diamond_axe);
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(10) == 0) dropItem(JourneyItems.boilingSkull, 1);
		super.dropFewItems(b, j);
	    if(rand.nextInt(30) == 0) dropItem(JourneyItems.boilPowder, 6);
		super.dropFewItems(b, j);
		if(rand.nextInt(70) == 0) dropItem(JourneyItems.sizzlingEye, 1);
		super.dropFewItems(b, j); {
		

		}
	}
}