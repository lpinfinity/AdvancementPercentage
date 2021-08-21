package dev.terrasmp.advancementpercentage;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class PlayerDataFileManager {

    private AdvancementPercentage plugin;
    private FileConfiguration playerKillsConfig = null;
    private File configFile = null;

    public PlayerDataFileManager(AdvancementPercentage plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if(this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "playerdata.db");

        this.playerKillsConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("playerdata.db");

        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.playerKillsConfig.setDefaults(defaultConfig);
        }

    }

    public FileConfiguration getConfig() {
        if(this.playerKillsConfig == null)
            reloadConfig();
        return this.playerKillsConfig;
    }

    public void saveConfig() {
        if(this.playerKillsConfig == null || this.configFile == null)
            return;

        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not save playerdata.db to " + this.configFile, e);
        }
    }

    public void saveDefaultConfig() {
        if(this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "playerdata.db");

        if(!this.configFile.exists()) {
            this.plugin.saveResource("playerdata.db", false);
        }
    }

}

