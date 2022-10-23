
package net.mcreator.techmagic.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.techmagic.procedures.NaniteInjectorRightclickedProcedure;
import net.mcreator.techmagic.procedures.NaniteInjectorItemIsCraftedsmeltedProcedure;
import net.mcreator.techmagic.init.TechmagicModTabs;

import java.util.List;

public class NaniteInjectorItem extends Item {
	public NaniteInjectorItem() {
		super(new Item.Properties().tab(TechmagicModTabs.TAB_TECH_MAGIC).durability(256).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Use to inject nanites"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		NaniteInjectorRightclickedProcedure.execute(entity, itemstack);
		return ar;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		NaniteInjectorItemIsCraftedsmeltedProcedure.execute(itemstack);
	}
}
