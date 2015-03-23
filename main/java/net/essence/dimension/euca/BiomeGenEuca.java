package net.essence.dimension.euca;

import java.awt.Color;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEuca extends BiomeGenBase {

	public BiomeGenEuca(int par1) {
		super(par1);
		this.setBiomeName("Euca");
		this.topBlock = EssenceBlocks.eucaGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.eucaStone.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        setColor(0xE57272);
	}
	
	@Override
	public int getSkyColorByTemp(float f) {
		return Color.getHSBColor(0.0F, 1.0F, 0.0F).getRGB();
	}
}