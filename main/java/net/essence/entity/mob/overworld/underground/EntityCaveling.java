package net.essence.entity.mob.overworld.underground;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntityCaveling extends EntityModMob {

	public EntityCaveling(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.0F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.bigHongoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.bigHongoHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.HONGO;
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
	public Item getItemDropped() {
		return SlayerAPI.toItem(Blocks.brown_mushroom);

	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && super.getCanSpawnHere() && 
				this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock().getMaterial() == Material.rock; 
	}

	@Override
	protected void dropFewItems(boolean b, int j) {

		if(rand.nextInt(20) == 0) dropItem(EssenceItems.sapphire, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(20) == 0) dropItem(EssenceItems.shadiumIngot, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(20) == 0) dropItem(EssenceItems.luniumIngot, 4);
		super.dropFewItems(b, j);
	}
}