package fr.blueberry.studio.hermes.plugins.discordMemberCount.listeners.hermes;

import fr.blueberry.studio.hermes.api.plugins.HermesListen;
import fr.blueberry.studio.hermes.api.plugins.Listener;
import fr.blueberry.studio.hermes.api.plugins.events.HermesReadyEvent;
import fr.blueberry.studio.hermes.plugins.discordMemberCount.core.DisplayManager;

public class HermesReadyListener implements Listener {

    @HermesListen
    public void onHermesReady(HermesReadyEvent event) {
        DisplayManager.update(event.getTriggerer());
    }
}
