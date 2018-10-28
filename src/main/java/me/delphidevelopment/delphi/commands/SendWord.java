package me.delphidevelopment.delphi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendWord implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length > 0 ){
                player.sendMessage(args[0]);
            }else{
                player.sendMessage("You need to specify an argument at the end of the command.");
                player.sendMessage("/sendword [word]");
            }




        }else{
            System.out.println("You need to be a player to execute this command.");
        }
        return false;
    }
}
