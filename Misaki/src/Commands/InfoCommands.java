package Commands;

import Outfasted.Misaki.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class InfoCommands extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//No response to other bots
		if (event.getAuthor().isBot()) {
			return;
		}  
		
		
		//COMMANDS
		
		if(args[0].equalsIgnoreCase(Main.prefix + "commands")) {			//Display embed with list of commands
			
			EmbedBuilder commands = new EmbedBuilder();
			commands.setTitle("What do you need? ⭐\n");
			
			commands.setDescription
			( "\n*Info/help*\n"
			+ "**--commands**: display misaki's list of commands\n"
			+ "**--misaki:** display misaki's bio\n"
			
			+ "\n*Basic commands*\n"
			+ "**--invite:** generate invite link to server\n"
			+ "**--ping:** display user's latency\n"
			
			+ "\n*Text chat commands*\n"
			+ "**--announce:** send an announcement through misaki\n"
			+ "**--ara:** Misaki sends a small greet to you\n"
			+ "**--call:** Misaki calls everyone out for you\n"
			+ "**--f:** Misaki pays her respects in the chat\n"
			+ "**--talk:** send a message through misaki\n"
			+ "**--talk del:** send a message through misaki and delete command\n"
			
			+ "\nMusic commands\n"
			+ "**--play [URL]:**Plays a song from a given URL\n"
			+ "**--stop:** Stop music and clear all the queue\n"
			+ "**--skip:** Skip the song that is currently playing\n"
			+ "**--now:** Show current track info\n"
			
			+ "\n*Random output commands*\n"
			+ "**--coin:** throw a coin for heads or tails\n"
			+ "**--dice:** throw a dice and get a number from 1 to 6\n"
			
			+ "\n*Chat filter commands*\n"
			+ "**--filter status:** check if the filter is enabled/disabled\n"
			+ "**--filter toggle:** enable/disable chat filter\n");
			
			commands.setColor(0xe8c205);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(commands.build()).queue();
			
			commands.clear();
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "misaki")) {			//Bot bio embed
			//TODO - add more detail to bio
			EmbedBuilder misaki = new EmbedBuilder();
			misaki.setTitle("Misaki desu! ⭐");
			misaki.setDescription("Multipurpose waifu capable of sending messages, reacting to events, managing chat filters, streaming music and more!");
			misaki.setColor(0xe8c205);
			misaki.setFooter("Created by OutFasted",null);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(misaki.build()).queue();
			
			misaki.clear();
		}
		
	}
}
