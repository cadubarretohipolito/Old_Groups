package br.cadu.pro.groups.group;

import br.cadu.pro.groups.options.Option;
import br.cadu.pro.groups.options.OptionRender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Group {

    GAME_MASTER(
            OptionRender.getString(Option.GAME_MASTER_NAME),
            OptionRender.getString(Option.GAME_MASTER_PREFIX),
            OptionRender.getString(Option.GAME_MASTER_SUFFIX)
    ),
    ADMINISTRATOR(
            OptionRender.getString(Option.ADMINISTRATOR_NAME),
            OptionRender.getString(Option.ADMINISTRATOR_PREFIX),
            OptionRender.getString(Option.ADMINISTRATOR_SUFFIX)
    ),
    MODERATOR(
            OptionRender.getString(Option.MODERATOR_NAME),
            OptionRender.getString(Option.MODERATOR_PREFIX),
            OptionRender.getString(Option.MODERATOR_SUFFIX)
    ),
    HELPER(
            OptionRender.getString(Option.HELPER_NAME),
            OptionRender.getString(Option.HELPER_PREFIX),
            OptionRender.getString(Option.HELPER_SUFFIX)
    ),
    MVP_PLUS(
            OptionRender.getString(Option.MVP_PLUS_NAME),
            OptionRender.getString(Option.MVP_PLUS_PREFIX),
            OptionRender.getString(Option.MVP_PLUS_SUFFIX)
    ),
    MVP(
            OptionRender.getString(Option.MVP_NAME),
            OptionRender.getString(Option.MVP_PREFIX),
            OptionRender.getString(Option.MVP_SUFFIX)
    ),
    VIP(
            OptionRender.getString(Option.VIP_NAME),
            OptionRender.getString(Option.VIP_PREFIX),
            OptionRender.getString(Option.VIP_SUFFIX)
    ),
    DEFAULT(
            OptionRender.getString(Option.DEFAULT_NAME),
            OptionRender.getString(Option.DEFAULT_PREFIX),
            OptionRender.getString(Option.DEFAULT_SUFFIX)
    );

    private final String name, prefix, suffix;

    public static Group of(String type) {
        for (Group group : values()) {
            if (group.getName().equalsIgnoreCase(type)) {
                return group;
            }
        }
        return null;
    }


}
