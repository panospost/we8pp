package com.example.we8.models.network

import com.example.we8.models.domain.ListItem
import com.google.gson.annotations.SerializedName

data class FeedSponsorShipItem(
    @SerializedName("brandInfo")
    val brandInfo: String,
    @SerializedName("brandLogoUri")
    val brandLogoUri: String,
    @SerializedName("brandName")
    val brandName: String,
    @SerializedName("brief")
    val brief: String,
    @SerializedName("campaignId")
    val campaignId: String,
    @SerializedName("cashIncentive")
    val cashIncentive: CashIncentive,
    @SerializedName("charityDonationIncentive")
    val charityDonationIncentive: CharityDonationIncentive?,
    @SerializedName("coverTileUri")
    val coverTileUri: String,
    @SerializedName("createdDate")
    val createdDate: String,
    @SerializedName("createdTimestampEpochInMilliseconds")
    val createdTimestampEpochInMilliseconds: Long,
    @SerializedName("questionCount")
    val questionCount: Int,
    @SerializedName("sponsorshipId")
    val sponsorshipId: String,
    @SerializedName("sponsorshipSetId")
    val sponsorshipSetId: String,
    @SerializedName("updatedDate")
    val updatedDate: String,
    @SerializedName("updatedTimestampEpochInMilliseconds")
    val updatedTimestampEpochInMilliseconds: Long,
    @SerializedName("videoUriDash")
    val videoUriDash: String,
    @SerializedName("videoUriHls")
    val videoUriHls: String,
    @SerializedName("weight")
    val weight: Int
)

data class CharityDonationIncentive(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("charityId")
    val charityId: String,
    @SerializedName("charityLogoUri")
    val charityLogoUri: String,
    @SerializedName("charityName")
    val charityName: String
)

data class CashIncentive(
    @SerializedName("amount")
    val amount: Double
)

fun convertFeedSponsorSHipItemToListItem(item: FeedSponsorShipItem): ListItem{
        return ListItem.FeedSponsorShipItem(
            brandInfo = item.brandInfo,
            brandLogoUri = item.brandLogoUri,
            brandName = item.brandName,
            brief = item.brief,
            campaignId = item.campaignId,
            cashIncentive = item.cashIncentive,
            charityDonationIncentive = item.charityDonationIncentive,
            coverTileUri = item.coverTileUri,
            createdDate = item.createdDate,
            createdTimestampEpochInMilliseconds = item.createdTimestampEpochInMilliseconds,
            questionCount = item.questionCount,
            sponsorshipId = item.sponsorshipId,
            sponsorshipSetId = item.sponsorshipSetId,
            updatedDate = item.updatedDate,
            updatedTimestampEpochInMilliseconds = item.updatedTimestampEpochInMilliseconds,
            videoUriHls = item.videoUriHls,
            videoUriDash = item.videoUriDash,
            weight = item.weight
        )

}