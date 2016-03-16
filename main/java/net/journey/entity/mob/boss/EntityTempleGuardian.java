package net.journey.entity.mob.boss;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.blocks.tileentity.TileEntityJourneyChest;
import net.journey.entity.EntityPeacefullMob;
import net.journey.entity.MobStats;
import net.journey.entity.projectile.EntityTempleBall;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityTempleGuardian extends EntityPeacefullMob implements IRangedAttackMob {

	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 15, 30);

	public EntityTempleGuardian(World par1World) {
		super(par1World);
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		if(par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
		setSize(1.0F, 3.0F);
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();
		if(itemstack != null && itemstack.getItem() == Items.stick) {
			this.tasks.addTask(4, this.aiArrowAttack);
		}
	}
	
	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);
		if(!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}
	
	@Override
	public void onDeath(DamageSource damage){
		this.worldObj.setBlockState(new BlockPos((int)Math.floor(this.posX + 0), ((int)Math.floor(this.posY + 0)), ((int)Math.floor(this.posZ + 0))), Blocks.chest.getStateFromMeta(5));
		TileEntityChest te = (TileEntityChest)worldObj.getTileEntity(new BlockPos((int)Math.floor(this.posX + 0), ((int)Math.floor(this.posY + 0)), ((int)Math.floor(this.posZ + 0))));
		switch(rand.nextInt(4)) {
		case 0:
			te.setInventorySlotContents(2, new ItemStack(JourneyItems.yellowGem, 3));
			te.setInventorySlotContents(11, new ItemStack(JourneyItems.blueGem, 2));
			te.setInventorySlotContents(16, new ItemStack(JourneyItems.greenGem, 5));
			te.setInventorySlotContents(5, new ItemStack(JourneyItems.purpleGem, 2));
			break;
		case 1:
			te.setInventorySlotContents(1, new ItemStack(JourneyItems.yellowGem, 4));
			te.setInventorySlotContents(14, new ItemStack(JourneyItems.blueGem, 5));
			te.setInventorySlotContents(12, new ItemStack(JourneyItems.greenGem, 2));
			te.setInventorySlotContents(4, new ItemStack(JourneyItems.purpleGem, 6));
			break;
		case 2:
			te.setInventorySlotContents(14, new ItemStack(JourneyItems.yellowGem, 2));
			te.setInventorySlotContents(1, new ItemStack(JourneyItems.blueGem, 4));
			te.setInventorySlotContents(4, new ItemStack(JourneyItems.greenGem, 6));
			te.setInventorySlotContents(12, new ItemStack(JourneyItems.purpleGem, 2));
			break;
		case 3:
			te.setInventorySlotContents(4, new ItemStack(JourneyItems.yellowGem, 5));
			te.setInventorySlotContents(12, new ItemStack(JourneyItems.blueGem, 1));
			te.setInventorySlotContents(14, new ItemStack(JourneyItems.greenGem, 4));
			te.setInventorySlotContents(1, new ItemStack(JourneyItems.purpleGem, 2));
			break;
		}
	}
	
	@Override
	public void fall(float distance, float damageMultiplier) { }
	
	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.stick);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
		EntityTempleBall b = new EntityTempleBall(this.worldObj, this, 10F);
        b.setThrowableHeading(e.posX-this.posX, e.posY-this.posY, e.posZ-this.posZ, 1.6f, 12);
        EnumSounds.playSound(EnumSounds.SPARKLE, worldObj, this);
        this.worldObj.spawnEntityInWorld(b);
	}
	
	@Override
	public void dropFewItems(boolean b, int j) {
		
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.templeGuardianHealth;
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

	@Override
	public Item getItemDropped() {
		return null;
	}
}