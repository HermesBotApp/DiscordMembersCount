package fr.blueberry.studio.hermes.plugins.discordMemberCount.core;

import fr.blueberry.studio.hermes.api.bots.Bot;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.DiscordMemberCount;

public class DisplayManager {

    /**
     * Update the category title including the member count (and next goal)
     * @param triggerer - The bot which will update the category channel.
     */
    public static void update(Bot triggerer) {
        final DiscordMemberCount discordMemberCount = DiscordMemberCount.INSTANCE;
        final int memberCount = triggerer.getGuild().getMemberCount();
        final long categoryId = discordMemberCount.getConfiguration().getLong("category");
        final int goalUnit = discordMemberCount.getConfiguration().getInt("goal");
        final String name = discordMemberCount.getConfiguration().getString("format")
            .replaceAll("%count%", String.valueOf(memberCount))
            .replaceAll("%goal%", String.valueOf(getNextGoal(memberCount, goalUnit)));

        triggerer.getGuild().getCategoryById(categoryId).getManager().setName(name).queue();
    }

    /**
     * Find next goal by the power of ten in config
     * @param memberCount - The member count in the guild
     * @param goalUnit - The goal unit in power of ten
     * @return - The next goal to achieve.
     */
    private static int getNextGoal(int memberCount, int goalUnit) {
        return (int)(Math.ceil((float)memberCount / (float)goalUnit) * goalUnit);
    }
}
