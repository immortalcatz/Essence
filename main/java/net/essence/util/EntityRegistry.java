package net.essence.util;

import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boiling.npc.EntityEscapedConvict;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.frozen.npc.EntityGreenElf;
import net.essence.entity.mob.frozen.npc.EntityRedElf;
import net.essence.entity.mob.overworld.*;
import net.essence.entity.mob.overworld.npc.*;
import net.essence.entity.mob.overworld.npc.water_tribe.*;
import net.essence.entity.projectile.*;
import net.slayer.api.*;

public class EntityRegistry {
	
	public static void init() {
		SlayerAPI.registerProjectile(EntityBasicProjectile.class, "basic");
		SlayerAPI.registerProjectile(EntityBouncingProjectile.class, "bouncing");
		SlayerAPI.registerProjectile(EntityChaosProjectile.class, "chaos");
		SlayerAPI.registerProjectile(EntityDoomsBringer.class, "doom");
		SlayerAPI.registerProjectile(EntityConjuring.class, "conjuring");
		SlayerAPI.registerProjectile(EntityEnlightenment.class, "enlightment");
		SlayerAPI.registerProjectile(EntityGreenpace.class, "greenpace");
		SlayerAPI.registerProjectile(EntityWizardsStar.class, "wizardsstar");
		SlayerAPI.registerProjectile(EntityMagmaFireball.class, "magmaball");
		SlayerAPI.registerProjectile(EntityFlameArrow.class, "flamearrow");
		SlayerAPI.registerProjectile(EntityFireBall.class, "fireball");
		SlayerAPI.registerProjectile(EntityIceBall.class, "iceball");
		SlayerAPI.registerProjectile(EntityTempleBall.class, "templeball");
		SlayerAPI.registerProjectile(EntityLightningBall.class, "lightningball");
		SlayerAPI.registerProjectile(EntityPoisonArrow.class, "poisonarrow");
		SlayerAPI.registerProjectile(EntityDarknessArrow.class, "darknessarrow");
		SlayerAPI.registerProjectile(EntityFrozenArrow.class, "frozenarrow");
		SlayerAPI.registerProjectile(EntityRockProjectile.class, "rockchunk");
		SlayerAPI.registerProjectile(EntityNetherPlasma.class, "netherplasma");
		SlayerAPI.registerProjectile(EntityOceanPlasma.class, "oceanplasma");
		SlayerAPI.registerProjectile(EntityForestPlasma.class, "forestplasma");

		SlayerAPI.registerMob(EntityRobot.class, "robot");
		SlayerAPI.registerMob(EntitySpyclops.class, "spyclops");
		SlayerAPI.registerMob(EntitySpikedBeast.class, "spikedBeast");
		SlayerAPI.registerMob(EntityMagmaGiant.class, "magmaGiant");
		SlayerAPI.registerMob(EntityInsecto.class, "insecto");
		SlayerAPI.registerMob(EntityPsyollom.class, "psyollom");
		SlayerAPI.registerMob(EntityDarknessCrawler.class, "darknessCrawler");
		SlayerAPI.registerMob(EntityDepthsBeast.class, "depthsBeast");
		SlayerAPI.registerMob(EntityBoom.class, "boomBoom");
		SlayerAPI.registerMob(EntityBigHongo.class, "bigHongo");
		SlayerAPI.registerMob(EntityMediumHongo.class, "mediumHongo");
		SlayerAPI.registerMob(EntitySmallHongo.class, "smallHongo");
		SlayerAPI.registerMob(EntityEucaFighter.class, "eucaFighter");
		SlayerAPI.registerMob(EntityEucaHopper.class, "eucaHopper");
		SlayerAPI.registerMob(EntityMagmaBlaze.class, "magmaBlaze");
		SlayerAPI.registerMob(EntityCrisp.class, "crisp");
		SlayerAPI.registerMob(EntityBurntMiner.class, "burntMiner");
		SlayerAPI.registerMob(EntityExposedFlame.class, "exposedFlame");
		SlayerAPI.registerMob(EntityBurningLight.class, "burningLight");
		SlayerAPI.registerMob(EntityAshHoarder.class, "ashHoarder");
		SlayerAPI.registerMob(EntityBurntAsh.class, "burntAsh");
		SlayerAPI.registerMob(EntityReaper.class, "reaper");
		SlayerAPI.registerMob(EntityDepthsHunter.class, "depthsHunter");
		SlayerAPI.registerMob(EntityEucaCharger.class, "eucaCharger");
		SlayerAPI.registerMob(EntityBunny.class, "bunny");
		SlayerAPI.registerMob(EntitySandCrawler.class, "sandCrawler");
		SlayerAPI.registerMob(EntityTurtle.class, "essenceTurtle");
		SlayerAPI.registerMob(EntityFish.class, "fish");
		//SlayerAPI.registerMob(EntityWaterTribeFisherman.class, "waterTribeFisherman");
		SlayerAPI.registerMob(EntityFireMage.class, "fireMage");
		SlayerAPI.registerMob(EntityIceMage.class, "iceMage");
		//SlayerAPI.registerMob(EntityDragon.class, "dragon");

		SlayerAPI.registerNPC(EntityMage.class, "mage");
		SlayerAPI.registerNPC(EntityBlacksmith.class, "blacksmith");
		SlayerAPI.registerNPC(EntityRedElf.class, "redElf");
		SlayerAPI.registerNPC(EntityGreenElf.class, "greenElf");
		SlayerAPI.registerNPC(EntityEscapedConvict.class, "escapedConvict");

		//SlayerAPI.registerEntity(EntityDragonEgg.class, "Dragon Egg");

		SlayerAPI.registerBossMob(EntityNetherBeast.class, "beastOfTheNether");
		SlayerAPI.registerBossMob(EntityWitheringBeast.class, "witheringBeast");
		SlayerAPI.registerBossMob(EntityCalcia.class, "calcia");
		SlayerAPI.registerBossMob(EntityTempleGuardian.class, "templeGuardian");
		SlayerAPI.registerBossMob(EntityEudor.class, "eudor");
		SlayerAPI.registerBossMob(EntityFourfa.class, "fourfa");
		SlayerAPI.registerBossMob(EntityBlazier.class, "blazier");
		SlayerAPI.registerBossMob(EntitySoulWatcher.class, "soulWatcher");
		SlayerAPI.registerBossMob(EntitySentryKing.class, "sentryKing");
		//SlayerAPI.registerBossMob(EntityWraith.class, "wraith");
	}
}