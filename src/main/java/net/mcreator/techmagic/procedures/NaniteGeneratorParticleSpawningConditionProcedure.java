package net.mcreator.techmagic.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.techmagic.network.TechmagicModVariables;

public class NaniteGeneratorParticleSpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (TechmagicModVariables.MapVariables.get(world).GeneratorRunning) {
			return true;
		}
		return false;
	}
}
