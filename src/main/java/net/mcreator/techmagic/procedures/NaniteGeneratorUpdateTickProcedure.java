package net.mcreator.techmagic.procedures;

import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.techmagic.network.TechmagicModVariables;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class NaniteGeneratorUpdateTickProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, new BlockPos(x, y, z)) > 10) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem() == Items.COPPER_INGOT) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, new BlockPos(x, y, z), 1)).getItem() == Items.REDSTONE) {
					TechmagicModVariables.MapVariables.get(world).GeneratorRunning = true;
					TechmagicModVariables.MapVariables.get(world).syncData(world);
					return true;
				}
				TechmagicModVariables.MapVariables.get(world).GeneratorRunning = false;
				TechmagicModVariables.MapVariables.get(world).syncData(world);
				return false;
			}
			TechmagicModVariables.MapVariables.get(world).GeneratorRunning = false;
			TechmagicModVariables.MapVariables.get(world).syncData(world);
			return false;
		}
		TechmagicModVariables.MapVariables.get(world).GeneratorRunning = false;
		TechmagicModVariables.MapVariables.get(world).syncData(world);
		return false;
	}
}
