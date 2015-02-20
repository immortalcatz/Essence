package net.essence.misc;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class TextureTropical extends TextureAtlasSprite {

	public TextureTropical(String spriteName) {
		super(spriteName);
	}

	public static TextureAtlasSprite createTexture(ResourceLocation loc) {
		return TextureAtlasSprite.makeAtlasSprite(loc);
	}
}
