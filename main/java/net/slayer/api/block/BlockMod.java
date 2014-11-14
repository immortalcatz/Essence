package net.slayer.api.block;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.client.render.BaseBlockRender;
import net.essence.client.render.BlockRenderInfo;
import net.essence.util.Config;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.EnumToolType;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMod extends Block{

	protected EnumMaterialTypes blockType;
	protected Item drop;
	protected Random rand;
	protected boolean exp = false;

	@SideOnly(Side.CLIENT)
	BlockRenderInfo renderInfo;
	public int boostBrightnessLow;
	public int boostBrightnessHigh;
	public boolean enhanceBrightness;

	public BlockMod(String name, float hardness) {
		this(EnumMaterialTypes.STONE, name, hardness, EssenceTabs.blocks);
	}

	public BlockMod(String name, float hardness, CreativeTabs tab) {
		this(EnumMaterialTypes.STONE, name, hardness, tab);
	}

	public BlockMod(String name, boolean breakable) {
		this(EnumMaterialTypes.STONE, name, breakable);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, float hardness) {
		this(blockType, name, hardness, EssenceTabs.blocks);
	}

	public BlockMod(String name, boolean breakable, CreativeTabs tab) {
		this(EnumMaterialTypes.STONE, name, breakable, tab);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, boolean breakable) {
		this(blockType, name, breakable, EssenceTabs.blocks);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, boolean breakable, CreativeTabs tab) {
		this(blockType, name, tab);
		if (!breakable) setBlockUnbreakable();
	}

	public BlockMod(EnumMaterialTypes blockType, String name, CreativeTabs tab) {
		super(blockType.getMaterial());
		this.blockType = blockType;
		setHardness(2.0F);
		rand = new Random();
		setBlockTextureName(SlayerAPI.PREFIX + name);
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
	}

	public BlockMod(EnumMaterialTypes t, String texture, String name) {
		super(t.getMaterial());
		this.blockType = t;
		rand = new Random();
		setHardness(2.0F);
		setBlockTextureName(SlayerAPI.PREFIX + texture);
		setStepSound(blockType.getSound());
		setCreativeTab(EssenceTabs.blocks);
		setBlockName(texture);
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
	}

	public BlockMod(EnumMaterialTypes blockType, String name, float hardness, CreativeTabs tab) {
		super(blockType.getMaterial());
		this.blockType = blockType;
		rand = new Random();
		setBlockTextureName(SlayerAPI.PREFIX + name);
		setStepSound(blockType.getSound());
		setCreativeTab(tab);
		setBlockName(name);
		setHardness(hardness);
		if(hardness == -1F) setBlockUnbreakable();
		GameRegistry.registerBlock(this, name);
		LangRegistry.addBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderInfo getRendererInstance() {
		if(renderInfo != null) return renderInfo;
		try {
			return renderInfo = new BlockRenderInfo(getRenderer().newInstance());
		}
		catch(Throwable t) {
			throw new RuntimeException(t);
		}
	}

	@SideOnly(Side.CLIENT)
	public Class<? extends BaseBlockRender> getRenderer() {
		return BaseBlockRender.class;
	}

	@Override
	public int getMixedBrightnessForBlock(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		if(this == EssenceBlocks.mossyEssenceStone || this == EssenceBlocks.cristmasLights) {
			int j1 = 500;
			if(enhanceBrightness) {
				j1 = Math.max( j1 >> 20, j1 >> 4);
				if(j1 > 4) j1 += boostBrightnessHigh;
				else j1 += boostBrightnessLow;
				if(j1 > 15) j1 = 15;
				return j1 << 20 | j1 << 4;
			}
			return j1;
		}
		return super.getMixedBrightnessForBlock(par1iBlockAccess, par2, par3, par4);
	}

	@Override
	public Item getItemDropped(int par1, Random par2, int par3) {
		if (drop == null)
			return SlayerAPI.toItem(this);
		return drop;
	}

	public BlockMod toggleExp(boolean exp) {
		this.exp = exp;
		return this;
	}

	public BlockMod setDropItem(Item drop) {
		this.drop = drop;
		return this;
	}

	public BlockMod setHarvestLevel(EnumToolType type) {
		setHarvestLevel(type.getType(), type.getLevel());
		return this;
	}

	@Override
	public int getExpDrop(IBlockAccess block, int par5, int par7) {
		if(this.getItemDropped(par5, rand, par7) != SlayerAPI.toItem(this)) {
			int j1 = 0;
			if (exp) j1 = MathHelper.getRandomIntegerInRange(rand, 0, 4);
			return j1;
		}
		return 0;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return !(this == EssenceBlocks.cristmasLights);
	}

	@Override
	public int getRenderType() {
		return this == EssenceBlocks.mossyEssenceStone || this == EssenceBlocks.cristmasLights ? 51 : 0;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Override
	public void randomDisplayTick(World w, int x, int y, int z, Random r) {
		if(Config.boilBlockSpawnSmoke){
			if(w.getBlock(x, y, z) == EssenceBlocks.hotBlock){
				for(int i = 0; i < 1; ++i) {
					float f = (float)x + r.nextFloat();
					float f1 = (float)y + r.nextFloat() + 0.5F;
					float f2 = (float)z + r.nextFloat();
					w.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}