package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to feed.");
                return true;
            }
            Player player = (Player) sender;
            double hunger = player.getFoodLevel();
            if(hunger == 20.0) {
                player.sendMessage("Your hunger is full!");
            }else {
                player.sendMessage("Your hunger has been restored!");
                player.setFoodLevel(20);
            }
            return true;
        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null){
                sender.sendMessage("That is not a valid player!");
                return true;
            }
            double hunger = target.getFoodLevel();
            if(hunger == 20.0){
                sender.sendMessage("That player is not hungry!");
            }else {
                target.sendMessage("Your hunger has been restored by " + sender.getName());
                target.setFoodLevel(20);
            }
        }
        return true;
    }
}
