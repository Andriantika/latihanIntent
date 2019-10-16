package love.belajar.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import love.belajar.git.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneDate()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ContactAdapter(testData, {phoneItem : PhoneData->phoneItemClicked(phoneItem)})
    }



    private fun phoneItemClicked (phoneItem : PhoneData){
        val  showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra("data",phoneItem)
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneDate() : List<PhoneData>{
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(85786534862,"TIKA","https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Pablo_picasso_1.jpg/510px-Pablo_picasso_1.jpg"))
        partList.add(PhoneData(85786534861,"HELDA","https://miro.medium.com/max/3200/1*2dfK1SVSJNNxuGm-sEYzbw.png"))
        partList.add(PhoneData(85786534863,"RIZQI","https://image.shutterstock.com/image-vector/thin-line-snap-finger-like-260nw-1070110487.jpg"))
        partList.add(PhoneData(85786534864,"SARI","http://static.simpledesktops.com/uploads/desktops/2019/06/22/Dinosaur_eye_2.png.620x390_q100.png"))

        return partList
    }
}
