package com.example.we8.models.domain

import com.example.we8.models.network.CashIncentive
import com.example.we8.models.network.CharityDonationIncentive

sealed class ListItem {
    data class CommunityTileItem(
        val categoryType: String,
        val createdDate: String,
        val createdTimestampEpochInMilliseconds: Long,
        val id: String,
        val mediaImageUri: String,
        val name: String,
        val updatedDate: String,
        val updatedTimestampEpochInMilliseconds: Long,
        val url: String,
        val weight: Int
    ):ListItem()

    data class FeedSponsorShipItem(
        val brandInfo: String,
        val brandLogoUri: String,
        val brandName: String,
        val brief: String,
        val campaignId: String,
        val cashIncentive: CashIncentive,
        val charityDonationIncentive: CharityDonationIncentive?,
        val coverTileUri: String,
        val createdDate: String,
        val createdTimestampEpochInMilliseconds: Long,
        val questionCount: Int,
        val sponsorshipId: String,
        val sponsorshipSetId: String,
        val updatedDate: String,
        val updatedTimestampEpochInMilliseconds: Long,
        val videoUriDash: String,
        val videoUriHls: String,
        val weight: Int
    ):ListItem()
}