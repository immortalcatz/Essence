package net.essence.event;

import java.util.Random;

import net.essence.client.PlayerKnowledge;
import net.essence.enums.EnumKnowledge;
import net.essence.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KnowledgeEvent {

	private PlayerKnowledge knowledge = PlayerKnowledge.instance;
	private Random rand = new Random();
	private int randomDeath = (int)((float)rand.nextInt(5) / 2);
	
	@SubscribeEvent
	public void entityKilled(LivingDeathEvent event) {
		EntityLivingBase killed = event.entityLiving;
		if(event.source != null && event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
			if(killed instanceof EntitySkeleton) {
				knowledge.xp[knowledge.getKnowledgeID(EnumKnowledge.OVERWORLD)] += 1F;
				Helper.print(knowledge.xp[knowledge.getKnowledgeID(EnumKnowledge.OVERWORLD)]);
			}
		}
	}
}