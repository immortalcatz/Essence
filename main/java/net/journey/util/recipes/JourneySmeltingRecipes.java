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

public class JourneySmeltingRecipes {

	public static void init() {
		initSmeltingCrafting();
	}

	public static void initSmeltingCrafting() {
		JourneyBlocks b = new JourneyBlocks();
		JourneyItems i = new JourneyItems();

		GameRegistry.addSmelting(i.spawnerClump, new ItemStack(i.spawnerBar), 1.0F);
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(b.smoothGlass), 1.0F);
		GameRegistry.addSmelting(i.flamingBeef, new ItemStack(JourneyItems.flamingBeefCooked), 0.5F);
		GameRegistry.addSmelting(i.ironDust, new ItemStack(Items.iron_ingot), 0.5F);
		GameRegistry.addSmelting(i.goldDust, new ItemStack(Items.gold_ingot), 0.5F);
		GameRegistry.addSmelting(i.diamondDust, new ItemStack(Items.diamond), 0.5F);
		GameRegistry.addSmelting(i.enderilliumDust, new ItemStack(JourneyItems.enderilliumShard), 0.5F);
		GameRegistry.addSmelting(new ItemStack(Items.leather), new ItemStack(Items.rotten_flesh), 0.5F);
		
		addOre(b.celestiumOre, i.celestiumIngot, b.celestiumBlock, i.celestiumAxe, i.celestiumPickaxe, i.celestiumShovel, i.celestiumHoe, i.celestiumSword, i.celestiumMultiTool, i.celestiumHelmet, i.celestiumChest, i.celestiumLegs, i.celestiumBoots, i.celestiumDust);
		addOre(b.hellstoneOre, i.hellstoneIngot, b.hellstoneBlock, i.hellstoneAxe, i.hellstonePickaxe, i.hellstoneShovel, i.hellstoneHoe, i.hellstoneSword, i.hellstoneMultiTool, i.hellstoneHelmet, i.hellstoneChest, i.hellstoneLegs, i.hellstoneBoots, i.hellstoneDust);
		addOre(b.flairiumOre, i.flairiumIngot, b.flairiumBlock, i.flairiumAxe, i.flairiumPickaxe, i.flairiumShovel, i.flairiumHoe, i.flairiumSword, i.flairiumMultiTool, i.flairiumHelmet, i.flairiumChest, i.flairiumLegs, i.flairiumBoots, i.flairiumDust);
		addOre(b.shadiumOre, i.shadiumIngot, b.shadiumBlock, i.shadiumAxe, i.shadiumPickaxe, i.shadiumShovel, i.shadiumHoe, i.shadiumSword, i.shadiumMultiTool, i.shadiumHelmet, i.shadiumChest, i.shadiumLegs, i.shadiumBoots, i.shadiumDust);
		addOre(b.luniumOre, i.luniumIngot, b.luniumBlock, i.luniumAxe, i.luniumPickaxe, i.luniumShovel, i.luniumHoe, i.luniumSword, i.luniumMultiTool, i.luniumHelmet, i.luniumChest, i.luniumLegs, i.luniumBoots, i.luniumDust);
		addOre(b.sapphireOre, i.sapphire, b.sapphireBlock, i.sapphireAxe, i.sapphirePickaxe, i.sapphireShovel, i.sapphireHoe, i.sapphireSword, i.sapphireMultiTool, i.sapphireHelmet, i.sapphireChest, i.sapphireLegs, i.sapphireBoots, i.sapphireDust);
		addOre(b.koriteOre, i.koriteIngot, b.koriteBlock, i.koriteAxe, i.koritePickaxe, i.koriteShovel, i.koriteHoe, i.koriteSword, i.koriteMultiTool, null, null, null, null, null);
		addOre(b.storonOre, i.storonIngot, b.storonBlock, i.storonAxe, i.storonPickaxe, i.storonShovel, i.storonHoe, i.storonSword, i.storonMultiTool, null, null, null, null, null);
		addOre(b.mekyumOre, i.mekyumIngot, b.mekyumBlock, i.mekyumAxe, i.mekyumPickaxe, i.mekyumShovel, i.mekyumHoe, i.mekyumSword, i.mekyumMultiTool, null, null, null, null, null);
	
	}
	public static void addOre(Block ore, Item ingot, Block block, Item axe, Item pick, Item shovel, Item hoe, Item sword, Item multiTool, Item helmet, Item chest, Item legs, Item boots, Item dust) {
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"b", "b", "s", 'b', block, 's', Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(multiTool), new Object[] {pick, shovel, hoe, axe});
		GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), new Object[] {block});
		GameRegistry.addSmelting(ore, new ItemStack(ingot), 0.5F);
		if(dust !=null)GameRegistry.addSmelting(dust, new ItemStack(ingot), 0.5F);
	}
}