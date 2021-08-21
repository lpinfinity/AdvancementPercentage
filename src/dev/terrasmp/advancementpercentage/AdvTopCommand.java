package dev.terrasmp.advancementpercentage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AdvTopCommand implements CommandExecutor {

    private final AdvancementPercentage advancementPercentage;

    public AdvTopCommand(AdvancementPercentage advancementPercentage) {
        this.advancementPercentage = advancementPercentage;
    }

    List<Integer> dataList;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(command.getName().equalsIgnoreCase("advtop")) {
            sortAdvTop();
            Bukkit.broadcastMessage(dataList.toString());
        }

        return false;
    }

    private void sortAdvTop() {

        dataList = advancementPercentage.playerData.getConfig().getIntegerList("advancementpercentage");
        System.out.println(advancementPercentage.playerData.getConfig().getKeys(true).size());

    }

}
