package com.example.we8.models.network

import androidx.compose.runtime.internal.updateLiveLiteralValue
import com.example.we8.models.domain.ListItem
import com.google.gson.annotations.SerializedName

data class CommunityTileItem(
    @SerializedName("categoryType")
    val categoryType: String,
    @SerializedName("createdDate")
    val createdDate: String,
    @SerializedName("createdTimestampEpochInMilliseconds")
    val createdTimestampEpochInMilliseconds: Long,
    @SerializedName("id")
    val id: String,
    @SerializedName("mediaImageUri")
    val mediaImageUri: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("updatedDate")
    val updatedDate: String,
    @SerializedName("updatedTimestampEpochInMilliseconds")
    val updatedTimestampEpochInMilliseconds: Long,
    @SerializedName("url")
    val url: String,
    @SerializedName("weight")
    val weight: Int
)

fun convertCommunityTileToListItem(tile: CommunityTileItem): ListItem {
    return ListItem.CommunityTileItem(
        categoryType = tile.categoryType,
        createdDate = tile.createdDate,
        createdTimestampEpochInMilliseconds = tile.createdTimestampEpochInMilliseconds,
        id = tile.id,
        mediaImageUri = tile.mediaImageUri,
        name = tile.name,
        updatedDate = tile.updatedDate,
        updatedTimestampEpochInMilliseconds = tile.updatedTimestampEpochInMilliseconds,
        url = tile.url,
        weight = tile.weight
    )
}