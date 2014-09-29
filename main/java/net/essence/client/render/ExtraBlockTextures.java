package net.essence.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public enum ExtraBlockTextures {
	
	celestiumOre("celestiumOre_overlay");

	final private String name;
	public IIcon IIcon;

	public static ResourceLocation GuiTexture(String string) {
		return new ResourceLocation(SlayerAPI.PREFIX + "textures/" + string);
	}

	public String getName() {
		return name;
	}

	private ExtraBlockTextures(String name) {
		this.name = name;
	}

	public IIcon getIcon() {
		return IIcon;
	}

	public void registerIcon(TextureMap map)
	{
		IIcon = map.registerIcon(SlayerAPI.PREFIX + name);
	}

	@SideOnly(Side.CLIENT)
	public static IIcon getMissing() {
		return ((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
	}
}