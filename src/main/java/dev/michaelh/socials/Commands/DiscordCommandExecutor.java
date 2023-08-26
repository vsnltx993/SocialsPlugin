package dev.michaelh.socials.Commands;

import dev.michaelh.socials.Socials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class DiscordCommandExecutor implements CommandExecutor {
    private final Socials plugin;

    public DiscordCommandExecutor(Socials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("discord")) {
            FileConfiguration config = plugin.getConfig();
            if (config.contains("socials.discord")) {
                String discordLink = config.getString("socials.discord");
                sender.sendMessage("Discord link: " + discordLink);
            } else {
                sender.sendMessage("Discord link not set in config.");
            }
            return true;
        }
        return false;
    }
}

