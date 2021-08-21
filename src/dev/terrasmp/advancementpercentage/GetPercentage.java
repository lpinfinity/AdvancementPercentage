package dev.terrasmp.advancementpercentage;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.*;

public class GetPercentage implements Listener {

    private final AdvancementPercentage advancementPercentage;

    public GetPercentage(AdvancementPercentage advancementPercentage) {
        this.advancementPercentage = advancementPercentage;
    }

    List<String> playerdata = new ArrayList<String>();

    //stores number of advancements completed for the player
    Integer numberCompleted = 0;

    //used for the loop to calculate completed advancements
    Integer loop = 0;

    //stores the number corresponding to the advancement currently being tested
    Integer currentAdvancement = 0;

    //stores the calculated percentage
    Integer percentage;

    Integer averageHolder = 0;
    Integer average = 0;

    //sets up scoreboard
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    Objective objective = board.registerNewObjective("Advancements", "dummy", "Advancement %");

    //Gets and stores the list of advancements
    Iterator<Advancement> advancementListIterator = Bukkit.advancementIterator();
    List<Advancement> actualList = new ArrayList<Advancement>();

    //gets number of advancements for input "player"
    public void GetCompleted(Player player) {

        while(advancementListIterator.hasNext()) {
            actualList.add(advancementListIterator.next());
        }

        Advancement key = actualList.get(currentAdvancement);

        //increases numberCompleted by one if the advancement has been completed
        if(testAdvancement(key, player)) {
            numberCompleted = numberCompleted + 1;
        }else if(!testAdvancement(key, player)){

        }else{
            return;
        }

        //tests if all advancements have been tested, if not GetCompleted() will be run again and currentAdvancement will be increased by one. If all have been tested, currentAdvancement and loop will be rest to zero
        if(loop < actualList.size() - 1) {

            currentAdvancement = currentAdvancement + 1;
            loop = loop + 1;
            GetCompleted(player);
        }else{
            currentAdvancement = 0;
            loop = 0;
        }

    }

    //calculates percentage of completed advancements and updates scoreboard
    public void calculatePercentage(PlayerEvent event) {

        //runs GetCompleted() and sets numberCompleted
        GetCompleted(event.getPlayer());

        //sets the display slot for scoreboard
        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        //sets player to the player who activated the event
        Player player;
        player = event.getPlayer();

        //sets the scoreboard for the player
        player.setScoreboard(board);

        //prepares score to set scoreboard
        Score score = objective.getScore(player.getName());

        //calculates percentage based on numberCompleted and the length of the advancements string
        percentage = (numberCompleted * 100) / actualList.size();

        //sets player score
        score.setScore(percentage);

        if(advancementPercentage.playerData.getConfig().getString(event.getPlayer().getUniqueId().toString()) != null) {
            advancementPercentage.playerData.getConfig().set(event.getPlayer().getUniqueId().toString(), percentage);
        } else {
            advancementPercentage.playerData.getConfig().addDefault(event.getPlayer().getUniqueId().toString(), percentage);
            advancementPercentage.playerData.getConfig().options().copyDefaults(true);
        }

        //playerdata.add(event.getPlayer().getUniqueId().toString(), percentage.toString());

        advancementPercentage.playerData.getConfig().getKeys(true);

        for(String string : advancementPercentage.playerData.getConfig().getKeys(true)) {
            averageHolder = advancementPercentage.playerData.getConfig().getInt(string) + averageHolder;
        }

        System.out.println(averageHolder);
        average = averageHolder / advancementPercentage.playerData.getConfig().getKeys(true).size();
        System.out.println(average);

        advancementPercentage.metrics.addCustomChart(new Metrics.DrilldownPie("average_completion_percentage", () -> {
            Map<String, Map<String, Integer>> map = new HashMap<>();
            Map<String, Integer> entry = new HashMap<>();
            entry.put(average.toString(), 1);
            if(average <= 10) {
                map.put("0-10%", entry);
            }else if(average <= 20) {
                map.put("11-20%", entry);
            }else if(average <= 30) {
                map.put("21-30%", entry);
            }else if(average <= 40) {
                map.put("31-40%", entry);
            }else if(average <= 50) {
                map.put("41-50%", entry);
            }else if(average <= 60) {
                map.put("51-60%", entry);
            }else if(average <= 70) {
                map.put("61-70%", entry);
            }else if(average <= 80) {
                map.put("71-80%", entry);
            }else if(average <= 90) {
                map.put("81-90%", entry);
            }else if(average <= 100) {
                map.put("91-100%", entry);
            }

            return map;

        }));


        averageHolder = 0;
        average = 0;

        advancementPercentage.playerData.saveConfig();

        //resets numberCompleted and percentage to zero
        numberCompleted = 0;
        percentage = 0;

    }

    //tests if given advancement has been completed
    private boolean testAdvancement(Advancement id, Player player) {
        return player.getAdvancementProgress(id).isDone();
    }

    //runs calculatePercentage() when a player earns an advancement
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event) {
        calculatePercentage(event);
    }

    //runs calculatePercentage() when a player joins the server
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        calculatePercentage(event);

    }

}
