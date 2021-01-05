package fr.blueberry.studio.hermes.plugins.discordMemberCount.listeners.discord;

import fr.blueberry.studio.hermes.api.bots.Bot;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.DiscordMemberCount;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.core.DisplayManager;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberLeaveListener extends ListenerAdapter {
    
    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        final Bot bot = DiscordMemberCount.INSTANCE.getHermes().getBotManager().getTriggerer();
        
        DisplayManager.update(bot);
    }
}
