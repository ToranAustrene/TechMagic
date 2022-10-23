
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.techmagic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.techmagic.item.NaniteInjectorItem;
import net.mcreator.techmagic.TechmagicMod;

public class TechmagicModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TechmagicMod.MODID);
	public static final RegistryObject<Item> NANITE_GENERATOR = block(TechmagicModBlocks.NANITE_GENERATOR, TechmagicModTabs.TAB_TECH_MAGIC);
	public static final RegistryObject<Item> NANITE_INJECTOR = REGISTRY.register("nanite_injector", () -> new NaniteInjectorItem());
	public static final RegistryObject<Item> CREATIVE_POWER = block(TechmagicModBlocks.CREATIVE_POWER, TechmagicModTabs.TAB_TECH_MAGIC);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
