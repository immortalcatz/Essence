package net.journey.blocks;

import java.util.List;
import java.util.Random;

import net.journey.JITL;
import net.journey.JourneyBlocks;
import net.journey.JourneyTabs;
import net.journey.client.GuiHandler;
import net.journey.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.EnumToolType;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockStoneCraftingTable extends BlockWorkbench
{
	protected EnumMaterialTypes blockType;
	protected Item drop = null;
	protected Random rand;
	public int boostBrightnessLow;
	public int boostBrightnessHigh;
	public boolean enhanceBrightness;
	public String name;
	protected boolean isOpaque = true, isNormalCube = true;
	
	public BlockStoneCraftingTable(String name, String finalName, float hardness) {
		this(EnumMaterialTypes.STONE, name, finalName, hardness, JourneyTabs.blocks);
	}

	public BlockStoneCraftingTable(String name, String finalName) {
		this(EnumMaterialTypes.STONE, name, finalName, 2.0F, JourneyTabs.blocks);
	}

	public BlockStoneCraftingTable(EnumMaterialTypes type, String name, String finalName, float hardness) {
		this(type, name, finalName, hardness, JourneyTabs.blocks);
	}

	public BlockStoneCraftingTable(String name, String finalName, boolean breakable, CreativeTabs tab) {
		this(EnumMaterialTypes.STONE, name, finalName, tab);
	}

	public BlockStoneCraftingTable(String name, String finalName, boolean breakable) {
		this(name, finalName, breakable, JourneyTabs.blocks);
	}

	public BlockStoneCraftingTable(EnumMaterialTypes blockType, String name, String finalName, CreativeTabs tab) {
		super();
		LangRegistry.addBlock(name, finalName);
		this.blockType = blockType;
		setHardness(2.0F);
		rand = new Random();
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		this.name = name; 
		JourneyBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public BlockStoneCraftingTable(EnumMaterialTypes blockType, String name, String finalName, float hardness, CreativeTabs tab) {
		super();
		LangRegistry.addBlock(name, finalName);
		this.blockType = blockType;
		rand = new Random();
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setHardness(hardness);
		this.name = name;
		JourneyBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public Block addName(String name) {
		JourneyBlocks.blockName.add(name);
		return this;
	}

	public String getName() {
		return name;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(drop == null) return SlayerAPI.toItem(this);
		return drop;
	}

	public BlockStoneCraftingTable setHarvestLevel(EnumToolType type) {
		setHarvestLevel(type.getType(), type.getLevel());
		return this;
	}

	@Override
	public int getRenderType() {
		return 3;
	}
	
	/*@SideOnly(Side.CLIENT)
	public BlockMod setCutout() {
		layerType = EnumWorldBlockLayer.CUTOUT;
		isOpaque = false;
		isNormalCube = false;
		setLightOpacity(3);
		return this;
	}
	
	@SideOnly(Side.CLIENT)
	public BlockMod setTranslucent() {
		layerType = EnumWorldBlockLayer.TRANSLUCENT;
		isOpaque = false;
		isNormalCube = false;
		setLightOpacity(3);
		return this;
	}*/

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.SOLID;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return isOpaque;
	}

	@Override
	public boolean isNormalCube() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, BlockPos pos, IBlockState state, Random random) {
		/*if(Config.boilBlockSpawnSmoke){
			if(w.getBlockState(pos) == EssenceBlocks.hotBlock.getDefaultState()){
				for(int i = 0; i < 3; ++i) {
					double d0 = (double)pos.getX() + rand.nextDouble();
					double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.7D;
					double d2 = (double)pos.getZ() + rand.nextDouble();
					w.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
				}
			}
		}*/
	}
    public BlockStoneCraftingTable()
    {
        super();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            player.openGui(JITL.instance, GuiHandler.CRAFTING, world, x, y, z);
            //player.displayGUIWorkbench(par2, par3, par4);
            return true;
        }
    }
}