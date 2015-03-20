package net.essence.client;

import net.essence.*;
import net.essence.blocks.tileentity.*;
import net.essence.client.render.*;
import net.essence.client.render.mob.*;
import net.essence.client.render.model.mob.boil.*;
import net.essence.client.render.model.mob.boss.*;
import net.essence.client.render.model.mob.depths.*;
import net.essence.client.render.model.mob.euca.*;
import net.essence.client.render.model.mob.overworld.*;
import net.essence.client.render.model.statue.*;
import net.essence.entity.*;
import net.essence.entity.*;
import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boiling.npc.*;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.frozen.*;
import net.essence.entity.mob.frozen.npc.*;
import net.essence.entity.mob.overworld.*;
import net.essence.entity.mob.overworld.npc.*;
import net.essence.entity.mob.overworld.npc.water_tribe.*;
import net.essence.entity.projectile.*;
import net.essence.entity.projectile.EntityBouncingProjectile;
import net.essence.util.*;
import net.minecraft.client.model.*;
import net.minecraftforge.fml.client.registry.*;
import net.slayer.api.*;

public class EntityRendering {

	private static Textures tex;
	private static MobStats stat;

	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBasicProjectile.class, new RenderStaffProjectile(tex.basic, 1.0F, 0.2F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoomsBringer.class, new RenderStaffProjectile(tex.basic, 1.2F, 0.2F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityConjuring.class, new RenderStaffProjectile(tex.basic, 0.1F, 1.0F, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnlightenment.class, new RenderStaffProjectile(tex.basic, 0.7F, 0.0F, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenpace.class, new RenderStaffProjectile(tex.basic, 0.6F, 1.0F, 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWizardsStar.class, new RenderStaffProjectile(tex.basic, 1.0F, 1.0F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBouncingProjectile.class, new RenderProjectile(tex.bouncingProjectile));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaFireball.class, new RenderProjectile(tex.magmaBall));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenArrow.class, new RenderModArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderStaffProjectile(tex.empty, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBall.class, new RenderStaffProjectile(tex.empty, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTempleBall.class, new RenderStaffProjectile(tex.templeBall, 0F, 0F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLightningBall.class, new RenderStaffProjectile(tex.empty, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRockProjectile.class, new RenderProjectile(tex.rockChunk));
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherPlasma.class, new RenderProjectile(tex.plasma));
		RenderingRegistry.registerEntityRenderingHandler(EntityOceanPlasma.class, new RenderProjectile(tex.plasma));
		RenderingRegistry.registerEntityRenderingHandler(EntityForestPlasma.class, new RenderProjectile(tex.plasma));

		RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderModMob(new ModelRobot(), tex.robot));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpikedBeast.class, new RenderModMob(new ModelSpikedBeast(), tex.spikedBeast));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpyclops.class, new RenderSpyclops(new ModelSpyclops()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaGiant.class, new RenderModMob(new ModelMagmaGiant(), tex.magmaGiant));
		RenderingRegistry.registerEntityRenderingHandler(EntityInsecto.class, new RenderInsecto(new ModelInsecto()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPsyollom.class, new RenderPsyollom(new ModelPsyollom()));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsBeast.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.depthsBeast));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessCrawler.class, new RenderModMob(new ModelDarknessCrawler(), tex.darknessCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoom.class, new RenderBoomBoom(new ModelBoomBoom(), tex.boom));
		RenderingRegistry.registerEntityRenderingHandler(EntityBigHongo.class, new RenderModMob(new ModelBigHongo(), tex.bigHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumHongo.class, new RenderModMob(new ModelMediumHongo(), tex.mediumHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallHongo.class, new RenderModMob(new ModelSmallHongo(), tex.smallHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaFighter.class, new RenderEucaFighter(new ModelEucaFighter()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaBlaze.class, new RenderModMob(new ModelBlaze(), tex.magmaBlaze));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrisp.class, new RenderModMob(new ModelDarknessCrawler(), tex.crisp));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurntMiner.class, new RenderModBiped(new ModelBiped(), tex.burntMiner));
		RenderingRegistry.registerEntityRenderingHandler(EntityExposedFlame.class, new RenderModBiped(new ModelBiped(), tex.exposedFlame));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurningLight.class, new RenderModBiped(new ModelBiped(), tex.burningLight));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaHopper.class, new RenderEucaHopper(new ModelEucaHopper(), tex.eucaHopper));
		RenderingRegistry.registerEntityRenderingHandler(EntityAshHoarder.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.ashHoarder));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurntAsh.class, new RenderSizeable(new ModelPsyollom(), 0.5F, 1.5F, tex.burntAsh));
		RenderingRegistry.registerEntityRenderingHandler(EntityReaper.class, new RenderReaper(new ModelReaper(), tex.reaper));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsHunter.class, new RenderSizeable(new ModelDepthsHunter(), 0.5F, 1.5F, tex.depthsHunter));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaCharger.class, new RenderSizeable(new ModelEucaCharger(), 0.5F, 1.5F, tex.eucaCharger));
		RenderingRegistry.registerEntityRenderingHandler(EntityBunny.class, new RenderModMob(new ModelBunny(), 0.3F, tex.bunny));
		RenderingRegistry.registerEntityRenderingHandler(EntitySandCrawler.class, new RenderModMob(new ModelSandCrawler(), 0.5F, tex.sandCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderModMob(new ModelTurtle(), 0.5F, tex.turtle));
		RenderingRegistry.registerEntityRenderingHandler(EntityFish.class, new RenderFish(new ModelFish()));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaterTribeFisherman.class, new RenderModBiped(new ModelBiped(), tex.waterFisherman));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireMage.class, new RenderModBiped(new ModelBiped(), tex.fireMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderModBiped(new ModelBiped(), tex.iceMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderModBiped(new ModelBiped(), tex.mage));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlacksmith.class, new RenderModBiped(new ModelBiped(), tex.blacksmith));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenElf.class, new RenderModBiped(new ModelBiped(), tex.greenElf));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedElf.class, new RenderModBiped(new ModelBiped(), tex.redElf));
		RenderingRegistry.registerEntityRenderingHandler(EntityEscapedConvict.class, new RenderModMob(new ModelEscapedConvict(), tex.escapedConvict));
		//RenderingRegistry.registerEntityRenderingHandler(EntityDragon.class, new RenderDragon());

		RenderingRegistry.registerEntityRenderingHandler(EntityDragonEgg.class, new RenderDragonEgg(new ModelDragonEgg()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShatterer.class, new RenderShatterer());

		RenderingRegistry.registerEntityRenderingHandler(EntityNetherBeast.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.netherBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitheringBeast.class, new RenderBoss(new ModelWitheringBeast(), 0.5F, 2.0F, tex.witheringBeast, stat.witheringBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityCalcia.class, new RenderCalcia(new ModelClacia(), 0.5F, 2.0F, tex.calcia, stat.calciaBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityEudor.class, new RenderEudor(new ModelEudor(), 0.5F, 2.0F, tex.eudor, stat.eudorBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityTempleGuardian.class, new RenderModBiped(new ModelBiped(), 1.5F, tex.templeGuardian));
		RenderingRegistry.registerEntityRenderingHandler(EntityFourfa.class, new RenderFourfa());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlazier.class, new RenderBoss(new ModelBlazier(), 0.5F, 2.0F, tex.blazier, stat.blazierBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntitySoulWatcher.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.soulWatcherBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntitySentryKing.class, new RenderBoss(new ModelSentryKing(), 0.5F, 2.0F, tex.sentryKing, stat.sentryKingBossID));

		//RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderBoss(new ModelWraith(), 0.5F, 1.0F, tex.wraith, stat.wraithBossID));
		
		//SlayerAPI.registerItemRenderer(EssenceBlocks.netherBeastStatue, new ItemRendererStatue("netherBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.witheringBeastStatue, new ItemRendererStatue("witheringBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.enderChampionStatue, new ItemRendererStatue("enderChampionStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.wraithStatue, new ItemRendererStatue("wraithStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.calciaStatue, new ItemRendererStatue("calciaStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.eudorStatue, new ItemRendererStatue("eudorStatue"));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatue.class, new StatueRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new GrindstoneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCorbaPortal.class, new CorbaPortalRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEssenceSign.class, new EssenceSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKnowledgeTable.class, new KnowledgeTableRenderer());

		//RenderingRegistry.registerBlockHandler(EssenceBlocks.celestiumOre.getRenderType(), new OreRenderer());
		//RenderingRegistry.registerBlockHandler(EssenceBlocks.mossyEssenceStone.getRenderType(), new OtherBlockRenderer());
	}
}