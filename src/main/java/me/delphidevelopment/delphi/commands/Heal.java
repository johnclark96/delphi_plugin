package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to heal.");
                return true;
            }
            Player player = (Player) sender;
            double health = player.getHealth();
            if(health == 20.0) {
                player.sendMessage("You are already fully healed!");
            }else {
                player.sendMessage("You have been given 1 heart!");
                player.setHealth(health + 1);
            }
            return true;
        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null){
                sender.sendMessage("That is not a valid player!");
                return true;
            }
            double health = target.getHealth();
            if(health == 20.0){
                sender.sendMessage("That player is already fully healed!");
            }else {
                target.sendMessage("You have been given 1 heart by " + sender.getName());
                target.setHealth(health + 1);
            }
        }
        return true;
    }
}