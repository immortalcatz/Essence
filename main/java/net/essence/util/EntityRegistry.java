package net.essence.util;

import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boiling.npc.*;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.cloudia.*;
import net.essence.entity.mob.cloudia.npc.*;
import net.essence.entity.mob.corba.*;
import net.essence.entity.mob.corba.npc.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.depths.npc.*;
import net.essence.entity.mob.end.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.euca.npc.*;
import net.essence.entity.mob.frozen.*;
import net.essence.entity.mob.frozen.npc.*;
import net.essence.entity.mob.overworld.*;
import net.essence.entity.mob.overworld.EntityWraith;
import net.essence.entity.mob.overworld.npc.*;
import net.essence.entity.mob.overworld.underground.*;
import net.essence.entity.projectile.*;
import net.slayer.api.SlayerAPI;

public class EntityRegistry {

	public static void init() {
		registerProjectiles();
		registerEntitys();
		registerEndMobs();
		registerOverworldMobs();
		registerNetherMobs();
		registerBPMobs();
		registerFLMobs();
		registerEucaMobs();
		registerDepthsMobs();
		registerCorbaMobs();
		registerCloudiaMobs();
		registerNPCs();
		registerBosses();
	}

	public static void registerProjectiles() {
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
		SlayerAPI.registerProjectile(EntityBoilingPiercer.class, "boilingpiercer");
		SlayerAPI.registerProjectile(EntityNethicPiercer.class, "nethicpiercer");
		SlayerAPI.registerProjectile(EntityFrozenPiercer.class, "frozenpiercer");
		SlayerAPI.registerProjectile(EntityEucaPiercer.class, "eucapiercer");
		SlayerAPI.registerProjectile(EntityDepthsPiercer.class, "depthspiercer");
		SlayerAPI.registerProjectile(EntityCorbaPiercer.class, "corbapiercer");
		SlayerAPI.registerProjectile(EntityFrostbittenPiercer.class, "frostbittenpiercer");
		SlayerAPI.registerProjectile(EntityFrostyPiercer.class, "frostypiercer");
		SlayerAPI.registerProjectile(EntityPower.class, "power");
		SlayerAPI.registerProjectile(EntityShimmererProjectile.class, "shimmererprojectile");
	}

	public static void registerEndMobs() {
		SlayerAPI.registerEndMob(EntityEnderLeaper.class, "enderLeaper");
		SlayerAPI.registerEndMob(EntityEnderCrawler.class, "enderCrawler");
	}

	public static void registerNetherMobs() {

	}

	public static void registerOverworldMobs() {
		SlayerAPI.registerOverworldMob(EntityRobot.class, "robot");
		SlayerAPI.registerOverworldMob(EntitySpyclops.class, "spyclops");
		SlayerAPI.registerOverworldMob(EntityBoom.class, "boomBoom");
		SlayerAPI.registerOverworldMob(EntitySmallHongo.class, "smallHongo");
		SlayerAPI.registerOverworldMob(EntityMediumHongo.class, "mediumHongo");
		SlayerAPI.registerOverworldMob(EntityBigHongo.class, "bigHongo");
		SlayerAPI.registerOverworldMob(EntityReaper.class, "reaper");
		SlayerAPI.registerOverworldMob(EntitySandCrawler.class, "sandCrawler");
		SlayerAPI.registerOverworldMob(EntityFireMage.class, "fireMage");
		SlayerAPI.registerOverworldMob(EntityIceMage.class, "iceMage");
		SlayerAPI.registerOverworldMob(EntityCaveMage.class, "caveMage");
		SlayerAPI.registerOverworldMob(EntityCavurn.class, "cavurn");
		SlayerAPI.registerOverworldMob(EntityCaveling.class, "caveling");
		SlayerAPI.registerOverworldMob(EntityWraith.class, "wraith");
		SlayerAPI.registerOverworldMob(EntityStonewalker.class, "stonewalker");
		SlayerAPI.registerOverworldMob(EntityTurducken.class, "turducken");
		SlayerAPI.registerOverworldMob(EntityFloro.class, "floro");
	}

	public static void registerBPMobs() {
		//SlayerAPI.registerBPMob(EntityAshHoarder.class, "ashHoarder");
		//SlayerAPI.registerBPMob(EntityBurntAsh.class, "burntAsh");
		//SlayerAPI.registerBPMob(EntityMagmaGiant.class, "magmaGiant");
		//SlayerAPI.registerBPMob(EntityCrisp.class, "crisp");
		//SlayerAPI.registerBPMob(EntityExposedFlame.class, "exposedFlame");
		SlayerAPI.registerBPMob(EntityMagmaBlaze.class, "magmaBlaze");
		SlayerAPI.registerBPMob(EntityBurningLight.class, "burningLight");
		SlayerAPI.registerBPMob(EntityFrightener.class, "frightener");
		SlayerAPI.registerBPMob(EntityHellwing.class, "hellwing");
		SlayerAPI.registerBPMob(EntityObserver.class, "observer");
		SlayerAPI.registerBPMob(EntityScreamer.class, "screamer");
		SlayerAPI.registerBPMob(EntityPhoenix.class, "phoenix");
	}

	public static void registerFLMobs() {
		SlayerAPI.registerFLMob(EntityShatterer.class, "shatterer");
		SlayerAPI.registerFLMob(EntityFrozenTroll.class, "frozenTroll");
		SlayerAPI.registerFLMob(EntityPermafraust.class, "permafraust");
		SlayerAPI.registerFLMob(EntityShiveringBushwalker.class, "shiveringBushwalker");
		SlayerAPI.registerFLMob(EntityShiverwolf.class, "shiverwolf");
		SlayerAPI.registerFLMob(EntityShiveringShrieker.class, "shiveringShrieker");
		SlayerAPI.registerFLMob(EntityFrozenFrostbiter.class, "frozenFrostbiter");
		SlayerAPI.registerFLMob(EntityCrystalCluster.class, "crystalCluster");
		SlayerAPI.registerFLMob(EntityShiverwing.class, "shiverwing");
	}

