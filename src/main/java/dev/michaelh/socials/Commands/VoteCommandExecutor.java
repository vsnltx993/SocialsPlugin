package dev.michaelh.socials.Commands;

import dev.michaelh.socials.Socials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class VoteCommandExecutor implements CommandExecutor {
    private final Socials plugin;

    public VoteCommandExecutor(Socials plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("vote")) {
            FileConfiguration config = plugin.getConfig();
            if (config.contains("socials.vote")) {
                String vl1 = config.getString("socials.vote1");
                String vl2 = config.getString("socials.vote2");
                String vl3 = config.getString("socials.vote3");
                String vl4 = config.getString("socials.vote4");

                sender.sendMessage("Vote links:");
                sender.sendMessage(vl1);
                sender.sendMessage(vl2);
                sender.sendMessage(vl3);
                sender.sendMessage(vl4);
            } else {
                sender.sendMessage("Vote links not set in config.");
            }
            return true;
        }
        return false;
    }
}