package devanir.soaresjunior.mezo_flicker_challenge.common


object Utils{

    fun generateImageUrl(farmId: String, serverId: String, id: String, secret: String, size: Char): String {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_%c.jpg", farmId, serverId, id, secret, size)
    }
}