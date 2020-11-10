package pile.procedure;

import pile.block.BlockBoneDust;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;

@ElementsThePile.ModElement.Tag
public class ProcedureToothsayerAltarUpdateTick extends ElementsThePile.ModElement {
	public ProcedureToothsayerAltarUpdateTick(ElementsThePile instance) {
		super(instance, 452);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ToothsayerAltarUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ToothsayerAltarUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ToothsayerAltarUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ToothsayerAltarUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockBoneDust.block.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock()))
				&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock())
						&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockBoneDust.block.getDefaultState()
								.getBlock())))
				&& ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == BlockBoneDust.block
										.getDefaultState().getBlock()))))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("altarPower", 1);
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if (((((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 2)))).getBlock() == BlockBoneDust.block.getDefaultState()
				.getBlock())
				&& ((world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + 2)))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock()))
				&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 2)))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 1)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock())))
				&& ((((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 0)))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z - 1)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 2)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z - 2)))).getBlock() == BlockBoneDust.block
										.getDefaultState().getBlock()))))
				&& ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 2)))).getBlock() == BlockBoneDust.block.getDefaultState()
						.getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z + 1)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z + 0)))).getBlock() == BlockBoneDust.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 1)))).getBlock() == BlockBoneDust.block
										.getDefaultState().getBlock()))))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("altarPower", 2);
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("altarPower", 0);
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
