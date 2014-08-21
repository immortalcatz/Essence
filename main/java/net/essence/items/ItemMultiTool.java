package net.essence.items;

import java.util.List;
import java.util.Set;

import net.essence.EssenceTabs;
import net.essence.util.EssenceToolMaterial;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.slayer.api.SlayerAPI;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMultiTool extends ItemTool {

    private static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(Block.blockRegistry);
    protected EssenceToolMaterial mat;
    
    public ItemMultiTool(String name, EssenceToolMaterial tool) {
		super(0, tool.getToolMaterial(), blocksEffectiveAgainst);
		mat = tool;
        setCreativeTab(EssenceTabs.tools);
        setTextureName(SlayerAPI.PREFIX + "/tools/" + name);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
        setHarvestLevel("pickaxe", tool.getHarvestLevel());
    }
    
	@Override
	public boolean getIsRepairable(ItemStack i, ItemStack i1) {
		boolean canRepair = mat.getRepairItem() != null;
		if(canRepair) return mat.getRepairItem() == i1.getItem() ? true : super.getIsRepairable(i, i1);
		return super.getIsRepairable(i, i1);
	}

    @Override
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return block.getBlockHardness(null, 0, 0, 0) != -1.0F;
    }

    @Override
    public boolean func_150897_b(Block block) {
        return isEfficient(block);
    }

    protected boolean isEfficient(Block block) {
        return block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 :
                (block != Blocks.diamond_block && block != Blocks.diamond_ore ?
                        (block != Blocks.emerald_ore && block != Blocks.emerald_block ?
                                (block != Blocks.gold_block && block != Blocks.gold_ore ?
                                        (block != Blocks.iron_block && block != Blocks.iron_ore ?
                                                (block != Blocks.lapis_block && block != Blocks.lapis_ore ?
                                                        (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ?
                                                                (block.getMaterial() == Material.rock ? true :
                                                                        (block.getMaterial() == Material.iron ? true :
                                                                                block.getMaterial() == Material.anvil)) :
                                                                this.toolMaterial.getHarvestLevel() >= 2) :
                                                        this.toolMaterial.getHarvestLevel() >= 1) :
                                                this.toolMaterial.getHarvestLevel() >= 1) :
                                        this.toolMaterial.getHarvestLevel() >= 2) :
                                this.toolMaterial.getHarvestLevel() >= 2) :
                        this.toolMaterial.getHarvestLevel() >= 2);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (!player.canPlayerEdit(x, y, z, par7, stack)) return false;

        UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
        if (MinecraftForge.EVENT_BUS.post(event)) return false;

        if (event.getResult() == Result.ALLOW) {
            stack.damageItem(1, player);
            return true;
        }

        Block block = world.getBlock(x, y, z);

        if (par7 != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt)) {
            Block block1 = Blocks.farmland;
            world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), block1.stepSound.getStepResourcePath(),
                    (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

            if (world.isRemote) return true;

            world.setBlock(x, y, z, block1);
            stack.damageItem(1, player);
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(SlayerAPI.Colour.BLUE + "Efficiency: " + toolMaterial.getEfficiencyOnProperMaterial());
        if (stack.getMaxDamage() != -1) list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses");
        else list.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
        list.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
    }
}
