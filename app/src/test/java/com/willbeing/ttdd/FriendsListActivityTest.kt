package com.willbeing.ttdd

import android.R
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

//TODO fixme
//TODO start spreadsheet of things that are difficult in TTDD (test-driven dev in Android)
@RunWith(RobolectricTestRunner::class)
class FriendsListActivityTest {
    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        ActivityScenario.launch(FriendsListActivity::class.java).use { scenario ->
            scenario.onActivity { activity: FriendsListActivity ->
                val friendsList = activity.findViewById<RecyclerView>(R.id.friends_list_recycler_view)
                val adapter = friendsList.adapter as FriendsListAdapter
                verifyAdapter(adapter)
            }
        }
    }


    private fun verifyAdapter(adapter: FriendsListAdapter) {
        assert(adapter.itemCount == 3)
        assert(adapter.view.equals("Jessica"))
        assert(adapter.getItemId(1).equals("Adan"))
        assert(adapter.getItemId(2).equals("Rishi"))
    }
}