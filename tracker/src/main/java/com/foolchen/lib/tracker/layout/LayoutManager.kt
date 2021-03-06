package com.foolchen.lib.tracker.layout

import android.app.Activity
import android.view.ViewGroup
import com.foolchen.lib.tracker.Tracker


fun wrap(activity: Activity) {
  val decorView = activity.window.decorView
  if (decorView != null && decorView is ViewGroup) {
    val trackLayout = TrackLayout(activity)
    trackLayout.registerClickFunc { view, ev, time ->
      Tracker.trackView(view, ev, time)
    }
    trackLayout.registerItemClickFunc { adapterView, view, position, id, ev, time ->
      Tracker.trackAdapterView(adapterView, view, position, id, ev, time)
    }
    decorView.addView(trackLayout,
        ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT))
  }
}