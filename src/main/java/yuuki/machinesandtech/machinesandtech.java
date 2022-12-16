package yuuki.machinesandtech;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import yuuki.machinesandtech.commands.CommandHandler;
import yuuki.machinesandtech.events.PlayerEvents;
import yuuki.machinesandtech.items.ItemHandler;

public final class machinesandtech extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemHandler.init();
        getCommand("givetest").setExecutor(new CommandHandler());
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Machines and Tech]: I am alive!~");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Machines and Tech]: WHO KILLED ME!");
    }
}
