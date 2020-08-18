package com.dontsu.fragmenttestex1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.view.*
import timber.log.Timber

class DetailFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private var word1: String? = null
    private var word2: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("---Detail : onAttach()")

        mainActivity = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("---Detail : onCreate()")
        word1 = arguments?.getString("key1")
        word2 = arguments?.getInt("key2")
    }
    
    //뷰를 초기화 하는 곳
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        Timber.d("---Detail : onCreateView() ${container?.context} and $mainActivity")
        view.detail_btn.setOnClickListener { mainActivity?.goBack() }

        Toast.makeText(mainActivity, "$word1, $word2 도 입니다.", Toast.LENGTH_SHORT).show()
        Timber.d("---Detail : onCreateView() $view")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("---Detail : onViewCreated() and $view")

        Toast.makeText(mainActivity, "$word1, $word2 도 입니다.", Toast.LENGTH_SHORT).show()

    }


    //주로 화면 생성 후에 화면에 입력될 값을 초기화하는 용도로 사용
    override fun onStart() {
        super.onStart()
        Timber.d("---Detail : onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("---Detail : onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("---Detail : onPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("---Detail : onStop()")
    }

    // onCreateView 에서 생성한 view가 모두 소멸된다.
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("---Detail : onDestroyView()")
    }

    // 액티비티에는 아직 남아있지만 프래그먼트 자체는 소멸, 프래그먼트에 연결된 모든 자원을 해제하는 용도로 사용.
    override fun onDestroy() {
        super.onDestroy()
        Timber.d("---Detail : onDestroy()")
    }

    //액티비티에서 연결 해제, 뜯겨진다.
    override fun onDetach() {
        super.onDetach()
        Timber.d("---Detail : onDetach()")
    }

}
