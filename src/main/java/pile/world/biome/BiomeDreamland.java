
package pile.world.biome;

import pile.block.BlockPsygrass;
import pile.block.BlockPsydirt;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;

import java.util.Random;

@ElementsThePile.ModElement.Tag
public class BiomeDreamland extends ElementsThePile.ModElement {
	@GameRegistry.ObjectHolder("pile:dreamland")
	public static final BiomeGenCustom biome = null;
	public BiomeDreamland(ElementsThePile instance) {
		super(instance, 338);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Dreamland").setRainfall(1F).setBaseHeight(0.1F).setHeightVariation(0.01F).setTemperature(0.1F));
			setRegistryName("dreamland");
			topBlock = BlockPsygrass.block.getDefaultState();
			fillerBlock = BlockPsydirt.block.getDefaultState();
			decorator.generateFalls = false;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
