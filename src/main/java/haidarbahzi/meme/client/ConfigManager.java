package haidarbahzi.meme.client;

public class ConfigManager {
    private static float volume = 1.0f;

    public static float getVolume() {
        return volume;
    }

    private static class Config {
        float volume;
    }
}
