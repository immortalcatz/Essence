package net.essence.dimension.euca;

import java.awt.Color;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEuca extends BiomeGenBase {

	public BiomeGenEuca(int id) {
		super(id);
		this.setBiomeName("Euca");
		this.topBlock = EssenceBlocks.eucaGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.eucaStone.getDefaultState();
		this.spawnableCreatureList.clear();
		setColor(0xE57272);
	}

	@Override
	public int getSkyColorByTemp(float f) {
		return 0xDBFF00;
	}
}