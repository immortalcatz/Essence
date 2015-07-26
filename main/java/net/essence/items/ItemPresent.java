package net.essence.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemPresent extends ItemMod {

	public ItemPresent(String name, String f) {
		super(name, f, EssenceTabs.items);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		Random r = new Random();
		items.add(new ItemStack(Items.apple, 10));
		items.add(new ItemStack(Items.arrow, 16));
		items.add(new ItemStack(Items.diamond, 1));
		items.add(new ItemStack(Items.beef, 32));
		items.add(new ItemStack(Blocks.ice, 5));
		items.add(new ItemStack(Items.bone, 1));
		items.add(new ItemStack(Items.ender_pearl, 8));
		items.add(new ItemStack(Items.cooked_fish, 25));
		items.add(new ItemStack(Items.bread, 32));
		items.add(new ItemStack(Items.wheat_seeds, 1));
		items.add(new ItemStack(Items.bone, 5));
		items.add(new ItemStack(Items.water_bucket, 1));
		items.add(new ItemStack(Blocks.anvil, 1));
		items.add(new ItemStack(Blocks.bookshelf, 5));
		items.add(new ItemStack(Blocks.grass, 4));
		items.add(new ItemStack(Blocks.emerald_ore, 1));
		items.add(new ItemStack(Blocks.dirt, 1));
		items.add(new ItemStack(Blocks.jukebox, 1));
		items.add(new ItemStack(Blocks.nether_brick, 16));
		items.add(new ItemStack(Blocks.mossy_cobblestone, 32));
		items.add(new ItemStack(Blocks.rail, 32));
		items.add(new ItemStack(EssenceBlocks.grindstone, 1));
		items.add(new ItemStack(EssenceItems.yellowGem, 5));
		items.add(new ItemStack(EssenceItems.purpleGem, 5));
		items.add(new ItemStack(EssenceItems.greenGem, 5));
		items.add(new ItemStack(EssenceItems.blueGem, 5));
		items.add(new ItemStack(EssenceItems.diamondDust, 2));
		items.add(new ItemStack(EssenceItems.shadiumSword, 1));
		if(!world.isRemote) {
			EnumSounds.playSound(EnumSounds.WRAPPER, world, player);
			int index = r.nextInt(items.size());
			String name = StatCollector.translateToLocal(items.get(index).getItem().getUnlocalizedName() + ".name");
			SlayerAPI.addChatMessage(player, "You recieved " + name);
			EntityItem item = new EntityItem(world, player.posX, player.posY, player.posZ, items.get(index));
			world.spawnEntityInWorld(item);
		}
		player.inventory.consumeInventoryItem(this);
		return stack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		list.add("Right click to open");
	}
}