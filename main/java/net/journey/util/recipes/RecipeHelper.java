package net.journey.util.recipes;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.blocks.BlockColouredBricks;
import net.journey.blocks.BlockMiniColouredBricks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHelper {

	public static void init() {
		initCrafting();
	}

	public static void initCrafting() {
		JourneyBlocks b = new JourneyBlocks();
		JourneyItems i = new JourneyItems();
		GameRegistry.addRecipe(new ItemStack(JourneyItems.flameCoin), new Object[] {"iii", "idi", "iii", 'i', Items.gold_ingot, 'd', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.hellcrustIngot), new Object[] {"iii", "idi", "iii", 'i', JourneyItems.ash, 'd', JourneyItems.hellstoneIngot});
		GameRegistry.addRecipe(new ItemStack(JourneyBlocks.eucaPortalFrame, 10), new Object[] {"iii", "iii", "iii", 'i', JourneyItems.eucaPortalGem});
		GameRegistry.addRecipe(new ItemStack(JourneyBlocks.depthsPortalFrame, 10), new Object[] {"iii", "iii", "iii", 'i', JourneyItems.depthsPortalGem});
		GameRegistry.addRecipe(new ItemStack(JourneyBlocks.cloudiaPortalFrame, 10), new Object[] {"iii", "iii", "iii", 'i', JourneyItems.cloudiaPortalGem});
		GameRegistry.addRecipe(new ItemStack(JourneyBlocks.corbaPortalFrame, 12), new Object[] {"   ", "iii", "iii", 'i', JourneyItems.corbaPortalGem});
		GameRegistry.addRecipe(new ItemStack(JourneyBlocks.terraniaPortalFrame, 10), new Object[] {"iii", "iii", "iii", 'i', JourneyItems.terraniaPortalGem});
		GameRegistry.addRecipe(new ItemStack(JourneyBlocks.frozenPortalFrame, 10), new Object[] {"iii", "idi", "iii", 'i', Items.snowball, 'd', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(JourneyItems.withicBlade), new Object[] {" d ", " d ", " i ", 'd', JourneyItems.withicDust, 'i', JourneyItems.stoneClump});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.reinforcedStoneSword), new Object[] {" d ", " d ", " i ", 'd', JourneyItems.reinforcedStoneIngot, 'i', JourneyItems.stoneStick});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.reinforcedCrystalSword), new Object[] {" d ", " d ", " i ", 'd', JourneyItems.reinforcedCrystalIngot, 'i', JourneyItems.stoneStick});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.pedalSword), new Object[] {" d ", " d ", " i ", 'd', JourneyItems.floroPedal, 'i', JourneyItems.stoneClump});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.crystalBlade), new Object[] {" d ", " d ", " i ", 'd', JourneyItems.caveCrystal, 'i', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.reinforcedStoneIngot), new Object[] {"ddd", "did", "ddd", 'd', JourneyItems.stoneClump, 'i', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.reinforcedCrystalIngot), new Object[] {"ddd", "did", "ddd", 'd', JourneyItems.stoneClump, 'i', JourneyItems.caveCrystal});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.crystalBall), new Object[] {"   ", "idi", "ixi", 'i', Items.diamond, 'd', Items.ender_pearl, 'x', JourneyItems.sapphire});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.demonicBomb, 16), new Object[] {"ddd", "did", "ddd", 'd', JourneyItems.demonicDust, 'i', JourneyItems.crystalBall});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.stoneClump, 4), new Object[] {"ddd", "ddd", "ddd", 'd', JourneyItems.caveDust});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.stoneStick, 16), new Object[] {" d ", " d ", " d ", 'd', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.stoneClump, 16), new Object[] {"ddd", "ddd", "ddd", 'd', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(JourneyItems.stoneClump, 16), new Object[] {"ddd", "ddd", "ddd", 'd', Blocks.cobblestone});
		
		GameRegistry.addShapelessRecipe(new ItemStack(i.demonicDust, 5), new Object[]{i.demonicBone});

		addOre(b.celestiumOre, i.celestiumIngot, b.celestiumBlock, i.celestiumAxe, i.celestiumPickaxe, i.celestiumShovel, i.celestiumHoe, i.celestiumSword, i.celestiumMultiTool, i.celestiumHelmet, i.celestiumChest, i.celestiumLegs, i.celestiumBoots, i.celestiumDust);
		addOre(b.hellstoneOre, i.hellstoneIngot, b.hellstoneBlock, i.hellstoneAxe, i.hellstonePickaxe, i.hellstoneShovel, i.hellstoneHoe, i.hellstoneSword, i.hellstoneMultiTool, i.hellstoneHelmet, i.hellstoneChest, i.hellstoneLegs, i.hellstoneBoots, i.hellstoneDust);
		addOre(b.flairiumOre, i.flairiumIngot, b.flairiumBlock, i.flairiumAxe, i.flairiumPickaxe, i.flairiumShovel, i.flairiumHoe, i.flairiumSword, i.flairiumMultiTool, i.flairiumHelmet, i.flairiumChest, i.flairiumLegs, i.flairiumBoots, i.flairiumDust);
		addOre(b.shadiumOre, i.shadiumIngot, b.shadiumBlock, i.shadiumAxe, i.shadiumPickaxe, i.shadiumShovel, i.shadiumHoe, i.shadiumSword, i.shadiumMultiTool, i.shadiumHelmet, i.shadiumChest, i.shadiumLegs, i.shadiumBoots, i.shadiumDust);
		addOre(b.luniumOre, i.luniumIngot, b.luniumBlock, i.luniumAxe, i.luniumPickaxe, i.luniumShovel, i.luniumHoe, i.luniumSword, i.luniumMultiTool, i.luniumHelmet, i.luniumChest, i.luniumLegs, i.luniumBoots, i.luniumDust);
		addOre(b.sapphireOre, i.sapphire, b.sapphireBlock, i.sapphireAxe, i.sapphirePickaxe, i.sapphireShovel, i.sapphireHoe, i.sapphireSword, i.sapphireMultiTool, i.sapphireHelmet, i.sapphireChest, i.sapphireLegs, i.sapphireBoots, i.sapphireDust);
		addOre(b.koriteOre, i.koriteIngot, b.koriteBlock, i.koriteAxe, i.koritePickaxe, i.koriteShovel, i.koriteHoe, i.koriteSword, i.koriteMultiTool, null, null, null, null, null);
		addOre(b.storonOre, i.storonIngot, b.storonBlock, i.storonAxe, i.storonPickaxe, i.storonShovel, i.storonHoe, i.storonSword, i.storonMultiTool, null, null, null, null, null);
		addOre(b.mekyumOre, i.mekyumIngot, b.mekyumBlock, i.mekyumAxe, i.mekyumPickaxe, i.mekyumShovel, i.mekyumHoe, i.mekyumSword, i.mekyumMultiTool, null, null, null, null, null);

		addWood(b.eucaGoldLog, b.goldEucaPlank, b.eucaGoldStairs, 0, true);
		addWood(b.depthsLog, b.depthsPlank, b.depthsStairs, 1, true);

		GameRegistry.addRecipe(new ItemStack(b.grindstone), new Object[] {" o ", "bib", "bbb", 'b', Blocks.brick_block, 'o', Blocks.obsidian, 'i', Items.iron_ingot});

		GameRegistry.addRecipe(new ItemStack(i.flameBow), new Object[] {" fs", "f s", " fs", 'f', Items.fire_charge, 's', Items.string});
		//GameRegistry.addRecipe(new ItemStack(i.flameArrow, 8), new Object[] {"l", "s", "f", 'f', Items.feather, 's', Items.stick, 'l', Items.flint_and_steel});

		//GameRegistry.addRecipe(new ItemStack(b.hotGlassPane, 16), new Object[] {"iii", "iii", 'i', b.hotGlass});
		//GameRegistry.addRecipe(new ItemStack(b.smoothGlassPane, 16), new Object[] {"iii", "iii", 'i', b.smoothGlass});
		
		addOPFood(JourneyItems.goldenPork, JourneyItems.goldenPorkOP, Items.porkchop);
		addOPFood(JourneyItems.goldenSteak, JourneyItems.goldenSteakOP, Items.beef);
		addOPFood(JourneyItems.goldenPotato, JourneyItems.goldenPotatoOP, Items.potato);
		GameRegistry.addRecipe(new ItemStack(i.hellstoneClump), new Object[] {"iii", 'i', i.hellstoneIngot});
		GameRegistry.addRecipe(new ItemStack(i.shadiumClump), new Object[] {"iii", 'i', i.shadiumIngot});
		GameRegistry.addRecipe(new ItemStack(i.luniumClump), new Object[] {"iii", 'i', i.luniumIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(i.spawnerClump), new Object[]{i.shadiumClump, i.luniumClump, i.hellstoneClump});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{b.redGlowshroomTop});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{b.redGlowshroomBottom});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{b.blueGlowshroomTop});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{b.blueGlowshroomBottom});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{b.greenGlowshroomTop});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{b.greenGlowshroomBottom});
		GameRegistry.addShapelessRecipe(new ItemStack(i.glowshroomPowder, 4), new Object[]{i.glowshroom});
		GameRegistry.addShapelessRecipe(new ItemStack(i.floroSeeds, 4), new Object[]{i.floroPedal});
		GameRegistry.addSmelting(i.spawnerClump, new ItemStack(i.spawnerBar), 1.0F);
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(b.smoothGlass), 1.0F);

		GameRegistry.addRecipe(new ItemStack(i.calciaOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', b.hellstoneBlock});
		GameRegistry.addRecipe(new ItemStack(i.witheringBeastOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', b.luniumBlock});
		GameRegistry.addRecipe(new ItemStack(i.netherBeastOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', b.shadiumBlock});
		GameRegistry.addRecipe(new ItemStack(i.eudorOrb), new Object[] {"iii", "ioi", "iii", 'i', i.spawnerBar, 'o', i.eucaTablet});

		GameRegistry.addSmelting(i.ironDust, new ItemStack(Items.iron_ingot), 0.5F);
		GameRegistry.addSmelting(i.goldDust, new ItemStack(Items.gold_ingot), 0.5F);
		GameRegistry.addSmelting(i.diamondDust, new ItemStack(Items.diamond), 0.5F);
		GameRegistry.addSmelting(i.enderilliumDust, new ItemStack(JourneyItems.enderilliumShard), 0.5F);
		
		GameRegistry.addRecipe(new ItemStack(Blocks.web), new Object[] {"sss", "sss","sss", 's', Items.string});
		GameRegistry.addSmelting(new ItemStack(Items.leather), new ItemStack(Items.rotten_flesh), 0.5F);
		
		//GameRegistry.addRecipe(new ItemStack(i.rockShard), new Object[] {" c ", "ccc"," c ", 'c', Blocks.cobblestone});
		//GameRegistry.addRecipe(new ItemStack(i.rockChunk, 4), new Object[] {" c ", "ccc"," c ", 'c', i.rockShard});

		
		ItemStack blackDye = new ItemStack(Items.dye, 1, 15);
		
		//GameRegistry.addRecipe(new ItemStack(i.darknessBow), new Object[] {" is", "ibs"," is", 's', Items.string, 'i', blackDye.getItem(), 'b', Items.bow});
		//GameRegistry.addRecipe(new ItemStack(i.frozenBow), new Object[] {" ls", "ibs"," ls", 's', Items.string, 'l', Items.slime_ball, 'i', Blocks.ice, 'b', Items.bow});

		for(int j = 0; j < 13; j++) {
			GameRegistry.addShapelessRecipe(new ItemStack(JourneyBlocks.colouredBricks, 1, j), new Object[] {Blocks.stonebrick, BlockColouredBricks.crafting[j]});
			GameRegistry.addRecipe(new ItemStack(JourneyBlocks.colouredBricks, 8, j), new Object[] {"bbb", "bdb", "bbb", 'b', Blocks.stonebrick, 'd', BlockColouredBricks.crafting[j]});
			GameRegistry.addShapelessRecipe(new ItemStack(JourneyBlocks.miniColouredBricks, 1, j), new Object[] {Blocks.brick_block, BlockMiniColouredBricks.crafting[j]});
			GameRegistry.addRecipe(new ItemStack(JourneyBlocks.miniColouredBricks, 8, j), new Object[] {"bbb", "bdb", "bbb", 'b', Blocks.brick_block, 'd', BlockMiniColouredBricks.crafting[j]});
		}
		
		for(int j = 0; j < 13; j++) {
			//GameRegistry.addRecipe(new ItemStack(EssenceItems.backpack, 1, j), new Object[] {"lll", "lil", "lll", 'i', ItemBackpack.crafting[j], 'l', Items.leather});
		}
	}
	
	public static void addBlock(Block made, Item used) {
		GameRegistry.addRecipe(new ItemStack(made), new Object[] {"iii", "iii", "iii", 'i', used});
	}
	
	public static void addBlock(Block made, Block used) {
		GameRegistry.addRecipe(new ItemStack(made), new Object[] {"iii", "iii", "iii", 'i', used});
	}
	
	public static void addOPFood(Item nonOP, Item OP, Item base) {
		GameRegistry.addRecipe(new ItemStack(nonOP), new Object[] {"iii", "ibi", "iii", 'i', Items.gold_ingot, 'b', base});
		GameRegistry.addRecipe(new ItemStack(OP), new Object[] {"iii", "ibi", "iii", 'i', Blocks.gold_block, 'b', base});

	}

	public static void addOre(Block ore, Item ingot, Block block, Item axe, Item pick, Item shovel, Item hoe, Item sword, Item multiTool, Item helmet, Item chest, Item legs, Item boots, Item dust) {
		addAxe(axe, ingot);
		addPickaxe(pick, ingot);
		addShovel(shovel, ingot);
		addHoe(hoe, ingot);
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"b", "b", "s", 'b', block, 's', Items.stick});
		addBlock(block, ingot);
		addHelmet(helmet, ingot);
		addChestplate(chest, ingot);
		addLeggings(legs, ingot);
		addBoots(boots, ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(multiTool), new Object[] {pick, shovel, hoe, axe});
		GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), new Object[] {block});
		GameRegistry.addSmelting(ore, new ItemStack(ingot), 0.5F);
		if(dust !=null)GameRegistry.addSmelting(dust, new ItemStack(ingot), 0.5F);
	}

	private static void addWood(Block log, Block plank, Block stair, int slabMeta, boolean smelt) {
		GameRegistry.addShapelessRecipe(new ItemStack(plank, 4), new Object[] {log});
		GameRegistry.addRecipe(new ItemStack(stair, 4), new Object[] {"i  ", "ii ", "iii", 'i', plank});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"i", "i", 'i', plank});
		GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table), new Object[] {"ii", "ii", 'i', plank});
		//GameRegistry.addRecipe(new ItemStack(EssenceBlocks.halfSlab, 6, slabMeta), new Object[] {"iii", 'i', plank});
		if(smelt) GameRegistry.addSmelting(log, new ItemStack(Items.coal), 0.5F);
	}

	private static void addAxe(Item axe, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] {" ii", " si", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addPickaxe(Item pick, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(pick), new Object[] {"iii", " s ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addShovel(Item shovel, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {" i ", " s ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addSword(Item sword, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {" i ", " i ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addHoe(Item hoe, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(hoe), new Object[] {" ii", " s ", " s ", 'i', ingot, 's', Items.stick});
	}

	private static void addHelmet(Item helmet, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] {"iii", "i i", 'i', ingot});
	}

	private static void addChestplate(Item chest, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(chest), new Object[] {"i i", "iii", "iii", 'i', ingot});
	}

	private static void addLeggings(Item legs, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(legs), new Object[] {"iii", "i i", "i i", 'i', ingot});
	}

	private static void addBoots(Item boots, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] {"i i", "i i", 'i', ingot});
	}
}