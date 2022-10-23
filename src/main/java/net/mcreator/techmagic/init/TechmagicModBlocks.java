
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.techmagic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.techmagic.block.NaniteGeneratorBlock;
import net.mcreator.techmagic.block.CreativePowerBlock;
import net.mcreator.techmagic.TechmagicMod;

public class TechmagicModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TechmagicMod.MODID);
	public static final RegistryObject<Block> NANITE_GENERATOR = REGISTRY.register("nanite_generator", () -> new NaniteGeneratorBlock());
	public static final RegistryObject<Block> CREATIVE_POWER = REGISTRY.register("creative_power", () -> new CreativePowerBlock());
}
