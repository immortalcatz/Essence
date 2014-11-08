package net.essence.entity.mob.vanilla;

import net.essence.entity.MobStats;
import net.essence.entity.AI.EntityAIBoomSwell;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityBoom extends EntityModMob {

	private int fuseTime = 40, lastActiveTime, timeSinceIgnited, explosionRadius = 4;

	public EntityBoom(World par1World) {
		super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIBoomSwell(this));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.setSize(1.0F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return 0;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.boomHealth;
	}

	@Override
	public String setLivingSound() {
		return "mob.creeper.say";
	}

	@Override
	public String setHurtSound() {
		return "mob.creeper.death";
	}

	@Override
	public String setDeathSound() {
		return "mob.creeper.death";
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		for(int i = 0; i < 1 + rand.nextInt(2); i++)
			this.dropItem(SlayerAPI.toItem(Blocks.tnt), i);
		this.dropItem(Items.gunpowder, 1 + rand.nextInt(2));
	}

	@Override
	public int getMaxSafePointTries() {
		return this.getAttackTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
	}

	@Override
	protected void fall(float par1) {
		super.fall(par1);
		this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + par1 * 1.5F);
		if(this.timeSinceIgnited > this.fuseTime - 5) this.timeSinceIgnited = this.fuseTime - 5;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) - 1));
		this.dataWatcher.addObject(17, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);

		if(this.dataWatcher.getWatchableObjectByte(17) == 1) par1NBTTagCompound.setBoolean("powered", true);
		par1NBTTagCompound.setShort("Fuse", (short)this.fuseTime);
		par1NBTTagCompound.setByte("ExplosionRadius", (byte)this.explosionRadius);
		par1NBTTagCompound.setBoolean("ignited", this.ignited());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(par1NBTTagCompound.getBoolean("powered") ? 1 : 0)));
		if(par1NBTTagCompound.hasKey("Fuse", 99)) this.fuseTime = par1NBTTagCompound.getShort("Fuse");
		if(par1NBTTagCompound.hasKey("ExplosionRadius", 99)) this.explosionRadius = par1NBTTagCompound.getByte("ExplosionRadius");
		if(par1NBTTagCompound.getBoolean("ignited")) this.isIgnited();
	}

	@Override
	public void onUpdate() {
		if(this.isEntityAlive()) {
			this.lastActiveTime = this.timeSinceIgnited;
			if(this.ignited()) this.setBoomBoomState(1);
			int i = this.getBoomBoomState();
			if(i > 0 && this.timeSinceIgnited == 0) this.playSound("creeper.primed", 1.0F, 0.5F);
			this.timeSinceIgnited += i;
			if(this.timeSinceIgnited < 0) this.timeSinceIgnited = 0;
			if(this.timeSinceIgnited >= this.fuseTime) {
				this.timeSinceIgnited = this.fuseTime;
				this.explosion();
			}
		}
		super.onUpdate();
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		return true;
	}

	public boolean getPowered() {
		return this.dataWatcher.getWatchableObjectByte(17) == 1;
	}

	@SideOnly(Side.CLIENT)
	public float getFlashIntensity(float par1) {
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.fuseTime - 2);
	}

	public int getBoomBoomState() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setBoomBoomState(int par1) {
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)par1));
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {
		super.onStruckByLightning(par1EntityLightningBolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)1));
	}

	@Override
	protected boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		if(itemstack != null && itemstack.getItem() == Items.flint_and_steel) {
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.ignite", 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
			par1EntityPlayer.swingItem();
			if(!this.worldObj.isRemote) {
				this.isIgnited();
				itemstack.damageItem(1, par1EntityPlayer);
				return true;
			}
		}
		return super.interact(par1EntityPlayer);
	}

	private void explosion() {
		if(!this.worldObj.isRemote) {
			boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
			if(this.getPowered()) this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 2), flag);
			else this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);
			this.setDead();
		}
	}
	
	public boolean ignited() {
		return this.dataWatcher.getWatchableObjectByte(18) != 0;
	}

	public void isIgnited() {
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)1));
	}
}