package dev.michaelh.socials.Commands;

import dev.michaelh.socials.Socials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfig implements CommandExecutor {

    private final Socials plugin;

    public ReloadConfig(Socials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (player.hasPermission("socials.reload")) {
            plugin.reloadConfig();
            sender.sendMessage("Config reloaded!");
        } else {
            sender.sendMessage("You do not have permission to use this command.");
        }
        return true;
    }
}
