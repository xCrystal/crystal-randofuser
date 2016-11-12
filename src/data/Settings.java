package data;

public class Settings {
	
	public static boolean AverageBaseStats = false; // if false, average base stats patterns only, keeping BST
	
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
	
	public static void setLegends() {
		
		Pokemon.ARTICUNO.setEvoType(EvoTypes.LEGEND);
		Pokemon.ZAPDOS.setEvoType(EvoTypes.LEGEND);
		Pokemon.MOLTRES.setEvoType(EvoTypes.LEGEND);
		Pokemon.MEWTWO.setEvoType(EvoTypes.LEGEND);
		Pokemon.MEW.setEvoType(EvoTypes.LEGEND);
		Pokemon.RAIKOU.setEvoType(EvoTypes.LEGEND);
		Pokemon.ENTEI.setEvoType(EvoTypes.LEGEND);
		Pokemon.SUICUNE.setEvoType(EvoTypes.LEGEND);
		Pokemon.LUGIA.setEvoType(EvoTypes.LEGEND);
		Pokemon.HO_OH.setEvoType(EvoTypes.LEGEND);
		Pokemon.CELEBI.setEvoType(EvoTypes.LEGEND);
	}
	
	public static void ignoreLegends() {
		
		Pokemon.ARTICUNO.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.ZAPDOS.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.MOLTRES.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.MEWTWO.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.MEW.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.RAIKOU.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.ENTEI.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.SUICUNE.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.LUGIA.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.HO_OH.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.CELEBI.setEvoType(EvoTypes.EVOTYPE1OF1);
	}
	
	public static void setWeakThreeStageEvo(EvoLines el) {
		el.getPkmn1().setEvoType(EvoTypes.EVOTYPE1OF3_WEAK);
		el.getPkmn2().setEvoType(EvoTypes.EVOTYPE2OF3_WEAK);
		el.getPkmn3().setEvoType(EvoTypes.EVOTYPE3OF3_WEAK);
	}
	
	public static void ignoreWeakThreeStageEvo(EvoLines el) {
		el.getPkmn1().setEvoType(EvoTypes.EVOTYPE1OF3);
		el.getPkmn2().setEvoType(EvoTypes.EVOTYPE2OF3);
		el.getPkmn3().setEvoType(EvoTypes.EVOTYPE3OF3);
	}
	
	public static void setWeakThreeStageEvos() {
		
		setWeakThreeStageEvo(EvoLines._PICHU);
		setWeakThreeStageEvo(EvoLines._IGGLYBUFF);
		setWeakThreeStageEvo(EvoLines._CLEFFA);
		setWeakThreeStageEvo(EvoLines._CATERPIE);
		setWeakThreeStageEvo(EvoLines._WEEDLE);
	}
	
	public static void ignoreWeakThreeStageEvos() {
		
		ignoreWeakThreeStageEvo(EvoLines._PICHU);
		ignoreWeakThreeStageEvo(EvoLines._IGGLYBUFF);
		ignoreWeakThreeStageEvo(EvoLines._CLEFFA);
		ignoreWeakThreeStageEvo(EvoLines._CATERPIE);
		ignoreWeakThreeStageEvo(EvoLines._WEEDLE);
	}
	
	public static void setWeakOneStagePokemon() {
		
		Pokemon.TANGELA.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.GLIGAR.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.QWILFISH.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.SNEASEL.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.DUNSPARCE.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.SUDOWOODO.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.MURKROW.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.WOBBUFFET.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.YANMA.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.LICKITUNG.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.CORSOLA.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.AIPOM.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.FARFETCH_D.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.UNOWN.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.DELIBIRD.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.DITTO.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
		Pokemon.SMEARGLE.setEvoType(EvoTypes.EVOTYPE1OF1_WEAK);
	}
	
	public static void ignoreWeakOneStagePokemon() {
		
		Pokemon.TANGELA.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.GLIGAR.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.QWILFISH.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.SNEASEL.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.DUNSPARCE.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.SUDOWOODO.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.MURKROW.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.WOBBUFFET.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.YANMA.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.LICKITUNG.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.CORSOLA.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.AIPOM.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.FARFETCH_D.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.UNOWN.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.DELIBIRD.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.DITTO.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.SMEARGLE.setEvoType(EvoTypes.EVOTYPE1OF1);
	}
	
	public static void makeScytherScizorIndependent() {
		
		Pokemon.SCYTHER.setEvoType(EvoTypes.EVOTYPE1OF1);
		Pokemon.SCIZOR.setEvoType(EvoTypes.EVOTYPE1OF1);
		EvoLines._SCYTHER.setPkmn2(Pokemon.NONE);
		EvoLines._SCIZOR.setPkmn1(Pokemon.SCIZOR);
	}
	
	public static void keepScytherScizorEvolution() {
		
		Pokemon.SCYTHER.setEvoType(EvoTypes.EVOTYPE1OF2);
		Pokemon.SCIZOR.setEvoType(EvoTypes.EVOTYPE2OF2);
		EvoLines._SCYTHER.setPkmn2(Pokemon.SCIZOR);
		EvoLines._SCIZOR.setPkmn1(Pokemon.NONE);
	}

}
