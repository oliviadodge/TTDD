package com.willbeing.ttdd

import android.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
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
            }
        }
    }


    @Test
    fun `verify adapter item count`(adapter: FriendsListAdapter) {
        assert(adapter.itemCount == 3)

        adapter.onCreateViewHolder()
        assert(adapter.view.equals("Jessica"))
        assert(adapter.getItemId(1).equals(""))
        assert(adapter.getItemId(2).equals(""))
    }

    @Test
    fun `verify adapter on create view holder`(adapter: FriendsListAdapter) {
        val parent = Mockito.mock(ViewGroup::class.java)
        val viewHolder = adapter.onCreateViewHolder(parent, Mockito.anyInt())
        val view = viewHolder.itemView
        assertTrue(view.parent == null)
        assertTrue(viewHolder.textView.id == R.id.text1)
    }
}