package com.nendo.argosy.data.emulator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class PizzaBoyProRegistryTest {

    @Test
    fun `gba pro resolves launch and sync configuration`() {
        val emulator = assertNotNull(EmulatorRegistry.getByPackage("it.dbtecno.pizzaboygbapro"))
        val launch = assertIs<LaunchConfig.Custom>(emulator.launchConfig)

        assertEquals("pizza_boy_gba_pro", emulator.id)
        assertEquals(android.content.Intent.ACTION_MAIN, emulator.launchAction)
        assertEquals("it.dbtecno.pizzaboygbapro.MainActivity", launch.activityClass)
        assertEquals(ExtraValue.FilePath, launch.intentExtras["rom_uri"])
        assertEquals(
            "pizza_boy_gba_pro",
            SavePathRegistry.getConfigByPackage(emulator.packageName)?.emulatorId
        )
        assertNotNull(StatePathRegistry.getConfig(emulator.id))
        assertTrue(emulator.id in EmulatorRegistry.getRecommendedEmulators().getValue("gba"))
    }

    @Test
    fun `gb pro resolves launch and sync configuration`() {
        val emulator = assertNotNull(EmulatorRegistry.getByPackage("it.dbtecno.pizzaboypro"))
        val launch = assertIs<LaunchConfig.Custom>(emulator.launchConfig)

        assertEquals("pizza_boy_gb_pro", emulator.id)
        assertEquals(android.content.Intent.ACTION_MAIN, emulator.launchAction)
        assertEquals("it.dbtecno.pizzaboypro.MainActivity", launch.activityClass)
        assertEquals(ExtraValue.FilePath, launch.intentExtras["rom_uri"])
        assertEquals(
            "pizza_boy_gb_pro",
            SavePathRegistry.getConfigByPackage(emulator.packageName)?.emulatorId
        )
        assertNotNull(StatePathRegistry.getConfig(emulator.id))
        assertTrue(emulator.id in EmulatorRegistry.getRecommendedEmulators().getValue("gb"))
        assertTrue(emulator.id in EmulatorRegistry.getRecommendedEmulators().getValue("gbc"))
    }
}
