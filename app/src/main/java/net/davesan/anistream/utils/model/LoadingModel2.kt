package net.davesan.anistream.utils.model

import net.davesan.anistream.utils.CommonViewModel2

data class LoadingModel2(
    val loading: CommonViewModel2.Loading,
    val isListEmpty: Boolean,
    val errorCode: Int,
    val errorMsg: Int
)