package haidarbahzi.meme.client;


import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

import static haidarbahzi.meme.client.MemeClient.MOD_ID;

public class ModSound {
    private static final Map<String, SoundEvent> REGISTERED_SOUNDS = new HashMap<>();

    private ModSound() {}

    public static void register() {
        String[] soundNames = {
                "ahhanime", "amogus", "bawek", "bruh", "cj", "fart1", "fart2", "fart3", "fart4",
                "getout", "huh1", "huh2", "ireng", "meow", "mrbeast", "omg", "raah",
                "stup", "sui", "wtdog", "yipe"
        };

        for (String name : soundNames) {
            Identifier id = Identifier.of(MOD_ID, name);
            SoundEvent soundEvent = SoundEvent.of(id);
            Registry.register(Registries.SOUND_EVENT, id, soundEvent);
            REGISTERED_SOUNDS.put(name, soundEvent);
        }

        System.out.println("Registered meme sounds.");
    }

    public static SoundEvent get(String name) {
        return REGISTERED_SOUNDS.get(name);
    }
}