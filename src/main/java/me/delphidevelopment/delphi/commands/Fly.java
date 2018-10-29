package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to give fly");
                return true;
            }
            Player player = (Player) sender;
            if(!player.getAllowFlight()){
                player.setAllowFlight(true);
                player.sendMessage("You have enabled flying!");
            }else{
                player.setAllowFlight(false);
                player.sendMessage("You have disabled flying!");
            }
            return true;
        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null) {
                sender.sendMessage("That is not a valid player!");
                return true;
            }if(!target.getAllowFlight()){
                target.setAllowFlight(true);
                target.sendMessage("You can now fly!");
            }else{
                target.setAllowFlight(false);
                target.sendMessage("You can no longer fly!");
            }
            return true;
        }
    }
}
