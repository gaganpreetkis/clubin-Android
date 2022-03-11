package com.clubin.com.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.clubin.com.onboarding.model.ViewPagerDM
import com.clubin.com.R

class OnboardingPagerAdapter(context: Context, pagerList:ArrayList<ViewPagerDM>): PagerAdapter() {
    internal var context: Context
    internal var pager:ArrayList<ViewPagerDM>

    init{
        this.context = context
        this.pager = pagerList
    }
    override fun isViewFromObject(view: View, o:Any):Boolean {
        return view === o
    }
    override fun instantiateItem(container: ViewGroup, position:Int):Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_pager_item, container, false)
        val imageView = view.findViewById(R.id.iv_onboarding) as ImageView
        val heading1 = view.findViewById(R.id.tv_heading) as TextView
        val heading2 = view.findViewById(R.id.tv_text) as TextView
        val center_heading = view.findViewById(R.id.center_heading) as TextView
        imageView.setBackgroundResource(pager.get(position).image!!)
        heading1.setText(pager.get(position).text1!!)
        heading2.setText(pager.get(position).text2!!)
      /*  if(position==pager.size-1)
        {
            center_heading.visibility=View.VISIBLE
            heading1.visibility=View.INVISIBLE
            heading2.visibility=View.INVISIBLE
        }
        else{
            center_heading.visibility=View.INVISIBLE
            heading1.visibility=View.VISIBLE
            heading2.visibility=View.VISIBLE
        }*/
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position:Int, `object`:Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return pager.size
    }

    override fun getItemPosition(`object`:Any):Int {
        return super.getItemPosition(`object`)
    }
}