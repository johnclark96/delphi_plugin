package me.delphidevelopment.delphi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.getHealth() == 20.0){
                player.sendMessage("You are already fully healed!");
            }else{
                player.sendMessage("You have been given 1 health!");
                player.setHealth(player.getHealth() + 1);
            }
        }else{
            System.out.println("You need to be a player to do this command.");
        }
    return false;
    }
}
