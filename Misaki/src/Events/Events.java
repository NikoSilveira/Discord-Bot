package Events;

import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Events extends ListenerAdapter{
	
	//List of messages
	String[] messagesJoin = {
			"Ara ara [member]",
			"You have entered the comedy area [member]",
			"Hello there, [member]"
		};
	
	String[] messagesLeave = {
			"Ara? You leaving [member]?",
			"*sad Misaki noises*"
		};
	
	//Member Join
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		
		Random rand = new Random();
		int number = rand.nextInt(messagesJoin.length);
		
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0xe8c205);
		join.setDescription(messagesJoin[number].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
		
		//Add role
		//event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Role", true)).complete();
		
	}
	
	//Member Leave
	public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
		
		Random rand = new Random();
		int number = rand.nextInt(messagesLeave.length);
		
		EmbedBuilder leave = new EmbedBuilder();
		leave.setColor(0xe8c205);
		leave.setDescription(messagesLeave[number].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
		
	}
	
}
