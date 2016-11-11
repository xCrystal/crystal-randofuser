package engine;

import java.util.Random;
import data.*;

public class Shuffle {
	
	private static final Random rnd = new Random();
	
	static int randomRange (int min, int max) {
		
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return  min + rnd.nextInt(max - min + 1);
	}
	
	static int[] shufflePokemonIds() {
		
		int[] fusionIds = new int[Constants.NUM_POKEMON];
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++ )
			fusionIds[i] = i;
		
		for (int i = Pokemon.BULBASAUR.ordinal(), rand ; i <= Pokemon.CELEBI.ordinal() ; i ++ ) {
			
			// don't mess with unown
			if (i == Pokemon.UNOWN.ordinal()) i ++;
			
			do {
				do {
					rand = randomRange(Pokemon.BULBASAUR.ordinal(), Pokemon.CELEBI.ordinal());
				} while ((i == fusionIds[rand]) || (rand == Pokemon.UNOWN.ordinal())); // make sure it's not fusing with itself or unown
			} while (Pokemon.values()[i].getEvoType() != Pokemon.values()[rand].getEvoType()); // assert same evolution type
			
			// swap the two ids in the fusionIds array
			int temp = fusionIds[rand];
			fusionIds[rand] = fusionIds[i];
			fusionIds[i] = temp;
			
			// the following code makes sure ids of the save evolutionary line are also swapped
			// no need to do anything else if lone evolution
			if ((Pokemon.values()[i].getEvoType() != EvoTypes.EVOTYPE1OF1) && (Pokemon.values()[i].getEvoType() != EvoTypes.LEGEND)) {
				
				// find out to which evo line the mon with id i belongs to
				int c1 = 0, f = 0, r = 0;
				do {
					if (EvoLines.values()[c1].getPkmn1() == Pokemon.values()[i]) { r = 1; f = 1; };
					if (EvoLines.values()[c1].getPkmn2() == Pokemon.values()[i]) { r = 1; f = 2; };
					if (EvoLines.values()[c1].getPkmn3() == Pokemon.values()[i]) { r = 1; f = 3; };
					c1 ++;
				} while (r == 0);
				
				c1 --;
				r = 0;
				
				// find out to which evo line the mon with id rand belongs to
				int c2 = 0;
				do {
					if (EvoLines.values()[c2].getPkmn1() == Pokemon.values()[rand]) r = 1;
					if (EvoLines.values()[c2].getPkmn2() == Pokemon.values()[rand]) r = 1;
					if (EvoLines.values()[c2].getPkmn3() == Pokemon.values()[rand]) r = 1;
					c2 ++;
				} while (r == 0);
				
				c2 --;
				r = 0;
				
				// now swap the ids corresponding to the other mons in save evo line, except the two ids already swapped
				if (f != 1) {
					temp = fusionIds[EvoLines.values()[c1].getPkmn1().ordinal()];
					fusionIds[EvoLines.values()[c1].getPkmn1().ordinal()] = fusionIds[EvoLines.values()[c2].getPkmn1().ordinal()];
					fusionIds[EvoLines.values()[c2].getPkmn1().ordinal()] = temp;
				}
				
				if (f != 2) { 
					temp = fusionIds[EvoLines.values()[c1].getPkmn2().ordinal()];
					fusionIds[EvoLines.values()[c1].getPkmn2().ordinal()] = fusionIds[EvoLines.values()[c2].getPkmn2().ordinal()];
					fusionIds[EvoLines.values()[c2].getPkmn2().ordinal()] = temp;
				}
				
				if ((Pokemon.values()[i].getEvoType() != EvoTypes.EVOTYPE1OF2) && (Pokemon.values()[i].getEvoType() != EvoTypes.EVOTYPE2OF2)) {
					
					if (f != 3) {
						temp = fusionIds[EvoLines.values()[c1].getPkmn3().ordinal()];
						fusionIds[EvoLines.values()[c1].getPkmn3().ordinal()] = fusionIds[EvoLines.values()[c2].getPkmn3().ordinal()];
						fusionIds[EvoLines.values()[c2].getPkmn3().ordinal()] = temp;
					}
				}
			}
		}
		
		return fusionIds;
	}

}
