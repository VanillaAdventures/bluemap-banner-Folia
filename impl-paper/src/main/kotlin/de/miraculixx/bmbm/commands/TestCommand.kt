package de.miraculixx.bmbm.commands

import de.miraculixx.bmbm.PluginManager
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.literalArgument
import dev.jorel.commandapi.kotlindsl.playerExecutor
import org.bukkit.ChatColor

class TestCommand {
    init {
        commandTree("test-bmb") {
            withPermission("banner-marker.command.settings")
            literalArgument("hello") {
                playerExecutor { player, _ ->
                    PluginManager.logger.info("DEBUG: Test command executed by ${player.name}")
                    player.sendMessage("${ChatColor.GREEN}Test command works! Player: ${player.name}")
                }
            }
        }
    }
}
