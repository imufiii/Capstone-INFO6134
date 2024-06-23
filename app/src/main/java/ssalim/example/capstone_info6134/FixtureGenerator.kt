package ssalim.example.capstone_info6134

import java.util.*
import java.io.Serializable

data class Fixture(
    val teamHome: String,
    val teamAway: String,
    val teamHomeLogo: Int,
    val teamAwayLogo: Int,
    val gameNumber: String,
    val venue: String,
    val time: String,
    val league: String
) : Serializable


object FixtureGenerator {

    private val teams = listOf(
        "Knicks", "Cavaliers", "Mavericks", "Bulls", "Celtics"
    )

    private val venues = listOf(
        "Rocket Mortgage FieldHouse",
        "American Airlines Center",
        "Madison Square Garden",
        "TD Garden"
    )

    private val leagues = listOf(
        "NBA", "NHL", "NFL", "MLB"
    )

    fun generateRandomFixtures(count: Int): List<Fixture> {
        val random = Random()
        val fixtures = mutableListOf<Fixture>()

        for (i in 1..count) {
            val homeIndex = random.nextInt(teams.size)
            var awayIndex = random.nextInt(teams.size)
            while (awayIndex == homeIndex) {
                awayIndex = random.nextInt(teams.size)
            }

            val gameNumber = "Game no: $i"
            val venue = venues[random.nextInt(venues.size)]
            val time = "${random.nextInt(12) + 1}:${random.nextInt(60).toString().padStart(2, '0')}PM"
            val league = leagues[random.nextInt(leagues.size)]

            val fixture = Fixture(
                teams[homeIndex], teams[awayIndex],
                getTeamLogoResId(teams[homeIndex]), getTeamLogoResId(teams[awayIndex]),
                gameNumber, venue, time, league
            )
            fixtures.add(fixture)
        }

        return fixtures
    }

    private fun getTeamLogoResId(teamName: String): Int {
        return when (teamName) {
            "Knicks" -> R.drawable.new_york_knicks_logo_primary_20129558
            "Cavaliers" -> R.drawable.cavaliers
            "Mavericks" -> R.drawable.mavericks
            "Bulls" -> R.drawable.chicago_bulls_logo_primary_19672598
            "Celtics" -> R.drawable.celtics
            else -> R.drawable.default_logo
        }
    }
}
