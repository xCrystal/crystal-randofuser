**This is no longer maintained. A revamped version integrated with pokecrystal is available at: https://gitlab.com/xCrystal/pokecrystal-randofuser. Includes ready to use game patches at: https://gitlab.com/xCrystal/pokecrystal-randofuser/-/tree/randofuser/sample_patches**

# Pokemon Crystal Randofuser

<img src="https://raw.githubusercontent.com/xCrystal/crystal-randofuser/713c2c8/media/gui.png" width="307">

This is a special randomizer tool compatible with Pokemon Crystal. It fuses each Pokemon with another
existing one at random with matching evolution stage. All the data and characteristics of the
Pokemon such as moves and base stats are combined in different ways, as described below.

## Table of contents

- [How Pokemon data gets fused](https://github.com/xCrystal/crystal-randofuser#how-pokemon-data-gets-fused)
- [Settings](https://github.com/xCrystal/crystal-randofuser#settings)
- [Other notes](https://github.com/xCrystal/crystal-randofuser#other-notes)
- [Download & How to use](https://github.com/xCrystal/crystal-randofuser/#download--how-to-use)
- [Suggestions & Bug reports](https://github.com/xCrystal/crystal-randofuser/#suggestions--bug-reports)
- [Some pics](https://github.com/xCrystal/crystal-randofuser#some-pics)
- [Changelog](https://github.com/xCrystal/crystal-randofuser/#changelog)

## How Pokemon data gets fused

The base Pokemon retains the Pokedex number, sprite, cry, and first half of the name, while the secondary
Pokemon can be identified by its palette and second half of its name. Each Pokemon has been assigned a prefix and a
suffix so that the names are properly merged and the secondary Pokemon can be easily identified.

#### <b>Evolutions</b>
Pokemon will only be merged with another Pokemon of the same evolution category. For example, Charmander might
be fused with Mareep, but not with Ekans. The combinations will be consistent across an evolutionary line; say Venonat 
is merged with Slugma, then Venomoth will be merged with Magcargo. Evolution categories can be further filtered before the randomization, for example to make Legendary Pokemon independent from other 1/1 evolution Pokemon.

Branched evolutions have been removed. Which Pokemon retains its evolutionary line is selectable. For example, if the user
chooses Politoed to be the evolution of Poliwhirl, Poliwrath will be independent and will be merged with another independent Pokemon
like Heracross or Mr. Mime. Note that the independent Pokemon will most likely be unobtainable due to not appearing as a wild Pokemon.

Trade evolutions have been replaced with reasonable level-based evolutions. If selected by the user, happiness evolutions will also be replaced with reasonable level-based evolutions.

If two Pokemon with level-based evolutions are fused, the resulting Pokemon will evolve at the average of the two. If the "Average Base Stat patterns only" setting is selected, however, the base Pokemon's evolution level will weigh 80% of the total. Refer to the *Settings* section for more information. If either Pokemon evolves through other method (happiness, stone), the evolution type of the base Pokemon will be tranferred to the resulting Pokemon unchanged.

#### <b>Types</b>
The resulting Pokemon will have a type taken from the base Pokemon and a type taken from the secondary Pokemon whenever possible. If either Pokemon is dual-type, the type chosen from it will be scored according to the custom type priorities (the type with the higher priority of the two will be chosen). If both types have the same priority, the primary type will be chosen. If both Pokemon are of the same single type, the resulting Pokemon will also be of only that type. 

If the resulting Pokemon is dual-type, its primary type will be the one with the higher score of the two, and its secondary type will be the one with the lower (second-highest) score. If both types have the same priority, the primary type will be the one that was taken from the base Pokemon and the secondary type will be the one coming from the secondary Pokemon, unless the base Pokemon passed its secondary type and the secondary Pokemon passed its primary type.

Consider for example a Gyarados (base Pokemon) + Lanturn (secondary Pokemon) fusion. If Water type's priority is 7, Flying type's priority is 8, and Electric type's priority is 9, the resulting Pokemon will be Electric/Flying. If Electric's priority was 8 instead, the resulting Pokemon would be Flying/Electric. If the priorities were Water=10, Flying=8, and Electric=9, the fusion would be Water/Electric. If they were Water=10, Flying=9, and Electric=9, the fusion would be Water/Flying, just like if all three types had the same priority value.

#### <b>Moves</b>
Learnsets are combined, including level-up, egg, and TM/HM moves. For example, if Cyndaquil gets fused with Gastly, it will learn Ember at level 12 and Mean Look at level 13, and will be able to learn both Fire Blast and Shadow Ball via TM. Moreover, level-up moves are arranged by level. When the moveset of a wild or trainer Pokemon is filled, it will end up with the last four moves that the two original Pokemon could learn by that level. For example, a level 30 "Gyarasect", will show up with Bite, Dragon Rage, Spore and Leer. Trainers no longer may have custom movesets.

Pokemon such as Raichu, Arcanine or Starmie that could only learn a subset of moves compared to their pre-evolutions have had their movesets updated to match the moves learnable by their pre-evolutions, although with a small level delay similar to the patterns found in other evolved Pokemon.

#### <b>Base Stats</b>
The user can choose whether each Base Stat is averaged or whether only the base stat patterns are averaged, keeping the BST (base stat total) of the base Pokemon unchanged. The second option differs from the first in that the resulting values of the base stats are then multiplied by a "BST factor", which is the quotient of the BST of the base Pokemon and the BST of the secondary Pokemon. This way, trainer and wild Pokemon can keep their original strength.

#### <b>Growth rates</b>
If 'average base stat patterns only' is chosen, the Growth Rate of the base Pokemon is retained. If not, yet either Pokemon's Growth Rate is parabolic, the base Pokemon's Growth Rate is also retained. The parabolic Growth Rate is a special one related to Pokemon that appear early in the game (such as the starters) in order to make them grow fast at lower levels and slow-ish at higher levels. Otherwise, that is, when the Growth Rates of both original Pokemon are linear, the experience requirement to grow levels is averaged, introducing two sub-types of Growth Rates for this purpose.

Additionally, there is a selectable option to homogenize Growth Rates, ignoring all the other rules. This option will make all Pokemon use a custom Growth Rate with characteristics from the parabolic and fast growth rates. It makes all Pokemon grow relatively fast at all level ranges, which is ideal to soften any necessity of grinding.

#### <b>Other data</b>
- <b>Base Experience</b>: the average of the two original Pokemon. If 'average base stat patterns only' is selected, the base experience value of the base Pokemon weighs 80% of the total.
- <b>Catch Rates</b>: calculated with the geometric mean of the catch rate of the original Pokemon, i.e. the square root of the product of the two values.  If 'average base stat patterns only' is selected, the catch rate value of the base Pokemon weighs 80% of the total.
- <b>Gender</b>: if neither of the two original Pokemon is genderless, the average of the two. For example, if one Pokemon has a 2/16 chance to be female and the other Pokemon a 8/16 chance, the resulting Pokemon will be female 5/16 of the times. If either is genderless, the gender rate of the base Pokemon is kept.
- <b>Wild Held Items</b>: follow the same logic used to obtain the types
- <b>Egg Groups</b>: follow the same logic used to obtain the types
- <b>Hatch Cycles</b>: the average of the two orginal Pokemon. If 'average base stat patterns only' is selected, the hatch cycles value of the base Pokemon weighs 80% of the total.

## Settings

#### <b>Base Stat Total</b>
Select whether the base stat total should be retained from the base Pokemon or also averaged, as described above. Choose "Average Base Stats and BST" if you prefer unpredictability and variability, or choose "Average Base Stat patterns only" for a more stable experience.

#### <b>Homogenize Growth Rates</b>
As described above, choose this option if you want all Pokemon to grow at the same speed and also relatively fast. A good idea if you are planning to bump the trainer Pokemon levels and/or looking for a nuzlocke run.

#### <b>Replace Happiness evolutions</b>
If this option is selected, Pokemon that evolve via happiness will be replaced with level-based evolutions, evolving at a reasonable level based on their overall strength. It's especially useful for balancing baby Pokemon like Togepi and Pichu.

#### <b>Trainer Level increase</b>
Choose whether you'd like to increase the level of all trainer Pokemon by a custom percentage. Kanto trainers include all post-League content except the battle against Red. This part is known for being considerably easier than the Johto part, so increasing the levels in Kanto can be a good idea to maintain a decent challenge.

#### <b>Evolution category filters</b>
Choose whether you'd like to further filter which Pokemon can be fused with which Pokemon. The legendary filter is good for purity while the other two are intended to provide stability if averaging BST is selected. A total of 16 Pokemon are included in the 1-stage filter (BST-based, up to Tangela) and a total of just 5 in the 3-stage evolution filter (Pichu, Cleffa, Igglybuff, Caterpie, and Weedle lines). Keep in mind that these filters cut versatility in the randomization, especially the 3-stage one.

#### <b>Randomize Wild encounters & Randomize trainer Pokemon</b>
Select these options if you want to completely randomize the species of wild and trainer Pokemon, respectively. Before being fused, Pokemon will be arranged in groups based on overall strength and other factors such as rarity and evolution stage. 6 groups are used for trainer parties and only 4 groups are used for wild encounters (less exclusiveness of strong Pokemon to ensure variety). Each wild Pokemon slot and/or trainer Pokemon will be replaced with another that belongs to the same group. This arrangement has nothing to do with how Pokemon get fused with each other. Note that this strength classification may lose accuracy once the Pokemon are fused if "Average Base Stat patterns only" was not selected, although the evolution stage was also factored in for this reason. Logic and consistency are not preserved; for example, you will be able to find Fire-type Pokemon in the sea and Grass-type Pokemon in caves, and as for trainers, leaders and other trainer classes will no longer be type themed and your rival will not retain his party across battles. The randomization of wild Pokemon includes fishing, Headbutt, Rock Smash and Bug Catching Contest encounters, but does not include static encounters and roaming legendaries. Unown is not randomized in either mode.

#### <b>Defaults</b>
There are some suggested defaults available to be chosen.
- Classic: A stable option with unchanged BSTs and unrandomized wild and trainer encounters, that also stays true to the trainer leves of the original game.
- Balanced: Like classic, but balances the Kanto trainers and homogenizes the growth rates to soften grinding. A good idea for nuzlocke and similar runs.
- Difficult: A more challenging setup that averages the BSTs, but adds additional filters to prevent extreme combinations.
- Crazy: The toughest and least predictable option. Trainer levels are considerably raised. Hardcore players may try this along with "Homogenize Growth Rates" for a very challenging nuzlocke run.

#### <b>Evolutionary Lines</b>
These settings are independent from the other ones and let the user choose which Pokemon follow its original evolutionary line. It also includes an option to separate Scyther and Scizor, as they have the same BST. Keep in mind that the Pokemon that you leave unselected will most likely become unobtainable, unless you play Catch 'Em All mode (see below).

#### <b>Type priorities</b>
Assign a different priority to each type to determine how the types should be fused, as detailed in the *Types* subsection above. You can use this to favor the appearance of rare types like Dark, Ice, Steel or Dragon, or just your favorites. You could lower the priority of generic types with lots of monotype Pokemon like Water or Normal so that they become a little less common. Be careful with type priorities though, as decreasing the priority of certain types could make them extinct. For example, if the Flying type is tied for the lowest priority, it will never show up given that there's no Pokemon with Flying as its primary type. This is the reason why the Normal type priority defaults to one point below all the other types; this way Normal/Flying Pokemon will pass their Flying type, while Pokemon like Xatu, Butterfree or Dragonite pass their other type.

#### <b>Catch 'Em All mode</b>
Two Pokemon Crystal ROMs are provided in the download. *crystal-notcea.gbc* is the regular one, while *crystal-cea.gbc* incorporates additional changes to make all 251 Pokemon obtainable, including those that may become unattainable as a result of the *Evolutionary Line* settings. Even if you're not interested in completing the Pokédex, the Catch 'Em All option provides more variety to the Pokemon you can capture and therefore build your team with. In the Catch 'Em All mode you will also be able to purchase the evolutionary stones, except Moon and Sun, in the Ecruteak Mart. For information on where the new Pokemon can be found in the Catch 'Em All mode, refer to the *catchemall.txt* file provided in the download.

<i>About combining this mode with the Randomize Wild encounters option</i>:
The Catch 'Em All mode was not made with the possibility of randomizing wild encounters in mind. At first glance, both modes seem contradictory, and in a way, they are. Randomizing wild encounters will override most of the changes provided by the Catch 'Em All mode. In practice, the only differences between both ROMs would be that with Catch 'Em All, evolutionary stones will be available in the Ecruteak Mart and that the Celebi event in the Ilex Forest will be active. If you're planning to turn on wild encounter randomization, choose one ROM or the other depending on if you wish to activate any of these two changes. Ironically, the Catch 'Em All mode won't ensure that the Pokedex can be completed if you randomize wild encounters, but due to all the wild Pokemon slots (up to 21 per area/map), it would be rare that a Pokemon (or a pre-evolution) doesn't appear anywhere.

## Other notes

- There may be hardcoded references to Pokemon in the games that still use non-fused names. If so, they refer to the base Pokemon.
- Unown is not fused with any Pokemon, and neither any Pokemon may be fused with Unown.
- The Battle Tower is not available.
- The odd egg Pokemon has random DVs.

## Download & How to use
- Download [crystal-randofuser.zip](https://github.com/xCrystal/crystal-randofuser/releases/download/v2.0/crystal-randofuser.zip?raw=true) and extract the .jar file and the two .gbc files
- Rename either *crystal-notcea.gbc* or *crystal-cea.gbc*, depending on which mode you want to play, to *crystal.gbc*. Note that in *crystal.gbc*, *.gbc* is the extension. If your system doesn't display the extension suffix as part of the filename, name the file just *crystal* instead.
- Execute *crystal-randofuser.jar*. Choose your desired settings and click on the "Randofuse!" button to generate a ready-to-play "randofused" ROM that will named *crystal_randofused.gbc*
- Do not combine this tool with any other hacking tool or randomizer

## Suggestions & Bug reports

If you think you've found a bug, feel free to let me know about it by opening an issue in this repository. Likewise, if you have a suggestion about what you'd like to see implemented in this tool, you can do the same. I'm probably not going to work on this project short term though, but depending on how popular it becomes, I may add new features in the future.

## Some pics
![1](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic1.png)
![2](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic5.png)
![3](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic3.png)
![4](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic4.png)

![5](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic6.png)
![6](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic2.png)
![7](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic7.png)
![8](https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/pic8.png)

## Changelog

### v1.1
- Added catch 'em all mode
- Added option to turn happiness evolutions into level-based evolutions
- Minor bug fixes and improvements

### v1.2
- Fixed wrong species bug with special evolutions
- Johto starters are now available to be caught in the catch 'em all mode

### v1.3
- Added type priorities
- Ready-to-randofuse ROMs are provided rather than .ips patch files. Don't tell your uncle who works at Nintendo about this!

### v2.0
- Added separate options to randomize species of wild and trainer Pokemon
