package com.willbeing.ttdd

import android.view.ViewGroup
import com.willbeing.ttdd.friends.Friend
import junit.framework.Assert
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FriendsListAdapterTest {

    private val friendsList: List<Friend> = listOf(Friend("Sammie"), Friend("Joseph"), Friend("Mara"))
    private val friendsListAdapter = FriendsListAdapter(friendsList)

    @Test
    fun onCreateViewHolder() {
        val parent = Mockito.mock(ViewGroup::class.java)
        val viewHolder = friendsListAdapter.onCreateViewHolder(parent, Mockito.anyInt())
        val view = viewHolder.itemView
        Assert.assertTrue(view.parent == null)
    }

    @Test
    fun onBindViewHolder() {
        val parent = Mockito.mock(ViewGroup::class.java)
        val viewHolder = friendsListAdapter.onCreateViewHolder(parent, Mockito.anyInt())
        friendsListAdapter.onBindViewHolder(viewHolder, 2)
        assert(viewHolder.textView.text == "Joseph")
    }

    @Test
    fun getItemCount() {
        assert(friendsListAdapter.itemCount == 3)
    }
}