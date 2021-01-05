package fr.blueberry.studio.hermes.plugins.discordMemberCount.listeners.discord;

import fr.blueberry.studio.hermes.api.bots.Bot;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.DiscordMemberCount;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.core.DisplayManager;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoinListener extends ListenerAdapter {
    
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        final Bot bot = DiscordMemberCount.INSTANCE.getHermes().getBotManager().getTriggerer();
        
        DisplayManager.update(bot);
    }
}
