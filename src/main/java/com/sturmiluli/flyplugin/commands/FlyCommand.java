package com.sturmiluli.flyplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    private ArrayList<Player> listOfFlyingPlayers = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                flyMethod(player);
            } else if (args.length != 0) {
                Player target = Bukkit.getPlayer(args[0]);
                flyMethod(target);
            }
        }
        return true;
    }
    private void flyMethod(Player player){
        if (player.hasPermission("flyplugin.fly")) {
            if (listOfFlyingPlayers.contains(player)) {
                listOfFlyingPlayers.remove(player);
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.AQUA + "Fly Disabled");
            } else if (!listOfFlyingPlayers.contains(player)) {
                listOfFlyingPlayers.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.AQUA + "Fly Enabled");
            }
        }
    }
}
