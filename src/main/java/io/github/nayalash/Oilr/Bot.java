package io.github.nayalash.Oilr;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Bot {

    private static JDA oilr;
    private static final String token = "Insert_Discord_Bot_Token_Here";

    public static void main(String[] args) throws LoginException {

        oilr = new JDABuilder(token).build();
        oilr.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        oilr.getPresence().setGame(Game.listening("To Gas Prices"));

        oilr.addEventListener(new Commands());

    }
}


