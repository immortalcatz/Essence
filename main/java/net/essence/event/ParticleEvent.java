package net.essence.event;

import java.util.Random;

import net.essence.Essence;
import net.essence.client.render.EnumParticlesClasses;
import net.essence.items.ItemFireSword;
import net.essence.items.ItemFreezeSword;
import net.essence.util.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
								Essence.proxy.spawnParticle(EnumParticlesClasses.FLAME, player.worldObj, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, false);
								Essence.proxy.spawnParticle(EnumParticlesClasses.SMOKE, player.worldObj, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, false);
								Essence.proxy.spawnParticle(EnumParticlesClasses.LAVA, player.worldObj, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, true);
							}
						}
						if(player.getHeldItem().getItem() instanceof ItemFreezeSword) {
							for(int i = 0; i < 70; i++) {
								Essence.proxy.spawnParticle(EnumParticlesClasses.SNOWBALL_POOF, player.worldObj, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, false);
							}
						}
					}
				}
			}
		}
	}
}