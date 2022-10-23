package net.mcreator.techmagic.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.techmagic.network.TechmagicModVariables;
import net.mcreator.techmagic.TechmagicMod;

public class NaniteInjectorRightclickedProcedure {
	public static boolean execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Injector had " + (256 - (itemstack).getDamageValue()))), (false));
		if ((itemstack).getDamageValue() < 256) {
			{
				double _setval = (entity.getCapability(TechmagicModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TechmagicModVariables.PlayerVariables())).Nanites + 256 - (itemstack).getDamageValue();
				entity.getCapability(TechmagicModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Nanites = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			(itemstack).setDamageValue(256);
			TechmagicMod.LOGGER.info("Injector Used");
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						new TextComponent(("Player now has " + (entity.getCapability(TechmagicModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TechmagicModVariables.PlayerVariables())).Nanites)),
						(false));
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("Injector now has " + (256 - (itemstack).getDamageValue()))), (false));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
			return true;
		}
		return false;
	}
}
