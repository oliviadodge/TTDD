package com.willbeing.ttdd

import android.R
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

//TODO fixme
//TODO start spreadsheet of things that are difficult in TDDA (test-driven dev in Android)
@RunWith(RobolectricTestRunner::class)
class FriendsListActivityTest {
    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        val activity: FriendsListActivity = Robolectric.setupActivity(FriendsListActivity::class.java)
        val friendsList = activity.findViewById<RecyclerView>(R.id.friends_list_recycler_view)
        val adapter = friendsList.adapter as FriendsListAdapter
        verifyAdapter(adapter)
    }

    private fun verifyAdapter(adapter: FriendsListAdapter) {
        assert(adapter.itemCount == 3)
        assert(adapter.view.equals("Jessica"))
        assert(adapter.getItemId(1).equals("Adan"))
        assert(adapter.getItemId(2).equals("Rishi"))
    }
}