package dev.terrasmp.advancementpercentage;

import org.bukkit.plugin.java.JavaPlugin;

public class AdvancementPercentage extends JavaPlugin {

    private final GetPercentage getPercentage;
    public AdvancementPercentage(GetPercentage getPercentage) {
        this.getPercentage = getPercentage;
    }

    //executed when plugin starts
    @Override
    public void onEnable() {
        //registers events in GetPercentage() class
        getServer().getPluginManager().registerEvents(new GetPercentage(getPercentage.getCompleted, getPercentage.calculatePercentage), this);

        //prints string to console
        System.out.println("AdvancementPercentage has started");
    }

    //executed when plugin stops
    @Override
    public void onDisable() {
        //prints string to console
        System.out.println("AdvancementPercentage has stopped");
    }

}

