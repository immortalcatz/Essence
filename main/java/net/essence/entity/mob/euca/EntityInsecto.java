package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityInsecto extends EntityModMob{

	public static final int ENTITY_TYPE = 23;
	
	public EntityInsecto(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.7F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.insectoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.insectoHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.INSECTO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.INSECTO_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.INSECTO_HURT.getPrefixedName();
	}
	
	@Override
	protected void attackEntity(Entity e, float a) {
		super.attackEntity(e, a);
		((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaMeat;
	}
}