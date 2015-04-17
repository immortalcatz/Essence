package net.essence.util;

import net.essence.entity.mob.boiling.EntityAshHoarder;
import net.essence.entity.mob.boiling.EntityBurningLight;
import net.essence.entity.mob.boiling.EntityBurntAsh;
import net.essence.entity.mob.boiling.EntityBurntMiner;
import net.essence.entity.mob.boiling.EntityCrisp;
import net.essence.entity.mob.boiling.EntityExposedFlame;
import net.essence.entity.mob.boiling.EntityMagmaBlaze;
import net.essence.entity.mob.boiling.EntityMagmaGiant;
import net.essence.entity.mob.boiling.npc.EntityEscapedConvict;
import net.essence.entity.mob.boss.EntityBlazier;
import net.essence.entity.mob.boss.EntityCalcia;
import net.essence.entity.mob.boss.EntityEudor;
import net.essence.entity.mob.boss.EntityFourfa;
import net.essence.entity.mob.boss.EntityNetherBeast;
import net.essence.entity.mob.boss.EntitySentryKing;
import net.essence.entity.mob.boss.EntitySoulWatcher;
import net.essence.entity.mob.boss.EntityTempleGuardian;
import net.essence.entity.mob.boss.EntityWitheringBeast;
import net.essence.entity.mob.cloudia.EntityCloudGhost;
import net.essence.entity.mob.corba.EntityOverseer;
import net.essence.entity.mob.corba.EntityOverseerElder;
import net.essence.entity.mob.corba.npc.EntityTordo;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntityDepthsHunter;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.depths.npc.EntityStaringGuardian;
import net.essence.entity.mob.euca.EntityEucaCharger;
import net.essence.entity.mob.euca.EntityEucaFighter;
import net.essence.entity.mob.euca.EntityEucaHopper;
import net.essence.entity.mob.euca.EntityInsecto;
import net.essence.entity.mob.euca.EntityPsyollom;
import net.essence.entity.mob.frozen.EntityFrozenTroll;
import net.essence.entity.mob.frozen.EntityPermafraust;
import net.essence.entity.mob.frozen.EntityShatterer;
import net.essence.entity.mob.frozen.EntityShiveringBushwalker;
import net.essence.entity.mob.frozen.npc.EntityFrozenMerchant;
import net.essence.entity.mob.overworld.EntityBigHongo;
import net.essence.entity.mob.overworld.EntityBoom;
import net.essence.entity.mob.overworld.EntityBunny;
import net.essence.entity.mob.overworld.EntityFireMage;
import net.essence.entity.mob.overworld.EntityFish;
import net.essence.entity.mob.overworld.EntityIceMage;
import net.essence.entity.mob.overworld.EntityMediumHongo;
import net.essence.entity.mob.overworld.EntityReaper;
import net.essence.entity.mob.overworld.EntityRobot;
import net.essence.entity.mob.overworld.EntitySandCrawler;
import net.essence.entity.mob.overworld.EntitySmallHongo;
import net.essence.entity.mob.overworld.EntitySpyclops;
import net.essence.entity.mob.overworld.EntityTurtle;
import net.essence.entity.mob.overworld.npc.EntityBlacksmith;
import net.essence.entity.mob.overworld.npc.EntityMage;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.entity.projectile.EntityBouncingProjectile;
import net.essence.entity.projectile.EntityChaosProjectile;
import net.essence.entity.projectile.EntityConjuring;
import net.essence.entity.projectile.EntityDarknessArrow;
import net.essence.entity.projectile.EntityDoomsBringer;
import net.essence.entity.projectile.EntityEnlightenment;
import net.essence.entity.projectile.EntityFireBall;
import net.essence.entity.projectile.EntityFlameArrow;
import net.essence.entity.projectile.EntityForestPlasma;
import net.essence.entity.projectile.EntityFrozenArrow;
import net.essence.entity.projectile.EntityGreenpace;
import net.essence.entity.projectile.EntityIceBall;
import net.essence.entity.projectile.EntityLightningBall;
import net.essence.entity.projectile.EntityMagmaFireball;
import net.essence.entity.projectile.EntityNetherPlasma;
import net.essence.entity.projectile.EntityOceanPlasma;
import net.essence.entity.projectile.EntityPoisonArrow;
import net.essence.entity.projectile.EntityRockProjectile;
import net.essence.entity.projectile.EntityTempleBall;
import net.essence.entity.projectile.EntityWizardsStar;
import net.slayer.api.SlayerAPI;

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
		SlayerAPI.registerMob(EntityOverseer.class, "overseer");
		SlayerAPI.registerMob(EntityOverseerElder.class, "overseerElder");
		SlayerAPI.registerMob(EntityTordo.class, "tordo");
		SlayerAPI.registerMob(EntityCloudGhost.class, "cloudGhost");

		SlayerAPI.registerNPC(EntityMage.class, "mage");
		SlayerAPI.registerNPC(EntityBlacksmith.class, "blacksmith");
		SlayerAPI.registerNPC(EntityFrozenMerchant.class, "frozenMerchant");
		SlayerAPI.registerNPC(EntityEscapedConvict.class, "escapedConvict");
		SlayerAPI.registerNPC(EntityStaringGuardian.class, "staringGuardian");
		
		SlayerAPI.registerMob(EntityShatterer.class, "shatterer");
		SlayerAPI.registerMob(EntityFrozenTroll.class, "frozenTroll");
		SlayerAPI.registerMob(EntityPermafraust.class, "permafraust");
		SlayerAPI.registerMob(EntityShiveringBushwalker.class, "shiveringBushwalker");
		
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