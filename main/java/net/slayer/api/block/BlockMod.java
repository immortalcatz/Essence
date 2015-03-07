package net.slayer.api.block;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.client.render.particles.OreParticleFX;
import net.essence.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.EnumToolType;
import net.slayer.api.SlayerAPI;

public class BlockMod extends Block{

	protected EnumMaterialTypes blockType;
	protected Item drop = null;
	protected Random rand;
	public int boostBrightnessLow;
	public int boostBrightnessHigh;
	public boolean enhanceBrightness;
	public String name;
	private boolean isOpaque = true, isNormalCube = true;
	private EnumWorldBlockLayer layerType = EnumWorldBlockLayer.SOLID;
	
	public BlockMod(String name, float hardness) {
		this(EnumMaterialTypes.STONE, name, hardness, EssenceTabs.blocks);
	}

	public BlockMod(String name) {
		this(EnumMaterialTypes.STONE, name, 2.0F, EssenceTabs.blocks);
	}

	public BlockMod(EnumMaterialTypes type, String name, float hardness) {
		this(type, name, hardness, EssenceTabs.blocks);
	}

	public BlockMod(String name, boolean breakable, CreativeTabs tab) {
		this(EnumMaterialTypes.STONE, name, tab);
	}

	public BlockMod(String name, boolean breakable) {
		this(name, breakable, EssenceTabs.blocks);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, CreativeTabs tab) {
		super(blockType.getMaterial());
		this.blockType = blockType;
		setHardness(2.0F);
		rand = new Random();
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		this.name = name; 
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, float hardness, CreativeTabs tab) {
		super(blockType.getMaterial());
		this.blockType = blockType;
		rand = new Random();
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setUnlocalizedName(name);
		setHardness(hardness);
		this.name = name;
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	public Block addName(String name) {
		EssenceBlocks.blockName.add(name);
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

	public BlockMod setHarvestLevel(EnumToolType type) {
		setHarvestLevel(type.getType(), type.getLevel());
		return this;
	}

	@Override
	public int getRenderType() {
		return 3;
	}
	
	public BlockMod setCutout() {
		layerType = EnumWorldBlockLayer.CUTOUT;
		isOpaque = false;
		isNormalCube = false;
		return this;
	}
	
	public BlockMod setTranslucent() {
		layerType = EnumWorldBlockLayer.TRANSLUCENT;
		isOpaque = false;
		isNormalCube = false;
		return this;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return layerType;
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
		return isNormalCube;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, BlockPos pos, IBlockState state, Random random) {
		if(Config.boilBlockSpawnSmoke){
			if(w.getBlockState(pos) == EssenceBlocks.hotBlock.getDefaultState()){
				for(int i = 0; i < 3; ++i) {
					double d0 = (double)pos.getX() + rand.nextDouble();
					double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.7D;
					double d2 = (double)pos.getZ() + rand.nextDouble();
					w.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
				}
			}
		}
	}
}