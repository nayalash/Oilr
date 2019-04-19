package io.github.nayalash.Oilr;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    API api = new API();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;


        Message message = event.getMessage();

        String content = message.getContentRaw();


        if (content.equals("!help")) {

            MessageChannel channel = event.getChannel();

            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("Commands \n \n");
            help.setAuthor("OILR THE GAS PRICE BOT");
            help.addField("!config (LAT) (LONG) (RADIUS)", "Configures values in order to display Gas Station Data. \n Example:   !config 41.965462 -87.654800 5 ", false);
            help.addField("!fetchPrice", "Displays Gas Station Data based on values you have configured", false);
            help.addField("!help", "Information About The Bot", false);
            help.addField("Creator", "Nayalash Mohammad \n https://github.com/Nayalash/Oilr", false);
            help.setDescription("\n \n \n DISCLAIMER: This bot will only receive parameters related to USA Longitude and Latitudes. Some features may not work as the API has not been updated in a while.");
            help.setColor(0xf45642);
            channel.sendTyping().queue();
            channel.sendMessage(help.build()).queue();
            help.clear();

        }

        String rawMessage[] = event.getMessage().getContentRaw().split(" ");

        if(rawMessage[0].equals("!config")) {
            api.LAT = rawMessage[1];
            api.LONG = rawMessage[2];
            api.radius = rawMessage[3];
        }

        else if (content.equals("!fetchPrice")) {

            MessageChannel channel = event.getChannel();
            channel.sendTyping().queue();

            String responsePrice = api.fetchStaionsPrice();

            String responseAddress = api.fetchStaionsAddress();

            channel.sendMessage("The Current Gas Price In Your Area Is:   $" + responsePrice + "\n \n" + "The Location of the Gas Station near you is " + responseAddress).queue();

        }

    }

}

