package br.cadu.pro.groups.options;

import br.cadu.pro.groups.RealmGroups;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OptionRender {

    private RealmGroups plugin;
    private static final Map<Option, OptionValue> options = new HashMap<>();

    public OptionRender(RealmGroups plugin){
        this.plugin = plugin;
    }

    public void loadOptions() {
        Logger logger = plugin.getLogger();
        loadDefaultOptions();
        FileConfiguration config = plugin.getConfig();
        int loaded = 0;
        long start = System.currentTimeMillis();
        for (Option option : Option.values()) {
            Object value = config.get(option.getPath());
            if (value != null) {
                if ((value instanceof Integer || value instanceof Double) && option.getType() == OptionType.INT) {
                    options.put(option, new OptionValue(value));
                    loaded++;
                }
                else if ((value instanceof Double || value instanceof Integer) && option.getType() == OptionType.DOUBLE) {
                    options.put(option, new OptionValue(value));
                    loaded++;
                }
                else if (value instanceof Boolean && option.getType() == OptionType.BOOLEAN) {
                    options.put(option, new OptionValue(value));
                    loaded++;
                }
                else if ((value instanceof String || value instanceof Integer || value instanceof Double || value instanceof Boolean) && option.getType() == OptionType.STRING) {
                    options.put(option, new OptionValue(String.valueOf(value)));
                    loaded++;
                }
                else if (value instanceof List && option.getType() == OptionType.LIST) {
                    options.put(option, new OptionValue(value));
                    loaded++;
                }
                else if (value instanceof String && option.getType() == OptionType.COLOR) {
                    options.put(option, new OptionValue(ChatColor.valueOf(String.valueOf(value))));
                    loaded++;
                }

                else {
                    logger.warning("Incorrect type in config.yml: Option " + option.name() + " with path " + option.getPath() + " should be of type " + option.getType().name() + ", using default value instead!");
                }
            }
            else {
                logger.warning("Missing value in config.yml: Option " + option.name() + " with path " + option.getPath() + " was not found, using default value instead!");
            }
        }
        long end = System.currentTimeMillis();
        logger.info("Loaded " + loaded + " config options in " + (end - start) + " ms");
    }

    private void loadDefaultOptions() {
        InputStream inputStream = plugin.getResource("config.yml");
        if (inputStream != null) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
            for (Option option : Option.values()) {
                if (option.getType() == OptionType.INT) {
                    options.put(option, new OptionValue(config.getInt(option.getPath())));
                }
                else if (option.getType() == OptionType.DOUBLE) {
                    options.put(option, new OptionValue(config.getDouble(option.getPath())));
                }
                else if (option.getType() == OptionType.BOOLEAN) {
                    options.put(option, new OptionValue(config.getBoolean(option.getPath())));
                }
            }
        }
    }

    public static double getDouble(Option option) {
        return options.get(option).asDouble();
    }

    public static int getInt(Option option) {
        return options.get(option).asInt();
    }

    public static boolean getBoolean(Option option) {
        return options.get(option).asBoolean();
    }

    public static String getString(Option option) {
        return options.get(option).asString();
    }

    public static List<String> getList(Option option) {
        return options.get(option).asList();
    }

    public static ChatColor getColor(Option option) {
        return options.get(option).asColor();
    }


}
