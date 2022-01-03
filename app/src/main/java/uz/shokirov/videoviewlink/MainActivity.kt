package uz.shokirov.videoviewlink

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mediaControls: MediaController? = null
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (mediaControls == null) {
            // creating an object of media controller class
            mediaControls = MediaController(this)

            // set the anchor view for the video view
            mediaControls!!.setAnchorView(videoview)
        }

        //val uri = Uri.parse("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")
        videoview.setVideoURI(Uri.parse("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")); //the string of the URL mentioned above
        videoview.requestFocus();
        videoview.start();

        btnScanner.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
        }

    }
}