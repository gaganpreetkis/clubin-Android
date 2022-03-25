package com.clubin.com.tabbar

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.clubin.com.R
import com.clubin.com.fragment.event.view.EventFragment
import com.clubin.com.fragment.hosts.view.HostsFragment
import com.clubin.com.fragment.profile.ProfileFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.chip.ChipGroup

class TabBarActivity : AppCompatActivity(), View.OnClickListener, EventFragment.BackPressedListener {

    lateinit var container: FrameLayout

    lateinit var eventTab: LinearLayout
    lateinit var hostTab: LinearLayout
    lateinit var billetsTab: LinearLayout
    lateinit var profileTab: LinearLayout

    lateinit var ic_search: ImageView
    lateinit var ic_home: ImageView
    lateinit var ic_billets: ImageView
    lateinit var ic_profile: ImageView

    lateinit var tab_event_txt: TextView
    lateinit var tab_home_txt: TextView
    lateinit var tab_billets_txt: TextView
    lateinit var tab_profile_txt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabbar_activity)

        setupFindViewById()
        setupClickListeners()

        eventTab.performClick()
    }

    companion object {
        var mInstance: TabBarActivity? = null
        fun getInstance(): TabBarActivity {
            return mInstance!!
        }
    }

    private fun setupFindViewById() {
        container = findViewById(R.id.container)

        eventTab = findViewById(R.id.eventTab)
        hostTab = findViewById(R.id.hostTab)
        billetsTab = findViewById(R.id.billetsTab)
        profileTab = findViewById(R.id.profileTab)

        ic_search = findViewById(R.id.ic_search)
        ic_home = findViewById(R.id.ic_home)
        ic_billets = findViewById(R.id.ic_billets)
        ic_profile = findViewById(R.id.ic_profile)

        tab_event_txt = findViewById(R.id.tab_event_txt)
        tab_home_txt = findViewById(R.id.tab_home_txt)
        tab_billets_txt = findViewById(R.id.tab_billets_txt)
        tab_profile_txt = findViewById(R.id.tab_profile_txt)
    }

    private fun setupClickListeners() {
        arrayOf(eventTab, hostTab, billetsTab, profileTab).forEach { it.setOnClickListener(this) }
    }

    private fun setupTabs(pos: Int) {
        val activeIconColor = ContextCompat.getColor(this, R.color.dull_green)
        val deactiveIconColor = ContextCompat.getColor(this, R.color.dull_white)
        val activeTextColor = ContextCompat.getColor(this, R.color.white)
        val deactiveTextColor = ContextCompat.getColor(this, R.color.dull_white)

        ic_search.setColorFilter(if (pos == 0) activeIconColor else deactiveIconColor)
        tab_event_txt.setTextColor(if (pos == 0) activeTextColor else deactiveTextColor)

        ic_home.setColorFilter(if (pos == 1) activeIconColor else deactiveIconColor)
        tab_home_txt.setTextColor(if (pos == 1) activeTextColor else deactiveTextColor)

        ic_billets.setColorFilter(if (pos == 2) activeIconColor else deactiveIconColor)
        tab_billets_txt.setTextColor(if (pos == 2) activeTextColor else deactiveTextColor)

        ic_profile.setColorFilter(if (pos == 3) activeIconColor else deactiveIconColor)
        tab_profile_txt.setTextColor(if (pos == 3) activeTextColor else deactiveTextColor)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            eventTab -> {

                setupTabs(0)
                addFragment(EventFragment(), false)
            }
            hostTab -> {
                setupTabs(1)
                addFragment(HostsFragment(), false)
            }
            billetsTab -> {
                setupTabs(2)
            }
            profileTab -> {
                setupTabs(3)
                addFragment(ProfileFragment(), false)
            }
        }
    }


    public fun addFragment(frag: Fragment, addToBackStack: Boolean) {
        /*if (!isFinishing) {
            util.hideKeyboard(this)
        }*/

        val trans = supportFragmentManager.beginTransaction()

        if (addToBackStack) {
            trans.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_right, R.anim.slide_in_from_right, R.anim.slide_out_to_right)
            trans.add(R.id.container, frag)
        } else {
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            trans.replace(R.id.container, frag)
        }

        if (addToBackStack) trans.addToBackStack(frag::class.java.simpleName)

        trans.commit()
        supportFragmentManager!!.executePendingTransactions()
    }

    fun removeFragment() {
        /*if (!isFinishing) {
            util.hideKeyboard(this)
        }*/

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            val v = currentFragment()
            //noinspection ConstantConditions
            if (supportFragmentManager.backStackEntryCount > 0) {
                v?.view?.requestFocus()
            }
        }
    }

    fun isVisible(): Boolean {
        return !isFinishing
    }

    fun currentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.container)
    }

    private fun bottomSheetShow() {
        val dialog = BottomSheetDialog(this)

        // on below line we are inflating a layout file which we have created.
        val view = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)

        val btnClose = view.findViewById<ImageView>(R.id.iv_cancel)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
        val night = view.findViewById<LinearLayout>(R.id.ll_nights)
        val chipNight = view.findViewById<ChipGroup>(R.id.chip_group_nights)
        val nightArrow = view.findViewById<ImageView>(R.id.iv_night_arrow)
        var nightChip = false;
        night.setOnClickListener {
            if (nightChip) {
                nightChip = false;
                chipNight.visibility = View.VISIBLE
                nightArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                nightChip = true;
                chipNight.visibility = View.GONE
                nightArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }
        val discovery = view.findViewById<LinearLayout>(R.id.ll_discovery)
        val chipDisGroup = view.findViewById<ChipGroup>(R.id.chip_group_discovery)
        val disArrow = view.findViewById<ImageView>(R.id.iv_dis_arrow)
        var disChip = false;
        discovery.setOnClickListener {
            if (disChip) {
                disChip = false;
                chipDisGroup.visibility = View.VISIBLE
                disArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                disChip = true;
                chipDisGroup.visibility = View.GONE
                disArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        val vibes = view.findViewById<LinearLayout>(R.id.ll_vibes)
        val chipVibesGroup = view.findViewById<ChipGroup>(R.id.chip_group_vibe)
        val vibesArrow = view.findViewById<ImageView>(R.id.iv_vibes_arrow)
        var vibesChip = false;
        vibes.setOnClickListener {
            if (vibesChip) {
                vibesChip = false;
                chipVibesGroup.visibility = View.VISIBLE
                vibesArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                vibesChip = true;
                chipVibesGroup.visibility = View.GONE
                vibesArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }


        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }

    override fun onItemClick(position: Int) {
        bottomSheetShow()
    }
}

/*Screen ::  EventFilteringSheetView
-----background : black

Trier - Filtrer
------style: .ExtraBold, ofSize: 28
----xmark - cross icon

Trier par thèmes
----tagFiltering
----style: .Bold, ofSize: 22


1. nights
-- style: .ExtraBold, ofSize: 18
---- up and down arraow ----- "chevron.up" : "chevron.down"
----Gradient  - opacity(0.6)  .cornerRadius(6)
--- tags will show data of vm.tagsNight
----Tagview :: Text(text)
.font(.type(style: .Bold, ofSize: 11))
.foregroundColor(isSelected ? Color.black : Color.white.opacity(0.7))
.padding()
.lineLimit(1)
.background(isSelected ? Color.white : Color.tertiarySystemFill)
.frame(height: 36)
.cornerRadius(18)

2. Discovery
-- style: .ExtraBold, ofSize: 18
---- up and down arraow ----- "chevron.up" : "chevron.down"
----Gradient  - opacity(0.6)  .cornerRadius(6)
--- tags will show data of vm.tagsAtelier



Trier par style de musique
--songFiltering
----style: .Bold, ofSize: 22


3. vibes
-- style: .ExtraBold, ofSize: 18
---- up and down arraow ----- "chevron.up" : "chevron.down"
----Gradient  - opacity(0.6)  .cornerRadius(6)
--- tags will show data of vm.tagsVibes


Lieu
----style: .Bold, ofSize: 22

for loop vm.places
title:
(style: .SemiBold, ofSize: 17)

switch toggle

Appliquer
----title2, color - black , background color - 29889A



Tags model::
struct EventTagItem: Hashable {
    var title: String
    var isSelected: Bool





    Tags Data::



    // Tags per Theme
    static var tagsNight = [EventTagItem(title: "After", isSelected: false),EventTagItem(title: "Soirée étudiante", isSelected: false),EventTagItem(title: "Apéro", isSelected: false),EventTagItem(title: "Big Party", isSelected: false), EventTagItem(title: "Association", isSelected: false),EventTagItem(title: "Soirée match", isSelected: false),EventTagItem(title: "Chill", isSelected: false),EventTagItem(title: "Concert", isSelected: false),EventTagItem(title: "Festival", isSelected: false),EventTagItem(title: "Week-end d'inté", isSelected: false),EventTagItem(title: "Cocktails", isSelected: false), EventTagItem(title: "Soirée déguisés", isSelected: false), EventTagItem(title: "A thème", isSelected: false),EventTagItem(title: "Soirée Gaming", isSelected: false),EventTagItem(title: "Anniversaire", isSelected: false), EventTagItem(title: "Années 60", isSelected: false), EventTagItem(title: "Années 70", isSelected: false),EventTagItem(title: "Années 80", isSelected: false),EventTagItem(title: "Années 90", isSelected: false),EventTagItem(title: "Pool Party", isSelected: false),EventTagItem(title: "Gala", isSelected: false),EventTagItem(title: "Karaoké", isSelected: false)]

    static var tagsVibes = [EventTagItem(title: "DJ", isSelected: false),EventTagItem(title: "Electro", isSelected: false),EventTagItem(title: "Rock", isSelected: false),EventTagItem(title: "Disco", isSelected: false),EventTagItem(title: "Pop", isSelected: false),EventTagItem(title: "Rap", isSelected: false),EventTagItem(title: "House", isSelected: false),EventTagItem(title: "Funk", isSelected: false),EventTagItem(title: "Reaggae", isSelected: false),EventTagItem(title: "Techno", isSelected: false),EventTagItem(title: "Trance", isSelected: false),EventTagItem(title: "Trap", isSelected: false),EventTagItem(title: "Metal", isSelected: false),EventTagItem(title: "Jazz", isSelected: false),EventTagItem(title: "Blues", isSelected: false),EventTagItem(title: "Samba", isSelected: false),EventTagItem(title: "Salsa", isSelected: false),EventTagItem(title: "Kizumba", isSelected: false),EventTagItem(title: "Latino", isSelected: false),EventTagItem(title: "Zumba", isSelected: false),EventTagItem(title: "Indé", isSelected: false),EventTagItem(title: "Classique", isSelected: false)]

    static var tagsAtelier = [EventTagItem(title: "Diner", isSelected: false), EventTagItem(title: "Humoriste", isSelected: false),EventTagItem(title: "Chef cuisinier", isSelected: false),EventTagItem(title: "Barman", isSelected: false),EventTagItem(title: "Magicien", isSelected: false),EventTagItem(title: "Dégustation", isSelected: false), EventTagItem(title: "Cocktails", isSelected: false),EventTagItem(title: "Bière du monde", isSelected: false),EventTagItem(title: "Vins", isSelected: false),EventTagItem(title: "Spiritueux", isSelected: false),EventTagItem(title: "Produits de terroir", isSelected: false), EventTagItem(title: "Improvisation", isSelected: false),EventTagItem(title: "Atelier culinaire", isSelected: false),EventTagItem(title: "Soirée rencontres", isSelected: false),EventTagItem(title: "Découverte de passion", isSelected: false), EventTagItem(title: "Soirée raclette", isSelected: false)]
}

static let themeNights = EventTheme(logo: "theatermasks.fill", image: "cocktail", title: "Nights", tags: tagsNight, description: "Le show doit continuer - Queen", gradiantColor1: Color.theme.darkAccent -- 203838, gradiantColor2: Color.theme.accent -- 2CD0A8)
static let themeVibes = EventTheme(logo: "music.note", image: "party", title: "Vibes",tags: tagsVibes, description: "La musique peut rendre les hommes libres. - Bob Marley",gradiantColor1: Color.theme.background- 000000,  gradiantColor2: Color.special.lipstick- D54667)
static let themeDiscovery = EventTheme(logo: "leaf.fill", image: "cocktail", title: "Discovery",tags: tagsAtelier, description: "Rien de grand ne se fait sans passion - Victor Hugo", gradiantColor1: Color.theme.background- 000000, gradiantColor2:  Color.special.sunset-- FDBB33)
   */