	public static void registerEucaMobs() {
		//SlayerAPI.registerEucaMob(EntityInsecto.class, "insecto");
		//SlayerAPI.registerEucaMob(EntityPsyollom.class, "psyollom");
		//SlayerAPI.registerEucaMob(EntityEucaFighter.class, "eucaFighter");
		//SlayerAPI.registerEucaMob(EntityEucaHopper.class, "eucaHopper");
		SlayerAPI.registerEucaMob(EntityEucaCharger.class, "eucaCharger");
		SlayerAPI.registerEucaMob(EntityDynaster.class, "dynaster");
		SlayerAPI.registerEucaMob(EntityGolder.class, "golder");
		SlayerAPI.registerEucaMob(EntityGolditeMage.class, "golditeMage");
		SlayerAPI.registerEucaMob(EntitySilverbot.class, "silverbot");
		SlayerAPI.registerEucaMob(EntityGoldbot.class, "goldbot");
		SlayerAPI.registerEucaMob(EntityShimmerer.class, "shimmerer");
		SlayerAPI.registerEucaMob(EntityGoldwing.class, "goldwing");
	}

	public static void registerDepthsMobs() {
		SlayerAPI.registerDepthsMob(EntitySpikedBeast.class, "spikedBeast");
		SlayerAPI.registerDepthsMob(EntityDarknessCrawler.class, "darknessCrawler");
		SlayerAPI.registerDepthsMob(EntityDepthsBeast.class, "depthsBeast");
		SlayerAPI.registerDepthsMob(EntityDepthsHunter.class, "depthsHunter");
		SlayerAPI.registerDepthsMob(EntityRoc.class, "roc");
		SlayerAPI.registerDepthsMob(EntityDarkener.class, "darkener");
		SlayerAPI.registerDepthsMob(EntityLightener.class, "lightener");
		SlayerAPI.registerDepthsMob(EntityDarkSorcerer.class, "darkSorcerer");
	}

	public static void registerCorbaMobs() {
		SlayerAPI.registerCorbaMob(EntityOverseer.class, "overseer");
		SlayerAPI.registerCorbaMob(EntityOverseerElder.class, "overseerElder");
		SlayerAPI.registerCorbaMob(EntitySurfaceSeer.class, "surfaceSeer");
		SlayerAPI.registerCorbaMob(EntityTreeGolem.class, "treeGolem");
		SlayerAPI.registerCorbaMob(EntityWoodCreature.class, "woodCreature");
		SlayerAPI.registerCorbaMob(EntityNatureMage.class, "natureMage");
		SlayerAPI.registerCorbaMob(EntityLeafBlower.class, "leafBlower");
		SlayerAPI.registerCorbaMob(EntityWoodpecker.class, "woodpecker");
	}

	public static void registerCloudiaMobs() {
		SlayerAPI.registerCloudiaMob(EntityCloudGhost.class, "cloudGhost");
		SlayerAPI.registerCloudiaMob(EntityCloudFlyer.class, "cloudFlyer");
		SlayerAPI.registerCloudiaMob(EntityStarlightGolem.class, "starlightGolem");
		SlayerAPI.registerCloudiaMob(EntityStarlightTransporter.class, "starlightTransporter");
	}

	public static void registerNPCs() {
		SlayerAPI.registerNPC(EntityMage.class, "mage");
		SlayerAPI.registerNPC(EntityBlacksmith.class, "blacksmith");
		SlayerAPI.registerNPC(EntityFrozenMerchant.class, "frozenMerchant");
		SlayerAPI.registerNPC(EntityEscapedConvict.class, "escapedConvict");
		SlayerAPI.registerNPC(EntityStaringGuardian.class, "staringGuardian");
		SlayerAPI.registerNPC(EntityTordo.class, "tordo");
		SlayerAPI.registerNPC(EntityRedTordo.class, "redTordo");
		SlayerAPI.registerNPC(EntityBoilTrader.class, "boilTrader");
		SlayerAPI.registerNPC(EntityAlloyMender.class, "alloyMender");
		SlayerAPI.registerNPC(EntityStarlightVillager.class, "starlightVillager");
	}

	public static void registerBosses() {
		SlayerAPI.registerBossMob(EntityNetherBeast.class, "beastOfTheNether");
		SlayerAPI.registerBossMob(EntityWitheringBeast.class, "witheringBeast");
		SlayerAPI.registerBossMob(EntityCalcia.class, "calcia");
		SlayerAPI.registerBossMob(EntityTempleGuardian.class, "templeGuardian");
		SlayerAPI.registerBossMob(EntityEudor.class, "eudor");
		SlayerAPI.registerBossMob(EntityFourfa.class, "fourfa");
		SlayerAPI.registerBossMob(EntityBlazier.class, "blazier");
		SlayerAPI.registerBossMob(EntitySoulWatcher.class, "soulWatcher");
		SlayerAPI.registerBossMob(EntitySentryKing.class, "sentryKing");
		SlayerAPI.registerBossMob(EntityThunderbird.class, "thunderbird");
		SlayerAPI.registerBossMob(EntityLogger.class, "logger");
		SlayerAPI.registerBossMob(EntityCorallator.class, "corallator");
		//SlayerAPI.registerBossMob(EntityWraith.class, "wraith");
	}

	public static void registerEntitys() {
		
	}
}