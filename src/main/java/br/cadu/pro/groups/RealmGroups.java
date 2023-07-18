package br.cadu.pro.groups;

import br.cadu.pro.groups.options.OptionRender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RealmGroups extends JavaPlugin {

    private static RealmGroups instance;

    private OptionRender optionRender;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();
        loadRenders();
    }

    @Override
    public void onDisable() {
        File file = new File(this.getDataFolder(), "config.yml");
        if (file.exists()) {
            reloadConfig();
            saveConfig();
        }
    }

    private void loadRenders() {
        optionRender = new OptionRender(this);
        optionRender.loadOptions();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        try {
            InputStream is = getResource("config.yml");
            if (is != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(is));
                ConfigurationSection config = defConfig.getConfigurationSection("");
                if (config != null) {
                    for (String key : config.getKeys(true)) {
                        if (!getConfig().contains(key)) {
                            getConfig().set(key, defConfig.get(key));
                        }
                    }
                }
                saveConfig();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RealmGroups getInstance() {
        return instance;
    }

    public OptionRender getOptionRender() {
        return optionRender;
    }
}