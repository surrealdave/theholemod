package pile.procedure;

import pile.block.BlockObombaBlock;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.client.gui.GuiTextField;

import java.util.HashMap;

@ElementsThePile.ModElement.Tag
public class ProcedureDetonateObomba extends ElementsThePile.ModElement {
	public ProcedureDetonateObomba(ElementsThePile instance) {
		super(instance, 406);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure DetonateObomba!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DetonateObomba!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		World world = (World) dependencies.get("world");
		if ((BlockObombaBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				GuiTextField textField = (GuiTextField) guistate.get("text:CoordX");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())), (int) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				GuiTextField textField = (GuiTextField) guistate.get("text:CoordY");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())), (int) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				GuiTextField textField = (GuiTextField) guistate.get("text:CoordZ");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText()))))).getBlock())) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						GuiTextField textField = (GuiTextField) guistate.get("text:CoordX");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText())), (int) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						GuiTextField textField = (GuiTextField) guistate.get("text:CoordY");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText())), (int) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						GuiTextField textField = (GuiTextField) guistate.get("text:CoordZ");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText())), (float) 20, true);
			}
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("Obomba detonated. Thanks, Obama."));
			}
		} else {
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("Incorrect coordinates for Obomba. Please try again."));
			}
		}
	}
}
