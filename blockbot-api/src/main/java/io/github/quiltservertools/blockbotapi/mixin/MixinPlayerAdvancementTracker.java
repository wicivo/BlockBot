package io.github.quiltservertools.blockbotapi.mixin;

import io.github.quiltservertools.blockbotapi.event.PlayerAdvancementGrantEvent;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.class_8779;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerAdvancementTracker.class)
public abstract class MixinPlayerAdvancementTracker {
    @Shadow
    private ServerPlayerEntity owner;

    @Inject(
        method = "method_53637",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/PlayerManager;broadcast(Lnet/minecraft/text/Text;Z)V"
        )
    )
    public void announceAdvancement(class_8779 arg, AdvancementDisplay advancementDisplay, CallbackInfo ci) {
        PlayerAdvancementGrantEvent.EVENT.invoker().onAdvancementGrant(owner, advancementDisplay);
    }
}
