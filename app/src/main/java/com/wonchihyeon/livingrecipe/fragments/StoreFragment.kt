package com.wonchihyeon.livingrecipe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.wonchihyeon.livingrecipe.R
import com.wonchihyeon.livingrecipe.databinding.FragmentStoreBinding

// 스토어 페이지
class StoreFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentStoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_storeFragment_to_tipFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_storeFragment_to_talkFragment)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_storeFragment_to_bookmarkFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_storeFragment)
        }

        // 직방 url을 웹뷰의 형태로 제공한다.
        val view = inflater.inflate(R.layout.fragment_store,container, false)
        val webView: WebView = view.findViewById(R.id.storeWebView)
        webView.loadUrl("https://www.zigbang.com/")

        return view
    }
}