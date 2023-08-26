package dev.michaelh.socials.Commands;

import dev.michaelh.socials.Socials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ForumCommandExecutor implements CommandExecutor {
    private final Socials plugin;

    public ForumCommandExecutor(Socials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("forums")) {
            FileConfiguration config = plugin.getConfig();
            if (config.contains("socials.forums")) {
                String forumsLink = config.getString("socials.forums");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Forums link: " + forumsLink));
            } else {
                sender.sendMessage("Forums link not set in config.");
            }
            return true;
        }
        return false;
    }
}
