package net.davesan.anistream

import android.app.Application
import net.davesan.anistream.utils.preference.PreferenceHelper
import net.davesan.anistream.utils.realm.InitalizeRealm
import net.davesan.anistream.utils.rertofit.RetrofitHelper
import timber.log.Timber

class AniStream : Application() {

    override fun onCreate() {
        super.onCreate()
        InitalizeRealm.initializeRealm(this)
        PreferenceHelper(context = this)
        RetrofitHelper(PreferenceHelper.sharedPreference.getBaseUrl())
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}