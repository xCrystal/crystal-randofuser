package engine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import data.Constants;
import data.Pokemon;

public class Main {
	
	public static void main() {
		
		ByteBuffer buf_names = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.NAMES_LENGTH);
		
		ByteBuffer buf_evosAttacks_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EVOS_ATTACKS_LENGTH);
		ByteBuffer buf_evosAttacks_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EVOS_ATTACKS_LENGTH);
		
		ByteBuffer buf_eggMoves_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EGG_MOVES_LENGTH);
		ByteBuffer buf_eggMoves_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EGG_MOVES_LENGTH);
		
		ByteBuffer buf_baseData_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.BASE_DATA_LENGTH);
		ByteBuffer buf_baseData_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.BASE_DATA_LENGTH);
		
		ByteBuffer buf_pals_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.PALETTES_LENGTH);
		ByteBuffer buf_pals_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.PALETTES_LENGTH);
		
		ByteBuffer buf_trainers = ByteBuffer.allocate(Constants.TRAINERS_END - Constants.TRAINERS);

		try (
			RandomAccessFile fin = new RandomAccessFile(Constants.FILE_NAME_IN,  "r" );
			RandomAccessFile fout = new RandomAccessFile(Constants.FILE_NAME_OUT,  "rw" );
			FileChannel chin  = fin.getChannel();
			FileChannel chout = fout.getChannel();
		) {
			
			if (Engine.verifyRom(chin) == false)
				throw new FileNotFoundException();
			
			Engine.createRomCopy(chin, chout);
			
			Engine.readData(chin, buf_names, Constants.NAMES);
			Engine.readData(chin, buf_evosAttacks_r, buf_evosAttacks_w, Constants.EVOS_ATTACKS);
			Engine.readData(chin, buf_eggMoves_r, buf_eggMoves_w, Constants.EGG_MOVES);
			Engine.readData(chin, buf_baseData_r, buf_baseData_w, Constants.BASE_DATA);
			Engine.readData(chin, buf_pals_r, buf_pals_w, Constants.PALETTES);
			Engine.readData(chin, buf_trainers, Constants.TRAINERS);
			
			boolean anyNotFused;
			int[] fusionIds;
			
			// can't seem to figure out why some pokemon might fuse with themselves
			// so here's this dirty workaround.
			do {
				anyNotFused = false;
				fusionIds = Shuffle.shufflePokemonIds();
			
				for (int i = 0 ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
					if (i == fusionIds[i] && i != Pokemon.UNOWN.ordinal())
						anyNotFused = true;
				}
			} while (anyNotFused);
			
			Engine.writeEvolutionChangesToRomIfAny(chout);
			Engine.replaceHappinessEvosIfSelected(chout);
			Engine.writeModifiedParabolicGrowthRateIfSelected(chout);			
			
			Engine.fuseNames(chout, buf_names, fusionIds);
			EvosAttacks.fuseEvosAttacks(buf_evosAttacks_r, buf_evosAttacks_w, fusionIds);
			EvosAttacks.fuseEggMoves(buf_eggMoves_r, buf_eggMoves_w, fusionIds);
			Engine.fuseBaseData(buf_baseData_r, buf_baseData_w, fusionIds);
			Engine.switchPalettes(buf_pals_r, buf_pals_w, fusionIds);
			Trainers.raiseLevels(buf_trainers);
			
			Engine.copyData(chout, buf_names, Constants.NAMES);
			Engine.copyData(chout, buf_evosAttacks_w, Constants.EVOS_ATTACKS);
			Engine.copyData(chout, buf_eggMoves_w, Constants.EGG_MOVES);
			Engine.copyData(chout, buf_baseData_w, Constants.BASE_DATA);
			Engine.copyData(chout, buf_pals_w, Constants.PALETTES);
			Engine.copyData(chout, buf_trainers, Constants.TRAINERS);
			
			Engine.fixGlobalChecksum(chout);
			
		} catch (FileNotFoundException e) {
			Engine.print(Constants.FILE_NAME_IN + " was not found in the directory "
					+ "or is not valid for the Pokemon Crystal Randofuser.\n");
			
		} catch (IOException e) {
			Engine.print("An unexpected error has occurred. Try again maybe?");
		}
	
	}
	
}
