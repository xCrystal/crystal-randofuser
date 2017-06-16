package engine;

import java.nio.ByteBuffer;

import data.Settings;

public class Wild {

	static void randomizeWild(ByteBuffer buf) {

		if (!Settings.randomizeWildPokemon) return;
		
		buf.rewind();
		
		int[] paramsGrass = {5, 0, 1,  1, 1, 21};
		int[] paramsWater = {3, 0, 1,  1, 1, 3};
		int[] paramsSwarm = {5, 0, 1,  1, 1, 21};
		
		buf = RandomizePokemon.randomize(buf, paramsGrass, (byte) 0xff, 2); // Johto Grass
		buf = RandomizePokemon.randomize(buf, paramsWater, (byte) 0xff, 2); // Johto Water
		buf = RandomizePokemon.randomize(buf, paramsGrass, (byte) 0xff, 2); // Kanto Grass
		buf = RandomizePokemon.randomize(buf, paramsWater, (byte) 0xff, 2); // Kanto Water
		buf = RandomizePokemon.randomize(buf, paramsSwarm, (byte) 0xff, 2); // Swarm
	}

}
