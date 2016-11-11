package engine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import data.Constants;

public class Main {
	
	public static void main(String[] args) {
		
		ByteBuffer buf_evosAttacks_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EVOS_ATTACKS_LENGTH);
		ByteBuffer buf_evosAttacks_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EVOS_ATTACKS_LENGTH);
		
		ByteBuffer buf_eggMoves_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EGG_MOVES_LENGTH);
		ByteBuffer buf_eggMoves_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.EGG_MOVES_LENGTH);
		
		ByteBuffer buf_baseData_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.BASE_DATA_LENGTH);
		ByteBuffer buf_baseData_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.BASE_DATA_LENGTH);
		
		ByteBuffer buf_names_r = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.NAMES_LENGTH);
		ByteBuffer buf_names_w = ByteBuffer.allocate(Constants.NUM_POKEMON * Constants.NAMES_LENGTH);

		try (
				RandomAccessFile fin = new RandomAccessFile(Constants.FILE_NAME_IN,  "r" );
				RandomAccessFile fout = new RandomAccessFile(Constants.FILE_NAME_OUT,  "rw" );
				FileChannel chin  = fin.getChannel();
				FileChannel chout = fout.getChannel();
			) 	{
			
			if (Engine.verifyRom(chin) == false)
				throw new FileNotFoundException();
			
			Engine.createRomCopy(chin, chout);
			
			Engine.readData (chin, buf_evosAttacks_r, buf_evosAttacks_w, Constants.EVOS_ATTACKS);
			Engine.readData (chin, buf_eggMoves_r, buf_eggMoves_w, Constants.EGG_MOVES);
			Engine.readData (chin, buf_baseData_r, buf_baseData_w, Constants.BASE_DATA);
			Engine.readData (chin, buf_names_r, buf_names_w, Constants.NAMES);
			
			int[] fusionIds = Shuffle.shufflePokemonIds();
			
			Engine.fuseNames(buf_names_r, buf_names_w, fusionIds);
			
			Engine.copyData(chout, buf_evosAttacks_w, Constants.EVOS_ATTACKS);
			Engine.copyData(chout, buf_eggMoves_w, Constants.EGG_MOVES);
			Engine.copyData(chout, buf_baseData_w, Constants.BASE_DATA);
			Engine.copyData(chout, buf_names_w, Constants.NAMES);
			
			Engine.fixGlobalChecksum(chout);
			
		} catch (FileNotFoundException e) {
			Engine.print(Constants.FILE_NAME_IN + " was not found in the directory "
					+ "or is not valid for the Pokemon Crystal Randofuser.\n");
			
		} catch (IOException e) {
			Engine.print("An unexpected error has occurred. Try again maybe?");
		}
	
	}
	
}
