package io.github.quiltservertools.blockbotapi.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.server.network.ServerPlayerEntity;

public interface PlayerAdvancementGrantEvent {
    Event<PlayerAdvancementGrantEvent> EVENT = EventFactory.createArrayBacked(PlayerAdvancementGrantEvent.class, (listeners) -> (player, advancementDisplay) -> {
        for (PlayerAdvancementGrantEvent listener : listeners) {
            listener.onAdvancementGrant(player, advancementDisplay);
        }
    });

    void onAdvancementGrant(ServerPlayerEntity player, AdvancementDisplay advancementDisplay);
}
