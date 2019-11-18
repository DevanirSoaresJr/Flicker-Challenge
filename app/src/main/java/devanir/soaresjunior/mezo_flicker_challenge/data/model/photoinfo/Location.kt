package devanir.soaresjunior.mezo_flicker_challenge.data.model.photoinfo

data class Location(
    val latitude: Double,
    val longitude: Double,
    val accuracy: Int,
    val context: Int,
    val locality: Locality,
    val county: County,
    val region: Region,
    val country: Country,
    val neighbourhood: Neighbourhood
)
