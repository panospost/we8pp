package com.example.we8.api

import com.example.we8.models.network.CommunityTileItem
import com.example.we8.models.network.FeedSponsorShipItem
import retrofit2.http.GET


interface WeApi {

    @GET("communitytiles.json")
    suspend fun getCommunityTiles(
    ): List<CommunityTileItem>

    @GET("feedsponsorships.json")
    suspend fun getFeedSponsorShips(
    ): List<FeedSponsorShipItem>
}