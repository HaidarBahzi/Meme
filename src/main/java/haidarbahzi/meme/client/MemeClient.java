package haidarbahzi.meme.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class MemeClient implements ClientModInitializer {
    private static KeyBinding playMemeKey;
    public static final String MOD_ID = "meme";
    private static boolean wasHeld = false;

    @Override
    public void onInitializeClient() {
        ModSound.register();

        playMemeKey = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("Play Meme", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_M, "Meme")
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            boolean isPressed = playMemeKey.isPressed();
            if (isPressed && !wasHeld) {
                MemePlayer.playRandomSound();
            }
            wasHeld = isPressed;
        });

    }
}

