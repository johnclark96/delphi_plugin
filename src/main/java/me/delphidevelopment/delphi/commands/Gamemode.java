package me.delphidevelopment.delphi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please specify a player to set gamemode");
                return true;
            }
            Player player = (Player) sender;
            if(player.getGameMode() == GameMode.SURVIVAL){
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.GREEN + "Your gamemode has been set to Creative");
            }else if(args[0].equalsIgnoreCase("2")){
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.YELLOW + "Your gamemode has been set to Survival");
            }else if(args[0].equalsIgnoreCase("3")){
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.RED + "Your gamemode has been set to Adventure");
            }
            return true;
        /*}else{
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target == null){
                sender.sendMessage("That is not a valid player!");
                return true;
            }
            if(args[0].equalsIgnoreCase("1")){
                target.setGameMode(GameMode.CREATIVE);
                target.sendMessage(ChatColor.GREEN + "Your gamemode has been set to Creative by: " + ChatColor.GOLD + sender.getName());
            }else if(args[0].equalsIgnoreCase("2")){
                target.setGameMode(GameMode.SURVIVAL);
                target.sendMessage(ChatColor.YELLOW + "Your gamemode has been set to Survival by: " + ChatColor.GOLD + sender.getName());
            }else if(args[0].equalsIgnoreCase("3")){
                target.setGameMode(GameMode.ADVENTURE);
                target.sendMessage(ChatColor.RED + "Your gamemode has been set to Adventure by: " + ChatColor.GOLD + sender.getName());
            }
            return true;*/
        }
        return true;
    }
}
