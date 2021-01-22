package com.willbeing.ttdd

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity

class FriendsListActivity: FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_friends_list)
    }
}
