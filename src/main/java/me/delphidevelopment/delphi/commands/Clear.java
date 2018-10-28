package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Clear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to clear there inventory");
                return true;
            }
            Player player = (Player) sender;
            Inventory pInven = player.getInventory();
            pInven.clear();
            sender.sendMessage("Your inventory has been cleared!");
            return true;
        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            Inventory tInven = target.getInventory();
            if(target == null) {
                sender.sendMessage("That is not a valid player!");
                return true;
            }else{
                tInven.clear();
                sender.sendMessage("You have cleared " + target.getName() + " inventory");
                target.sendMessage("Your inventory has been cleared by " + sender.getName());
                return true;
            }
        }
    }
}
