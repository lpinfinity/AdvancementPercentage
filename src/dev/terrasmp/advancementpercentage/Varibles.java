package dev.terrasmp.advancementpercentage;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Varibles {

    //stores number of advancements completed for the player
    Integer numberCompleted = 0;

    //used for the loop to calculate completed advancements
    Integer loop = 0;

    //stores the number corresponding to the advancement currently being tested
    Integer currentAdvancement = 0;

    //stores the calculated percentage
    Integer percentage;

    //list of all advancements
    String[] advancements = {"story/mine_stone", "story/upgrade_tools", "story/smelt_iron", "story/obtain_armor", "story/lava_bucket", "story/iron_tools", "story/deflect_arrow", "story/form_obsidian", "story/mine_diamond", "story/enter_the_nether", "story/shiny_gear", "story/enchant_item", "story/cure_zombie_villager", "story/follow_ender_eye", "story/enter_the_end", "nether/root", "nether/return_to_sender", "nether/find_bastion", "nether/obtain_ancient_debris", "nether/fast_travel", "nether/find_fortress", "nether/obtain_crying_obsidian", "nether/distract_piglin", "nether/ride_strider", "nether/uneasy_alliance", "nether/loot_bastion", "nether/use_lodestone", "nether/netherite_armor", "nether/get_wither_skull", "nether/obtain_blaze_rod", "nether/charge_respawn_anchor", "nether/explore_nether", "nether/summon_wither", "nether/brew_potion", "nether/create_beacon", "nether/all_potions", "nether/create_full_beacon", "nether/all_effects", "end/root", "end/kill_dragon", "end/dragon_egg", "end/enter_end_gateway", "end/respawn_dragon", "end/find_end_city", "end/elytra", "end/levitate", "adventure/root", "adventure/voluntary_exile", "adventure/kill_a_mob", "adventure/trade", "adventure/honey_block_slide", "adventure/ol_betsy", "adventure/sleep_in_bed", "adventure/hero_of_the_village", "adventure/throw_trident", "adventure/shoot_arrow", "adventure/kill_all_mobs", "adventure/totem_of_undying", "adventure/summon_iron_golem", "adventure/two_birds_one_arrow", "adventure/whos_the_pillager_now", "adventure/arbalistic", "adventure/adventuring_time", "adventure/very_very_frightening", "adventure/sniper_duel", "adventure/bullseye", "husbandry/root", "husbandry/safely_harvest_honey", "husbandry/breed_an_animal", "husbandry/tame_an_animal", "husbandry/fishy_business", "husbandry/silk_touch_nest", "husbandry/plant_seed", "husbandry/bred_all_animals", "husbandry/complete_catalogue", "husbandry/tactical_fishing", "husbandry/balanced_diet", "husbandry/obtain_netherite_hoe"};

    //sets up scoreboard
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board;

    {
        assert manager != null;
        board = manager.getNewScoreboard();
    }

    Objective objective = board.registerNewObjective("Advancements", "dummy", "Advancement %");


}
