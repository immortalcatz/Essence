package net.essence.entity.mob.boss;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityEudor extends EntityEssenceBoss {

	@SuppressWarnings("Finish this")
	public EntityEudor(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(2.0F, 3.8F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.eudorDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.eudorHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.WITHER.getNonPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.WITHER_HURT.getNonPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.WITHER_DEATH.getNonPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.depthsPortalGem;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(getItemDropped(), 6 + rand.nextInt(4));
		
		if(rand.nextInt(1) == 0) this.dropItem(Item.getItemFromBlock(EssenceBlocks.eudorStatue), 1);
	}
}