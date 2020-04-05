package net.bnbdiscord.raretrades;

import org.bukkit.plugin.java.JavaPlugin;

public final class Raretrades extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("trades").setExecutor(new TradeUI());
        this.getServer().getPluginManager().registerEvents(new TradeUIListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
