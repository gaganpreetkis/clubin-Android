package com.clubin.com.onboarding.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.clubin.com.R
import com.clubin.com.databinding.ActivityOnboardingBinding
import com.clubin.com.inscription.InscriptionAgeActivity
import com.clubin.com.inscription.InscriptionNameActivity
import com.clubin.com.onboarding.adapter.OnboardingPagerAdapter
import com.clubin.com.onboarding.model.ViewPagerDM
import com.clubin.com.onboarding.viewmodel.OnboardingVM
import com.clubin.com.passwordreset.PasswordResetEmailActivity
import com.clubin.com.utills.CommonUtilities

class OnboardingActivity : AppCompatActivity() {
    var binding: ActivityOnboardingBinding? = null
    var vm: OnboardingVM? = null
    var whichScreen: String? = null
    var pos:Int?=0
    var pager_itemList = ArrayList<ViewPagerDM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        vm = ViewModelProviders.of(this)[OnboardingVM::class.java]
        binding?.mview = vm
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.blueberry,
                R.string.onboarding_one_title,
                R.string.onboarding_one_headline
            )
        )
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.strawberry,
                R.string.onboarding_two_title,
                R.string.onboarding_two_headline
            )
        )
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.lemon,
                R.string.onboarding_three_title,
                R.string.onboarding_three_headline
            )
        )
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.plum,
                R.string.onboarding_four_title,
                R.string.onboarding_four_headline
            )
        )

        pager_itemList.add(
            ViewPagerDM(
                R.drawable.lime,
                R.string.onboarding_five_title,
                R.string.onboarding_five_headline
            )
        )

        pager_itemList.add(
            ViewPagerDM(
                R.drawable.pomegranate,
                R.string.onboarding_six_title,
                R.string.onboarding_six_headline
            )
        )

        val adapter = OnboardingPagerAdapter(this, pager_itemList)
        binding?.viewpager!!.adapter = adapter
        binding?.dotsIndicator!!.setViewPager(binding?.viewpager!!)
        binding?.viewpager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if(position==pager_itemList.size-1){
                    whichScreen="last"
                    binding?.btnNext!!.setText(resources.getText(R.string.button_text))
                }
                else
                {
                    whichScreen="non-last"
                    pos=position
                    binding?.btnNext!!.setText(resources.getText(R.string.button_text))
                }
            }

        })


        binding?.btnNext!!.setOnClickListener {
         //   if (whichScreen == "last") {
                CommonUtilities.fireActivityIntent(
                    this,
                    Intent(this, InscriptionAgeActivity::class.java),
                    isFinish = false,
                    isForward = true
                )
          //  }
           /* else{
                binding!!.viewpager.setCurrentItem(pos!!.plus(1),true)
            }*/
        }

    }

}