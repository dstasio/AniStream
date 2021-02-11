package net.davesan.anistream.utils.model

import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey


open class Content(
    var url: String?="",
    @Ignore
    var animeName: String = "",
    var episodeName: String?="",
    @PrimaryKey
    var episodeUrl: String?="",
    var nextEpisodeUrl: String?= null,
    var previousEpisodeUrl: String?=null,
    @Ignore
    var watchedDuration: Long = 0,
    @Ignore
    var duration: Long = 0,
    var insertionTime: Long = 0
): RealmObject()