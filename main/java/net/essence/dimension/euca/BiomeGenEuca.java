package net.essence.dimension.euca;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenEuca extends BiomeGenBase
{
    public BiomeGenEuca(int id)
    {
        super(id);
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = EssenceBlocks.eucaGrass.getDefaultState();
        this.fillerBlock = EssenceBlocks.eucaStone.getDefaultState();
    }


    @Override
    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, ChunkPrimer p_150573_3_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
    {
        this.generateTerrainForBiome(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
    
    public final void generateTerrainForBiome(World w, Random rand, ChunkPrimer cp, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        boolean flag = true;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_180628_6_ / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int i1 = p_180628_4_ & 15;
        int j1 = p_180628_5_ & 15;

        for (int k1 = 255; k1 >= 0; --k1) {
            if (k1 <= rand.nextInt(5)) {
                cp.setBlockState(j1, k1, i1, Blocks.bedrock.getDefaultState());
            } else {
                IBlockState iblockstate2 = cp.getBlockState(j1, k1, i1);

                if (iblockstate2.getBlock().getMaterial() == Material.air) 
                    k = -1;
                else if (iblockstate2.getBlock() == EssenceBlocks.eucaStone) {
                    if (k == -1) {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;

                        k = l;

                            cp.setBlockState(j1, k1, i1, iblockstate);

                    }
                    else if (k > 0)
                    {
                        --k;
                        cp.setBlockState(j1, k1, i1, iblockstate1);
                    }
                }
            }
        }
    }
    
    public BiomeGenEuca setColor(int color){
		return (BiomeGenEuca) super.setColor(color);
    }
    
    public BiomeGenEuca setBiomeName(String name){
    	return (BiomeGenEuca) super.setBiomeName(name);
    }
    
    public BiomeGenEuca setTheHeight(BiomeGenBase.Height h){
    	return (BiomeGenEuca) super.setHeight(h);
    }
    
    public BiomeGenEuca setEnableSnow(){
    	return (BiomeGenEuca) super.setEnableSnow();
    }
    
    public BiomeGenEuca setTemperatureRainfall(float f1, float f2){
    	return (BiomeGenEuca) super.setTemperatureRainfall(f1, f2);
    }
}