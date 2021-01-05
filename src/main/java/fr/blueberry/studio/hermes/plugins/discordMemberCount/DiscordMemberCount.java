package fr.blueberry.studio.hermes.plugins.discordMemberCount;

import fr.blueberry.studio.hermes.api.plugins.Plugin;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.listeners.discord.GuildMemberJoinListener;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.listeners.discord.GuildMemberLeaveListener;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.listeners.hermes.HermesReadyListener;

public class DiscordMemberCount extends Plugin {
    public static DiscordMemberCount INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        getHermes().getPluginManager().registerEventListener(this, new HermesReadyListener());
        
        getHermes().getBotManager().getJDAListenerManager().registerJDAListener(new GuildMemberJoinListener());
        getHermes().getBotManager().getJDAListenerManager().registerJDAListener(new GuildMemberLeaveListener());
    }

    @Override
    public void onDisable() {}
}
