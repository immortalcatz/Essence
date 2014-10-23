package net.essence.entity;

import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class EntityDragonEgg extends EntityModMob {

	private String colour = "";
	
	public EntityDragonEgg(World w, String colour) {
		super(w);
		setSize(0.4F, 0.5F);
		this.colour = colour;
	}
	
	public String getColour() {
		return colour;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return 0;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return 20;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected boolean isMovementCeased() {
		return true;
	}

	@Override
	protected boolean isMovementBlocked() {
		return true;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean canPickUpLoot() {
		return false;
	}

	@Override
	public boolean allowLeashing() {
		return false;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float par1) {
		return 15728880;
	}

	@Override
	public float getBrightness(float par1) {
		return 1.0F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		return false;
	}

	@Override
	public String setLivingSound() {
		return null;
	}

	@Override
	public String setHurtSound() {
		return null;
	}

	@Override
	public String setDeathSound() {
		return null;
	}
}