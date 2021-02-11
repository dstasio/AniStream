package net.davesan.anistream.ui.main.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import net.davesan.anistream.utils.model.FavouriteModel
import net.davesan.anistream.utils.realm.InitalizeRealm

class FavouriteViewModel : ViewModel() {

    private lateinit var result: RealmResults<FavouriteModel>
    private val realm = Realm.getInstance(InitalizeRealm.getConfig())
    private val _favouriteLists: MutableLiveData<ArrayList<FavouriteModel>> =
        MutableLiveData(ArrayList())
    var favouriteList: LiveData<ArrayList<FavouriteModel>> = _favouriteLists
    init {
        favouriteListListener()
    }

    private fun favouriteListListener() {
        result = realm.where(FavouriteModel::class.java).sort("insertionTime", Sort.DESCENDING).findAll()
        _favouriteLists.value = realm.copyFromRealm(result) as ArrayList<FavouriteModel>?
        result.addChangeListener { newList ->
            _favouriteLists.value = realm.copyFromRealm(newList) as ArrayList<FavouriteModel>?
        }

    }
}

