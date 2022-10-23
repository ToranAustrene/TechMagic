package net.mcreator.techmagic.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CreativePowerNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (Direction directioniterator : Direction.values()) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = 200;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, directioniterator).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
	}
}
