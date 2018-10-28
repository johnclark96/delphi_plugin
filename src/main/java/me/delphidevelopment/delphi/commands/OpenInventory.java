package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenInventory implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to open there inventory");
                return true;
            }
            Player player = (Player) sender;
            Inventory pInven = player.getInventory();
            player.openInventory(pInven);
            return true;
        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            Inventory tInven = target.getInventory();
            if(target == null){
                sender.sendMessage("That is not a valid player!");
                return true;
            }else{
                target.openInventory(tInven);
                sender.sendMessage("You are now accessing " + target.getName() + " inventory.");
                Bukkit.getConsoleSender().sendMessage(sender.getName() + " is accessing player " + target.getName() + " inventory");
                return true;
            }
        }
    }
}
