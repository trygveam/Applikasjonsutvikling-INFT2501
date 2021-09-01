package inft2501.leksjon2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClickStartChangeFlagActivity(v: View?) {
        val intent = Intent("inft2501.ChangeFlagActivity")
        startActivity(intent)
    }
}