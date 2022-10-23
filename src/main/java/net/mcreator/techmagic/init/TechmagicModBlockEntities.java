
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.techmagic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.techmagic.block.entity.NaniteGeneratorBlockEntity;
import net.mcreator.techmagic.block.entity.CreativePowerBlockEntity;
import net.mcreator.techmagic.TechmagicMod;

public class TechmagicModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TechmagicMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> NANITE_GENERATOR = register("nanite_generator", TechmagicModBlocks.NANITE_GENERATOR,
			NaniteGeneratorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CREATIVE_POWER = register("creative_power", TechmagicModBlocks.CREATIVE_POWER,
			CreativePowerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
