package net.essence.entity.mob.boss;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityCalcia extends EntityEssenceBoss {

	private int firetick;
	private int firemax = 400, firemax2 = 300;
	private boolean isInvi;

	public EntityCalcia(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.6F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.calciaDamage;
	}

	@Override
	public double setKnockbackResistance() {
		return 1.0D;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.calciaHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.CALCIA.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.CALCIA_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.CALCIA_HURT.getPrefixedName();
	}

	public boolean isInv() {
		return isInvi;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if(isInv()) {
			for(int i = 0; i < 5; i++)
				this.worldObj.spawnParticle("enchantmenttable", posX + 0.5F + rand.nextFloat(), posY + 1.0D + rand.nextFloat(), posZ + 0.5F + rand.nextFloat(), 0, 0, 0);
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
		return EssenceItems.eucaPortalGem;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		Item item = getItemDropped();
		for(int i = 0; i < rand.nextInt(5) + 4; i++)
			this.dropItem(item, 1);

		this.dropItem(EssenceItems.calciaSword, 1);

		if(rand.nextInt(1) == 0)
			this.dropItem(Item.getItemFromBlock(EssenceBlocks.calciaStatue), 1);
	}
}