package m.tech.demoexopool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pools
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import m.tech.demoexopool.hnim_exo.HnimExo

class MainActivity : AppCompatActivity() {

    var hnimExo: HnimExo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hnimExo = HnimExo.Builder(applicationContext)
            .autoPlay(true) //auto play when video is buffered
            .isMuted(false) //volume on/off
            .autoMoveNext(true) //auto move next video when video ended
            .isSaveState(false) //save position of video if its exo still in pool
            .lifeCycle(lifecycle) //handle pause, resume with lifecycle or you can do it manually
            .create()

        val vp2 = findViewById<ViewPager2>(R.id.vp2)

        val mAdapter = VideoAdapter(applicationContext, hnimExo!!) {
            vp2.currentItem = vp2.currentItem + 1
        }

        with(vp2) {
            mAdapter.submitList(getListVideo())
            adapter = mAdapter
            offscreenPageLimit = 1 //must set before attach (if use)
            hnimExo!!.attach(this)
        }

        findViewById<Button>(R.id.btnNoti).setOnClickListener {
            startActivity(
                Intent(this, MainActivity2::class.java)
            )
        }
    }

    private fun getListVideo() = listOf(
        VideoItem(
            "A sample video #1",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"
        ),
        VideoItem(
            "A sample video #2",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg"
        ),
        VideoItem(
            "A sample video #3",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg"
        ),
        VideoItem(
            "A sample video #4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg"
        ),
        VideoItem(
            "A sample video #5",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerFun.jpg"
        ),
        VideoItem(
            "A sample video #6",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerJoyrides.jpg"
        ),
        VideoItem(
            "A sample video #7",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerMeltdowns.jpg"
        ),
        VideoItem(
            "A sample video #8",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/Sintel.jpg"
        ),
        VideoItem(
            "A sample video #9",
            "https://video-5a.gapo.vn/videos/results/6d20bf58-2972-4aa5-9bb5-031fe45bbbb9/720p/file.m3u8",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/WeAreGoingOnBullrun.jpg"
        ),

        VideoItem(
            "A sample video #10",
            "https://video-5a.gapo.vn/videos/results/05ebf212-9611-4477-8c28-e8a9cb7bfe21/720p/file.m3u8",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/SubaruOutbackOnStreetAndDirt.jpg"
        ),
        VideoItem(
            "A sample video #11",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/WeAreGoingOnBullrun.jpg"
        ),

        VideoItem(
            "A sample video #12",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/SubaruOutbackOnStreetAndDirt.jpg"
        ),
        VideoItem(
            "A sample video #13",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/WeAreGoingOnBullrun.jpg"
        ),

        VideoItem(
            "A sample video #14",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/SubaruOutbackOnStreetAndDirt.jpg"
        ),
    )
}
