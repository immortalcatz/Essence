package net.essence.entity.mob.boss;

import net.essence.EssenceItems;
import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityCalcia extends EntityEssenceBoss {

	public EntityCalcia(World par1World) {
		super(par1World);
		addAttackingAI();
	}
	
	@Override
	public double setAttackDamage(MobStats s) {
		return s.calciaDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.calciaHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return null;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return null;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return null;
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaPortalGem;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		Item item = getItemDropped();
		for(int i = 0; i < rand.nextInt(5) + 4; i++)
			this.dropItem(item, 1);
	}
}