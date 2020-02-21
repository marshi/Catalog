package marshi.android.catalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import marshi.android.catalog.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DataBindingUtil.setContentView<ActivitySampleBinding>(this, R.layout.activity_sample)
  }
}
