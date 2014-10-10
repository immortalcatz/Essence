package net.slayer.api.block;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
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

public class BlockMod extends Block{

	protected EnumMaterialTypes blockType;
	protected Item drop;
	protected Random rand;
	protected boolean exp = false;

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
		if (this.getItemDropped(par5, rand, par7) != SlayerAPI.toItem(this)) {
			int j1 = 0;
			if (exp) j1 = MathHelper.getRandomIntegerInRange(rand, 0, 4);
			return j1;
		}
		return 0;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Override
	public void randomDisplayTick(World w, int x, int y, int z, Random r) {
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