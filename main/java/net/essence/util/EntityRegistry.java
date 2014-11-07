package net.essence.util;

import net.essence.entity.mob.boiling.EntityAshHoarder;
import net.essence.entity.mob.boiling.EntityBurningLight;
import net.essence.entity.mob.boiling.EntityBurntAsh;
import net.essence.entity.mob.boiling.EntityBurntMiner;
import net.essence.entity.mob.boiling.EntityCrisp;
import net.essence.entity.mob.boiling.EntityExposedFlame;
import net.essence.entity.mob.boiling.EntityMagmaBlaze;
import net.essence.entity.mob.boiling.EntityMagmaGiant;
import net.essence.entity.mob.boss.EntityCalcia;
import net.essence.entity.mob.boss.EntityNetherBeast;
import net.essence.entity.mob.boss.EntityWitheringBeast;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntityDepthsHunter;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.euca.EntityEucaCharger;
import net.essence.entity.mob.euca.EntityEucaFighter;
import net.essence.entity.mob.euca.EntityEucaHopper;
import net.essence.entity.mob.euca.EntityInsecto;
import net.essence.entity.mob.euca.EntityPsyollom;
import net.essence.entity.mob.vanilla.EntityBigHongo;
import net.essence.entity.mob.vanilla.EntityBoom;
import net.essence.entity.mob.vanilla.EntityBunny;
import net.essence.entity.mob.vanilla.EntityMediumHongo;
import net.essence.entity.mob.vanilla.EntityReaper;
import net.essence.entity.mob.vanilla.EntityRobot;
import net.essence.entity.mob.vanilla.EntitySandCrawler;
import net.essence.entity.mob.vanilla.EntitySmallHongo;
import net.essence.entity.mob.vanilla.EntitySpyclops;
import net.essence.entity.mob.vanilla.EntityTurtle;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.entity.projectile.EntityBouncingProjectile;
import net.essence.entity.projectile.EntityChaosProjectile;
import net.essence.entity.projectile.EntityConjuring;
import net.essence.entity.projectile.EntityDoomsBringer;
import net.essence.entity.projectile.EntityEnlightment;
import net.essence.entity.projectile.EntityGreenpace;
import net.essence.entity.projectile.EntityMagmaFireball;
import net.essence.entity.projectile.EntityWizardsStar;
import net.slayer.api.SlayerAPI;

public class EntityRegistry {
	
	public static void init() {
		SlayerAPI.registerProjectile(EntityBasicProjectile.class, "basic");
		SlayerAPI.registerProjectile(EntityBouncingProjectile.class, "bouncing");
		SlayerAPI.registerProjectile(EntityChaosProjectile.class, "chaos");
		SlayerAPI.registerProjectile(EntityDoomsBringer.class, "doom");
		SlayerAPI.registerProjectile(EntityConjuring.class, "conjuring");
		SlayerAPI.registerProjectile(EntityEnlightment.class, "enlightment");
		SlayerAPI.registerProjectile(EntityGreenpace.class, "greenpace");
		SlayerAPI.registerProjectile(EntityWizardsStar.class, "wizardsstar");
		SlayerAPI.registerProjectile(EntityMagmaFireball.class, "magmaball");

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
		SlayerAPI.registerMob(EntityMagmaBlaze.class, "Magma Blaze", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityCrisp.class, "Crisp", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBurntMiner.class, "Burnt Miner", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityExposedFlame.class, "Exposed Flame", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBurningLight.class, "Burning Light", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityAshHoarder.class, "Ash Hoarder", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBurntAsh.class, "Burnt Ash", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityReaper.class, "Reaper", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityDepthsHunter.class, "Depths Hunter", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityEucaCharger.class, "Euca Charger", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBunny.class, "Bunny", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySandCrawler.class, "Sand Crawler", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityTurtle.class, "Turtle", SlayerAPI.mobID++);

		//SlayerAPI.registerEntity(EntityDragonEgg.class, "Dragon Egg", SlayerAPI.mobID++);

		SlayerAPI.registerBossMob(EntityNetherBeast.class, "Beast of the Nether", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityWitheringBeast.class, "Withering Beast", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityCalcia.class, "Calcia", SlayerAPI.mobID++);
		//SlayerAPI.registerBossMob(EntityWraith.class, "Wraith", SlayerAPI.mobID++);
	}
}