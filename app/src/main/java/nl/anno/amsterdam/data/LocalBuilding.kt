package nl.anno.amsterdam.data

import com.google.android.gms.maps.model.LatLng
import nl.anno.amsterdam.model.Building
import java.util.UUID

data class LocalBuilding(
    val id: String,
    val name: String,
    val year: Int,
    val typeOfUse: String,
    val artefacts: List<String>,
    val description: String,
    val mainLocalImageLink: LocalImage,
    val localImageLinks: List<LocalImage>,
    val localTimeline: List<LocalTimeline>,
    val latitude: Double,
    val longitude: Double
)
{
    fun convertToLatLng(): LatLng {
        return LatLng(latitude, longitude)
    }

}


data class LocalImage(
    val url: String,
    val source: String,
    val year: Int
)

data class LocalTimeline(
    val year: Int,
    val text: String
)

fun mapBuildingToLocalBuilding(building: Building): LocalBuilding {
    return LocalBuilding(
        building.id ?: UUID.randomUUID().toString(),
        building.address,
        building.constructionYear,
        building.typeOfUse,
        building.tags ?: emptyList(),
        building.description ?: "",
        LocalImage(building.mainImageUrl ?: "", "", -1),
        building.imageUrls?.map { LocalImage(it.url ?: "" , it.source ?: "", -1) } ?: emptyList(),
        building.timeline?.map { LocalTimeline(it.year ?: -1, it.description ?: "") } ?: emptyList(),
        building.location.coordinates?.get(1)?.toDouble() ?: 0.0,
        building.location.coordinates?.get(0)?.toDouble() ?: 0.0,
    )
}

fun demoBuildingData(): List<LocalBuilding> {
    return listOf(
        LocalBuilding(
            "1",
            "Rijksmuseum",
            1800,
            "Museum",
            listOf(
                "The Night Watch",
                "The Milkmaid",
                "Sick",
                "Gschissen",
                "Woke",
                "Goofy",
                "Oasch"
            ),
            "This house is called De Dolphijn. It is one of three examples in Amsterdam of an early 17th century house with side house (the predecessor of the double house). The second resident, Frans Banninck Cocq, was a lieutenant of the militia in 1635 and in that capacity he was immortalized by Rembrandt in 1642 in the 'Night Watch'.",
            LocalImage(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Rijksmuseum_Amsterdam_ca_1895_rotated.jpg/1200px-Rijksmuseum_Amsterdam_ca_1895_rotated.jpg",
                "Source",
                2023
            ),
            listOf(
                LocalImage(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Rijksmuseum_Amsterdam_ca_1895_rotated.jpg/1200px-Rijksmuseum_Amsterdam_ca_1895_rotated.jpg",
                    "Source",
                    2023
                ),
                LocalImage(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Rijksmuseum_Amsterdam_ca_1895_rotated.jpg/1200px-Rijksmuseum_Amsterdam_ca_1895_rotated.jpg",
                    "Source",
                    2023
                ),
                LocalImage(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Rijksmuseum_Amsterdam_ca_1895_rotated.jpg/1200px-Rijksmuseum_Amsterdam_ca_1895_rotated.jpg",
                    "Source",
                    2023
                ),
            ),
            listOf(LocalTimeline(1800, "Renovation started"), LocalTimeline(1885, "Officially opened")),
            52.359794, 4.885691
        ),
        LocalBuilding(
            "2",
            "Anne Frank House",
            1800,
            "Historical Site",
            listOf("Diary of Anne Frank", "Historical documents"),
            "A museum dedicated to the Jewish wartime diarist Anne Frank.",
            LocalImage("PLACEHOLDER_URL_ANNE_FRANK_HOUSE_MAIN", "Source", 2023),
            listOf(LocalImage("PLACEHOLDER_URL_ANNE_FRANK_HOUSE_1", "Source", 2023)),
            listOf(LocalTimeline(1942, "Anne Frank went into hiding"), LocalTimeline(1960, "Museum opened")),
            52.37522, 4.88395
        ),
        LocalBuilding(
            "3",
            "Van Gogh Museum",
            1800,
            "Museum",
            listOf("Sunflowers", "The Starry Night"),
            "A museum dedicated to the works of Vincent van Gogh.",
            LocalImage("PLACEHOLDER_URL_VAN_GOGH_MUSEUM_MAIN", "Source", 2023),
            listOf(LocalImage("PLACEHOLDER_URL_VAN_GOGH_MUSEUM_1", "Source", 2023)),
            listOf(LocalTimeline(1973, "Museum opened")),
            52.35807, 4.88121
        ),
        LocalBuilding(
            "4",
            "Stedelijk Museum",
            1800,
            "Museum",
            listOf("Contemporary Art", "Design"),
            "A museum for modern art, contemporary art, and design.",
            LocalImage("PLACEHOLDER_URL_STEDELIJK_MUSEUM_MAIN", "Source", 2023),
            listOf(LocalImage("PLACEHOLDER_URL_STEDELIJK_MUSEUM_1", "Source", 2023)),
            listOf(LocalTimeline(1895, "Museum opened")),
            52.35807, 4.87986
        ),
        LocalBuilding(
            "5",
            "Hermitage Amsterdam",
            1800,
            "Museum",
            listOf("Russian art", "Cultural exhibitions"),
            "A branch museum of the Hermitage Museum of Saint Petersburg.",
            LocalImage("PLACEHOLDER_URL_HERMITAGE_AMSTERDAM_MAIN", "Source", 2023),
            listOf(LocalImage("PLACEHOLDER_URL_HERMITAGE_AMSTERDAM_1", "Source", 2023)),
            listOf(LocalTimeline(2009, "Opened as Hermitage Amsterdam")),
            52.36532, 4.90231
        )
    )
}
