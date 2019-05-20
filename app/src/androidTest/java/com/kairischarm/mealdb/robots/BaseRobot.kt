package com.kairischarm.mealdb.robots

import android.content.res.Resources
import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View

import com.kairischarm.mealdb.RecyclerView

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.hamcrest.TypeSafeMatcher

import org.junit.Assert.assertEquals

abstract class BaseRobot {
    private fun findViewWithId(@IdRes id: Int): Matcher<View> {
        return withId(id)
    }

    protected fun findViewWithIdAndText(@IdRes id: Int, text: String): ViewInteraction {
        return onView(allOf(findViewWithId(id), withText(text)))
    }

    protected fun click(interaction: ViewInteraction) {
        interaction.perform(click())
    }

    protected fun listHasItemCount(count: Int, @IdRes recyclerViewId: Int) {
        onView(findViewWithId(recyclerViewId)).check(hasItemCount(count))
    }

    protected fun listItemAtPositionHasText(position: Int, text: String, @IdRes recyclerViewId: Int, @IdRes textViewId: Int) {
        onView(RecyclerViewMatcher(recyclerViewId).atPositionOnView(position, textViewId)).check(matches(allOf(withText(containsString(text)), isDisplayed())))
    }

    private fun hasItemCount(count: Int): ViewAssertion {
        return ViewAssertion { view, noViewFoundException ->
            if (view !is RecyclerView<*>) {
                throw noViewFoundException
            }
            assertEquals(count, view.adapter?.itemCount)
        }
    }

    internal inner class RecyclerViewMatcher(private val recyclerViewId: Int) {
        fun atPositionOnView(position: Int, targetViewId: Int): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                var resources: Resources? = null
                var childView: View? = null

                override fun describeTo(description: Description) {
                    var idDescription = Integer.toString(recyclerViewId)

                    if (this.resources != null) {
                        idDescription = try { this.resources?.getResourceName(recyclerViewId)?: "(Unknown resource)" }
                                        catch (var4: Resources.NotFoundException) { String.format("%s (resource name not found)", Integer.valueOf(recyclerViewId)) }
                    }

                    description.appendText("with id: $idDescription")
                }

                override fun matchesSafely(view: View): Boolean {
                    this.resources = view.resources

                    if (childView == null) {
                        val recyclerView = view.rootView.findViewById<View>(recyclerViewId) as RecyclerView<*>

                        if (recyclerView.id == recyclerViewId) {
                            childView = recyclerView.findViewHolderForAdapterPosition(position)?.itemView
                        } else {
                            return false
                        }
                    }

                    return if (targetViewId == -1) { view === childView }
                           else { view === childView?.findViewById<View>(targetViewId)}
                }
            }
        }
    }
}