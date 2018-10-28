package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to set as god");
                return true;
            }
            Player player = (Player) sender;
            if (!player.isInvulnerable()) {
                player.setInvulnerable(true);
                player.sendMessage("You have activated god mode!");
            } else {
                player.setInvulnerable(false);
                player.sendMessage("You have turned off god mode!");
            }
            return true;
        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null){
                sender.sendMessage("That is not a valid player!");
                return true;
            }
            if(!target.isInvulnerable()) {
                target.setInvulnerable(true);
                target.sendMessage("You have been given God Mode by " + sender.getName());
            }else{
                target.setInvulnerable(false);
                target.sendMessage("Your God Mode has been removed by " + sender.getName());
                return true;
            }
        }
        return true;
    }
}
