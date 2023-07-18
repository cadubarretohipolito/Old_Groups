package br.cadu.pro.groups.options;

public enum Option {

    GAME_MASTER_PREFIX("options.game-master.prefix", OptionType.STRING),
    GAME_MASTER_SUFFIX("options.game-master.suffix", OptionType.STRING),
    GAME_MASTER_NAME("options.game-master.name", OptionType.STRING),

    ADMINISTRATOR_PREFIX("options.administrator.prefix", OptionType.STRING),
    ADMINISTRATOR_SUFFIX("options.administrator.suffix", OptionType.STRING),
    ADMINISTRATOR_NAME("options.administrator.name", OptionType.STRING),

    MODERATOR_PREFIX("options.moderator.prefix", OptionType.STRING),
    MODERATOR_SUFFIX("options.moderator.suffix", OptionType.STRING),
    MODERATOR_NAME("options.moderator.name", OptionType.STRING),

    HELPER_PREFIX("options.helper.prefix", OptionType.STRING),
    HELPER_SUFFIX("options.helper.suffix", OptionType.STRING),
    HELPER_NAME("options.helper.name", OptionType.STRING),

    MVP_PLUS_PREFIX("options.mvp-plus.prefix", OptionType.STRING),
    MVP_PLUS_SUFFIX("options.mvp-plus.suffix", OptionType.STRING),
    MVP_PLUS_NAME("options.mvp-plus.name", OptionType.STRING),

    MVP_PREFIX("options.mvp.prefix", OptionType.STRING),
    MVP_SUFFIX("options.mvp.suffix", OptionType.STRING),
    MVP_NAME("options.mvp.name", OptionType.STRING),

    VIP_PREFIX("options.vip.prefix", OptionType.STRING),
    VIP_SUFFIX("options.vip.suffix", OptionType.STRING),
    VIP_NAME("options.vip.name", OptionType.STRING),

    DEFAULT_PREFIX("options.default.prefix", OptionType.STRING),
    DEFAULT_SUFFIX("options.default.suffix", OptionType.STRING),
    DEFAULT_NAME("options.default.name", OptionType.STRING);


    private String path;
    private OptionType type;

    Option(String path, OptionType type){
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public OptionType getType() {
        return type;
    }
}
