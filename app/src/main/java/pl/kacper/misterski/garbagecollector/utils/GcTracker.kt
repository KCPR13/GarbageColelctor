package pl.kacper.misterski.garbagecollector.utils

import android.util.Log
import java.lang.ref.PhantomReference
import java.lang.ref.ReferenceQueue

object GcTracker {
    private val queue = ReferenceQueue<Any>()
    private val references = mutableMapOf<PhantomReference<Any>, String>()

    fun track(obj: Any, tag: String) {
        val ref = PhantomReference(obj, queue)
        references[ref] = tag

        Thread {
            try {
                val removed = queue.remove()
                val tagRemoved = references[removed]
                Log.d("GC_TEST", "$tagRemoved: Garbage collected (PhantomReference)")
            } catch (e: InterruptedException) {
                Log.e("GC_TEST", "Interrupted GC watcher", e)
            }
        }.start()
    }
}