package net.essence.dimension.corba.gen.maze;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class MazeRoom {

	public abstract boolean generate(MazeChunk w, Random r, int x, int y, int z);
}