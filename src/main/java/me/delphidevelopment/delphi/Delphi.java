package me.delphidevelopment.delphi;

import me.delphidevelopment.delphi.commands.Die;
import me.delphidevelopment.delphi.commands.Feed;
import me.delphidevelopment.delphi.commands.God;
import me.delphidevelopment.delphi.commands.Heal;
import me.delphidevelopment.delphi.events.OnDeath;
import me.delphidevelopment.delphi.events.PlayerJoin;
import me.delphidevelopment.delphi.events.PlayerLeave;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Delphi extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin is starting up!");
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getCommand("god").setExecutor(new God());
        getCommand("heal").setExecutor(new Heal());
        getCommand("die").setExecutor(new Die());
        getCommand("feed").setExecutor(new Feed());
    }
}
