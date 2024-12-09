package io.github.chromonym.nosneakanim;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class NoSneakAnimation implements ClientModInitializer {
	public static final String MOD_ID = "nosneakanim";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static NoSneakAnimConfig config;

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		AutoConfig.register(NoSneakAnimConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(NoSneakAnimConfig.class).getConfig();
	}
}