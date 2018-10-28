package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Die implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                player.sendMessage("You killed yourself");
                player.setHealth(0);
            }else{
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player){
                    target.sendMessage("You just got killed by " + ((Player) sender).getDisplayName());
                    target.setHealth(0);
                    player.sendMessage("You just killed " + target.getDisplayName());
                }else{
                    player.sendMessage("That player does not exist");
                }
            }
            System.out.println("You need to be a player to do this command.");
        }
    return true;
    }
}
