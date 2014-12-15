package net.essence.util;

import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.vanilla.*;
import net.essence.entity.mob.vanilla.water_tribe.EntityWaterTribeFisherman;
import net.essence.entity.projectile.*;
import net.slayer.api.*;

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
		SlayerAPI.registerProjectile(EntityFlameArrow.class, "flamearrow");
		SlayerAPI.registerProjectile(EntityFireBall.class, "fireball");
		SlayerAPI.registerProjectile(EntityIceBall.class, "iceball");

		SlayerAPI.registerMob(EntityRobot.class, "robot", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySpyclops.class, "spyclops", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySpikedBeast.class, "spikedBeast", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityMagmaGiant.class, "magmaGiant", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityInsecto.class, "insecto", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityPsyollom.class, "psyollom", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityDarknessCrawler.class, "darknessCrawler", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityDepthsBeast.class, "depthsBeast", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBoom.class, "boomBoom", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBigHongo.class, "bigHongo", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityMediumHongo.class, "mediumHongo", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySmallHongo.class, "smallHongo", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityEucaFighter.class, "eucaFighter", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityEucaHopper.class, "eucaHopper", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityMagmaBlaze.class, "magmaBlaze", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityCrisp.class, "crisp", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBurntMiner.class, "burntMiner", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityExposedFlame.class, "exposedFlame", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBurningLight.class, "burningLight", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityAshHoarder.class, "ashHoarder", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBurntAsh.class, "burntAsh", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityReaper.class, "reaper", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityDepthsHunter.class, "depthsHunter", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityEucaCharger.class, "eucaCharger", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityBunny.class, "bunny", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntitySandCrawler.class, "sandCrawler", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityTurtle.class, "essenceTurtle", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityFish.class, "fish", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityWaterTribeFisherman.class, "waterTribeFisherman", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityFireMage.class, "fireMage", SlayerAPI.mobID++);
		SlayerAPI.registerMob(EntityIceMage.class, "iceMage", SlayerAPI.mobID++);

		//SlayerAPI.registerEntity(EntityDragonEgg.class, "Dragon Egg", SlayerAPI.mobID++);

		SlayerAPI.registerBossMob(EntityNetherBeast.class, "Beast of the Nether", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityWitheringBeast.class, "Withering Beast", SlayerAPI.mobID++);
		SlayerAPI.registerBossMob(EntityCalcia.class, "Calcia", SlayerAPI.mobID++);
		//SlayerAPI.registerBossMob(EntityEudor.class, "Eudor", SlayerAPI.mobID++);
		//SlayerAPI.registerBossMob(EntityWraith.class, "Wraith", SlayerAPI.mobID++);
	}
}