package com.dontsu.fragmenttestex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    init {
        //Timer initialize
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    private fun setFragment() {
        val listFragment: ListFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }

    fun goDetailFragment() {
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        val bundle = Bundle()
        bundle.putString("key1", "날씨가 더워요")
        bundle.putInt("key2", 35)
        detailFragment.arguments = bundle
        // 스마트폰 뒤로가기 버튼 사용 가능
        // 만약 addToBackStack 을 사용하지 않으면 액티비티가 종료되어 버림
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun detailAlarm() {
        Toast.makeText(this@MainActivity, "알람이 왜 울려", Toast.LENGTH_SHORT).show()
    }

    fun goBack() {
        //액티비티가 제공하는 기본메서드
        onBackPressed()
    }

}
