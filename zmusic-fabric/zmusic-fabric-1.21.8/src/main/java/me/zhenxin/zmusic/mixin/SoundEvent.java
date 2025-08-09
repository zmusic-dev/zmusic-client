package me.zhenxin.zmusic.mixin;

import me.zhenxin.zmusic.ZMusic;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SoundSystem.class)
public class SoundEvent {
    @Inject(method = "play*", at = @At("HEAD"), cancellable = true)
    public void play(SoundInstance soundInstance, CallbackInfoReturnable<SoundSystem.PlayResult> info) {
        if (ZMusic.getPlayer().isPlay()) {
            SoundCategory data = soundInstance.getCategory();
            if (data == SoundCategory.RECORDS || data == SoundCategory.MUSIC) {
                info.setReturnValue(SoundSystem.PlayResult.NOT_STARTED);
            }
        }
    }

    @Inject(method = "reloadSounds", at = @At("RETURN"))
    public void reload(CallbackInfo info) {
        ZMusic.getPlayer().setReload();
    }
}