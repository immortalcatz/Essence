package net.essence.entity.mob.boss;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityCorallator extends EntityEssenceBoss {

	private int firetick;
	private int firemax = 400, firemax2 = 300;
	private boolean isInvi;

	public EntityCorallator(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.6F, 3.2F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.corallatorDamage;
	}

	@Override
	public double setKnockbackResistance() {
		return 1.0D;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.corallatorHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.CALCIA;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.CALCIA_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.CALCIA_HURT;
	}

	public boolean isInv() {
		return isInvi;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if(isInv()) {
			for(int i = 0; i < 5; i++) this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
			Entity entity = attackingPlayer;
			if(entity != null)
				((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 25, 2));
		}
	}

	@Override
	public void onLivingUpdate() {
		if(firemax == firetick && firetick != 0) {
			this.isInvi = true;
			this.firetick = 0;
		} else {
			firetick++;
		} 

		if(firemax2 == firetick && firetick != 0) {
			this.isInvi = false;
			this.firetick = 0;
		} else {
			firetick++;
		}
		super.onLivingUpdate();
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.depthsPortalGem;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		dropItem(EssenceItems.depthsPortalGem, 18);
		switch(rand.nextInt(2)) {
		case 0: dropItem(EssenceItems.coreMender, 1); break;
		case 1: dropItem(EssenceItems.coreExpender, 1); break;
		}
	}
}