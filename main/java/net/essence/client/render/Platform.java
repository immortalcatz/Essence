package net.essence.client.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.common.util.ForgeDirection;

public class Platform {

	public static boolean isDrawing(Tessellator tess) {
		return false;
	}
	
	public static ForgeDirection crossProduct(ForgeDirection forward, ForgeDirection up) {
		int west_x = forward.offsetY * up.offsetZ - forward.offsetZ * up.offsetY;
		int west_y = forward.offsetZ * up.offsetX - forward.offsetX * up.offsetZ;
		int west_z = forward.offsetX * up.offsetY - forward.offsetY * up.offsetX;

		switch (west_x + west_y * 2 + west_z * 3) {
		case 1:
			return ForgeDirection.EAST;
		case -1:
			return ForgeDirection.WEST;
		case 2:
			return ForgeDirection.UP;
		case -2:
			return ForgeDirection.DOWN;
		case 3:
			return ForgeDirection.SOUTH;
		case -3:
			return ForgeDirection.NORTH;
		}
		return ForgeDirection.UNKNOWN;
	}
}