package net.essence.dimension.cloudia;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeGenCloudia extends BiomeGenBase {

	public BiomeGenCloudia(int par1) {
		super(par1);
		this.setBiomeName("Cloudia");
		this.topBlock = EssenceBlocks.cloudiaGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.cloudiaDirt.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        setColor(0xAE9000);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float f) {
        return 0xAE9000;
    }
}