package dev.terrasmp.advancementpercentage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancementPercentage extends JavaPlugin {

    public FileConfiguration config = getConfig();

    public PlayerDataFileManager playerData;
    int pluginId = 12527;
    Metrics metrics = new Metrics(this, pluginId);
    //executed when plugin starts
    @Override
    public void onEnable() {

        this.playerData = new PlayerDataFileManager(this);

        //registers events in GetPercentage() class
        getServer().getPluginManager().registerEvents(new GetPercentage(this), this);

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            System.out.println("PlaceholderAPI is present, hooking in...");
            System.out.println("Hooked into PlaceholderAPI");
        } else {
            System.out.println("PlaceholderAPI is not present, but is not a hard depend, ignoring");
        }

        //this.getCommand("advtop").setExecutor(new AdvTopCommand(this));



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

