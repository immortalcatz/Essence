package net.essence.util;

import net.essence.entity.EntityDragonEgg;
import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.vanilla.*;
import net.essence.entity.projectile.*;
import net.essence.entity.projectile.spawner.EntityCalciaSpawner;
import net.slayer.api.SlayerAPI;

public class EntityRegistry {
	
	public static void init(){
		SlayerAPI.registerProjectile(EntityBasicProjectile.class, "basic");
		SlayerAPI.registerProjectile(EntityBouncingProjectile.class, "bouncing");
		SlayerAPI.registerProjectile(EntityChaosProjectile.class, "chaos");
		SlayerAPI.registerProjectile(EntityCalciaSpawner.class, "calcia spawner");

		SlayerAPI.registerMob(EntityRobot.class, "Robot", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySpyclops.class, "Spyclops", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySpikedBeast.class, "Spiked Beast", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityMagmaGiant.class, "Magma Giant", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityInsecto.class, "Insecto", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityPsyollom.class, "Psyollom", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityDarknessCrawler.class, "Darkness Crawler", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityDepthsBeast.class, "Depths Beast", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBoom.class, "Boom Boom", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBigHongo.class, "Big Hongo", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityMediumHongo.class, "Medium Hongo", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySmallHongo.class, "Small Hongo", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityEucaFighter.class, "Euca Fighter", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityEucaHopper.class, "Euca Hopper", SlayerAPI.mobID++);

		//SlayerAPI.registerEntity(EntityDragonEgg.class, "Dragon Egg", SlayerAPI.mobID++);

		SlayerAPI.registerBossMob(EntityNetherBeast.class, "Beast of the Nether", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityWitheringBeast.class, "Withering Beast", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityCalcia.class, "Calcia", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityWraith.class, "Wraith", SlayerAPI.mobID++);
	}
}