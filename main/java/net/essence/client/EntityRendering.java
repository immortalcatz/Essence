package net.essence.client;

import net.essence.*;
import net.essence.blocks.tileentity.*;
import net.essence.client.render.*;
import net.essence.client.render.block.*;
import net.essence.client.render.mob.*;
import net.essence.client.render.model.mob.boil.*;
import net.essence.client.render.model.mob.boss.*;
import net.essence.client.render.model.mob.cloudia.*;
import net.essence.client.render.model.mob.corba.*;
import net.essence.client.render.model.mob.depths.*;
import net.essence.client.render.model.mob.end.*;
import net.essence.client.render.model.mob.euca.*;
import net.essence.client.render.model.mob.frozen.*;
import net.essence.client.render.model.mob.overworld.*;
import net.essence.client.render.model.mob.overworld.underground.*;
import net.essence.entity.*;
import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boiling.npc.*;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.cloudia.*;
import net.essence.entity.mob.cloudia.npc.*;
import net.essence.entity.mob.corba.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.depths.npc.*;
import net.essence.entity.mob.end.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.euca.npc.*;
import net.essence.entity.mob.frozen.*;
import net.essence.entity.mob.frozen.npc.*;
import net.essence.entity.mob.overworld.*;
import net.essence.entity.mob.overworld.npc.*;
import net.essence.entity.mob.overworld.underground.*;
import net.essence.entity.projectile.*;
import net.essence.entity.projectile.*;
import net.essence.util.*;
import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraftforge.fml.client.registry.*;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityBoilingPiercer.class, new RenderItemProjectile(EssenceItems.boilingPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityNethicPiercer.class, new RenderItemProjectile(EssenceItems.nethicPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenPiercer.class, new RenderItemProjectile(EssenceItems.frozenPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaPiercer.class, new RenderItemProjectile(EssenceItems.eucaPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsPiercer.class, new RenderItemProjectile(EssenceItems.depthsPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityCorbaPiercer.class, new RenderItemProjectile(EssenceItems.corbaPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostbittenPiercer.class, new RenderItemProjectile(EssenceItems.frostbittenPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostyPiercer.class, new RenderItemProjectile(EssenceItems.frostyPiercer));
		RenderingRegistry.registerEntityRenderingHandler(EntityShimmererProjectile.class, new RenderProjectile(tex.shimmererProjectile));

		RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderModMob(new ModelRobot(), tex.robot));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpikedBeast.class, new RenderModMob(new ModelSpikedBeast(), tex.spikedBeast));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpyclops.class, new RenderSpyclops(new ModelSpyclops()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityMagmaGiant.class, new RenderModMob(new ModelMagmaGiant(), tex.magmaGiant));
		//RenderingRegistry.registerEntityRenderingHandler(EntityInsecto.class, new RenderInsecto(new ModelInsecto()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityPsyollom.class, new RenderPsyollom(new ModelPsyollom()));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsBeast.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.depthsBeast));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessCrawler.class, new RenderModMob(new ModelDarknessCrawler(), tex.darknessCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoom.class, new RenderBoomBoom(new ModelBoomBoom(), tex.boom));
		RenderingRegistry.registerEntityRenderingHandler(EntityBigHongo.class, new RenderModMob(new ModelBigHongo(), tex.bigHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumHongo.class, new RenderModMob(new ModelMediumHongo(), tex.mediumHongo));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallHongo.class, new RenderModMob(new ModelSmallHongo(), tex.smallHongo));
		//RenderingRegistry.registerEntityRenderingHandler(EntityEucaFighter.class, new RenderEucaFighter(new ModelEucaFighter()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaBlaze.class, new RenderModMob(new ModelBlaze(), tex.magmaBlaze));
		//RenderingRegistry.registerEntityRenderingHandler(EntityCrisp.class, new RenderModMob(new ModelDarknessCrawler(), tex.crisp));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBurntMiner.class, new RenderModBiped(new ModelBiped(), tex.burntMiner));
		//RenderingRegistry.registerEntityRenderingHandler(EntityExposedFlame.class, new RenderModBiped(new ModelBiped(), tex.exposedFlame));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurningLight.class, new RenderModBiped(new ModelBiped(), tex.burningLight));
		//RenderingRegistry.registerEntityRenderingHandler(EntityEucaHopper.class, new RenderEucaHopper(new ModelEucaHopper(), tex.eucaHopper));
		//RenderingRegistry.registerEntityRenderingHandler(EntityAshHoarder.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.ashHoarder));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBurntAsh.class, new RenderSizeable(new ModelPsyollom(), 0.5F, 1.5F, tex.burntAsh));
		RenderingRegistry.registerEntityRenderingHandler(EntityReaper.class, new RenderReaper(new ModelReaper(), tex.reaper));
		RenderingRegistry.registerEntityRenderingHandler(EntityDepthsHunter.class, new RenderSizeable(new ModelDepthsHunter(), 0.5F, 1.5F, tex.depthsHunter));
		RenderingRegistry.registerEntityRenderingHandler(EntityEucaCharger.class, new RenderSizeable(new ModelEucaCharger(), 0.5F, 1.5F, tex.eucaCharger));
		RenderingRegistry.registerEntityRenderingHandler(EntitySandCrawler.class, new RenderModMob(new ModelSandCrawler(), 0.5F, tex.sandCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireMage.class, new RenderMage(new ModelMage(), tex.fireMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderMage(new ModelMageTransparent(), tex.iceMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderMage(new ModelMage(), tex.mage));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlacksmith.class, new RenderModBiped(new ModelBiped(), tex.blacksmith));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenMerchant.class, new RenderModMob(new ModelFrozenMerchant(), tex.frozenMerchant));
		RenderingRegistry.registerEntityRenderingHandler(EntityEscapedConvict.class, new RenderModMob(new ModelEscapedConvict(), tex.escapedConvict));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoilTrader.class, new RenderModMob(new ModelBoilTrader(), tex.boilTrader));
		RenderingRegistry.registerEntityRenderingHandler(EntityAlloyMender.class, new RenderModMob(new ModelAlloyMender(), tex.alloyMender));
		//RenderingRegistry.registerEntityRenderingHandler(EntityDragon.class, new RenderDragon());
		RenderingRegistry.registerEntityRenderingHandler(EntityOverseer.class, new RenderModMob(new ModelOverseer(), tex.overseer));
		RenderingRegistry.registerEntityRenderingHandler(EntitySurfaceSeer.class, new RenderModMob(new ModelOverseer(), tex.surfaceSeer));
		RenderingRegistry.registerEntityRenderingHandler(EntityOverseerElder.class, new RenderModMob(new ModelOverseerElder(), tex.overseerElder));
		RenderingRegistry.registerEntityRenderingHandler(EntityCloudGhost.class, new RenderModMob(new ModelCloudGhost(), tex.cloudGhost));
		RenderingRegistry.registerEntityRenderingHandler(EntityStaringGuardian.class, new RenderModMob(new ModelStaringGuardian(), tex.staringGuardian));
		RenderingRegistry.registerEntityRenderingHandler(EntityTreeGolem.class, new RenderModMob(new ModelTreeGolem(), tex.treeGolem));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodCreature.class, new RenderModMob(new ModelWoodCreature(), tex.woodCreature));
		RenderingRegistry.registerEntityRenderingHandler(EntityRoc.class, new RenderModMob(new ModelRoc(), tex.roc));
		RenderingRegistry.registerEntityRenderingHandler(EntityDynaster.class, new RenderModMob(new ModelDynaster(), tex.dynaster));
		RenderingRegistry.registerEntityRenderingHandler(EntityGolder.class, new RenderModMob(new ModelGolder(), tex.golder));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrystalCluster.class, new RenderModMob(new ModelCrystalCluster(), tex.crystalCluster));
		RenderingRegistry.registerEntityRenderingHandler(EntitySilverbot.class, new RenderModMob(new ModelSilverbot(), tex.silverbot));
		RenderingRegistry.registerEntityRenderingHandler(EntityGolditeMage.class, new RenderModMob(new ModelMage(), tex.golditeMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityTinbot.class, new RenderModMob(new ModelTinbot(), tex.tinbot));
		RenderingRegistry.registerEntityRenderingHandler(EntityShimmerer.class, new RenderModMob(new ModelShimmerer(), tex.shimmerer));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderLeaper.class, new RenderModMob(new ModelEnderLeaper(), tex.enderLeaper));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrightener.class, new RenderModMob(new ModelFrightener(), tex.frightener));
		RenderingRegistry.registerEntityRenderingHandler(EntityHellwing.class, new RenderModMob(new ModelHellwing(), tex.hellwing));
		RenderingRegistry.registerEntityRenderingHandler(EntityObserver.class, new RenderModMob(new ModelObserver(), tex.observer));
		RenderingRegistry.registerEntityRenderingHandler(EntityScreamer.class, new RenderModMob(new ModelScreamer(), tex.screamer));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderCrawler.class, new RenderModMob(new ModelEnderCrawler(), tex.enderCrawler));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveMage.class, new RenderModMob(new ModelMage(), tex.caveMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityNatureMage.class, new RenderModMob(new ModelMage(), tex.natureMage));
		RenderingRegistry.registerEntityRenderingHandler(EntityCavurn.class, new RenderModMob(new ModelCavurn(), tex.cavurn));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveling.class, new RenderModMob(new ModelCaveling(), tex.caveling));
		RenderingRegistry.registerEntityRenderingHandler(EntityStonewalker.class, new RenderModMob(new ModelStonewalker(), tex.stonewalker));
		RenderingRegistry.registerEntityRenderingHandler(EntityShiverwolf.class, new RenderModMob(new ModelShiverwolf(), tex.shiverwolf));
		RenderingRegistry.registerEntityRenderingHandler(EntityShiveringShrieker.class, new RenderModMob(new ModelShiveringShrieker(), tex.shiveringShrieker));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenFrostbiter.class, new RenderModMob(new ModelFrozenFrostbiter(), tex.frozenFrostbiter));
		RenderingRegistry.registerEntityRenderingHandler(EntityStarlightVillager.class, new RenderModMob(new ModelStarlightVillager(), tex.starlightVillager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonEgg.class, new RenderDragonEgg(new ModelDragonEgg()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShatterer.class, new RenderShatterer());
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenTroll.class, new RenderModMob(new ModelFrozenTroll(), tex.frozenTroll));
		RenderingRegistry.registerEntityRenderingHandler(EntityPermafraust.class, new RenderModMob(new ModelPermafraust(), tex.permafraust));
		RenderingRegistry.registerEntityRenderingHandler(EntityShiveringBushwalker.class, new RenderModMob(new ModelShiveringBushwalker(), tex.shiveringBushwalker));
		RenderingRegistry.registerEntityRenderingHandler(EntityLeafBlower.class, new RenderModMob(new ModelLeafBlower(), tex.leafBlower));
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherBeast.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.netherBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitheringBeast.class, new RenderBoss(new ModelWitheringBeast(), 0.5F, 2.0F, tex.witheringBeast, stat.witheringBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityCalcia.class, new RenderCalcia(new ModelClacia(), 0.5F, 2.0F, tex.calcia, stat.calciaBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityEudor.class, new RenderEudor(new ModelEudor(), 0.5F, 2.0F, tex.eudor, stat.eudorBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityTempleGuardian.class, new RenderModBiped(new ModelBiped(), 1.5F, tex.templeGuardian));
		RenderingRegistry.registerEntityRenderingHandler(EntityFourfa.class, new RenderFourfa());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlazier.class, new RenderBoss(new ModelBlazier(), 0.5F, 2.0F, tex.blazier, stat.blazierBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntitySoulWatcher.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.soulWatcherBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntitySentryKing.class, new RenderBoss(new ModelSentryKing(), 0.5F, 2.0F, tex.sentryKing, stat.sentryKingBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityThunderbird.class, new RenderBoss(new ModelThunderbird(), 0.5F, 2.0F, tex.thunderbird, stat.thunderbirdBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityLogger.class, new RenderBoss(new ModelLogger(), 0.5F, 2.0F, tex.logger, stat.loggerBossID));
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderBoss(new ModelWraith(), 0.5F, 1.0F, tex.wraith, stat.wraithBossID));
		
		//SlayerAPI.registerItemRenderer(EssenceBlocks.netherBeastStatue, new ItemRendererStatue("netherBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.witheringBeastStatue, new ItemRendererStatue("witheringBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.enderChampionStatue, new ItemRendererStatue("enderChampionStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.wraithStatue, new ItemRendererStatue("wraithStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.calciaStatue, new ItemRendererStatue("calciaStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.eudorStatue, new ItemRendererStatue("eudorStatue"));
		
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(EssenceBlocks.calciaStatue);
		//TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer(TileEntityItemStackRenderer.instance);
		
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatue.class, new StatueRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new GrindstoneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCorbaPortal.class, new CorbaPortalRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEssenceSign.class, new EssenceSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKnowledgeTable.class, new KnowledgeTableRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySummoningTable.class, new SummoningTableRenderer());

		//RenderingRegistry.registerBlockHandler(EssenceBlocks.celestiumOre.getRenderType(), new OreRenderer());
		//RenderingRegistry.registerBlockHandler(EssenceBlocks.mossyEssenceStone.getRenderType(), new OtherBlockRenderer());
	}
}