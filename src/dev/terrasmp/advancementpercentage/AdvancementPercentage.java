package dev.terrasmp.advancementpercentage;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancementPercentage extends JavaPlugin {

    public FileConfiguration config = getConfig();

    //executed when plugin starts
    @Override
    public void onEnable() {
        //registers events in GetPercentage() class
        getServer().getPluginManager().registerEvents(new GetPercentage(), this);

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

