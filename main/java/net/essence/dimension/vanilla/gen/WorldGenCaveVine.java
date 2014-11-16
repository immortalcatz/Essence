package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCaveVine extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
        int l = x;
        for(int i1 = z; y < 40; ++y) {
            if(w.isAirBlock(x, y, z)) {
                for(int j1 = 2; j1 <= 5; ++j1) {
                    if(EssenceBlocks.caveVine.canPlaceBlockOnSide(w, x, y, z, j1)) {
                        w.setBlock(x, y, z, EssenceBlocks.caveVine, 1 << Direction.facingToDirection[Facing.oppositeSide[j1]], 2);
                        break;
                    }
                }
            } else {
                x = l + r.nextInt(4) - r.nextInt(4);
                z = i1 + r.nextInt(4) - r.nextInt(4);
            }
        }
        return true;
    }
}