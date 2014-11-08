package net.essence.entity.mob.boiling;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityMagmaGiant extends EntityModMob{

	public EntityMagmaGiant(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.0F, 2.7F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.magmaGiantDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.magmaGiantHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.MAGMA_GIANT.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
	}
	
	@Override
	protected void attackEntity(Entity e, float a) {
		super.attackEntity(e, a);
		((EntityPlayer)e).setFire(5 + rand.nextInt(7));
	}
	
	@Override
    public int getBrightnessForRender(float par1) {
        return 15728880;
    }

    @Override
    public float getBrightness(float par1) {
        return 1.0F;
    }
    
	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);

        if(this.isWet()) this.attackEntityFrom(DamageSource.drown, 1.0F);

        for(int l = 0; l < 4; ++l) {
            i = MathHelper.floor_double(this.posX + (double)((float)(l % 2 * 2 - 1) * 0.25F));
            j = MathHelper.floor_double(this.posY);
            k = MathHelper.floor_double(this.posZ + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
            if(this.worldObj.getBlock(i, j, k).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, i, j, k)) 
            	this.worldObj.setBlock(i, j, k, Blocks.fire);
        }
    }
}