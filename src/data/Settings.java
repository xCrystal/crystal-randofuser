package data;

public class Settings {
	
	public static void setSlowpokeSlowbro() {
		
		Pokemon.SLOWBRO.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._SLOWPOKE.setPkmn2(Pokemon.SLOWBRO);
		
		Pokemon.SLOWKING.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._SLOWKING.setPkmn1(Pokemon.SLOWKING);	
	}
	
	public static void setSlowpokeSlowking() {
		
		Pokemon.SLOWKING.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._SLOWPOKE.setPkmn2(Pokemon.SLOWKING);
		
		Pokemon.SLOWBRO.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._SLOWKING.setPkmn1(Pokemon.SLOWBRO);
	}
	
	public static void setOddishGloomVileplume() {
		
		Pokemon.VILEPLUME.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._ODDISH.setPkmn3(Pokemon.VILEPLUME);
		
		Pokemon.BELLOSSOM.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._BELLOSSOM.setPkmn1(Pokemon.BELLOSSOM);
	}
	
	public static void setOddishGloomBellossom() {
		
		Pokemon.BELLOSSOM.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._ODDISH.setPkmn3(Pokemon.BELLOSSOM);
		
		Pokemon.VILEPLUME.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._BELLOSSOM.setPkmn1(Pokemon.VILEPLUME);
	}
	
	public static void setPoliwagPoliwhirlPoliwrath() {
		
		Pokemon.POLIWRATH.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._POLIWAG.setPkmn3(Pokemon.POLIWRATH);
		
		Pokemon.POLITOED.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._POLITOED.setPkmn1(Pokemon.POLITOED);
	}
	
	public static void setPoliwagPoliwhirlPolitoed() {

		Pokemon.POLITOED.setEvoType(EvoTypes.EVOTYPE3OF3);
		EvoLines._POLIWAG.setPkmn3(Pokemon.POLITOED);
		
		Pokemon.POLIWRATH.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._POLITOED.setPkmn1(Pokemon.POLIWRATH);
	}
	
	public static void setTyrogueHitmontop() {
		
		Pokemon.HITMONTOP.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._TYROGUE.setPkmn2(Pokemon.HITMONTOP);
		
		setPokemonAlone(Pokemon.HITMONLEE, EvoLines._HITMONLEE);	
		setPokemonAlone(Pokemon.HITMONCHAN, EvoLines._HITMONCHAN);
	}
	
	public static void setTyrogueHitmonlee() {
		
		Pokemon.HITMONLEE.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._TYROGUE.setPkmn2(Pokemon.HITMONLEE);
		
		setPokemonAlone(Pokemon.HITMONCHAN, EvoLines._HITMONCHAN);
		setPokemonAlone(Pokemon.HITMONTOP, EvoLines._HITMONLEE);
	}
	
	public static void setTyrogueHitmonchan() {
		
		Pokemon.HITMONCHAN.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._TYROGUE.setPkmn2(Pokemon.HITMONCHAN);
		
		setPokemonAlone(Pokemon.HITMONLEE, EvoLines._HITMONLEE);
		setPokemonAlone(Pokemon.HITMONTOP, EvoLines._HITMONCHAN);
	}
	
	public static void setEeveeVaporeon() {
		
		Pokemon.VAPOREON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.VAPOREON);
		
		setPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		setPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		setPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		setPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public static void setEeveeJolteon() {
		
		Pokemon.JOLTEON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.JOLTEON);
		
		setPokemonAlone(Pokemon.VAPOREON, EvoLines._JOLTEON);
		setPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		setPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		setPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public static void setEeveeFlareon() {
		
		Pokemon.FLAREON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.FLAREON);
		
		setPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		setPokemonAlone(Pokemon.VAPOREON, EvoLines._FLAREON);
		setPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		setPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public static void setEeveeEspeon() {
		
		Pokemon.ESPEON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.ESPEON);
		
		setPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		setPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		setPokemonAlone(Pokemon.VAPOREON, EvoLines._ESPEON);
		setPokemonAlone(Pokemon.UMBREON, EvoLines._UMBREON);
	}
	
	public static void setEeveeUmbreon() {
		
		Pokemon.UMBREON.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._EEVEE.setPkmn2(Pokemon.UMBREON);
		
		setPokemonAlone(Pokemon.JOLTEON, EvoLines._JOLTEON);
		setPokemonAlone(Pokemon.FLAREON, EvoLines._FLAREON);
		setPokemonAlone(Pokemon.ESPEON, EvoLines._ESPEON);
		setPokemonAlone(Pokemon.VAPOREON, EvoLines._UMBREON);
	}
	
	public static void setPokemonAlone (Pokemon pkmn, EvoLines evoLine) {
		pkmn.setEvoType(EvoTypes.EVOTYPE1OF1);
		evoLine.setPkmn1(pkmn);
	}

}
