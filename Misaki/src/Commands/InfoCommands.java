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
		
		if(args[0].equalsIgnoreCase(Main.prefix + "commands")) {			//<Display embed with list of commands>
			
			EmbedBuilder commands = new EmbedBuilder();
			commands.setTitle("What do you need? ⭐\n");
			
			commands.setDescription
			( "\n*Info/help*\n"
			+ "**--commands**: display misaki's list of commands\n"
			+ "**--info:** display misaki's bio\n"
			
			+ "\n*Basic commands*\n"
			+ "**--invite:** generate invite link to server\n"
			+ "**--ping:** display user's latency\n"
			
			+ "\n*Text chat commands*\n"
			+ "**--announce [text]:** send an announcement through misaki\n"
			+ "**--call:** Misaki calls everyone out for you\n"
			+ "**--del n:** Misaki deletes the last n messages in the chat \n"
			+ "**--f:** Misaki pays her respects in the chat\n"
			+ "**--f [text]:** user pays respect to [text]\n"
			+ "**--misaki:** Misaki sends a small greet to you\n"
			+ "**--talk [text]:** send a message through misaki\n"
			+ "**--talk del [text]:** send a message through misaki and delete command\n"
			
			+ "\nMusic commands\n"
			+ "**--play [URL]:** plays a song from a given URL\n"
			+ "**--pause:** pauses/resumes the audio track\n"
			+ "**--skip:** skip the song that is currently playing\n"
			+ "**--stop:** stop music, clear queue and force bot out of VC\n"
			+ "**--now:** show current track info\n"
			+ "**--come:** change Misaki to the VC you are currently in\n"
			
			+ "\n*Random output commands*\n"
			+ "**--coin:** throw a coin for heads or tails\n"
			+ "**--dice:** throw a dice and get a number from 1 to 6\n"
			
			/*
			+ "\n*Chat filter commands*\n"
			+ "**--filter status:** check if the filter is enabled/disabled\n"
			+ "**--filter toggle:** enable/disable chat filter\n"*/
			);
			
			commands.setColor(0xe8c205);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(commands.build()).queue();
			
			commands.clear();
		}
		
		else if(args[0].equalsIgnoreCase(Main.prefix + "info")) {			//<Bot bio embed>
			
			EmbedBuilder misaki = new EmbedBuilder();
			misaki.setTitle("Misaki desu! ⭐");
			misaki.setDescription("Waifu bot capable of streaming music, generating server invite links, interacting with users and more!");
			misaki.addField("How do I interact with Misaki?","Just use the prefix '--' followed by a command.",true);
			misaki.addField("What commands do you have?","Type *--commands* and I will display the list of available commands for you.",true);
			misaki.addField("Can we hold hands?","**No. ✨**",true);
			misaki.setColor(0xe8c205);
			misaki.setFooter("Created by OutFasted | https://github.com/NikoSilveira/Discord-Bot-Misaki",null);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(misaki.build()).queue();
			
			misaki.clear();
		}
		
	}
}
