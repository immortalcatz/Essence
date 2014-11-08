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

public class EntityBurningLight extends EntityModMob{

	public EntityBurningLight(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.burningLightDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.burningLightHealth;
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
		return new ItemStack(Items.diamond_shovel);
	}
	
	@Override
	protected void dropFewItems(boolean b, int i) {
		Item it = getItemDropped();
		this.dropItem(it, 1);
		Item shovel = Items.wooden_shovel;
		switch(rand.nextInt(3)) {
		case 0:
			shovel = Items.golden_shovel;
			break;
		case 1:
			shovel = Items.iron_shovel;
			break;
		case 2:
			shovel = Items.diamond_shovel;
			break;
		}
		if(rand.nextInt(3) == 0) {
			this.dropItem(shovel, 1);
		}
	}
}