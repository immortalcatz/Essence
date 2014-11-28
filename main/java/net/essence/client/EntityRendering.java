package net.essence.client;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.blocks.tileentity.*;
import net.essence.client.render.*;
import net.essence.client.render.mob.*;
import net.essence.client.render.mob.model.*;
import net.essence.client.render.mob.model.boil.*;
import net.essence.client.render.mob.model.boss.*;
import net.essence.client.render.mob.model.depths.*;
import net.essence.client.render.mob.model.euca.*;
import net.essence.client.render.mob.model.statue.*;
import net.essence.client.render.mob.model.vanilla.*;
import net.essence.entity.EntityDragonEgg;
import net.essence.entity.MobStats;
import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.boss.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.vanilla.*;
import net.essence.entity.projectile.*;
import net.essence.util.*;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.registry.*;
import net.slayer.api.SlayerAPI;

public class EntityRendering {

	private static Textures tex;
	private static MobStats stat;

	public static void init() {
		/*RenderingRegistry.registerEntityRenderingHandler(EntityBasicProjectile.class, new RenderStaffProjectile(tex.basic, 1.0F, 0.2F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoomsBringer.class, new RenderStaffProjectile(tex.basic, 0.2F, 1.0F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityConjuring.class, new RenderStaffProjectile(tex.basic, 0.1F, 1.0F, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnlightment.class, new RenderStaffProjectile(tex.basic, 0.7F, 0.0F, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenpace.class, new RenderStaffProjectile(tex.basic, 0.6F, 1.0F, 0.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWizardsStar.class, new RenderStaffProjectile(tex.basic, 1.0F, 1.0F, 0.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBouncingProjectile.class, new RenderProjectile(tex.bouncingProjectile));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaFireball.class, new RenderProjectile(tex.magmaBall));

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

		RenderingRegistry.registerEntityRenderingHandler(EntityDragonEgg.class, new RenderDragonEgg(new ModelDragonEgg()));

		RenderingRegistry.registerEntityRenderingHandler(EntityNetherBeast.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, tex.netherBeast, stat.netherBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitheringBeast.class, new RenderBoss(new ModelWitheringBeast(), 0.5F, 2.0F, tex.witheringBeast, stat.witheringBeastBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityCalcia.class, new RenderCalcia(new ModelClacia(), 0.5F, 2.0F, tex.calcia, stat.calciaBossID));
		RenderingRegistry.registerEntityRenderingHandler(EntityEudor.class, new RenderBoss(new ModelEudor(), 0.5F, 2.0F, tex.eudor, stat.eudorBossID));

		//RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderBoss(new ModelWraith(), 0.5F, 1.0F, tex.wraith, stat.wraithBossID));
		
		SlayerAPI.registerItemRenderer(EssenceBlocks.netherBeastStatue, new ItemRendererStatue("netherBeastStatue"));
		SlayerAPI.registerItemRenderer(EssenceBlocks.witheringBeastStatue, new ItemRendererStatue("witheringBeastStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.enderChampionStatue, new ItemRendererStatue("enderChampionStatue"));
		//SlayerAPI.registerItemRenderer(EssenceBlocks.wraithStatue, new ItemRendererStatue("wraithStatue"));
		SlayerAPI.registerItemRenderer(EssenceBlocks.calciaStatue, new ItemRendererStatue("calciaStatue"));
		SlayerAPI.registerItemRenderer(EssenceBlocks.eudorStatue, new ItemRendererStatue("eudorStatue"));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatue.class, new StatueRenderer());
		
		//RenderingRegistry.registerBlockHandler(EssenceBlocks.celestiumOre.getRenderType(), new OreRenderer());
		//RenderingRegistry.registerBlockHandler(EssenceBlocks.mossyEssenceStone.getRenderType(), new OtherBlockRenderer());*/
	}
}