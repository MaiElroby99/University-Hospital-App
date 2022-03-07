package com.route.myapplication.hms.ui.HomeFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageSwitcher
import android.widget.ImageView
import com.route.myapplication.hms.R


class HomeFragment : Fragment() {
    lateinit var btPrevious: ImageButton
    lateinit var btNext: ImageButton
    lateinit var imgSwitcher: ImageSwitcher

    private val imageList = intArrayOf(
        R.drawable.img1,
        R.drawable.img2, R.drawable.img3
    )
    private var index = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgSwitcher = requireView().findViewById<ImageSwitcher>(R.id.image_switcher)

        imgSwitcher?.setFactory({
            val imgView = ImageView(context)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        })

        // set the method and pass array as a parameter
        imgSwitcher?.setImageResource(imageList[index])

        val imgIn = AnimationUtils.loadAnimation(
            context, android.R.anim.slide_in_left)
        imgSwitcher?.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            context, android.R.anim.slide_out_right)
        imgSwitcher?.outAnimation = imgOut

        // previous button functionality
        btPrevious = requireView().findViewById<ImageButton>(R.id.bt_previous)
        btPrevious.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else 2
            imgSwitcher?.setImageResource(imageList[index])
        }

        // next button functionality
        btNext = requireView().findViewById<ImageButton>(R.id.bt_next)
        btNext.setOnClickListener {
            index = if (index + 1 < imageList.size) index +1 else 0
            imgSwitcher?.setImageResource(imageList[index])
        }
    }
}

