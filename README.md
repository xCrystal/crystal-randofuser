# Pokemon Crystal Randofuser

<img src="https://raw.githubusercontent.com/xCrystal/crystal-randofuser/master/media/gui.png" width="307">

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
The first type of the base Pokemon will always be chosen from the first type of the resulting Pokemon. The secondary type will 
be taken from the first type of the secondary Pokemon, unless the types match. If so, a secondary type of one of the fused 
Pokemon will be used, if possible. For example, Nidorino plus Gloom will yield a Poison/Grass Pokemon while Lanturn fused with
Gyarados will output a Water/Electric Pokemon. Marill fused with Goldeen will simply yield a Water-type Pokemon.

In all cases, Normal/Flying Pokemon are treated as Flying/Normal Pokemon instead. For example, Pidgey plus Machop will turn 
into a Flying/Fighting Pokemon.

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

#### <b>Defaults</b>
There are some suggested defaults available to be chosen.
- Classic: A stable option with unchanged BSTs that stays true to the trainer leves of the original game.
- Balanced: Like classic, but balances the Kanto trainers and homogenizes the growth rates to soften grinding. A good idea for nuzlocke and similar runs.
- Difficult: A more challenging setup that averages the BSTs, but adds additional filters to prevent extreme combinations.
- Crazy: The toughest and least predictable option. Trainer levels are considerably raised. Hardcore players may try this along with "Homogenize Growth Rates" for a very challenging nuzlocke run.

#### <b>Evolutionary Lines</b>
These settings are independent from the other ones and let the user choose which Pokemon follow its original evolutionary line. It also includes an option to separate Scyther and Scizor, as they have the same BST. Keep in mind that the Pokemon that you leave unselected will most likely become unobtainable, unless you play Catch 'Em All mode (see below).

#### <b>Catch 'Em All mode</b>
Two .ips patches are provided with the download. *crystal-randofuser.ips* is the normal patch, while *crystal-randofuser-catchemall.ips* incorporates additional changes to make all 251 Pokemon obtainable, including those that may become unattainable as a result of the *Evolutionary Line* settings. Even if you're not interested in completing the Pokédex, the Catch 'Em All option provides more variety to the Pokemon you can build your team with. With the Catch 'Em All patch you will also be able to purchase the evolutionary stones, except Moon and Sun, in the Ecruteak Mart. More information on how to use these patches in *Download & How to use*. For information on where the new Pokemon can be found, refer to the *catchemall.txt* file.

## Other notes

- There may be hardcoded references to Pokemon in the games that still use non-fused names. If so, they refer to the base Pokemon.
- Unown is not fused with any Pokemon, and neither any Pokemon may be fused with Unown
- The Battle Tower is not available
- The odd egg Pokemon has random DVs

## Download & How to use
- Download [crystal-randofuser.zip](https://github.com/xCrystal/crystal-randofuser/releases/download/v1.1/crystal-randofuser.zip?raw=true) and extract the .jar file and the two .ips files
- Get yourself the following ROM: <b>Pokemon - Crystal Version (UE) (V1.0) [C][!]</b>
- Apply either of the two .ips patches to the ROM with [Lunar IPS](http://fusoya.eludevisibility.org/lips/), and save the result as *crystal.gbc* in the directory where you extracted the .jar file. Note that in *crystal.gbc*, .gbc is the extension. If your system doesn't display the extension suffix as part of the filename, name the file just *crystal* instead.
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
- Fix wrong species bug with special evolutions
- Johto starters are now available to be caught in the catch 'em all mode
