package net.essence.entity.mob.boiling;

import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityExposedFlame extends EntityModMob{

	public EntityExposedFlame(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.exposedFlameDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.exposedFlameHealth;
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
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).setFire(5 + rand.nextInt(7));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.ash;
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.diamond_axe);
	}
	
	@Override
	protected void dropFewItems(boolean b, int i) {
		Item it = getItemDropped();
		this.dropItem(it, 1);
		Item axe = Items.wooden_axe;
		switch(rand.nextInt(3)) {
		case 0:
			axe = Items.golden_axe;
			break;
		case 1:
			axe = Items.iron_axe;
			break;
		case 2:
			axe = Items.diamond_axe;
			break;
		}
		if(rand.nextInt(3) == 0) {
			this.dropItem(axe, 1);
		}
	}
}