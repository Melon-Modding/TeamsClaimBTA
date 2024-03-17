package lusii.lusiiclaimchunks.commands;

import lusii.lusiiclaimchunks.LusiiClaimChunks;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.net.command.Command;
import net.minecraft.core.net.command.CommandHandler;
import net.minecraft.core.net.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OPTrustCommand extends Command {
	public OPTrustCommand() {
		super("optrust","opclaimtrust");
	}
//
	public boolean execute(CommandHandler handler, CommandSender sender, String[] args) {
		int cx = sender.getPlayer().chunkCoordX;
		int cz = sender.getPlayer().chunkCoordZ;
		LusiiClaimChunks.IntPair intPair = new LusiiClaimChunks.IntPair(cx,cz);
		String player;
		player = args[0];
		if (LusiiClaimChunks.map.get(intPair) == null) {
			sender.sendMessage("§3No one owns this chunk!");
			return true;
		}
		List<String> Users = new ArrayList<>(LusiiClaimChunks.map.get(intPair));
		Users.add(player);
		LusiiClaimChunks.map.put(intPair, Users);
		sender.sendMessage("§ePlayer §r"+ player + " §etrusted via Operator.");
		LusiiClaimChunks.saveHashMap();
		return true;
	}
//
	public boolean opRequired(String[] args) {
		return true;
	}
//
	public void sendCommandSyntax(CommandHandler handler, CommandSender sender) {

	}
}
