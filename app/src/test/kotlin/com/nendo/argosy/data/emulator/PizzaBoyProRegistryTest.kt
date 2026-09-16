package com.nendo.argosy.data.emulator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class PizzaBoyProRegistryTest {

    @Test
    fun `gba pro resolves launch and sync configuration`() {
        val emulator = EmulatorRegistry.getByPackage("it.dbtecno.pizzaboygbapro")
        assertNotNull("Expected pizza_boy_gba_pro to be registered", emulator)
        requireNotNull(emulator)

        assertTrue(
            "Expected LaunchConfig.Custom for pizza_boy_gba_pro",
            emulator.launchConfig is LaunchConfig.Custom
        )
        val launch = emulator.launchConfig as LaunchConfig.Custom

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
        val emulator = EmulatorRegistry.getByPackage("it.dbtecno.pizzaboypro")
        assertNotNull("Expected pizza_boy_gb_pro to be registered", emulator)
        requireNotNull(emulator)

        assertTrue(
            "Expected LaunchConfig.Custom for pizza_boy_gb_pro",
            emulator.launchConfig is LaunchConfig.Custom
        )
        val launch = emulator.launchConfig as LaunchConfig.Custom

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
