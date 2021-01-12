package com.willbeing.ttdd

import android.widget.FrameLayout
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.willbeing.ttdd.friends.Friend
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class FriendsListAdapterAndroidTest {

    private val friendsList: List<Friend> = listOf(
        Friend("Sammie"),
        Friend("Joseph"),
        Friend("Mara")
    )
    private val friendsListAdapter = FriendsListAdapter(friendsList)

    @Test
    fun onCreateViewHolder() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val parent = FrameLayout(appContext)
        val viewHolder = friendsListAdapter.onCreateViewHolder(parent, 0)
        val view = viewHolder.itemView
        Assert.assertTrue(view.parent == null)
    }

    @Test
    fun onBindViewHolder() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val parent = FrameLayout(appContext)
        val viewHolder = friendsListAdapter.onCreateViewHolder(parent, Mockito.anyInt())
        bindViewHolderAt(0, "Sammie", viewHolder)
        bindViewHolderAt(1, "Joseph", viewHolder)
        bindViewHolderAt(2, "Mara", viewHolder)
    }

    private fun bindViewHolderAt(
        pos: Int,
        name: CharSequence,
        viewHolder: FriendsListAdapter.ViewHolder
    ) {
        friendsListAdapter.onBindViewHolder(viewHolder, pos)
        assertEquals(viewHolder.textView.text, name)
    }

    @Test
    fun getItemCount() {
        assert(friendsListAdapter.itemCount == 3)
    }
}