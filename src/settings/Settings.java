package settings;

import data.*;

public class Settings {
	
	public void SetSlowpokeSlowbro() {
		
		Pokemon.SLOWBRO.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._SLOWPOKE.setPkmn2(Pokemon.SLOWBRO);
		
		Pokemon.SLOWKING.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._SLOWKING.setPkmn1(Pokemon.SLOWKING);	
	}
	
	public void SetSlowpokeSlowking() {
		
		Pokemon.SLOWKING.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._SLOWPOKE.setPkmn2(Pokemon.SLOWKING);
		
		Pokemon.SLOWBRO.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._SLOWKING.setPkmn1(Pokemon.SLOWBRO);
	}
	
	public void SetOddishGloomVileplume() {
		
		Pokemon.VILEPLUME.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._ODDISH.setPkmn3(Pokemon.VILEPLUME);
		
		Pokemon.BELLOSSOM.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._BELLOSSOM.setPkmn1(Pokemon.BELLOSSOM);
	}
	
	public void SetOddishGloomBellossom() {
		
		Pokemon.BELLOSSOM.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._ODDISH.setPkmn3(Pokemon.BELLOSSOM);
		
		Pokemon.VILEPLUME.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._BELLOSSOM.setPkmn1(Pokemon.VILEPLUME);
	}
	
	public void SetPoliwagPoliwhirlPoliwrath() {
		
		Pokemon.POLIWRATH.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._POLIWAG.setPkmn3(Pokemon.POLIWRATH);
		
		Pokemon.POLITOED.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._POLITOED.setPkmn1(Pokemon.POLITOED);
	}
	
	public void SetPoliwagPoliwhirlPolitoed() {

		Pokemon.POLITOED.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._POLIWAG.setPkmn3(Pokemon.POLITOED);
		
		Pokemon.POLIWRATH.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._POLITOED.setPkmn1(Pokemon.POLIWRATH);
	}
	
	public void SetTyrogueHitmontop() {
		
		Pokemon.HITMONTOP.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._TYROGUE.setPkmn2(Pokemon.HITMONTOP);
		
		SetPokemonAlone(Pokemon.HITMONLEE, EvoLines._HITMONLEE);	
		SetPokemonAlone(Pokemon.HITMONCHAN, EvoLines._HITMONCHAN);
	}
	
	public void SetTyrogueHitmonlee() {
		
		Pokemon.HITMONLEE.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._TYROGUE.setPkmn2(Pokemon.HITMONLEE);
		
		SetPokemonAlone(Pokemon.HITMONCHAN, EvoLines._HITMONCHAN);
		SetPokemonAlone(Pokemon.HITMONTOP, EvoLines._HITMONLEE);
	}
	
	public void SetTyrogueHitmonchan() {
		
		Pokemon.HITMONCHAN.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._TYROGUE.setPkmn2(Pokemon.HITMONCHAN);
		
		SetPokemonAlone(Pokemon.HITMONLEE, EvoLines._HITMONLEE);
		SetPokemonAlone(Pokemon.HITMONTOP, EvoLines._HITMONCHAN);
	}
	
	public void SetEeveeVaporeon() {
		
		Pokemon.VAPOREON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.VAPOREON);
		
		SetPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		SetPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		SetPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		SetPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public void SetEeveeJolteon() {
		
		Pokemon.JOLTEON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.JOLTEON);
		
		SetPokemonAlone(Pokemon.VAPOREON, EvoLines._JOLTEON);
		SetPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		SetPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		SetPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public void SetEeveeFlareon() {
		
		Pokemon.FLAREON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.FLAREON);
		
		SetPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		SetPokemonAlone(Pokemon.VAPOREON, EvoLines._FLAREON);
		SetPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		SetPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public void SetEeveeEspeon() {
		
		Pokemon.ESPEON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.ESPEON);
		
		SetPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		SetPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		SetPokemonAlone(Pokemon.VAPOREON, EvoLines._ESPEON);
		SetPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public void SetEeveeUmbreon() {
		
		Pokemon.UMBREON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.UMBREON);
		
		SetPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		SetPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		SetPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		SetPokemonAlone(Pokemon.VAPOREON, EvoLines._UMBREON);
	}
	
	public void SetPokemonAlone(Pokemon pkmn, EvoLines evoLine) {
		pkmn.setEvoType(EvoTypes.EVOTYPE1OF1);
		evoLine.setPkmn1(pkmn);
	}

}
