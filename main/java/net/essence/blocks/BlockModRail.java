package net.essence.blocks;

import net.essence.EssenceTabs;
import net.minecraft.block.BlockRail;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModRail extends BlockRail {

	private boolean power;
	private float speed;
	
	public BlockModRail(String name, boolean isPowered, float speed) {
		setCreativeTab(EssenceTabs.blocks);
		setBlockTextureName(SlayerAPI.PREFIX + name);
		setBlockName(name);
		GameRegistry.registerBlock(this, name);
		power = isPowered;
		this.speed = speed;
	}

    @Override
    public float getRailMaxSpeed(World var1, EntityMinecart var2, int var3, int var4, int var5) {
        return speed;
    }
}