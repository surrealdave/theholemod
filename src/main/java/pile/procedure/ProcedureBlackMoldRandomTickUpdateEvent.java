package pile.procedure;

import pile.block.BlockDeadMold;
import pile.block.BlockBlackMold;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.material.Material;

@ElementsThePile.ModElement.Tag
public class ProcedureBlackMoldRandomTickUpdateEvent extends ElementsThePile.ModElement {
	public ProcedureBlackMoldRandomTickUpdateEvent(ElementsThePile instance) {
		super(instance, 251);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BlackMoldRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BlackMoldRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BlackMoldRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BlackMoldRandomTickUpdateEvent!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		double deathChance = 0;
		double radius = 0;
		double growthType = 0;
		double growthChance = 0;
		double surrounding = 0;
		boolean isNearWater = false;
		boolean isNearAir = false;
		boolean isTotem = false;
		boolean hasGrown = false;
		world.notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
				world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), true);
		if (((ThePileVariables.MapVariables.get(world).canMoldGrow) && ((Math.random() * 10) <= 3))) {
			surrounding = (double) 0;
			xPos = (double) 0;
			yPos = (double) 0;
			zPos = (double) 0;
			deathChance = (double) 0;
			hasGrown = (boolean) (false);
			if ((!(world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z))))) {
				surrounding = (double) ((surrounding) + 1);
			}
			if ((!(world.isAirBlock(new BlockPos((int) (x - 1), (int) y, (int) z))))) {
				surrounding = (double) ((surrounding) + 1);
			}
			if ((!(world.isAirBlock(new BlockPos((int) (x + 1), (int) y, (int) z))))) {
				surrounding = (double) ((surrounding) + 1);
			}
			if ((!(world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z - 1)))))) {
				surrounding = (double) ((surrounding) + 1);
			}
			if ((!(world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z + 1)))))) {
				surrounding = (double) ((surrounding) + 1);
			}
			while ((!(hasGrown))) {
				deathChance = (double) ((Math.random() * 100) - (surrounding));
				if (((deathChance) < 5)) {
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					world.notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
							world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), true);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockDeadMold.block.getDefaultState(), 3);
					world.notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
							world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), true);
					break;
				} else {
					growthType = (double) (Math.random() * 5);
					if ((Math.ceil((growthType)) == 1)) {
						if (((world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z)))
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == Material.PLANTS)
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == Material.LEAVES)
												|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
														.getMaterial() == Material.WATER))))) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), BlockBlackMold.block.getDefaultState(), 3);
							hasGrown = (boolean) (true);
						}
					} else if ((Math.ceil((growthType)) == 2)) {
						if (((world.isAirBlock(new BlockPos((int) (x - 1), (int) y, (int) z)))
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.PLANTS)
										|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == Material.LEAVES)
												|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
														.getMaterial() == Material.WATER))))) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), BlockBlackMold.block.getDefaultState(), 3);
							hasGrown = (boolean) (true);
						}
					} else if ((Math.ceil((growthType)) == 3)) {
						if (((world.isAirBlock(new BlockPos((int) (x + 1), (int) y, (int) z)))
								|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.PLANTS)
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == Material.LEAVES)
												|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
														.getMaterial() == Material.WATER))))) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), BlockBlackMold.block.getDefaultState(), 3);
							hasGrown = (boolean) (true);
						}
					} else if ((Math.ceil((growthType)) == 4)) {
						if (((world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z - 1))))
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.PLANTS)
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == Material.LEAVES)
												|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getMaterial() == Material.WATER))))) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), BlockBlackMold.block.getDefaultState(), 3);
							hasGrown = (boolean) (true);
						}
					} else {
						if (((world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z + 1))))
								|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.PLANTS)
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == Material.LEAVES)
												|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
														.getMaterial() == Material.WATER))))) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), BlockBlackMold.block.getDefaultState(), 3);
							hasGrown = (boolean) (true);
						}
					}
				}
			}
		}
	}
}
