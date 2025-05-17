package haidarbahzi.meme.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

import java.util.List;
import java.util.Random;

public class MemePlayer {
    private static final List<String> SOUNDS = List.of(
            "ahhanime", "amogus", "bawek", "bruh", "cj", "fart1", "fart2", "fart3", "fart4",
            "getout", "huh1", "huh2", "ireng", "meow", "mrbeast", "omg", "raah",
            "stup", "sui", "wtdog", "yipe"
    );
    private static final Random RANDOM = new Random();

    public static void playRandomSound() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.world == null) return;

        String soundName = SOUNDS.get(RANDOM.nextInt(SOUNDS.size()));
        SoundEvent sound = ModSound.get(soundName);

        if (sound == null) {
            System.err.println("Sound not found: " + soundName);
            return;
        }

        float pitch = 1.0f;
        float volume = ConfigManager.getVolume();

        // Play sound with subtitle support
        client.world.playSound(
                client.player, // source
                client.player.getBlockPos(), // location
                sound,
                SoundCategory.PLAYERS,
                volume,
                pitch
        );
    }
}
