package net.essence.client.render.model.statue;

import org.lwjgl.opengl.GL11;

import net.essence.EssenceBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.slayer.api.SlayerAPI;

public class ItemRendererStatue implements IItemRenderer {

	private String texture;

	public ItemRendererStatue(String tex) {
		this.texture = tex;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack i, Object...data) {
		Item item = i.getItem();
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(SlayerAPI.PREFIX + "textures/models/statues/" + texture + ".png"));
		float scale = 1.0F;
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 4.0F);
		/*if(item == SlayerAPI.toItem(EssenceBlocks.witheringBeastStatue)){
			switch(type){
			case EQUIPPED:
				scale = 1.5F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(-0.6F, -1.0F, 0.4F);
				break;
			case ENTITY:
				scale = 3.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				break;
			case INVENTORY:
				scale = 0.8F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -0.5F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				scale = 1.5F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.0F, 0.4F);
				break;
			default: break;
			}
			new ModelWitheringBeastStatue().render(0.0625F);
		}

		if(item == SlayerAPI.toItem(EssenceBlocks.netherBeastStatue)){
			switch(type){
			case EQUIPPED:
				scale = 1.5F;
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(-180F, 0.0F, 40.0F, 5.0F);
				GL11.glRotatef(90F, 0.0F, 4.0F, 0.0F);
				GL11.glTranslatef(0.3F, -0.8F, 0.4F);
				break;
			case ENTITY:
				scale = 3.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				break;
			case INVENTORY:
				scale = 0.6F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -0.4F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				scale = 1.5F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.0F, 0.4F);
				break;
			default: break;
			}
			new ModelNetherBeastStatue().render(0.0625F);
		}
		
		/*if(item == SlayerAPI.toItem(EssenceBlocks.enderChampionStatue)){
			switch(type){
			case EQUIPPED:
				scale = 1.5F;
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(-180F, 0.0F, 40.0F, 5.0F);
				GL11.glRotatef(90F, 0.0F, 4.0F, 0.0F);
				GL11.glTranslatef(0.3F, -0.8F, 0.4F);
				break;
			case ENTITY:
				scale = 2.6F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				break;
			case INVENTORY:
				scale = 0.6F;
				GL11.glScalef(scale, scale, scale);
				break;
			case EQUIPPED_FIRST_PERSON:
				scale = 1.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.0F, 0.7F);
				break;
			default: break;
			}
			new ModelEnderChampionStatue().render(0.0625F);
		}
		
		if(item == SlayerAPI.toItem(EssenceBlocks.wraithStatue)){
			switch(type){
			case EQUIPPED:
				scale = 1.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(-180F, 0.0F, 40.0F, 5.0F);
				GL11.glRotatef(90F, 0.0F, 2.0F, 0.0F);
				GL11.glTranslatef(0.3F, 0.6F, 0.4F);
				break;
			case ENTITY:
				scale = 1.7F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				break;
			case INVENTORY:
				scale = 0.35F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, 0.7F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				scale = 0.7F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.0F, 0.7F);
				GL11.glRotatef(90F, 0.0F, 2.0F, 0.0F);
				break;
			default: break;
			}
			new ModelWraithStatue().render(0.0625F);
		}
		
		if(item == SlayerAPI.toItem(EssenceBlocks.calciaStatue)){
			switch(type){
			case EQUIPPED:
				scale = 2.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(-180F, 0.0F, 40.0F, 5.0F);
				GL11.glRotatef(90F, 0.0F, 2.0F, 0.0F);
				GL11.glTranslatef(0.3F, -0.6F, 0.4F);
				break;
			case ENTITY:
				scale = 3.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				break;
			case INVENTORY:
				scale = 1.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -0.7F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				scale = 1.7F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.0F, 0.7F);
				GL11.glRotatef(90F, 0.0F, 2.0F, 0.0F);
				break;
			default: break;
			}
			new ModelCalciaStatue().render(0.0625F);
		}
		
		if(item == SlayerAPI.toItem(EssenceBlocks.eudorStatue)){
			switch(type){
			case EQUIPPED:
				scale = 2.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(-180F, 0.0F, 40.0F, 5.0F);
				GL11.glRotatef(90F, 0.0F, 2.0F, 0.0F);
				GL11.glTranslatef(0.3F, -0.6F, 0.4F);
				break;
			case ENTITY:
				scale = 3.0F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.5F, 0.0F);
				break;
			case INVENTORY:
				scale = 0.8F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -0.5F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				scale = 1.7F;
				GL11.glScalef(scale, scale, scale);
				GL11.glTranslatef(0.0F, -1.0F, 0.7F);
				GL11.glRotatef(90F, 0.0F, 2.0F, 0.0F);
				break;
			default: break;
			}
			new ModelEudorStatue().render(0.0625F);
		}*/
		GL11.glPopMatrix();
	}
}