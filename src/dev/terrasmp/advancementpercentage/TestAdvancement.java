package dev.terrasmp.advancementpercentage;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;

public class TestAdvancement {

    public boolean testAdvancement(NamespacedKey id, Player player) {
        Advancement advancement = Bukkit.getAdvancement(id);
        assert advancement != null;
        AdvancementProgress progress = player.getAdvancementProgress(advancement);
        return progress.isDone();
    }

}
