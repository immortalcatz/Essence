package net.slayer.api;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.essence.Essence;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class SlayerAPI {

	public static int mobID = 400, projectileID = 230;
	public static Logger logger = Logger.getLogger(SlayerAPI.MOD_ID);

	public static final String MOD_NAME = "Essence Of The Gods", MOD_ID = "eotg", PREFIX = MOD_ID + ":", MOD_VERSION = "1.2"; 
	public static final boolean DEVMODE = true;
	
	/**
	 * @param i The ItemStack you want to be made
	 * @param o The Object[] of the recipe
	 */
	public static void addRecipe(ItemStack i, Object... o) {
		GameRegistry.addRecipe(i, o);
	}

	public static void scaleFont(FontRenderer f, String s, int x, int y, int color, double scale){
		GL11.glScaled(scale, scale, scale);
		f.drawString(s, 0, 0, color);
		GL11.glTranslatef(x, y, 0);
		double fixScale = 1 / scale;
		GL11.glScaled(fixScale, fixScale, fixScale);
	}
	
	/**
	 * @param fluid
	 * @param modBucket
	 */
	public static void addBucket(Fluid fluid, ItemStack modBucket) {
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(fluid.getName(), FluidContainerRegistry.BUCKET_VOLUME), modBucket, new ItemStack(Items.bucket)));
	}
	
	public static void addMapGen(Class c, String s){
		try {
			MapGenStructureIO.func_143031_a(c, s);
			MapGenStructureIO.registerStructure(c, s);
		} catch(Exception e){
			logger.log(Level.WARNING, "[" + MOD_NAME + "] Failed To Spawn The Map Piece With The ID: " + s);
		}
	}

	public static void addVillageCreationHandler(IVillageCreationHandler v){
		VillagerRegistry.instance().registerVillageCreationHandler(v);
	}

	/**
	 * @param o The command file you wish to register
	 */
	public static void registerCommand(ICommand o){
		if (MinecraftServer.getServer().getCommandManager() instanceof ServerCommandManager) {
			((CommandHandler)MinecraftServer.getServer().getCommandManager()).registerCommand(o);
		}
	}
	
	/**
	 * @param o The EventBus of the events that are made by Mojang
	 */
	public static void addEventBus(Object o) {
		MinecraftForge.EVENT_BUS.register(o);
	}

	/**
	 * @param o The EventBus of the events that are made by forge
	 */
	public static void addForgeEventBus(Object o) {
		FMLCommonHandler.instance().bus().register(o);
	}

	/**
	 * @param i The ItemStack you want to be made
	 * @param o The Object[] of the recipe
	 */
	public static void addShapelessRecipe(ItemStack i, Object... o) {
		GameRegistry.addShapelessRecipe(i, o);
	}

	/**
	 * @param input
	 * @param output
	 * @param XP
	 */
	public static void addSmeltingRecipe(ItemStack input, ItemStack output, float XP) {
		GameRegistry.addSmelting(input, output, XP);
	}
	
	/**
	 * @param input
	 * @param output
	 * @param XP
	 */
	public static void addSmeltingRecipe(Item input, Block output, float XP) {
		GameRegistry.addSmelting(new ItemStack(input), new ItemStack(output), XP);
	}
	
	/**
	 * @param input
	 * @param output
	 * @param XP
	 */
	public static void addSmeltingRecipe(Block input, Block output, float XP) {
		GameRegistry.addSmelting(new ItemStack(input), new ItemStack(output), XP);
	}
	
	/**
	 * @param input
	 * @param output
	 * @param XP
	 */
	public static void addSmeltingRecipe(Item input, Item output, float XP) {
		GameRegistry.addSmelting(new ItemStack(input), new ItemStack(output), XP);
	}
	
	/**
	 * @param input
	 * @param output
	 * @param XP
	 */
	public static void addSmeltingRecipe(Block input, Item output, float XP) {
		GameRegistry.addSmelting(new ItemStack(input), new ItemStack(output), XP);
	}

	/**
	 * @param entityClass The class of the Entity
	 * @param entityName The name of the Entity
	 * @param ID Usually returns "SlayerAPI.mobID++"
	 */
	public static void registerMob(Class entityClass, String entityName, int ID) {
		LangRegistry.addMob(entityName);
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityID, 0x00CCB7, 0x16C400);
		EntityRegistry.registerModEntity(entityClass, entityName, ID, Essence.instance, 120, 5, true);
	}
	
	public static void registerEntity(Class entityClass, String entityName, int ID) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityID, 0x123123, 0x321321);
		EntityRegistry.registerModEntity(entityClass, entityName, ID, Essence.instance, 250, 265, false);
	}
	
	/**
	 * @param entityClass The class of the Entity
	 * @param entityName The name of the Entity
	 * @param ID Usually returns "SlayerAPI.mobID++"
	 */
	public static void registerBossMob(Class entityClass, String entityName, int ID) {
		LangRegistry.addMob(entityName);
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityID, 0x000000, 0x9B0000);
		EntityRegistry.registerModEntity(entityClass, entityName, ID, Essence.instance, 120, 5, true);
	}

	/**
	 * @param entityClass The class of the Entity
	 * @param entityName The name of the Entity
	 */
	public static void registerProjectile(Class entityClass, String entityName) {
		int ID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName + " Projectile", ID);
		EntityRegistry.registerModEntity(entityClass, entityName + " Projectile", ID, Essence.instance, 250, 5, true);
	}

	/**
	 * @param name
	 * @param durability
	 * @param oldArmor
	 * @param enchantability
	 */
    public static ArmorMaterial addArmorMaterial(String name, int durability, int[] oldArmor, int enchantability) {
        int duraNew = (int) Math.round(durability / 13.75);
        return EnumHelper.addEnum(ArmorMaterial.class, name, duraNew, oldArmor, enchantability);
    }

	/**
	 * @param colour The colour you want to use
	 * @param str What you want to print in the chat
	 */
	public static ChatComponentTranslation addChatMessageWithColour(EnumChatFormatting colour, String str) {
		ChatComponentTranslation ret = new ChatComponentTranslation(SlayerAPI.Colour.AQUA + "[" + SlayerAPI.Colour.BLUE + MOD_NAME + SlayerAPI.Colour.AQUA + "] " + str);
		ret.getChatStyle().setColor(colour);
		return ret;
	}

	/**
	 * @param str What you want to print in the chat
	 */
	public static ChatComponentTranslation addChatMessage(String str) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str);
		return ret;
	}

	private static final String	SECTION_SIGN	= "\u00a7";

	public static final class Colour {
		public static final String	BLACK		= SECTION_SIGN + "0";
		public static final String	DARK_BLUE	= SECTION_SIGN + "1";
		public static final String	DARK_GREEN	= SECTION_SIGN + "2";
		public static final String	DARK_AQUA	= SECTION_SIGN + "3";
		public static final String	DARK_RED	= SECTION_SIGN + "4";
		public static final String	PURPLE		= SECTION_SIGN + "5";
		public static final String	GOLD		= SECTION_SIGN + "6";
		public static final String	GRAY		= SECTION_SIGN + "7";
		public static final String	DARK_GRAY	= SECTION_SIGN + "8";
		public static final String	BLUE		= SECTION_SIGN + "9";
		public static final String	GREEN		= SECTION_SIGN + "A";
		public static final String	AQUA		= SECTION_SIGN + "B";
		public static final String	RED			= SECTION_SIGN + "C";
		public static final String	LIGHT_PURPLE= SECTION_SIGN + "D";
		public static final String	YELLOW		= SECTION_SIGN + "E";
		public static final String	WHITE		= SECTION_SIGN + "F";
	}

	public static final class Format {
		public static final String	OBFUSCATED	= SECTION_SIGN + "k";
		public static final String	BOLD		= SECTION_SIGN + "l";
		public static final String	STRIKE		= SECTION_SIGN + "m";
		public static final String	UNDERLINE	= SECTION_SIGN + "n";
		public static final String	ITALIC		= SECTION_SIGN + "o";
		public static final String	RESET		= SECTION_SIGN + "r";
	}

	/**
	 * @param i The Item to render when held/dropped/etc
	 * @param ir The IItemRender that you will use for that Item
	 */
	public static void registerItemRenderer(Item i, IItemRenderer ir) {
		MinecraftForgeClient.registerItemRenderer(i, ir);
	}

	/**
	 * @param b The block to render when held/dropped/etc
	 * @param ir The IItemRender that you will use for that block
	 */
	public static void registerItemRenderer(Block b, IItemRenderer ir) {
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(b), ir);
	}

	/**
	 * @param message Used to send messages to everyone thats in the same world
	 */
	public static void sendMessageToAll(String message, boolean showMod) {
		if(showMod) FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation(SlayerAPI.Colour.AQUA + "[" + SlayerAPI.Colour.BLUE + MOD_NAME + SlayerAPI.Colour.AQUA + "] " + SlayerAPI.Colour.GREEN + message));
		else FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation(SlayerAPI.Colour.GREEN + message));
	}

	/**
	 * @param message Used to continue messages if they're too long to have as one message in the Ingame chat box
	 */
	public static void sendContinuedMessageToAll(String message) {
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation(SlayerAPI.Colour.GREEN + message));
	}

	/**
	 * @param maxUses
	 * @param damage
	 */
	public static ToolMaterial addMeleeMaterial(int maxUses, float damage, int enchant) {
		return EnumHelper.addEnum(ToolMaterial.class, "", 0, maxUses, 0, damage - 4, enchant);
	}

	/**
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addMeleeMaterial(float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", 0, -1, 0, damage - 4, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param maxUses
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addAxeMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addAxeMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param maxUses
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addPickMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addPickMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param maxUses
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addSpadeMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addSpadeMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 3, enchantability);
	}
	
	/**
	 * @param harvestLevel
	 * @param maxUses
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addHoeMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addHoeMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 3, enchantability);
	}	

	/**
	 * @param harvestLevel
	 * @param maxUses
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addShickMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, maxUses, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param harvestLevel
	 * @param efficiency
	 * @param damage
	 * @param enchantability
	 */
	public static ToolMaterial addShickMaterial(int harvestLevel, float efficiency, float damage, int enchantability) {
		return EnumHelper.addEnum(ToolMaterial.class, "", harvestLevel, -1, efficiency, damage - 3, enchantability);
	}

	/**
	 * @param removed The Item recipe that you have removed
	 */
	public static void removeCraftingRecipe(Item removed) {
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();

		for (int i = 0; i < recipes.size(); i++) {
			IRecipe tmpRecipe = (IRecipe) recipes.get(i);

			if (tmpRecipe instanceof ShapedRecipes) {
				ShapedRecipes recipe = (ShapedRecipes) tmpRecipe;
				recipeResult = recipe.getRecipeOutput();
			}

			if (ItemStack.areItemStacksEqual(new ItemStack(removed), recipeResult)) {
				System.out.println("[" + MOD_NAME + "] Removed Recipe: " + recipes.get(i) + " -> " + recipeResult);
				recipes.remove(i);
			}
		}
	}
	
	/**
	 * @param removed The Block recipe that you have removed
	 */
	public static void removeCraftingRecipe(Block removed) {
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList)CraftingManager.getInstance().getRecipeList();

		for (int i = 0; i < recipes.size(); i++) {
			IRecipe tmpRecipe = (IRecipe) recipes.get(i);

			if (tmpRecipe instanceof ShapedRecipes) {
				ShapedRecipes recipe = (ShapedRecipes) tmpRecipe;
				recipeResult = recipe.getRecipeOutput();
			}

			if (ItemStack.areItemStacksEqual(new ItemStack(removed), recipeResult)) {
				System.out.println("[" + MOD_NAME + "] Removed Recipe: " + recipes.get(i) + " -> " + recipeResult);
				recipes.remove(i);
			}
		}
	}

	/**
	 * @param block The block that you convert to an item
	 * @return
	 * For example, when you want the block to drop itself, where it returns an item. You will use this method to return 
	 */
	public static Item toItem(Block block){
		return Item.getItemFromBlock(block);
	}
}