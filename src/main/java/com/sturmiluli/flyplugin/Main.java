package com.sturmiluli.flyplugin;

import com.sturmiluli.flyplugin.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
