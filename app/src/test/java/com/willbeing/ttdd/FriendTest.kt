package com.willbeing.ttdd

import com.willbeing.ttdd.friends.Friend
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FriendTest {

    private val friend: Friend = Friend(name = "Sammie")

    @Test
    fun `friend name is as expected`() {
        assertEquals(friend.name, "Sammie")
    }
}