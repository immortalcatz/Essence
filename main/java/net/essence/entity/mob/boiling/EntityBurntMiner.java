package net.essence.entity.mob.boiling;

import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityBurntMiner extends EntityModMob{

	public EntityBurntMiner(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.burntMinerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.burntMinerHealth;
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
	protected void attackEntity(Entity e, float a) {
		super.attackEntity(e, a);
		((EntityPlayer)e).setFire(5 + rand.nextInt(7));
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.ash;
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.diamond_pickaxe);
	}
	
	@Override
	protected void dropFewItems(boolean b, int i) {
		Item it = getItemDropped();
		this.dropItem(it, 1);
		Item pick = Items.wooden_pickaxe;
		switch(rand.nextInt(3)){
		case 0:
			pick = Items.golden_pickaxe;
			break;
		case 1:
			pick = Items.iron_pickaxe;
			break;
		case 2:
			pick = Items.diamond_pickaxe;
			break;
		}
		if(rand.nextInt(3) == 0) {
			this.dropItem(pick, 1);
		}
	}
}