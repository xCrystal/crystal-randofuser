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
		
		buf = RandomizePokemon.randomize(buf, paramsGrass, (byte) 0xff, 2, false); // Johto Grass
		buf = RandomizePokemon.randomize(buf, paramsWater, (byte) 0xff, 2, false); // Johto Water
		buf = RandomizePokemon.randomize(buf, paramsGrass, (byte) 0xff, 2, false); // Kanto Grass
		buf = RandomizePokemon.randomize(buf, paramsWater, (byte) 0xff, 2, false); // Kanto Water
		buf = RandomizePokemon.randomize(buf, paramsSwarm, (byte) 0xff, 2, false); // Swarm
	}

	public static void randomizeFish(ByteBuffer buf) {

		if (!Settings.randomizeWildPokemon) return;
		
		buf.rewind();
		
		int[] paramsFishGroups = {1, 1, 1,  1, 0, 1};
		int[] paramsTimeFishGroups = {0, 1, 1,  1, 0, 1};		
		
		buf = RandomizePokemon.randomize(buf, paramsFishGroups, (byte) 222, 2, false);
		buf.position(buf.position() - 1); // 222 isn't the terminator, but the first byte of the next struct
		buf = RandomizePokemon.randomize(buf, paramsTimeFishGroups, (byte) 0x21, 2, false);
	}

}
