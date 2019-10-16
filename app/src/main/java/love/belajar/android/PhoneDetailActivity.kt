package love.belajar.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_phone_detail.*
import love.belajar.git.R

class PhoneDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)


        var intentData = getIntent()
        if(intentData.hasExtra("data")){
            val data = intentData.getSerializableExtra("data") as PhoneData
            tv_item_id.text = data.contactName
            tv_item_id1.text = data.phone.toString()
            Picasso.get().load(data.image).resize(200,200).into(img_view_phone_detail1)
        }
        //        var intentThatStartThisActivity = getIntent()
//        if(intentThatStartThisActivity.hasExtra(Intent.EXTRA_TEXT)){
//            var partId = intentThatStartThisActivity.getStringExtra(Intent.EXTRA_TEXT)
//            tv_item_id.text = partId
//        }
//
//        var intentThatEndThisActivity= getIntent()
//        if(intentThatEndThisActivity.hasExtra(Intent.EXTRA_INDEX)){
//            var partId = intentThatEndThisActivity.getStringExtra(Intent.EXTRA_INDEX)
//            tv_item_id1.text = partId
//        }



    }
}