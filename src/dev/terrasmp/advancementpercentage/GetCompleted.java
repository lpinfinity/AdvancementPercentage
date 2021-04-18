package dev.terrasmp.advancementpercentage;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class GetCompleted {

    private final GetPercentage getPercentage;
    private final TestAdvancement testAdvancement;
    private final Varibles varibles;
    public GetCompleted(GetPercentage getPercentage, TestAdvancement testAdvancement, Varibles varibles) {
        this.getPercentage = getPercentage;
        this.testAdvancement = testAdvancement;
        this.varibles = varibles;
    }

    public void GetCompleted(Player player) {

        NamespacedKey key = NamespacedKey.minecraft(varibles.advancements[varibles.currentAdvancement]);

        //increases numberCompleted by one if the advancement has been completed
        if(testAdvancement.testAdvancement(key, player)) {
            varibles.numberCompleted = varibles.numberCompleted + 1;
        }else{
            return;
        }

        //tests if all advancements have been tested, if not GetCompleted() will be run again and currentAdvancement will be increased by one. If all have been tested, currentAdvancement and loop will be rest to zero
        if(varibles.loop < varibles.advancements.length - 1) {

            varibles.currentAdvancement = varibles.currentAdvancement + 1;
            varibles.loop = varibles.loop + 1;
            GetCompleted(player);
        }else{
            varibles.currentAdvancement = 0;
            varibles.loop = 0;
        }

    }

}
