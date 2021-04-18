package dev.terrasmp.advancementpercentage;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class GetPercentage implements Listener {

    public final GetCompleted getCompleted;
    public final CalculatePercentage calculatePercentage;
    public GetPercentage(GetCompleted getCompleted, CalculatePercentage calculatePercentage) {
        this.getCompleted = getCompleted;
        this.calculatePercentage = calculatePercentage;
    }

    //runs calculatePercentage() when a player earns an advancement
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event) {

        calculatePercentage.calculatePercentage(event);

    }

    //runs calculatePercentage() when a player joins the server
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {

        calculatePercentage.calculatePercentage(event);

    }

}
