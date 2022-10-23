
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.techmagic.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TechmagicModTabs {
	public static CreativeModeTab TAB_TECH_MAGIC;

	public static void load() {
		TAB_TECH_MAGIC = new CreativeModeTab("tabtech_magic") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.RAW_COPPER);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
