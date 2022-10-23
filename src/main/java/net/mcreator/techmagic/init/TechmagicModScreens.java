
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.techmagic.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.techmagic.client.gui.NaniteGeneratorGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TechmagicModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TechmagicModMenus.NANITE_GENERATOR_GUI, NaniteGeneratorGuiScreen::new);
		});
	}
}
