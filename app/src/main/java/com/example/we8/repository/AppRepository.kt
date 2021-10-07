package com.example.we8.repository

import com.example.we8.api.WeApi
import com.example.we8.models.domain.ListItem

import com.example.we8.models.network.convertCommunityTileToListItem
import com.example.we8.models.network.convertFeedSponsorSHipItemToListItem
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

@ActivityScoped
class AppRepositoryImpl @Inject constructor(
    private val api: WeApi
): AppRepository {

    override fun getData(
    ): Flow<List<ListItem>> = flow {
        val result = api.getCommunityTiles()
        emit(result)
    }.zip(flow {
        val result = api.getFeedSponsorShips()
        emit(result)
    }) { community, sponsorhip ->
        val list = mutableListOf<ListItem>()
        community.map { item -> list.add(convertCommunityTileToListItem(item)) }
        sponsorhip.map { item -> item.let { list.add(convertFeedSponsorSHipItemToListItem(item)) } }
        return@zip list
    }
}

interface AppRepository{
    fun getData():Flow<List<ListItem>>
}