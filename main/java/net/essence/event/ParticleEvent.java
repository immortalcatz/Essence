package net.essence.event;

import java.util.Random;

import net.essence.Essence;
import net.essence.enums.EnumParticlesClasses;
import net.essence.items.ItemFireSword;
import net.essence.items.ItemFreezeSword;
import net.essence.util.Config;
import net.essence.util.Helper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ParticleEvent {

	@SubscribeEvent
	public void onMobHit(LivingHurtEvent event) {
		Entity hit = event.entityLiving;
		Random r = new Random();
		if(Config.spawnSwordParticles) {
			if(!event.entityLiving.worldObj.isRemote) {
				if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
					if(player != null && player.getHeldItem() != null) {
						if(player.getHeldItem().getItem() instanceof ItemFireSword) {
							for(int i = 0; i < 70; i++) {
								hit.worldObj.spawnParticle(EnumParticleTypes.PORTAL, hit.posX + (r.nextDouble() - 0.5D) * (double)hit.width, hit.posY + r.nextDouble() * (double)hit.height - 0.25D, hit.posZ + (r.nextDouble() - 0.5D) * (double)hit.width, (r.nextDouble() - 0.5D) * 2.0D, -r.nextDouble(), (r.nextDouble() - 0.5D) * 2.0D, new int[0]);
								hit.worldObj.spawnParticle(EnumParticleTypes.FLAME, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
								hit.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
								hit.worldObj.spawnParticle(EnumParticleTypes.LAVA, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
							}
						}
						if(player.getHeldItem().getItem() instanceof ItemFreezeSword) {
							for(int i = 0; i < 70; i++) {
								event.entityLiving.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0D, 0D, 0D);
								event.entityLiving.worldObj.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0D, 0D, 0D);
							}
						}
					}
				}
			}
		}
	}
}