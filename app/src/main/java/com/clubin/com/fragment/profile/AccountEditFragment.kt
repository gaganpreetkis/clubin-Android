package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R
import com.clubin.com.databinding.AccountEditFragmentDataBinding
import com.clubin.com.databinding.ContactUsFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.fragment.profile.callbacks.ContactUsFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AccountEditFragment : BaseDataBindingFragment<AccountEditFragmentDataBinding>
    (R.layout.fragment_account_edit), AccountEditFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun injectDaggerComponent() {

    }

    override fun onDataBindingCreated() {

    }


}
/*
Screen :
AccountEditView

opens on click :: --- MenuView - on click of username and profile photo - Modifier mon profil

(image: "Alex", size: 120)

if isEditing {
    Button {changePicture.toggle()} label: {
        Image(systemName: "pencil.circle.fill")
        .font(.title)
        .foregroundColor(.blue)
    }
            .buttonStyle(.plain)
    .offset(x: 50, y: 40)
}
}

Button(action: {isEditing.toggle()}, label: {
    Text(isEditing ? "Sauvegarder les informations" : "Modifier les informations")
    .body()
        .foregroundColor(.blue)
    .padding(10)
})

if isEditing {
    editingView
} else {

    fixedView

}




********editingView ::

Général
-----bold 16


title --- style: .Medium, ofSize: 12)
centertext --style: .Medium, ofSize: 12

CenterRowTextFieldView(textInput: "", title: "Nom d'utilisateur",
centertext: "@alex_b")

CenterRowTextFieldView(textInput: "", title: "Nom et prénom",
centertext: "Alexandre Baysset")
CenterRowTextFieldView(textInput: "", title: "Age",
centertext: "22")
CenterRowTextFieldView(textInput: "", title: "Bio",
centertext: "Digital goodies designer @pixsellz Everything is designed.")


Réseaux
--- bold 16
CenterRowTextFieldView(textInput: "", title: "Instagram",
centertext: "instagram.com/brandon_f")
CenterRowTextFieldView(textInput: "NIoput", title: "Facebook",
centertext: "facebook.com/BrandonFang")


Informations privés - contact
----- bold 16

E-mail
mailto:jacob.west@gmail.com
-----on click - open AccountVerificationEmailView

Téléphone
+1 202 555 0147
-----on click - open AccountVerificationSMSView

Sexe
Homme


******** fixedView::

Général
CenterRowTextView(title: "Nom d'utilisateur",
centertext: "@alex_b")
CenterRowTextView(title: "Nom et prénom",
centertext: "Alexandre Baysset")
CenterRowTextView(title: "Age",
centertext: "22")
CenterRowTextView(title: "Bio",
centertext: "Digital goodies designer @pixsellz Everything is designed.")

Réseaux
CenterRowTextView(title: "Instagram",
centertext: "instagram.com/brandon_f")
CenterRowTextView(title: "Facebook",
centertext: "facebook.com/BrandonFang")

Informations privés - contact
CenterRowTextView(title: "E-mail",
centertext: "mailto:jacob.west@gmail.com")

CenterRowTextView(title: "Téléphone",
centertext: "+1 202 555 0147")

CenterRowTextView(title: "Sexe",
centertext: "Homme")*/
