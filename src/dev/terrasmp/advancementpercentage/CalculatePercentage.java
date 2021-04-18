package dev.terrasmp.advancementpercentage;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

public class CalculatePercentage {

    private final GetPercentage getPercentage;
    private final Varibles varibles;
    public CalculatePercentage(GetPercentage getPercentage, Varibles varibles) {
        this.getPercentage = getPercentage;
        this.varibles = varibles;
    }

    public void calculatePercentage(PlayerEvent event) {

        //runs GetCompleted() and sets numberCompleted
        getPercentage.getCompleted.GetCompleted(event.getPlayer());

        //sets the display slot for scoreboard
        varibles.objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        //sets player to the player who activated the event
        Player player;
        player = event.getPlayer();

        //sets the scoreboard for the player
        player.setScoreboard(varibles.board);

        //prepares score to set scoreboard
        Score score = varibles.objective.getScore(player.getName());

        //calculates percentage based on numberCompleted and the length of the advancements string
        varibles.percentage = (varibles.numberCompleted * 100) / varibles.advancements.length;

        //sets player score
        score.setScore(varibles.percentage);

        //resets numberCompleted and percentage to zero
        varibles.numberCompleted = 0;
        varibles.percentage = 0;

    }

}
