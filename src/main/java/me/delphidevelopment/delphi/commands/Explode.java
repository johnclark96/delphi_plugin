package me.delphidevelopment.delphi.commands;

import me.delphidevelopment.delphi.Delphi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.security.auth.login.Configuration;

public class Explode implements CommandExecutor {

    Plugin plugin = Delphi.getPlugin(Delphi.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String food = plugin.getConfig().getString("Food");

        Player player = (Player) sender;
        player.sendMessage(food);

        return false;
    }
}
