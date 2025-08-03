package io.github.dexrnzacattack;

import com.vdurmont.semver4j.Semver;
import io.github.dexrnzacattack.rrdiscordbridge.RRDiscordBridge;
import io.github.dexrnzacattack.rrdiscordbridge.extension.ExtensionPriority;
import io.github.dexrnzacattack.rrdiscordbridge.extension.IBridgeExtension;
import io.github.dexrnzacattack.rrdiscordbridge.extension.config.ExtensionConfig;
import io.github.dexrnzacattack.rrdiscordbridge.extension.result.ModifiableExtensionChatResult;
import io.github.dexrnzacattack.rrdiscordbridge.interfaces.IPlayer;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import org.pf4j.Plugin;

import javax.annotation.Nullable;
import java.io.IOException;

public class ExampleBridgeExtension extends Plugin implements IBridgeExtension {
    ExtensionConfig config;

    /** Initializes the config */
    public ExampleBridgeExtension() throws IOException {
        config = new ExtensionConfig(new ExampleBridgeExtensionOptions(), this.getVersion(), this.getName()).load();
    }

    @Override
    public String getName() {
        return "ExampleBridgeExtension";
    }

    @Override
    public String getAuthor() {
        return "DexrnZacAttack";
    }

    @Override
    public Semver getCompatibleVersion() {
        return new Semver("3.0.0");
    }

    @Override
    public void onRegister(RRDiscordBridge rrDiscordBridge) {

    }

    @Override
    public void onEnable() {
        // prints "It works:tm:"
        RRDiscordBridge.logger.info("It works:tm:");
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onMinecraftChat(IPlayer iPlayer, String s, ModifiableExtensionChatResult<String> modifiableExtensionChatResult) {
        ExampleBridgeExtensionOptions options = (ExampleBridgeExtensionOptions)(config.options);

        // Changes the message that goes to Discord, but not Minecraft
        if (options.changeMessage)
            modifiableExtensionChatResult.message = "This message was changed by ExampleExtension.";
    }

    @Override
    public void onDiscordChat(Message message, ModifiableExtensionChatResult<Message> modifiableExtensionChatResult) {
        // Interacts with the Discord message
        modifiableExtensionChatResult.message.addReaction(Emoji.fromUnicode("👋")).complete();
    }

    @Nullable
    @Override
    public ExtensionConfig getConfig() {
        return config;
    }

    @Override
    public ExtensionPriority getPriority() {
        return ExtensionPriority.HIGH;
    }
}