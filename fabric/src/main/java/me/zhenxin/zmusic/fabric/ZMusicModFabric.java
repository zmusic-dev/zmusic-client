package me.zhenxin.zmusic.fabric;

import me.zhenxin.zmusic.ZMusicMod;
import net.fabricmc.api.ModInitializer;

public final class ZMusicModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ZMusicMod.init();
    }
}
