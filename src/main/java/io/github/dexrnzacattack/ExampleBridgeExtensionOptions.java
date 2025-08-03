package io.github.dexrnzacattack;

import com.google.gson.annotations.Expose;
import io.github.dexrnzacattack.rrdiscordbridge.extension.config.options.BaseExtensionOptions;

public class ExampleBridgeExtensionOptions extends BaseExtensionOptions {
    @Expose() public boolean changeMessage = true;
}
