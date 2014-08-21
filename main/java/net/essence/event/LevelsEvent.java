package net.essence.event;

import java.util.Random;

import net.essence.client.PlayerLevels;
import net.essence.entity.mob.boss.EntityWitheringBeast;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LevelsEvent {

	public static Random rand = new Random();

	public static int expGained = (int)((float)rand.nextInt(3) / 2);
	public static int headXP = (int)((float)rand.nextInt(10) / 2);
	public static int bowXP = (int)((float)rand.nextInt(5) / 2);
	public static int pickXP = (int)((float)rand.nextInt(5) / 2);
	public static int hoeXP = (int)((float)rand.nextInt(5) / 2);


	@SubscribeEvent
	public void onDrop(LivingDropsEvent event){
		if(event.source.getSourceOfDamage() != null && event.source.getSourceOfDamage() instanceof EntityPlayer){
			EntityLivingBase e = event.entityLiving;
			PlayerLevels props = new PlayerLevels((EntityPlayer)event.source.getSourceOfDamage());
			EntitySkeleton s = new EntitySkeleton(event.entity.worldObj);
			if(s.getSkeletonType() == 1 || event.entity instanceof EntityWitheringBeast || event.entity instanceof EntityWither){
				if(props.getWitherExperience() > 5){
					if(rand.nextInt(props.getWitherExperience()) > 5)
						event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(Items.skull, 1, 1)));
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event){
		if(event.harvester != null && event.harvester instanceof EntityPlayer) {
			EntityPlayer p = event.harvester;
			PlayerLevels props = new PlayerLevels(p);
			if(event.harvester.getHeldItem() != null && event.harvester.getHeldItem().getItem() instanceof ItemPickaxe) {
				if(props.getPickaxeExperience() > 10){
					if(rand.nextInt(props.getPickaxeExperience()) > 40){
						if(!event.isSilkTouching){
							ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(event.block, 1, event.blockMetadata));
							if(stack != null && event.block != Blocks.redstone_ore && event.block != Blocks.lapis_ore) {
								event.drops.clear();
								event.drops.add(stack.copy());
							}
						}
					}
				}
				props.addPickaxeExperience(pickXP, p);
			}
		}
	}

	@SubscribeEvent
	public void hoe(UseHoeEvent event){
		EntityPlayer p = event.entityPlayer;
		PlayerLevels props = new PlayerLevels(p);
		World w = event.world;
		int x, y, z;
		x = event.x;
		y = event.y;
		z = event.z;
		Block block = Blocks.dirt;
		if(w.getBlock(x, y, z) == Blocks.grass || w.getBlock(x, y, z) == Blocks.dirt || w.getBlock(x, y, z) == Blocks.farmland){
			if(!p.isSneaking()){
				if(props.getHoeExperience() > 10){
					int size = 1;
					w.setBlock(x, y, z, Blocks.water);
					w.setBlock(x + size, y, z, Blocks.farmland);
					w.setBlock(x - size, y, z, Blocks.farmland);
					w.setBlock(x, y, z + size, Blocks.farmland);
					w.setBlock(x, y, z - size, Blocks.farmland);
					w.setBlock(x + size, y, z + size, Blocks.farmland);
					w.setBlock(x - size, y, z - size, Blocks.farmland);
					w.setBlock(x + size, y, z - size, Blocks.farmland);
					w.setBlock(x - size, y, z + size, Blocks.farmland);
					event.current.damageItem(9, p);
				}

				if(props.getHoeExperience() > 30){
					int size = 1;
					w.setBlock(x, y, z, Blocks.water);
					w.setBlock(x + size, y, z, Blocks.farmland);
					w.setBlock(x - size, y, z, Blocks.farmland);
					w.setBlock(x, y, z + size, Blocks.farmland);
					w.setBlock(x, y, z - size, Blocks.farmland);
					w.setBlock(x + size, y, z + size, Blocks.farmland);
					w.setBlock(x - size, y, z - size, Blocks.farmland);
					w.setBlock(x + size, y, z - size, Blocks.farmland);
					w.setBlock(x - size, y, z + size, Blocks.farmland);
					w.setBlock(x - size, y + size, z + size, Blocks.potatoes);
					w.setBlock(x, y + 1, z - size, Blocks.carrots);
					event.current.damageItem(15, p);
				}

				if(props.getHoeExperience() > 50){
					int size = 1;
					w.setBlock(x, y, z, Blocks.water);
					w.setBlock(x + size, y, z, Blocks.farmland);
					w.setBlock(x - size, y, z, Blocks.farmland);
					w.setBlock(x, y, z + size, Blocks.farmland);
					w.setBlock(x, y, z - size, Blocks.farmland);
					w.setBlock(x + size, y, z + size, Blocks.farmland);
					w.setBlock(x - size, y, z - size, Blocks.farmland);
					w.setBlock(x + size, y, z - size, Blocks.farmland);
					w.setBlock(x - size, y, z + size, Blocks.farmland);
					w.setBlock(x - size, y + size, z + size, Blocks.potatoes);
					w.setBlock(x, y + size, z - size, Blocks.carrots);
					w.setBlock(x, y - size, z - size, Blocks.wheat);
					event.current.damageItem(20, p);
				}
			}
			if(w.getBlock(x, y, z) != Blocks.farmland)
				w.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getStepResourcePath(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

			if(event.entityPlayer != null){
				props.addHoeExperience(hoeXP, p);
			}
		}
	}

	@SubscribeEvent
	public void onKilledMob(LivingDeathEvent event){
		if(event.source.getSourceOfDamage() instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer)event.source.getSourceOfDamage();
			PlayerLevels props = new PlayerLevels(p);
			EntitySkeleton s = new EntitySkeleton(event.entity.worldObj);
			if(s.getSkeletonType() == 1 || event.entity instanceof EntityWitheringBeast || event.entity instanceof EntityWither)
				props.addWitherExperience(headXP, p);
		}
	}

	@SubscribeEvent
	public void useBow(ArrowLooseEvent event){
		EntityPlayer p = event.entityPlayer;
		PlayerLevels props = new PlayerLevels(p);
		EntityArrow e = new EntityArrow(event.entityPlayer.worldObj, event.entityPlayer, event.entityLiving, 1.6F, (float)(14 - event.entityPlayer.worldObj.difficultySetting.getDifficultyId() * 4));
		if(event.entityPlayer != null){
			if(props.getBowExperience() > 5)
				e.setDamage(e.getDamage() + 2);
			if(props.getBowExperience() > 10)
				e.setDamage(e.getDamage() + 4);
			if(props.getBowExperience() > 15)
				e.setDamage(e.getDamage() + 6);
			if(props.getBowExperience() > 20)
				e.setDamage(e.getDamage() + 8);
			if(props.getBowExperience() > 25)
				e.setDamage(e.getDamage() + 10);
			if(props.getBowExperience() < 50)
				e.setDamage(e.getDamage() + 15);
			props.addBowExperience(bowXP, p);
		}
	}
}