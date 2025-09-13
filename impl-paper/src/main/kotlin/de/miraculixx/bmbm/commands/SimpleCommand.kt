package de.miraculixx.bmbm.commands

import de.miraculixx.bmbm.PluginManager
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SimpleCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        PluginManager.logger.info("DEBUG: Simple command executed by ${sender.name}")
        
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}This command can only be executed by players!")
            return true
        }
        
        when (args.getOrNull(0)) {
            "global" -> {
                PluginManager.logger.info("DEBUG: Global subcommand executed")
                sender.sendMessage("${ChatColor.GREEN}Global command works! Player: ${sender.name}")
                // Здесь можно добавить логику для открытия GUI
            }
            else -> {
                if (args.isNotEmpty()) {
                    val targetName = args[0]
                    PluginManager.logger.info("DEBUG: Target subcommand executed for: $targetName")
                    sender.sendMessage("${ChatColor.GREEN}Target command works! Target: $targetName, Player: ${sender.name}")
                    // Здесь можно добавить логику для открытия GUI с маркерами игрока
                } else {
                    sender.sendMessage("${ChatColor.YELLOW}Usage: /banner-marker <global|player>")
                }
            }
        }
        
        return true
    }
}
