package dev.michaelh.socials;

import dev.michaelh.socials.Commands.DiscordCommandExecutor;
import dev.michaelh.socials.Commands.ForumCommandExecutor;
import dev.michaelh.socials.Commands.ReloadConfig;
import dev.michaelh.socials.Commands.VoteCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Socials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Socials has been enabled!");
        saveDefaultConfig(); // Copies the config.yml from resources if it doesn't exist

        //Commands
        getCommand("discord").setExecutor(new DiscordCommandExecutor(this));
        getCommand("forums").setExecutor(new ForumCommandExecutor(this));
        getCommand("vote").setExecutor(new VoteCommandExecutor(this));
        getCommand("socialsreload").setExecutor(new ReloadConfig(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("Socials has been disabled!");

        saveConfig(); // Saves the config.yml
    }
}
